package com.AdOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AdOmega.qa.base.TestBase;

public class LeadsPage extends TestBase{
	
//PageFactory
	
	@FindBy(xpath="//a[text()='Create Lead']") WebElement createLeadLink ;
	@FindBy(xpath="//input[@ id=\"createLeadForm_companyName\"]") WebElement companyName;
	@FindBy(xpath="//input[@ id=\"createLeadForm_firstName\"]") WebElement firstName;
	@FindBy(xpath="//input[@ id=\"createLeadForm_lastName\"]") WebElement lastName;
	@FindBy(xpath="//input[@ name=\"submitButton\"]") WebElement createLeadButton;
	
//initialization
	
	public LeadsPage() {
		
		PageFactory.initElements(driver,this);
	}
	
//Actions
	
	public void clickOnCreateLeadLink(){
		createLeadLink.click();
	}
	
	public void enterLeadDetails(String compName,String fName,String lName) {
		
		companyName.sendKeys(compName);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
	
	}
	
	public void clickOnCreateLeadButton() {
		createLeadButton.click();
	}
}

