package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;


public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	@BeforeClass	
	public void openBrowser() throws IOException {
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
@BeforeMethod
public void login() throws IOException {
	FileLib file=new FileLib();
	String url = file.readPropertyData("url");
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	String un = file.readPropertyData("username");
	String pwd = file.readPropertyData("password");
	l.setLogin(un, pwd);
}
@AfterMethod
public void logout() throws InterruptedException {
	HomePage h=new HomePage(driver);
for(;;)	{
	try {
		h.setLogout();
		break;
	} catch (ElementClickInterceptedException e) {
	}
}
}
@AfterClass
public void closeBrowser() {
	driver.quit();
}
}
