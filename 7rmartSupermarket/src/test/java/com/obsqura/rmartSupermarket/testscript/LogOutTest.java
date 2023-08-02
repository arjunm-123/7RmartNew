package com.obsqura.rmartSupermarket.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LogOutPage;
import com.obsqura.rmartSupermarket.pages.LoginPage;

import Retry.Retry;
import utilities.ExcelUtility;

public class LogOutTest extends Base 
{
	LoginPage loginPage;
	LogOutPage logoutpage;
	
	@Test(retryAnalyzer = Retry.class,description="verifyWhetherUserCanAbleToLogOutFromApplication")
	public void verifyWhetherUserCanAbleToLogOutFromApplication()
	{
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
		LogOutPage logoutpage = new LogOutPage(driver);
		logoutpage.clickOnAdminButtonForLogOut().clickOnLogOutButtonInHomePage();
		boolean loginPageLogoDispalyedWhenLogOut = logoutpage.isLogInPageLogoDisplayed();
		assertTrue(loginPageLogoDispalyedWhenLogOut, " The user cannot able to logout from the Application ");
	}
}