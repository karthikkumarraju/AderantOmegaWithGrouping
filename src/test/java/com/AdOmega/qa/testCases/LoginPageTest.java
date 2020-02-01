package com.AdOmega.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AdOmega.qa.base.TestBase;
import com.AdOmega.qa.pages.CrmsfaPage;
import com.AdOmega.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	CrmsfaPage crmsfapage;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(groups= {"Regression"})
	
	public void loginTest() {
		crmsfapage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}
}
