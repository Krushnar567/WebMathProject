package webMathProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

 public class UnitsConversionsOnLength{
	 WebDriver driver;
	 Properties p = new Properties();

 @Test
 public void unitsConversionsOnLength() throws IOException {
	  
	    WebElement mathForEveryone = driver.findElement(By.xpath(p.getProperty("mathForEveryone")));
      
        mathForEveryone.click();
	  
        WebElement length = driver.findElement(By.xpath(p.getProperty("length")));
	    
        length.click();
        
        WebElement value = driver.findElement(By.xpath(p.getProperty("value")));
        value.sendKeys(p.getProperty("sendKeys"));
        
        WebElement unit1 = driver.findElement(By.xpath(p.getProperty("unit1")));
        Select drop1 = new Select (unit1);
  	    drop1.selectByIndex(0);
  	    
		
	    WebElement unit2 = driver.findElement(By.xpath(p.getProperty("unit2")));
		Select drop2 = new Select (unit2); 
		drop2.selectByIndex(1);
		  
		WebElement convert = driver.findElement(By.xpath(p.getProperty("convert")));
		convert.click();
		  
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
  public void closeBrowser() {
	  
	    driver.close();
	   
  }
}
