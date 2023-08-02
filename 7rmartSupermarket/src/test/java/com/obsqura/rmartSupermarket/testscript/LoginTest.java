package com.obsqura.rmartSupermarket.testscript;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.pages.LoginPage;

import Retry.Retry;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class LoginTest extends Base
{
		
	@Test(retryAnalyzer = Retry.class,description="Verify whether user is able to login using valid username and password",groups={"regression"})
		public void verifyTheUserIsAbleToLogInValidCredential()
		{
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(ExcelUtility.getString(0,0,"LoginPage")).enterpasswordOnPasswordField(ExcelUtility.getString(0,0,"LoginPage")).clickOnSignInButton();
		boolean ishomepage = loginPage.isHomePageDisplayed();
		assertTrue(ishomepage,"not navigated to home page");
		
		
		}
	@Test(retryAnalyzer = Retry.class,description="verifyTheUserIsAbleToLogInWithUsernameAndInvalidPassword",groups={"smoke"})
	@Parameters("username")
public void verifyTheUserIsAbleToLogInWithUsernameAndInvalidPassword(String username)
		{
		//String username = ExcelUtility.getString(1, 0, "LoginPage");
		String passWord = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(username).enterpasswordOnPasswordField(passWord).clickOnSignInButton();
		boolean isAlertPopupDisplayed = loginPage.alertMessageIsDisplayed();
		assertTrue(isAlertPopupDisplayed,"home page is displayed");
	
	
		}
	@Test(retryAnalyzer = Retry.class,description="verifyTheUserIsAbleToLogInWithInvalidUsernameAndvalidPassword" ,groups={"smoke","regression"})
public void verifyTheUserIsAbleToLogInWithInvalidUsernameAndvalidPassword()
		{
		String username = ExcelUtility.getString(1, 1, "LoginPage");
		String passWord = ExcelUtility.getString(1,0,"LoginPage");
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(username).enterpasswordOnPasswordField(passWord).clickOnSignInButton();
		boolean isAlertPopupDisplayed = loginPage.alertMessageIsDisplayed();
		assertTrue(isAlertPopupDisplayed,"home page is displayed");
		}
	
	@Test(dataProvider="LoginProvider" ,retryAnalyzer = Retry.class,description="verifyTheUserIsAbleToLogInWithInvalidUsernameAndInvalidPassword")
public void verifyTheUserIsAbleToLogInWithInvalidUsernameAndInvalidPassword()
		{
		String username = ExcelUtility.getString(1,1,"LoginPage");
		String passWord = ExcelUtility.getString(1,1,"LoginPage");
		LoginPage loginPage  = new LoginPage(driver);
		loginPage.enterUserNameOnusernamefield(username).enterpasswordOnPasswordField(passWord).clickOnSignInButton();
		boolean isAlertPopupDisplayed = loginPage.alertMessageIsDisplayed();
		assertTrue(isAlertPopupDisplayed,"home page is displayed");
	
		}	

	@DataProvider(name = "LoginProvider")
public Object[][] getDataFromTestData() {
	return new Object[][] { { ExcelUtility.getString(1, 1, "LoginPage"), ExcelUtility.getString(1, 1, "LoginPage") },
	};
}
}