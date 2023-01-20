package ferliniIT.Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends Base {

	

		// TODO Auto-generated method stub
	//This class cover below point 	
	//Access "ferlini.it".
	//Check the title of the page.
	//Go to "CONTATTACI" on the footer of the page.
	//Check the title of the page.
		
	public static void main(String[] args)
	{
		
	 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Techment Technology\\Downloads\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Accessing the site
        driver.get("https://www.ferlini.it");
         //Getting Title
		 
        String homePage=driver.getTitle();
        System.out.println(homePage);
        
         //driver.manage().window().maximize();
		
		// driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);	//driver.findElement(By.xpath("//div[@class='login-btn']")).click();
		
		
	
		//Finding CONTACCTI
		WebElement Element=driver.findElement(By.xpath("//*[@class='secondary-nav']/div/ul/li[2]/a"));
	// Scrolling down the page till the element is found
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        //Found CONTACCTI and clicked on it
        Element.click();
       
       //Getting title for Contact Us Page
       
       String contactUs=driver.getTitle();
       System.out.print(contactUs);
       
       
       
       //Verifying presence of form
       WebElement Form=driver.findElement(By.xpath("//div[@class='sqs-block form-block sqs-block-form']"));
       js.executeScript("arguments[0].scrollIntoView();",Form);
       
       
       
       
       
      
       
       
       
      

	}

}
