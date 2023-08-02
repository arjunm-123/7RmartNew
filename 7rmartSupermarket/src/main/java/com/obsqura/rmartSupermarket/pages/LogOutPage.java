package com.obsqura.rmartSupermarket.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage
{
	public WebDriver driver;
	public LogOutPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link']//child::img[starts-with(@src,'https://groceryapp.uniqassosiates.com/public/assets/admin')]")	WebElement adminButtonInHomePage;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']//parent::a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/logout')]")	WebElement logOutButtonInHomePage;
	@FindBy(xpath = "//div[@class='login-logo']")	WebElement logInPageLogoElement;

	public LogOutPage clickOnAdminButtonForLogOut() 
	{
		adminButtonInHomePage.click();
		return this;
	}

	public LogOutPage clickOnLogOutButtonInHomePage()
	{
		logOutButtonInHomePage.click();
		return this;
	}

	public boolean isLogInPageLogoDisplayed() 
	{
		return logInPageLogoElement.isDisplayed();
	}
}




