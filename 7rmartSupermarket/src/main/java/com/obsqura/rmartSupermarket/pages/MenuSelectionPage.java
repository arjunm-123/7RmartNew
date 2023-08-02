package com.obsqura.rmartSupermarket.pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuSelectionPage 
{
    private static final long EXPLICIT_WAIT = 0;
	public WebDriver driver;
	
	public MenuSelectionPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(xpath = "//nav[@class='mt-2']//p")) List<WebElement> menuList;
	@FindBy(xpath = "//li[@class='nav-item']//p[text() ='Dashboard']") private WebElement dashBoard;
	@FindBy(xpath = "//i[contains(@class,'fa-shopping-basket')]") private WebElement manageOrders;
	@FindBy(xpath = "//li[@class='nav-item']//p[text() ='groceries']") private WebElement groceries;
	@FindBy(xpath = "//i[contains(@class,'fa-money-bill-alt')]") private WebElement manageExpense;
	@FindBy(xpath = "//i[contains(@class,'fa-tasks')]") private WebElement manageProduct;
	@FindBy(xpath = "//i[contains(@class,'fa-user-check')]") private WebElement verifyUsers;
	@FindBy(xpath = "(//i[contains(@class,'fa-angle-left')])[3]") private WebElement manageUsers;
	@FindBy(xpath = "//i[contains(@class,'fa-bell')]") private WebElement pushNotification;
	@FindBy(xpath = "//a[@class='nav-link']//i[contains(@class,'fa-edit')]") private WebElement manageContent;
	@FindBy(xpath = "//textarea[@id='news']")private WebElement news;
	@FindBy(xpath = "//i[contains(@class,'fa-map-marker')]") private WebElement manageLocation;
	@FindBy(xpath = "//i[contains(@class,'window-restore')]") private WebElement manageSlider;
	@FindBy(xpath = "//i[contains(@class,'window-minimize')]") private WebElement mobileSlider;
	@FindBy(xpath = "//i[contains(@class,'list-alt')]") private WebElement manageCategory;
	@FindBy(xpath = "//i[contains(@class,'fa-cubes')]") private WebElement manageOfferCode;
	@FindBy(xpath = "//i[contains(@class,'user-plus')]") private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//i[contains(@class,'credit-card')]") private WebElement managePaymentMethod;
	@FindBy(xpath = "//i[contains(@class,'fa-users')]") private WebElement adminUsers;
	@FindBy(xpath = "//i[contains(@class,'sidebar-item-icon')]") private WebElement settings;
	
	
	public void toGetAllTheSubMenus(String category)
	{
		for(WebElement menu:menuList)
		{

			String getMenuText = menu.getText();
			if(getMenuText.equals(category))
			{
				menu.click();
			}
		}
	}
	public void clickOnDashBoard()
	{
		//dashBoard.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(dashBoard));
	}
	public void clickOnManageOrders()
	{
		//manageOrders.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(manageOrders));
	}
	public void clickOnGroceries()
	{
		//groceries.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(groceries));
	}
	public void clickOnManageExpense()
	{
		manageExpense.click();
	}
	public void clickOnManageProduct()
	{
		manageProduct.click();
	}
	public void clickOnVerifyUsers()
	{
		verifyUsers.click();
	}
	public void clickOnManageUsers()
	{
		manageUsers.click();
	}
	public void clickOnPushNotification()
	{
		pushNotification.click();
	}
	public void clickOnManageContent()
	{
		manageContent.click();
	}
	public void clickOnNewsButton()
	{
		news.click();
	}
	public void clickOnManageLocation()
	{
		manageLocation.click();
	}
	public void clickOnManageSlider()
	{
		manageSlider.click();
	}
	public void clickOnMobileSlider()
	{
		mobileSlider.click();
	}
	public void clickOnManageCategory()
	{
		manageCategory.click();
	}
	public void clickOnManageOfferCode() 
	{
		manageOfferCode.click();
	}
	public void clickOnManageDeliveryBoy()
	{
		manageDeliveryBoy.click();
	}
	public void clickOnManagePaymentMethod()
	{
		managePaymentMethod.click();
	}
	public void clickOnAdminUsers() 
	{
		adminUsers.click();
	}
	public void clickOnSettings()
	{
		settings.click();
	}

}