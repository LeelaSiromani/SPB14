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
import com.training.pom.TeacherAddAssignmentPOM;
import com.training.pom.TeacherLoginPOM;
import com.training.pom.TeacherRegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TeacherAddAssignmentTests {

	private WebDriver driver;
	private String baseUrl;
	private TeacherLoginPOM TeacherloginPOM;
	private TeacherAddAssignmentPOM TeacheraddassignmentPOM;
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
		TeacherloginPOM = new TeacherLoginPOM (driver);
		TeacheraddassignmentPOM = new TeacherAddAssignmentPOM(driver); 
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
	public void validTeacherLoginAndAddAssignementTest() {
		TeacherloginPOM.sendUserName("Leela");
		TeacherloginPOM.sendPassword("Welcome2ibm");
		TeacherloginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Teacher");
		TeacheraddassignmentPOM.clickCourse();
		TeacheraddassignmentPOM.clickAssignments();
		TeacheraddassignmentPOM.clickCreateAssignment(); 
		TeacheraddassignmentPOM.sendAssignmentName("Hands on exercises");
		TeacheraddassignmentPOM.sendDescription("exercise");
		TeacheraddassignmentPOM.clickAdvancedSettings(); 
		TeacheraddassignmentPOM.sendMaximumScore("60");
		TeacheraddassignmentPOM.clickValidateBtn(); 
		TeacheraddassignmentPOM.clickCourse();
		TeacheraddassignmentPOM.clickSettings();
		TeacheraddassignmentPOM.clickAssignmentSettings();
		TeacheraddassignmentPOM.clickSaveSettingsBtn(); 
		screenShot.captureScreenShot("AddAssignment");
	}
	
}
