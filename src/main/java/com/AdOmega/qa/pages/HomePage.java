package com.AdOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AdOmega.qa.base.TestBase;

public class HomePage extends TestBase {
	
//Page factory
	
	@FindBy(xpath="//a[contains(text(),'My Home')]") WebElement myHomeTab;
	@CacheLookup
	
	@FindBy(xpath="//div[contains(text(),'My Home')]") WebElement myHomeTitle;
	
	@FindBy(xpath="//a[@href='/crmsfa/control/leadsMain']") WebElement leadsTab;
	
//initialization
	
		public HomePage() {
			
			PageFactory.initElements(driver,this);
		}
		
//Actions
		
		public String verifyHomePageTitle() {
			
			return driver.getTitle();
			
				
		}
		
		public LeadsPage clickOnLeadsTab() {
			leadsTab.click();
			
			return new LeadsPage();
		}

}
