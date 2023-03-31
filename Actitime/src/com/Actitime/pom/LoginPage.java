package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwtbx;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement lgbtn;
	
	//initilization
	
	//create a construtor
		public LoginPage(WebDriver driver)
		{
			//to call static method we need to call a pagefactory class
			PageFactory.initElements(driver, this);
		}
		
		//utilization

		public WebElement getUntbx() {
			return untbx;
		}

		public WebElement getPwtbx() {
			return pwtbx;
		}

		public WebElement getLgbtn() {
			return lgbtn;
		}
		
	
		

}
