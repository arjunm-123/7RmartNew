package com.obsqura.rmartSupermarket.testscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GeneralUtility;
import utilities.ScreenShotUtility;

public class Base 

{	
	private static final long IMPLICIT_WAIT = 0;
	public Properties prop;
	public FileInputStream fs;
	public WebDriver driver;
	public ScreenShotUtility scrshot;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intialiseBrowser(String browser) throws Exception
	{
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(GeneralUtility.CONFIGfILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		if (browser.equalsIgnoreCase("firefox")) 
		{
			driver = WebDriverManager.firefoxdriver().create();

		}
		else if (browser.equalsIgnoreCase("chrome")) 
		{
			driver = WebDriverManager.chromedriver().create();

		}

		else if (browser.equalsIgnoreCase("edge")) 
		{
			driver = WebDriverManager.edgedriver().create();
		} 
		else 
		{
			throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		}
	
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException 
		{
		if (iTestResult.getStatus() == ITestResult.FAILURE)
		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}
