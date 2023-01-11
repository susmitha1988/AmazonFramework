package com.amazon.customer.login.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.customer.login.constant.LoginConstant;
import com.amazon.customer.web.core.AmazonWebBaseTest;
import com.amazon.customer.web.core.XLSUtil;

public class LoginTest extends AmazonWebBaseTest implements LoginConstant{
	@BeforeMethod
	public void getbaseurl() { 
		driver.get(BASE_URL);
	}

	@DataProvider(name="logindata")
	public String[][] customerlogindata(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,sheetName,"validlogindetails");
		return data;
	}
	@Test(dataProvider="logindata")
	public void testwithvaliddata(String email,String password) throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(email, password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name="blankdata")
	public String[][] customerlogindata1(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,sheetName,"Blankdata");
		return data;
	}
	
	@Test(dataProvider="blankdata")
	public void TestingBypassingblankdata(String email,String password) throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendemil(email);
		Thread.sleep(2000);
	}
	
	@DataProvider(name="validuserdata")
	public String[][] customerlogindata2(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,sheetName,"Validuserdata");
		return data;
	}
	
	@Test(dataProvider="validuserdata")
	public void TestingBypassingValiduserdata(String email,String password) throws InterruptedException
	{	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(email, password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name="validuseridinvalidpassword")
	public String[][] customerlogindata3(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,"Sheet1","Invalidpassword");
		return data;
	}
	
	@Test(dataProvider="validuseridinvalidpassword")
	public void TestingBypassingInvalidpassword(String email,String password) throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(email, password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name="forgotPassword")
	public String[][] customerlogindata4(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,"Sheet1","ForgotPassword");
		return data;
	}
	
	@Test(dataProvider="forgotPassword")
	public void TestingForgotPasswordField(String email,String password) throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendemil(email);
		loginpage.clickforgotPassword();
		Thread.sleep(2000);
	}
	
	/*@DataProvider(name="emaiIDvalidating")
	public String[][] customerlogin(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,sheetName,"EmailID");
		return data;
	}
	
	@Test(dataProvider="emaiIDvalidating")
	public void TestingWithEmail(String email,String password) throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(email, password);
		Thread.sleep(2000);
		String errormsg=driver.findElement(By.xpath("//h4[contains(text(),'There was a problem')]")).getText();
		AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("There was a problem"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	
	
	@Test
	public void TestingOtherLinksInLoginPage1() throws InterruptedException
	{
		String Email=email+"@gmail.com";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendemil(Email);
		Thread.sleep(2000);
		loginpage.sendpassword(password);
		Thread.sleep(2000);
	}
	
	@Test
	public void TestingOtherLinksInLoginPage2() throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Notice')]")).click();;
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
		AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Amazon.com Privacy Notice - Amazon Customer Service"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	
	@DataProvider(name="FPinuserloginpage")
	public String[][] customerlogindata5(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,"Sheet1","ForgotPassword");
		return data;
	}
	
	@Test(dataProvider="FPinuserloginpage")
	public void TestingFPFieldinLoginPage(String email,String password) throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		String Email=email+"@gmail.com";
		driver.findElement(By.id("ap_email")).sendKeys(Email);
		driver.findElement(By.xpath("//span[contains(text(),'Need help?')]")).click();
		driver.findElement(By.xpath("//a[@id='auth-fpp-link-bottom']")).click();
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
        AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Amazon Password Assistance"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	@DataProvider(name="OtherissuesWithLogin")
	public String[][] customerlogindata6(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,"Sheet1","ForgotPassword");
		return data;
	}
	
	@Test(dataProvider="OtherissuesWithLogin")
	public void TestingOtherissuesWithLoginlink(String email,String password) throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		String Email=email+"@gmail.com";
		driver.findElement(By.id("ap_email")).sendKeys(Email);
		driver.findElement(By.xpath("//span[contains(text(),'Need help?')]")).click();
		driver.findElement(By.xpath("//a[@id='ap-other-signin-issues-link']")).click();
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
        AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Amazon.com - Account & Login Issues"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	
	@DataProvider(name="casesensitivityinemail")
	public String[][] customerlogindata7(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,"Sheet1","CaseSensitiveEmail");
		return data;
	}
	
	@Test(dataProvider="casesensitivityinemail")
	public void Testingcasesensitivityinemail(String email,String password) throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		String Email=email+"@gmail.com";
		Amazon_UserCredential_Utils.Passingemailidandpassword(password, driver, Email);
		driver.findElement(By.xpath("//span[@class='a-list-item']"));
        Thread.sleep(2000);
        String errormsg=driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
        AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Your password is incorrect"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}

	@Test
	public void TestingCreateAccountLink() throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();;
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
		AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Amazon Registration"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	
	@Test
	public void TestingCinditionsOfUseLinkinLP() throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		driver.findElement(By.xpath("//a[contains(text(),'Conditions of Use')]")).click();;
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
		AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Conditions of Use - Amazon Customer Service"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	
	@Test
	public void TestingPrivacyNoticeLinkinLP() throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Notice')]")).click();;
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
		AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Amazon.com Privacy Notice - Amazon Customer Service"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}
	
	@Test
	public void TestingHelpLinkinLP() throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();;
        Thread.sleep(2000);
        String errormsg=driver.getTitle();
		AssertJUnit.assertTrue(errormsg.equalsIgnoreCase("Amazon Sign-In"));
		Amazon_UserCredential_Utils.DisplayErrorMessage(errormsg);
		driver.close();
	}

	
	@DataProvider(name="passwordsecurity")
	public String[][] customerlogindata8(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,sheetName,"Passwordsecurity");
		return data;
	}
	
	@Test(dataProvider="passwordsecurity")
	public void TestingPassword(String email,String password) throws InterruptedException
	{
		WebDriver driver=WebDriverSetup();
		String Email=email+"@gmail.com";
		Amazon_UserCredential_Utils.Passingemailid(password, driver, Email);
		driver.findElement(By.id("ap_password")).sendKeys(password);        
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		WebElement link=driver.findElement(By.id("ap_password"));
		a.doubleClick(link).keyDown(Keys.CONTROL).keyDown(Keys.INSERT).perform();;
	    a.keyUp(Keys.INSERT).keyUp(Keys.CONTROL).perform();
	    driver.get("https://www.google.com/");
	    WebElement li=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	    a.click(li).keyDown(Keys.SHIFT).keyDown(Keys.INSERT).perform();
	    String password1=li.getText();
        AssertJUnit.assertFalse(password1.equalsIgnoreCase(password));
		driver.close();
	}
	
	@DataProvider(name="security")
	public String[][] customevaliddata(){
		String[][] data=XLSUtil.getTableArrayPOST(xlFilePath,"Sheet1","Validdata");
		return data;
	}
	
	@Test(dataProvider="security")
	public void TestingBycopyandpastingtheURL(String email,String password) throws InterruptedException
	{
		String Email=email+"@gmail.com";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendemil(Email);
		Thread.sleep(2000);
		loginpage.sendpassword(password);
		Thread.sleep(2000);
		String url1=driver.getCurrentUrl();
	    Actions a=new Actions(driver);
	    WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
	    a.moveToElement(element).perform();
	    driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
	    driver.get(url1);
	    String text=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).getText();
	    AssertJUnit.assertEquals(text,"Hello, Sign in");
		driver.close();
	}*/

	

}
