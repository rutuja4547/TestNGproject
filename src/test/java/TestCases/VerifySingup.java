package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjectModels.LoginPageObjects;
import PageObjectModels.singuPageObjects;
import resources.baseClass;
import resources.constants;

public class VerifySingup extends baseClass{
	@Test
	public void singup() throws IOException, InterruptedException {

		 
		  LoginPageObjects lpo=new LoginPageObjects(driver);
		  
		   lpo.clickOntryForFreee().click();
		   
		   singuPageObjects spo=new singuPageObjects(driver);
		   Thread.sleep(5000);

		   spo.enterFirstname().sendKeys(constants.firstname);

		   Select s=new Select(spo.selectEmployee());
		   s.selectByIndex(1);
		   
}
}
