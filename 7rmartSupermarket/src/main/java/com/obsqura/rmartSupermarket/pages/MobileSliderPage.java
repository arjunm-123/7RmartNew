package com.obsqura.rmartSupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.netty.handler.codec.http.multipart.FileUpload;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage 
{
	 public WebDriver driver;
		
	 public MobileSliderPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
		@FindBy (xpath = "//select[@id='cat_id']")private WebElement categoryDropDown;
		@FindBy (xpath = "//button[@name='create']") private WebElement saveButton;
		@FindBy (xpath = "//input[@id='main_img']") private WebElement chooseFileButton;
		@FindBy (xpath = "//i[@class='icon fas fa-check']") private WebElement alertMessage;
		
		
		public void clickOnNewButton()
		{
			newButton.click();
		}
		public void clickOnTheCategoryDropDownBox()
		{
			categoryDropDown.click();
		}
		public void clickOnSaveButton()
		{
			saveButton.click();
		}
		
		public void selectValueFromCategoryDropDown()
		{
			PageUtility pageUtility = new PageUtility();
			pageUtility.selectDropdownbyText(categoryDropDown,ExcelUtility.getString(0, 0,"MobileSlider"));
		}
		
		public void uploadFileByClickingOnChooseFileButton()
		{
			FileUploadUtility fileUpload = new FileUploadUtility();
			fileUpload.fileUploadUsingSendKeys(chooseFileButton,GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		}
		
		
		public boolean isSuccessAlertMessageDisplayed()
		{
			return alertMessage.isDisplayed();
		}
}