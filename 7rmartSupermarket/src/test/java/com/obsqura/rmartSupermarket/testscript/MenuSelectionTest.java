package com.obsqura.rmartSupermarket.testscript;
import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LoginPage;
import com.obsqura.rmartSupermarket.pages.MenuSelectionPage;

import Retry.Retry;
import utilities.ExcelUtility;

public class MenuSelectionTest extends Base
	{
		@Test(retryAnalyzer = Retry.class,description="menuSelection")
		public void menuSelection()
			{
			LoginPage loginPage  = new LoginPage(driver);
			loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
			MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
			menuSelectionPage.clickOnDashBoard();
			menuSelectionPage.clickOnManageOrders();
			menuSelectionPage.clickOnGroceries();
			menuSelectionPage.clickOnManageExpense();
			menuSelectionPage.clickOnManageProduct();
			menuSelectionPage.clickOnVerifyUsers();
			menuSelectionPage.clickOnManageUsers();
			menuSelectionPage.clickOnPushNotification();
			menuSelectionPage.clickOnManageContent();
			menuSelectionPage.clickOnManageLocation();
			menuSelectionPage.clickOnManageSlider();
			menuSelectionPage.clickOnMobileSlider();
			menuSelectionPage.clickOnManageCategory();
			menuSelectionPage.clickOnManageOfferCode();
			menuSelectionPage.clickOnManageDeliveryBoy();
			menuSelectionPage.clickOnManagePaymentMethod();
			menuSelectionPage.clickOnAdminUsers();
			menuSelectionPage.clickOnSettings();
			
			}

}
