package com.AdOmega.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AdOmega.qa.base.TestBase;
import com.AdOmega.qa.pages.CrmsfaPage;
import com.AdOmega.qa.pages.HomePage;
import com.AdOmega.qa.pages.LeadsPage;
import com.AdOmega.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	CrmsfaPage crmsfapage;
	HomePage homepage;
	LeadsPage leadspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	
	public void setUp() {
		initialization();
		loginpage =new LoginPage();
		homepage=new HomePage();
		crmsfapage=new CrmsfaPage();
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		crmsfapage.clickOnCRMSFALink();
	}
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest() {
		
		String homePageTitle=homepage.verifyHomePageTitle();
		System.out.println("Home page title: "+homePageTitle);
		Assert.assertEquals(homePageTitle,"My Home | opentaps CRM","Home Page title not matched");	
	}
	
	@Test(priority=2,groups= {"Regression"})
	
	public void clickOnLeadsTabTest() {
		
		homepage.clickOnLeadsTab();
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}

}
