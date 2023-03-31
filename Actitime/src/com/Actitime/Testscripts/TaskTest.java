package com.Actitime.Testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Actitime.GeniricLibrary.Baseclass;
import com.Actitime.GeniricLibrary.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.Taskpage;

public class TaskTest extends Baseclass {
	@Test
	public void createCustomer() throws IOException 
	{

		//create a object for homepage(task,report,user)
		HomePage hp= new HomePage(driver);
		hp.getTasklnk().click();
		
				
			//create a object for taskpage
				
				Taskpage tp=new Taskpage(driver);
				tp.getAddnewbtn().click();
				tp.getNewcust().click();
				FileLibrary f= new FileLibrary();
				String name = f.readDataFromExcelFile("Sheet1", 3, 2);
				tp.getCustname().sendKeys(name);
				String desp = f.readDataFromExcelFile("Sheet1", 3, 1);
				tp.getCustdesp().sendKeys(desp);
				tp.getCreatecust().click();
	}

}
