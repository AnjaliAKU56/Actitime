package com.actiTime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseClass;
import com.actiTime.generic.FileLib;
import com.actiTime.pom.HomePage;
import com.actiTime.pom.TaskListPage;

@Listeners(com.actiTime.generic.ListenerImplementation.class)

public class CustomerModule extends BaseClass {
	    
@Test
    public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
	Reporter.log("Create Customer",true);
	FileLib f=new FileLib();
	String expCustomerName=f.getExcelData("CreateCustomer",1,3);
	String customerDescription=f.getExcelData("CreateCustomer",1,4);
	HomePage h=new HomePage(driver);
	Thread.sleep(3000);
	h.setTaskTab();
	TaskListPage t=new TaskListPage(driver);
	Thread.sleep(3000);
	t.getAddNewBtn().click();
	Thread.sleep(3000);
	t.getNewCustomerOption().click();
	Thread.sleep(3000);
	t.getEnterCustomerNameTbx().sendKeys(expCustomerName);
	Thread.sleep(3000);
	t.getCustomerDescriptionTbx().sendKeys(customerDescription);
	Thread.sleep(3000);
	t.getSelectCustomerDD().click();
	Thread.sleep(3000);
	t.getOurCompanyOption().click();
	Thread.sleep(3000);
	t.getCreateCustomerBtn().click();
	Thread.sleep(3000);
	String actualCustomer=t.getActualCustomerName().getText();
	Assert.assertEquals(actualCustomer,expCustomerName);
	}
}
