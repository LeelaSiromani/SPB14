package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import com.training.pom.TeacherRegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TeacherRegistrationTests {

	private WebDriver driver;
	private String baseUrl;
	private TeacherRegistrationPOM TeacherregistrationPOM;
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
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		TeacherregistrationPOM = new TeacherRegistrationPOM(driver); 
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
	@Test
	public void validRegistrationTest() {
		TeacherregistrationPOM.clickSignUpLink();
		TeacherregistrationPOM.clickTeachCourses();
		TeacherregistrationPOM.sendFirstName("manzoor");
		TeacherregistrationPOM.sendLastName("mehadi");
		TeacherregistrationPOM.sendEmail("manzoor1@gmail.com");
		TeacherregistrationPOM.sendUserName("manzoor");
		TeacherregistrationPOM.sendConfirmPassWord("manzoor");
		TeacherregistrationPOM.sendConfirmPassWord("manzoor");
		TeacherregistrationPOM.sendPhoneNumber("9876543212");
		TeacherregistrationPOM.clickRegistrationBtn(); 
		screenShot.captureScreenShot("Registration");
	}
	
}
