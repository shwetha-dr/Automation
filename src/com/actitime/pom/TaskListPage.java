package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement AddNew;
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement NewCustomer;
	@FindBy(xpath="//input[contains(@class,'inputNameField')]")
	private WebElement CustomerName;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement CustomerDescription;
	@FindBy(xpath="(//div[@class='dropdownButton'])[15]")
	private WebElement DropDownBtn;
	@FindBy(xpath="//div[@class='searchItemList']/div[.='Our company']")
    private WebElement DropDownOption;
	@FindBy(xpath="(//div[.='  Create Customer'])[2]")
	private WebElement CreateCustomerBtn;
	public WebElement getCreateCustomerBtn() {
		return CreateCustomerBtn;
	}
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='title']")
private WebElement CustomerCreated;
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddNew() {
		return AddNew;
	}
	public WebElement getNewCustomer() {
		return NewCustomer;
	}
	public WebElement getCustomerName() {
		return CustomerName;
	}
	public WebElement getCustomerDescription() {
		return CustomerDescription;
	}
	public WebElement getDropDownBtn() {
		return DropDownBtn;
	}
	public WebElement getDropDownOption() {
		return DropDownOption;
	}
	public WebElement getCustomerCreated() {
		return CustomerCreated;
	}
	
	
	
	
}