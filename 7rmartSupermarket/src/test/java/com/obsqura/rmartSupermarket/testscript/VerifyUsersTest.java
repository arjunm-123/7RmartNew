package com.obsqura.rmartSupermarket.testscript;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LoginPage;
import com.obsqura.rmartSupermarket.pages.ManageLocationPage;
import com.obsqura.rmartSupermarket.pages.MenuSelectionPage;
import com.obsqura.rmartSupermarket.pages.VerifyUsersPage;

import Retry.Retry;
import utilities.ExcelUtility;

public class VerifyUsersTest extends Base
{
	LoginPage loginPage;
	MenuSelectionPage menuSelectionPage;
	
	@Test(retryAnalyzer = Retry.class,description="verifyTheUserExistsInTheVerifyUsersList")
	public void verifyTheUserExistsInTheVerifyUsersList()
		{
		
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
		String name = ExcelUtility.getString(0, 0,"VerifyUserPage");
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnVerifyUsers();
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox();
		verifyUsersPage.enterNameinSearchField(name);
		verifyUsersPage.clickOnSearchButton();
		String actualResult = verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList();
		assertEquals(name, actualResult,"The entered name is not exists in the actual result");	
		}
	
	@Test
	public void checkingSearchFunctioanlity() throws InterruptedException
	{
		String name = ExcelUtility.getString(1, 1,"VerifyUserPage");
		String userName = ExcelUtility.getString(0, 0,"LoginPage");
		String password = ExcelUtility.getString(0, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(userName).enterpasswordOnPasswordField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnVerifyUsers();
		
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox();
		verifyUsersPage.enterNameinSearchField(name);
		verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList(name, false);
		verifyUsersPage.clickOnSearchButton();
		
	}

}