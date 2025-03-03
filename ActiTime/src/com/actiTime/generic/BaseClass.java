package com.actiTime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actiTime.pom.HomePage;
import com.actiTime.pom.LoginPage;

public class BaseClass
{ 
	public WebDriver driver;
	@BeforeTest
	public void openBroswer()
	{
		Reporter.log("openBrowser",true);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 	
	}

	@AfterTest
	public void closeBroswer(){
		Reporter.log("closeBrowser",true);
		driver.quit();
	}
	
	@BeforeMethod
	public void login() throws IOException{
		Reporter.log("login",true);
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
		
	}
	@AfterMethod
	public void logout(){
		Reporter.log("logout",true);
		HomePage h=new HomePage(driver);
		h.setLogOut();	
	}
}