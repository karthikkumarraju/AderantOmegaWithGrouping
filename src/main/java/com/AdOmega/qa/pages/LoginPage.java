package com.AdOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AdOmega.qa.base.TestBase;

public class LoginPage extends TestBase{
	
//Page factory
	
	@FindBy(name="USERNAME") WebElement username;
	@FindBy(name="PASSWORD") WebElement password;
	@FindBy(className="decorativeSubmit") WebElement loginBtn;
	
//initialization
	
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
		
	}

//Actions
	
	public CrmsfaPage login(String un,String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new CrmsfaPage();
	}

}
