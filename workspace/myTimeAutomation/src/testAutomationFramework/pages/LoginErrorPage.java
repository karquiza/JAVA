package testAutomationFramework.pages;

import testAutomationFramework.util.TestDriver;

public class LoginErrorPage {
	private TestDriver driver;
	private static String title = "Error";
	
	public LoginErrorPage(TestDriver td) {
		this.driver = td;
		if(!driver.getDriver().getTitle().equals(title) ) {
			throw new IllegalStateException("This is not the Error Page! This is: "  
					+ driver.getDriver().getTitle() + " at " +
					driver.getDriver().getCurrentUrl());
		}			
	}
	
	public String getTitle() {
		return title;
	}
	
	public LoginPage returnToLogin() {
		driver.clickElemByXPath("//a[@href=\"LoginServlet\"]");
		return new LoginPage(driver);
	}
}
