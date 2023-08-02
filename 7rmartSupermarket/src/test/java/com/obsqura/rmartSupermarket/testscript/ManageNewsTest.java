package com.obsqura.rmartSupermarket.testscript;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LoginPage;
import com.obsqura.rmartSupermarket.pages.ManageNewsPage;

import Retry.Retry;
import utilities.ExcelUtility;
public class ManageNewsTest extends Base 
{
	LoginPage loginPage;
	ManageNewsPage manageNewsPage;
	
	@Test(retryAnalyzer = Retry.class,description="verifyWhetherUserCanAbleToUPdateNewsInManageNewsPage")
	public void verifyWhetherUserCanAbleToUPdateNewsInManageNewsPage() 
	{
	LoginPage loginPage  = new LoginPage(driver);
	loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
	manageNewsPage=new ManageNewsPage(driver);
	manageNewsPage.navigateToManageNewsFromDashboard();
	manageNewsPage.clickOnNewButtonToAddNewsinManagePage().enterNewsInTheTextFiled(ExcelUtility.getString(1, 0, "News"));
	boolean alertMessageInNewsPage =manageNewsPage.isAlertMessageDisplayed();
	assertTrue(alertMessageInNewsPage,"The User cannot able to update news in manage news Page");


	}	
}
