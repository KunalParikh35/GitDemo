package ferliniIT.Web;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Techment Technology\\Downloads\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
         driver.get("https://www.ferlini.it/contattaci");
         driver.manage().window().maximize();
         //Map is displayed
         driver.findElement(By.xpath("//*[@id=\"block-410b055c3694f7cc62d3\"]/div/div/div/div[2]/div[2]")).isDisplayed();
         HashMap<String, String> objMap = new HashMap<String, String>();
         objMap.put("Location", "122/A Via Roveggia Verona");
         objMap.put("Region", "220");
         objMap.put("ZipCode", "37135");
         objMap.put("Country", "Italy");
         System.out.println("Elements of the Map:");
         System.out.println(objMap);
         System.out.println(objMap.keySet());
         objMap.values();
       }
     
         
         
         
	}


