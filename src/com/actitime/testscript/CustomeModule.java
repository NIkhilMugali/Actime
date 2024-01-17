package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

public class CustomeModule extends BaseClass {
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage h=new HomePage(driver);
		h.clickTask();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomer().click();
		FileLib f = new FileLib();
		String customerName = f.readExcelData("CreateCustomer", 1, 0);
		t.getCustomerNameTB().sendKeys(customerName);
		String desc = f.readExcelData("CreateCustomer", 1, 1);
		t.getCustomerDescription().sendKeys(desc);
		t.getCustomerDropdown().click();
		t.getOurCompany().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(4000);
		String cusName = t.getVerifyTitle().getText();
		if(customerName.equals(cusName)) {
			System.out.println("Pass "+ customerName +" is same as expected " +cusName);
		}else {
			System.out.println("Fail "+ customerName +" is not same as expected " +cusName);

		}
	}@Test
	public void deleteCustomer() {
		
	}
}
