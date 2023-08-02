package com.obsqura.rmartSupermarket.testscript;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.AdminUserPage;
import com.obsqura.rmartSupermarket.pages.LoginPage;

import Retry.Retry;
import utilities.ExcelUtility;

public class AdminUserTest extends Base
{
	LoginPage loginPage;
	AdminUserPage adminUserPage;
	
	@Test(retryAnalyzer = Retry.class,description="verifyUserCanAbleToAddNewUserInAdminUserPage")
	public void verifyUserCanAbleToAddNewUserInAdminUserPage() 
	{
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickOnMoreInfoButtonToloadAdminUserPage().clickOnNewButtonToAddUserserInAdminUserPage().enterUserNAmeForNewUserInAdminPage(ExcelUtility.getString(1, 0, "AdminUserInformation")).enterPasswordForNewUserInAdminPage(ExcelUtility.getString(1, 1, "AdminUserInformation")).clickOnUserTypeButtonInAdminUserPage();
		adminUserPage.clickOnSaveButtonToSaveTheDetailsInAdminUserInfoPage();
		boolean isAlertMessageDispalyedInAdminUser = adminUserPage.isAlertMessageGeneratedWhenSaveButtonIsClicked();
		assertTrue(isAlertMessageDispalyedInAdminUser, "The user cannot able to add new user in the admin user page");

	}
}

