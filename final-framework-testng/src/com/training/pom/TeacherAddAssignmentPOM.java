package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherAddAssignmentPOM {
	private WebDriver driver; 
	
	public TeacherAddAssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="SeleniumIBM")   
	private WebElement Course; 

	@FindBy(id="toolimage_8708")
	private WebElement Assignments; 
	
	@FindBy(xpath="//a[@href='/main/work/work.php?cidReq=SELENIUMIBM&id_session=0&gidReq=0&gradebook=0&origin=&action=create_dir']")
	private WebElement CreateAssignment;
	
	@FindBy(id="form1_new_dir")
	private WebElement AssignmentName; 
	
	@FindBy(className="cke_editable")
	private WebElement Description; 
	
	@FindBy(className="cke_wysiwyg_frame")
	private WebElement DescriptionTextField; 
	
	@FindBy(id="advanced_params")
	private WebElement AdvancedSettings; 
	
	@FindBy(id="form1_qualification")
	private WebElement MaximumScore; 
	
	@FindBy(id="form1_submit")
	private WebElement ValidateBtn; 
	
	@FindBy(id="toolimage_8718")
	private WebElement Settings; 
	
	@FindBy(partialLinkText="Assignments")
	private WebElement AssignmentSettings; 
	
	@FindBy(id="update_course_submit_save")
	private WebElement SaveSettingsBtn; 
	
	public void clickCourse() {
		this.Course.click();
	}
	public void clickAssignments() {
		this.Assignments.click();
	}
	public void clickCreateAssignment() {
		this.CreateAssignment.click(); 
	}
		public void sendAssignmentName(String AssignmentName) {
		this.AssignmentName.clear(); 
		this.AssignmentName.sendKeys(AssignmentName); 
	}
	public void sendDescription(String Description) {
		driver.switchTo().frame(this.DescriptionTextField);
		this.Description.sendKeys(Description); 
		driver.switchTo().defaultContent();
	}
	public void clickAdvancedSettings() {
		this.AdvancedSettings.click(); 
	}
	
	public void sendMaximumScore(String MaximumScore) {
		this.MaximumScore.clear(); 
		this.MaximumScore.sendKeys(MaximumScore); 
	}
	public void clickValidateBtn() {
		this.ValidateBtn.click(); 
	}
	public void clickSettings() {
		this.Settings.click();	
	}	
	public void clickAssignmentSettings() {
		this.AssignmentSettings.click();
	}
	public void clickSaveSettingsBtn() {
		this.SaveSettingsBtn.click();
	}
	
	}
	

