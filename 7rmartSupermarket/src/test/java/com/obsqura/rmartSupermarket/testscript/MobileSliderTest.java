package com.obsqura.rmartSupermarket.testscript;

	import static org.testng.Assert.assertTrue;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LoginPage;
import com.obsqura.rmartSupermarket.pages.MenuSelectionPage;
import com.obsqura.rmartSupermarket.pages.MobileSliderPage;

import Retry.Retry;
import utilities.ExcelUtility;
	import utilities.PageUtility;

public class MobileSliderTest extends Base
{
		
		@Test(retryAnalyzer = Retry.class,description="checkWhetherTheUserAbletoSelectValueFromDropDown")
		public void checkWhetherTheUserAbletoSelectValueFromDropDown() throws InterruptedException
		{
			LoginPage loginPage  = new LoginPage(driver);
			loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
			MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
			menuSelectionPage.clickOnMobileSlider();
			MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
			mobileSliderPage.clickOnNewButton();
			mobileSliderPage.clickOnTheCategoryDropDownBox();
			mobileSliderPage.selectValueFromCategoryDropDown();
			mobileSliderPage.uploadFileByClickingOnChooseFileButton();
			mobileSliderPage.clickOnSaveButton();
				
			boolean isSuccessMessageDisplayed = mobileSliderPage.isSuccessAlertMessageDisplayed();
			assertTrue(isSuccessMessageDisplayed, "Not successfully saved");
		}
}

