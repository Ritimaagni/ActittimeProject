package com.Actitime.GeniricLibrary;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;
import com.Actitime.pom.Taskpage;

public class Baseclass {
	
	public static WebDriver driver;
	
	FileLibrary  f= new FileLibrary ();/*create a object for filelibrary class to call non static method
	to use this every class we should declare in global area.*/
	
	
	@BeforeSuite
	public void databaseconnection()
	{
		Reporter.log("database connected",true);
		
	}
	@AfterSuite
	public void databasedisconnected()
	{
		Reporter.log("database disconnected",true);	
	}
	@BeforeTest
	public void launchbrowser() throws IOException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		// to call a method from filelibrary class we use refrence variable f
		String url = f.readDataFromPropertyfile("url");
		driver.get(url);
		
		Reporter.log("browser launch",true);
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
		Reporter.log("browser closed",true);
	}
	@BeforeMethod
	public void login() throws IOException
	{
		String un = f.readDataFromPropertyfile("username");
		String pwd = f.readDataFromPropertyfile("password");
		
	// create a object for loginpage(username,password,click)
		
		LoginPage lp=new LoginPage(driver);
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
		
	
		Reporter.log("login successfully",true);
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("loged out successfully",true);
	}
	
	

}
