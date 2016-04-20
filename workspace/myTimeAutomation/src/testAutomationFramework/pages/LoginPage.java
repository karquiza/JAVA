package testAutomationFramework.pages;

import testAutomationFramework.util.TestDriver;
import testAutomationFramework.pages.UserPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testAutomationFramework.pages.LoginErrorPage;


public class LoginPage {
	private TestDriver driver;
	private static String title = "myTime Login";
	
	public LoginPage(TestDriver td) {
		this.driver = td;
		if(!driver.getDriver().getTitle().equals(title)) {
			throw new IllegalStateException("This is not the Login Page! This is: " + driver.getDriver().getTitle() + " at " + driver.getDriver().getCurrentUrl());
		}			
	}
	
	public String getTitle() {
		return title;
	}
	
	/*
	 * function: loginValidUser
	 * description: Log in a valid user
	 * return: A valid user's UserPage
	 */
	public UserPage loginValidUser(String username, String password) {
		boolean res;
		
		res = driver.inputTextFieldById("login_name", username);
		
		if(res == true) {
			res = driver.inputTextFieldById("login_password", password);
		}
		
		if(res == true) {
			res = driver.clickElemByXPath("//input[@value='Login' and @type='submit']");
		}
		
		// TODO: Wait for next page to load
		
		return new UserPage(this.driver);
	}
	
	/*
	 * function: loginInvalidUserPassword
	 * description: Log in using an invalid username and or password
	 * return: An error page
	 */
	public LoginErrorPage loginInvalidUserPassword(String username, String password) {
		boolean res;
		
		res = driver.inputTextFieldById("login_name", username);
		
		if(res == true) {
			res = driver.inputTextFieldById("login_password", password);
		}
		
		if(res == true) {
			res = driver.clickElemByXPath("//input[@value='Login' and @type='submit']");
		}
		
		// TODO: Wait for next page to load
		
		return new LoginErrorPage(this.driver);		
	}
	
	/*
	 * function: loginAndReset
	 * description: Log in using any username and or password, and then click Reset button
	 * return: None	 
	 */
	public void loginAndReset(String username, String password) {
		boolean res;
		
		res = driver.inputTextFieldById("login_name", username);
		
		if(res == true) {
			res = driver.inputTextFieldById("login_password", password);
		}
		
		if(res == true) {
			res = driver.clickElemByXPath("//input[@value='Reset' and @type='reset']");
		}		
		
		// TODO: Wait for next page to load
	}
	
	public String getTextValue(String elemID) {
		return driver.getTextFieldById(elemID);		
	}
	
}
