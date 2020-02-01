package com.AdOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AdOmega.qa.base.TestBase;

public class CrmsfaPage extends TestBase {
	
//Page Factory
	
		@FindBy(linkText="CRM/SFA") WebElement crmLink;
		
//initialization
		
		public CrmsfaPage() {
			
			PageFactory.initElements(driver,this);
		}
		
//Actions
		
		public HomePage clickOnCRMSFALink() {
			
			crmLink.click();
			
			return new HomePage();
			
		}

}
