package com.amazon.customer.login.constant;

public interface LoginConstant {
	String USERID_LOCATER = "ap_email";
	String CONTINUE_LOCATER = "continue";
	String PASSWORD_LOCATER = "ap_password";
    String SIGNIN_LOCATER = "signInSubmit";
	String sheetName = "Sheet1";

    
    String WEBDRIVER_CHROMEDRIVER = "webdriver.chrome.driver";
	String CHROMEDRIVER_PATH = "C:\\Users\\chiru\\eclipse-workspace\\com.KOHLS.LoginPage\\Driver\\chromedriver.exe";

	 String BASE_URL = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Ftag%3Damazusnavi-20%26hvadid%3D381891887666%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D14855069028573647441%26hvpone%3D%26hvptwo%3D%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9028275%26hvtargid%3Dkwd-6175535867%26ref%3Dnav_signin%26hydadcr%3D28881_11845388%26gclid%3DCjwKCAjw6fyXBhBgEiwAhhiZsigjz8I7rBhxwoJmJ61o5iyB3jEoTQKz5T4qqrXFvc8a0SBz0iozWxoCnLMQAvD_BwE&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
	 String xlFilePath = "C:\\Users\\chiru\\Documents\\APITestData\\AmazonLoginPageData.xls";
	 
	 
    String AMAZON_WELCOMEPAGE_TITLE = "Amazon.com. Spend less. Smile more.";
    
    
    String XPATH_USEREMAIL_ERRORMESSAGE = "//div[contains(text(),'Enter your email or mobile phone number')]";

}
