package webMathProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TitleTest {
   WebDriver driver;
   Properties p = new Properties();
   
  @Test
  public void titleTest() throws IOException {
	  
	        WebElement home = driver.findElement(By.xpath(p.getProperty("home")));
                home.click();
        
                String expectedTitle = "WebMath - Solve Your Math Problem";
		
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equalsIgnoreCase(actualTitle))
			
		{
			System.out.println("Title is Displayed");
		}
	
		else {
			
			System.out.println("Title is not Displayed");
		
		     }
		
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
