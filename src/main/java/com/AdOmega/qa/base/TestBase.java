package com.AdOmega.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.AdOmega.qa.Utilities.TestUtils;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase(){
		
	prop=new Properties();
	
	try {
		FileInputStream fis=new FileInputStream("E:\\AderantWorkLocation\\AderantOmegaTesting\\src\\main\\java\\com\\AdOmega\\qa\\config\\config.properties");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
		}

	}
	
	//initialization
	
	public void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "E:\\AderantWorkLocation\\AderantOmegaTesting\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();	
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\AderantWorkLocation\\AderantOmegaTesting\\drivers\\geckodriver_64 bit.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITLY_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	
	
	
}