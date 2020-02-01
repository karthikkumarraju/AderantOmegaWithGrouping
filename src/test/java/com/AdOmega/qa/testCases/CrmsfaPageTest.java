package com.AdOmega.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AdOmega.qa.base.TestBase;
import com.AdOmega.qa.pages.CrmsfaPage;
import com.AdOmega.qa.pages.HomePage;
import com.AdOmega.qa.pages.LoginPage;

public class CrmsfaPageTest extends TestBase{
	
	LoginPage loginpage;
	CrmsfaPage crmsfapage;
	HomePage homepage;
	
	public CrmsfaPageTest() {
		
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	
	public void setUp() {
		initialization();
		LoginPage loginpage=new LoginPage();
		crmsfapage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(groups= {"Regression"})
	
	public void clickOnCrmsfaLinkTest() {
		homepage=crmsfapage.clickOnCRMSFALink();
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}

}
