package testAutomationFramework.util;

import testAutomationFramework.util.DriverType;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;


public class TestDriver {
	private WebDriver driver;
	
	public void setDriver(DriverType type){		
		switch(type){
			
			case TYPE_CHROME:
				driver = new ChromeDriver();
				System.out.println("[DEBUG] Created new Chrome WebDriver");
				break;
			
			case TYPE_SAFARI:
				driver = new SafariDriver();
				System.out.println("[DEBUG] Created new Safari WebDriver");
				break;
				
			case TYPE_FIREFOX:
			default: /* fall-through */
				driver = new FirefoxDriver();
				System.out.println("[DEBUG] Created new Firefox WebDriver");
				break;
				
		}
		
		// Set the default page load timeout to 30 seconds.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.get(driver.getCurrentUrl());
		driver.close();
	}
	
	public boolean inputTextFieldById(String elemID, String text) {
		if(driver != null){
			if(driver.findElement(By.id(elemID)).isDisplayed() == true) {
				driver.findElement(By.id(elemID)).sendKeys(text);
				return true;
			}				
		}
		return false;
	}
	
	public boolean clickElemByXPath(String elemXPath) {
		if(driver != null){
			if(driver.findElement(By.xpath(elemXPath)).isDisplayed() == true) {
				driver.findElement(By.xpath(elemXPath)).click();
				return true;
			}				
		}
		return false;
	}
	
	public List<WebElement> findElemsByXPath(String elemXPath) {
		if(driver != null){
			return driver.findElements(By.xpath(elemXPath));						
		}
		return null;
	}
	
	public String getTextFieldById(String elemID) {
		try {
			if(driver.findElement(By.id(elemID)).isDisplayed() == true) {
				return driver.findElement(By.id(elemID)).getText();				
			}
			return null;
		} catch( Exception e ) {
			return null;
		}
	}
}
