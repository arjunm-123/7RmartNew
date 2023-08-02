package com.obsqura.rmartSupermarket.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSettingsPage
{
	public WebDriver driver;
	public AdminSettingsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link']//child::img[starts-with(@src,'https://groceryapp.uniqassosiates.com/public/assets/admin')]")WebElement adminButtonInHomePage;
	@FindBy(xpath = "//a[@class='dropdown-item']")WebElement settingsButtonInHomePage;
	@FindBy(xpath = "//nav[@class='mt-2']//p")WebElement menuList;

	public AdminSettingsPage clickOnAdminButtonForLogOut() 
	{
		adminButtonInHomePage.click();
		return this;
	}

	public AdminSettingsPage clickOnSettingsButtonInHomePage()
	{
		settingsButtonInHomePage.click();
		return this;
	}

	public boolean isMenulistDisplayed() 
	{
		return menuList.isDisplayed();
	}
}