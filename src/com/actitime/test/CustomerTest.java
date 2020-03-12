package com.actitime.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.TaskListPage;



public class CustomerTest extends BaseClass{
	@Test
	public void testCreateCustomer() throws Exception
	{
		String ExpectedCustomer = f.getExceldata("CreateCustomer", 1, 2);
		String customerdescription = f.getExceldata("CreateCustomer", 1, 3);
		WebDriverWait wait=new WebDriverWait(driver,10);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.getTasks().click();
		TaskListPage t=new TaskListPage(driver);
		wait.until(ExpectedConditions.visibilityOf(t.getAddNew()));
		t.getAddNew().click();
		Thread.sleep(2000);
		t.getNewCustomer().click();
		Thread.sleep(3000);
		t.getCustomerName().sendKeys(ExpectedCustomer);
		t.getCustomerDescription().sendKeys(customerdescription);
		t.getDropDownBtn().click();
		t.getDropDownOption().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(3000);
		String ActualCustomer=t.getCustomerCreated().getText();
      Assert.assertEquals(ExpectedCustomer, ActualCustomer);
		Reporter.log("Customer Created Successfully",true);
	}

}
