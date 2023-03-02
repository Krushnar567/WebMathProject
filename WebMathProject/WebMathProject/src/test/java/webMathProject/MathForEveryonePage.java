package webMathProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MathForEveryonePage {
        WebDriver driver;
        Properties p = new Properties();

@Test
public void mathForEveryonePage() throws IOException {
	 
        WebElement mathForEveryone = driver.findElement(By.xpath(p.getProperty("mathForEveryone")));
        
        mathForEveryone.click();
        
  } 
  
 @BeforeClass
 public void launchURL() throws IOException {
	  
	  WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
		
	  FileInputStream fis = new FileInputStream("C:\\Users\\krush\\OneDrive\\Desktop\\Excelr\\WebMathProject\\src\\test\\java\\com\\utils\\data.properties");
	    
	   p.load(fis);
	    
	   driver.get(p.getProperty("url"));
	   driver.manage().window().maximize();
		
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  
	}

 @AfterClass
 public void afterClass() {
	  
	    driver.close();
  }

}
