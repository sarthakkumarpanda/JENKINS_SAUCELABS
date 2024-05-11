package com.sauceDemo.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauceDemo.TestBase.TestBase;

public class InvalidLoginTest extends TestBase{
	
	public InvalidLoginTest() throws Exception {
		super();
	}
	
public WebDriver driver;	
	
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication("Chrome");		
	}

	@Test(priority=1)
	public void invalidPasswordLogin() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("invalidPassword"));
		driver.findElement(By.id("login-button")).click();
		String expectedWarningMessage = "Epic sadface: Username and password do not match any user in this service";
		String actualWarningMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Test(priority=2)
	public void invalidBlankPasswordLogin() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String expectedWarningMessage = "Epic sadface: Password is required";
		String actualWarningMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Test(priority=3)
	public void invalidBlankUsernameLogin() throws Exception {
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String expectedWarningMessage = "Epic sadface: Username is required";
		String actualWarningMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Test(priority=4)
	public void invalidBlankUsernameAndPasswordLogin() throws Exception {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String expectedWarningMessage = "Epic sadface: Username is required";
		String actualWarningMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
