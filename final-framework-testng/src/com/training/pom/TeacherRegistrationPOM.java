package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherRegistrationPOM {
	
	private WebDriver driver; 
	
	public TeacherRegistrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign up!")   
	private WebElement SignUpLink; 
	
	@FindBy(xpath="//*[@value='1']")      
	private WebElement TeachCourses;
	
	@FindBy(id="registration_firstname")
	private WebElement FirstName; 
	
	@FindBy(id="registration_lastname")
	private WebElement LastName; 

	@FindBy(id="registration_email")
	private WebElement Email;

	@FindBy(id="username")
	private WebElement UserName; 
	
	@FindBy(id="pass1")
	private WebElement PassWord;
	
	@FindBy(id="pass2")
	private WebElement ConfirmPassWord;
	
	@FindBy(id="registration_phone")
	private WebElement PhoneNumber;
	
	@FindBy(id="registration_submit")
	private WebElement RegistrationBtn; 
		
	public void clickSignUpLink() {
		this.SignUpLink.click(); 
	}
	
	public void clickTeachCourses() {
		this.TeachCourses.click(); 
	}
	public void sendFirstName(String FirstName) {
		this.FirstName.clear();
		this.FirstName.sendKeys(FirstName);
	}
	public void sendLastName(String LastName) {
		this.LastName.clear();
		this.LastName.sendKeys(LastName);
	}
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	public void sendUserName(String UserName) {
		this.UserName.clear();
		this.UserName.sendKeys(UserName);
	}
	public void sendPassWord(String PassWord) {
		this.PassWord.clear();
		this.PassWord.sendKeys(PassWord);
	}
	public void sendConfirmPassWord(String ConfirmPassWord) {
	this.ConfirmPassWord.clear();
	this.ConfirmPassWord.sendKeys(ConfirmPassWord);
	}
	public void sendPhoneNumber(String PhoneNumber) {
	this.PhoneNumber.clear(); 
	this.PhoneNumber.sendKeys(PhoneNumber); 
	}
	public void clickRegistrationBtn() {
	this.RegistrationBtn.click(); 
	}
}