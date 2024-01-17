package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
@FindBy(className = "addNewButton")
private WebElement addNewBtn;
@FindBy(xpath="//div[contains(@class,'createNewCustomer')]")
private WebElement newCustomer;
@FindBy(xpath="//div[@class='customerNameDiv']/input")
private WebElement customerNameTB;
@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
private WebElement customerDescription;
@FindBy(xpath="//span[contains(@class,'customerSelectorPlaceholder')]")
private WebElement customerDropdown;
@FindBy(xpath="//div[text()='Our company' and @class='itemRow cpItemRow ']")
private WebElement ourCompany;
@FindBy(xpath="//div[text()='Create Customer']")
private WebElement createCustomerBtn;
@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[text()]")
private WebElement verifyTitle;
public TaskListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getAddNewBtn() {
	return addNewBtn;
}
public WebElement getNewCustomer() {
	return newCustomer;
}
public WebElement getCustomerNameTB() {
	return customerNameTB;
}
public WebElement getCustomerDescription() {
	return customerDescription;
}
public WebElement getCustomerDropdown() {
	return customerDropdown;
}
public WebElement getOurCompany() {
	return ourCompany;
}
public WebElement getCreateCustomerBtn() {
	return createCustomerBtn;
}
public WebElement getVerifyTitle() {
	return verifyTitle;
}
}









