package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	public FileLib f= new FileLib();
	@BeforeTest
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
//		FileLib f=new FileLib();
		driver.get(f.getPropertyData("Url"));
		LoginPage l=new LoginPage(driver);
		l.setLogin(f.getPropertyData("Username"),f.getPropertyData("Password"));
		Thread.sleep(3000);
	}
@AfterMethod
public void logout() {
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
//	e.getTasks();
	e.setLogout();
}
}


