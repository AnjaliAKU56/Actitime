package com.actiTime.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseClass;

public class TestClasses  {
	@Test
	public void createCustomer() {
		Reporter.log("createCustomer",true);	
	}
	@Test
	public void deleteCustomer() {
		Reporter.log("deleteCustomer",true);	
	}
}

