package com.obsqura.rmartSupermarket.testscript;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LoginPage;
import com.obsqura.rmartSupermarket.pages.ManageLocationPage;

import Retry.Retry;
import utilities.ExcelUtility;


public class ManageLocationTest extends Base
{
	LoginPage loginPage;
	ManageLocationPage manageLocationPage;

	@Test(retryAnalyzer = Retry.class,description="verifyWhetherLocationIsUpdatedInLocationPage", groups={"regression"})
	public void verifyWhetherLocationIsUpdatedInLocationPage() 
	{
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
		ManageLocationPage manageLocationPage = new ManageLocationPage(driver);
		manageLocationPage.clickMoreInfoLocationPage().clickOnNewBottonInLocationPage().clickOnCountryToSelectInLocationPage(ExcelUtility.getString(1, 0, "Country")).clickOnStateToSelectInLocationPage(ExcelUtility.getString(1, 0, "State")).enterLocationInLocationPage(ExcelUtility.getString(1, 0, "location")).enterDeliveryChargeInLocationPage(ExcelUtility.getString(1, 0, "DeliveryCharge")).ClickOnSaveButtonInLocationPage();
		boolean isAlertMessageShownInPage = manageLocationPage.isAlertMessageDispalyedInLocationPage();
		assertTrue(isAlertMessageShownInPage, "Location cannot updated in Location Page");
	}
}