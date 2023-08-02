package com.obsqura.rmartSupermarket.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class LoginPage 
{
	private static final long EXPLICIT_WAIT = 0;
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")private WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")private WebElement signInButton;
	@FindBy(xpath="//li[@class=\"breadcrumb-item active\"]")private WebElement homePage;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertPopup;
	public LoginPage enterUserNameOnusernamefield(String username)
	{
		userNameField.sendKeys(username);
		return this;
	}
	public LoginPage enterpasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public void clickOnSignInButton()
	{
		
		   signInButton.click();
 
	}
	public boolean isHomePageDisplayed()
	{
		return homePage.isDisplayed();
	}
	public boolean alertMessageIsDisplayed()
	{
		return alertPopup.isDisplayed();
	}
}
