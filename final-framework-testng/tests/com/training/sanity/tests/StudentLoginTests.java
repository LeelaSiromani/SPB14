package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.StudentLoginPOM;
import com.training.pom.TeacherLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentLoginTests {

	private WebDriver driver;
	private String baseUrl;
	private StudentLoginPOM StudentloginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		StudentloginPOM = new StudentLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=10, enabled=true)
	public void validForgotPasswordTest() {
		StudentloginPOM.clickLostPassWordLink(); 
		StudentloginPOM.sendUserNameOrEmail("Leela2");
		StudentloginPOM.clickSendMessageBtn(); 
		String error = driver.findElement(By.className("error-msg")).getText();
		System.out.println(error);
		if(error.equals("Your password has been emailed to you. "))
			System.out.println("TestCase Pass");
		else
			System.out.println("TestCase Failed");
		screenShot.captureScreenShot("Student");
	}
	@Test(priority=20, enabled=true)
	public void validForLoginTest() {
				StudentloginPOM.sendUserNameValid("Leela2");
				StudentloginPOM.sendPassword("Welcome2ibm");
				StudentloginPOM.clickLoginBtn(); 
				screenShot.captureScreenShot("Student2");
	}
}
