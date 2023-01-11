package com.amazon.customer.login.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(how=How.ID,using="ap_email")
	private WebElement searchemail;
	
	@FindBy(id="continue")
	private WebElement searchcontinuebutton;
	
	@FindBy(how=How.ID,using="ap_password")
	private WebElement searchpassword;
	
	@FindBy(id="signInSubmit")
	private WebElement searchsigninbutton;
	
	@FindBy(id="auth-fpp-link-bottom")
    private WebElement findForgotPassword;
	
	public LoginPage(WebDriver driver){
	PageFactory.initElements(driver,this);
	}
	
	public void searchemailbox(String email) {
		searchemail.sendKeys(email);
	}
	
	public void searchcontinuebutton() {
		searchcontinuebutton.click();
	}
	
	public void serachpasswordbox(String password) {
		searchpassword.sendKeys(password);
	}
	public void searchsigninbutton() {
		searchsigninbutton.click();
	}
	
	public void sendemil(String email) {
		searchemailbox(email);
		searchcontinuebutton();
	}
	public void sendpassword(String password) throws InterruptedException {
		serachpasswordbox(password);
		Thread.sleep(2000);
		searchsigninbutton();
	}
	public void login(String email,String password) throws InterruptedException
	{
		sendemil(email);
		sendpassword(password);
		
	}
	public void clickforgotPassword() {
		findForgotPassword.click();
	}
}
