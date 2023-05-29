package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModels.LoginPageObjects;
import resources.baseClass;
import resources.constants;

public class VerifyLogin  extends baseClass{
	
	@Test(dataProvider="testData")
	
	
	 public void login(String uname,String password) throws IOException {
		  
		  
		  LoginPageObjects obj=new LoginPageObjects(driver);
		  obj.enterUsername().sendKeys(uname);
		  
		  obj.enterPassword().sendKeys(password);
		  
		  obj.clickOnLogin().click();
		  
		  //commonMethods.handleAssertions(password, uname, password);
		  
		  SoftAssert a=new SoftAssert();
		  String actual=obj.errorText().getText();
		    
		  String expected="Please check your password. If you still can't log in, contact your Salesforce administrator.";
		  
		  a.assertEquals(actual, expected,"Error message is not matching");
		  
		     a.assertAll();
		    
	 }
	 
	 @DataProvider
	 public Object[][] testData() {
	  Object[][] data=new Object[4][2];
	  data[0][0]=constants.username1;
	  data[0][1]=constants.password1;
	  data[1][0]=constants.username2;
	  data[1][1]=constants.password2;
	 
	 
	  return data;
	 }
	 
}



