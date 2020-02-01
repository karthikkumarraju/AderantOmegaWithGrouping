package com.AdOmega.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AdOmega.qa.Utilities.TestUtils;
import com.AdOmega.qa.base.TestBase;
import com.AdOmega.qa.pages.CrmsfaPage;
import com.AdOmega.qa.pages.HomePage;
import com.AdOmega.qa.pages.LeadsPage;
import com.AdOmega.qa.pages.LoginPage;

public class LeadsPageTest extends TestBase{
	
	LoginPage loginpage;
	CrmsfaPage crmsfapage;
	HomePage homepage;
	LeadsPage leadspage;
	
	String sheetName="Create Leads";
	
	public LeadsPageTest() {
		
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		crmsfapage=new CrmsfaPage();
		leadspage=new LeadsPage();
		
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		crmsfapage.clickOnCRMSFALink();
	}
	
	@DataProvider
	
	public Object[][]getCreateLeadTestData() throws IOException{
		
		Object[][]data=TestUtils.getDataOfCreateLead(sheetName);
				
				return data;
	}
	
	@Test(dataProvider="getCreateLeadTestData",groups= {"Regression"})
	
	public void validateCreateLeadTest(String companyName,String firstName,String lastName) {
	
		leadspage.clickOnCreateLeadLink();
		leadspage.enterLeadDetails(companyName,firstName,lastName);
		leadspage.clickOnCreateLeadButton();
	} 
	
	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}

}
