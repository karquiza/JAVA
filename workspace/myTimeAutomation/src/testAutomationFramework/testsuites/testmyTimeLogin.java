package testAutomationFramework.testsuites;

import testAutomationFramework.util.*;
import testAutomationFramework.pages.*;
import testAutomationFramework.db.*;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class testmyTimeLogin {
	private static TestDriver td;
	private static testDBControl dbc;
	private static TestAssert testAssert;
	
	public static void main(String[] args) {
		// Read config file
		TestConfigReader cfg = new TestConfigReader();
		testAssert = new TestAssert();
	
		// Set Test Driver
		td = new TestDriver();
		td.setDriver(cfg.getDriverType());
		
		// Set DB
		dbc = new testDBControl();
		
		
		// Open Website
		td.openUrl("http://localhost:8080/myTime");
		
		// TODO: Add test case to check static web elements of each page
		
		// Test Reset
		test_Login_01();
		
		// Test Valid Login 
		test_Login_02();
		
		// Test User Page
		test_UserPage_01();
		
		// Test User Page Logout
		test_UserPage_02();		
		
		// Test Invalid Login (invalid user, invalid password)
		test_Login_03();
		
		// Test Login Error returns to Login
		test_LoginErr_01();
		
		// Test Invalid Login (valid user, invalid password)
		test_Login_04();
		
		// Test Login Error returns to Login
		test_LoginErr_01();
		
		// Close website
		td.closeBrowser();
		
		// cleanup
		cfg = null;
		testAssert = null;
		td = null;
		dbc = null;
		
	}
	
	private static void test_Login_01() {
		System.out.println("\n===== START TEST test_Login_01 =====");
		System.out.println("[TC] Check that Reset button clears input fields");
		
		LoginPage login = new LoginPage(td);
		
		login.loginAndReset("login01", "loginpwd01");
		testAssert.assertTrue(td.getTextFieldById("login_name").equals(""),"Test Case: Login name is empty");		
		testAssert.assertTrue(td.getTextFieldById("login_password").equals(""), "Test Case: Login password is empty");	
		testAssert.assertTrue(td.getDriver().getTitle().equals(login.getTitle()), "Test Case: Page title not changed");
		
		// cleanup
		login = null;
		
		System.out.println("===== END TEST test_Login_01 =====");
	}
	
	private static void test_Login_02() {
		System.out.println("\n===== START TEST test_Login_02 =====");
		System.out.println("[TC] Check that valid user and password can log-in sucessfully");
		
		LoginPage login = new LoginPage(td);
				
		String validUser = dbc.getUserIdAtIndex(0);
		String validPassword = dbc.getPasswordAtIndex(0);
		
		UserPage userpage = login.loginValidUser(validUser, validPassword);

		testAssert.assertTrue(td.getDriver().getTitle().equals(userpage.getTitle()), "Test Case: Login Successful");
		
		// cleanup
		login = null;
		userpage = null;
		
		System.out.println("===== END TEST test_Login_02 =====");
	}
	
	private static void test_UserPage_01() {
		System.out.println("\n===== START TEST test_UserPage_01 =====");
		System.out.println("[TC] (Continued from test_Login_02) Check that user page displays the correct user name");
		
		String text = dbc.getFullNameAtIndex(1);
		// List<WebElement> list = td.getDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		List<WebElement> list = td.findElemsByXPath("//*[contains(text(),'Welcome "+ text +"')]");
		testAssert.assertTrue(list.size() > 0, "Test Case: Find text [" + text + "]");//, "[test_UserPage_01][FAILED] Text [" + text + "] not found!");
	
		// cleanup
		
		System.out.println("===== END TEST test_UserPage_01 =====");
	}
	
	private static void test_UserPage_02() {
		System.out.println("\n===== START TEST test_UserPage_02 =====");
		System.out.println("[TC] (Continued from previous test) Check successful \"logout\" of user from user page");
		
		UserPage userpage = new UserPage(td);
		
		LoginPage login = userpage.logoutUser();
		testAssert.assertTrue(td.getDriver().getTitle().equals(login.getTitle()), "Test Case: Logout Successful");
		
		System.out.println("===== END TEST test_UserPage_02 =====");
	}
	
	private static void test_Login_03() {
		System.out.println("\n===== START TEST test_Login_03 =====");
		System.out.println("[TC] Check that invalid user and invalid password results in login error page");
		
		LoginPage login = new LoginPage(td);
		
		LoginErrorPage loginerrpage = login.loginInvalidUserPassword("login03", "loginpwd03");
		testAssert.assertTrue(!td.getDriver().getTitle().equals(login.getTitle()), "Test Case: Invalid Login");
		testAssert.assertTrue(td.getDriver().getTitle().equals(loginerrpage.getTitle()), "Test Case: Login Error Page");
		
		System.out.println("===== END TEST test_Login_03 =====");
	}
	
	private static void test_LoginErr_01() {
		System.out.println("\n===== START TEST test_LoginErr_01 =====");
		System.out.println("[TC] (Continued from test_Login_03) Check that we can return to login page from error page");
		
		LoginErrorPage loginerrpage = new LoginErrorPage(td);
		
		LoginPage login = loginerrpage.returnToLogin();
		testAssert.assertTrue(td.getDriver().getTitle().equals(login.getTitle()), "Test Case: Return to Login page");
		
		System.out.println("===== END TEST test_LoginErr_01 =====");
	}
	
	private static void test_Login_04() {
		System.out.println("\n===== START TEST test_Login_04 =====");
		System.out.println("[TC] Check that valid user and invalid password results in login error page");
		
		LoginPage login = new LoginPage(td);
		
		String validUser = dbc.getUserIdAtIndex(0);
		String validPassword = dbc.getPasswordAtIndex(0);
		
		LoginErrorPage loginerrpage = login.loginInvalidUserPassword(validUser, validPassword + "_invalid");
		testAssert.assertTrue(!td.getDriver().getTitle().equals(login.getTitle()), "Test Case: Invalid Login");
		testAssert.assertTrue(td.getDriver().getTitle().equals(loginerrpage.getTitle()), "Test Case: Login Error Page");
		
		System.out.println("===== END TEST test_Login_04 =====");
	}
	
	
}
