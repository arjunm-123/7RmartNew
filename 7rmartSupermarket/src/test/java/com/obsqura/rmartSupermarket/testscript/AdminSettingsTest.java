package com.obsqura.rmartSupermarket.testscript;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.AdminSettingsPage;
import com.obsqura.rmartSupermarket.pages.LogOutPage;
import com.obsqura.rmartSupermarket.pages.LoginPage;

import Retry.Retry;
import utilities.ExcelUtility;

public class AdminSettingsTest extends Base 
{
	LoginPage loginPage;
	AdminSettingsPage adminSettingsPage;
	
	@Test(retryAnalyzer = Retry.class,description="verifyWhetherUserCanAbleToLogOutFromApplication")
	public void verifyWhetherUserCanAbleToLogOutFromApplication()
	{
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
		AdminSettingsPage adminSettingsPage = new AdminSettingsPage(driver);
		adminSettingsPage.clickOnAdminButtonForLogOut().clickOnSettingsButtonInHomePage();
		boolean menuListDispalyed = adminSettingsPage.isMenulistDisplayed();
		assertTrue(menuListDispalyed, " cannot able to click settings button ");
	}
}

