package testAutomationFramework.pages;

import testAutomationFramework.util.TestDriver;

public class UserPage {
	private TestDriver driver;
	private static String title = "Welcome!";

	public UserPage(TestDriver td) {
		this.driver = td;
		if(!driver.getDriver().getTitle().equals(title) ) {
			throw new IllegalStateException("This is not the User Page! This is: "  
					+ driver.getDriver().getTitle() + " at " +
					driver.getDriver().getCurrentUrl());
		}			
	}
	
	public String getTitle() {
		return title;
	}
	
	public LoginPage logoutUser() {
		driver.clickElemByXPath("//a[@href=\"LoginServlet\"]");
		return new LoginPage(this.driver);
	}
}
