package com.sauceDemo.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauceDemo.TestBase.TestBase;

public class ValidLoginTest extends TestBase{
	
	public ValidLoginTest() throws Exception {
		super();
	}

	public WebDriver driver;	
	
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication("Chrome");		
	}
	
	@Test(priority=1)
	public void validLoginWithFirstUsername() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username1"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();

		driver.findElement(By.linkText("Logout")).click();

		WebElement swaglabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		Assert.assertTrue(swaglabs.isDisplayed());	
	}
	
	@Test(priority=2)
	public void validLoginWithSecondUsername() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username2"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		String expectedWarningMessage = "Epic sadface: Sorry, this user has been locked out.";
		String actualWarningMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	
	}
	
	@Test(priority=3)
	public void validLoginWithThirdUsername() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username3"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		WebElement swaglabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		Assert.assertTrue(swaglabs.isDisplayed());	
	}
	
	@Test(priority=4)
	public void validLoginWithFourthUsername() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username4"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		WebElement swaglabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		Assert.assertTrue(swaglabs.isDisplayed());	
	}
	
	@Test(priority=5)
	public void validLoginWithFifthUsername() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username5"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		WebElement swaglabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		Assert.assertTrue(swaglabs.isDisplayed());	
	}
	
	@Test(priority=6)
	public void validLoginWithSixthUsername() throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username6"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		WebElement swaglabs = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
		Assert.assertTrue(swaglabs.isDisplayed());	
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
