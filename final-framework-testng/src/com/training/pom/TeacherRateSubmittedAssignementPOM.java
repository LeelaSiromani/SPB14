package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherRateSubmittedAssignementPOM {
	
	private WebDriver driver;
	
	public TeacherRateSubmittedAssignementPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="SeleniumIBM")   
	private WebElement Course; 
	
	@FindBy(id="istooldesc_8708")   
	private WebElement Assignements; 
	
	@FindBy(linkText="test")      
	private WebElement SubmittedAssignment;
	
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/main/work/view.php?cidReq=SELENIUMIBM&id_session=0&gidReq=0&gradebook=0&origin=&id=92']")	
	private WebElement CorrectAndRate;
		
	@FindBy(id="qualification")
	private WebElement Score; 
	
	@FindBy(id="work_comment_button")
	private WebElement SendMessageBtn;
	
	@FindBy(xpath="//a[@href=\'http://elearning.upskills.in/main/work/work_list_all.php?id=91&cidReq=SELENIUMIBM&id_session=0&gidReq=0&gradebook=0&origin=&']")	
	private WebElement NameContainingAssessmentLink;
	
	public void clickCourse() {
		this.Course.click();
	}
		public void clickAssignements() {
		this.Assignements.click();
	}
		public void clickSubmittedAssignment() {
		this.SubmittedAssignment.click();
	}
	public void clickCorrectAndRate() {
		this.CorrectAndRate.click();
	}
	public void sendScore(String Score) {
		this.Score.clear(); 
		this.Score.sendKeys(Score);
	}
	public void clickSendMessageBtn() {
	this.SendMessageBtn.click(); 
	}
	public void clickNameContainingAssessmentLink() {
		this.NameContainingAssessmentLink.click(); 
		}

}
