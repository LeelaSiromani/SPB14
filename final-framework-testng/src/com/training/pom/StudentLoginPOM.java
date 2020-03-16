package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLoginPOM {
	private WebDriver driver; 
	
	public StudentLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="I lost my password")   
	private WebElement LostPassWordLink; 
	
	@FindBy(id="lost_password_user")
	private WebElement UserNameOrEmail;
	
	@FindBy(id="lost_password_submit")
	private WebElement SendMessageBtn; 
	
	@FindBy(id="login")
	private WebElement userNameValid; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	public void clickLostPassWordLink() {
		this.LostPassWordLink.click(); 
	}
	
	public void sendUserNameOrEmail(String userName) {
		this.UserNameOrEmail.clear();
		this.UserNameOrEmail.sendKeys(userName);
	}

	public void clickSendMessageBtn() {
		this.SendMessageBtn.click(); 
	}
	public void sendUserNameValid(String userNameValid) {
	this.userNameValid.clear();
	this.userNameValid.sendKeys(userNameValid);
}

	public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
}

	public void clickLoginBtn() {
	this.loginBtn.click(); 
}

}