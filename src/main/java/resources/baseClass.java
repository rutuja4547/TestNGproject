package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public  class baseClass {
	
	public WebDriver driver;
	 public Properties prop;
	 
	 public void driverInitilize() throws IOException {
	    //This will read the properties file
FileInputStream fis=new FileInputStream (System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	 
	   prop=new Properties();
	  prop.load(fis);
	  
	  String browserName= prop.getProperty("browser");
	  
	  if(browserName.equalsIgnoreCase("chrome")) {
		   driver=new ChromeDriver();
		  }
		  else if(browserName.equalsIgnoreCase("firefox")) {
		   //firefox code
		  }
		  else if(browserName.equalsIgnoreCase("Edge")) {
		   //firefox code
		  }
		  else {
		   System.out.println("please make sure you have corrct browser");
		  }
	 }
       @BeforeMethod
       public  void openUrl() throws IOException {
          driverInitilize();
          
          String urlName= prop.getProperty("Url");
          driver.get(urlName); 
         }
        
       
       
       @AfterMethod
       public void closeBrowser() throws IOException {
       
        driver.quit();
       }
}

	
	 