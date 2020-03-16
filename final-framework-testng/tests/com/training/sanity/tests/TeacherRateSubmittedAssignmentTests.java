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
import com.training.pom.TeacherRateSubmittedAssignementPOM;
import com.training.pom.TeacherRegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TeacherRateSubmittedAssignmentTests {

	private WebDriver driver;
	private String baseUrl;
	private TeacherLoginPOM TeacherloginPOM;
	private TeacherRateSubmittedAssignementPOM TeacherratesubmittedassignementPOM;
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
		TeacherratesubmittedassignementPOM = new TeacherRateSubmittedAssignementPOM(driver); 
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
	public void validateRatetheSubmittedAssignment() throws InterruptedException {
		TeacherloginPOM.sendUserName("Leela");
		TeacherloginPOM.sendPassword("Welcome2ibm");
		TeacherloginPOM.clickLoginBtn(); 
		TeacherratesubmittedassignementPOM.clickCourse();
		TeacherratesubmittedassignementPOM.clickAssignements();
		TeacherratesubmittedassignementPOM.clickSubmittedAssignment();
		Thread.sleep(2000);
		TeacherratesubmittedassignementPOM.clickCorrectAndRate();
		TeacherratesubmittedassignementPOM.sendScore("40");
		TeacherratesubmittedassignementPOM.clickSendMessageBtn();
		TeacherratesubmittedassignementPOM.clickNameContainingAssessmentLink(); 
		screenShot.captureScreenShot("RateAssignment");
	}
	
}
