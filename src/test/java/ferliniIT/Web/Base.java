package ferliniIT.Web;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Base {

	

 public static WebDriver driver;	
 public JavascriptExecutor js;
		//This class will run before every line of code
		@BeforeClass
		public void initiliazechrome()
		
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Techment Technology\\Downloads\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//Defining java script executor for scrolling in WebPage
			
			//LOading WebPage in chrome driver.
			driver.get("https://www.ferlini.it/");
			//Maximizming driver for a full view
			 driver.manage().window().maximize();
		}
		
		// TODO Auto-generated method stub
      
	  public void contactus()
	  {
		  WebElement Element=driver.findElement(By.xpath("//*[@class='secondary-nav']/div/ul/li[2]/a"));
			// Scrolling down the page till the element is found
			   JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("arguments[0].scrollIntoView();", Element);
		       Element.click();
	  }
	  //This class will run after completion of all code 
		@AfterClass	
	  
		public void closebrowser()
		{
			driver.close();
		}
		
	




}