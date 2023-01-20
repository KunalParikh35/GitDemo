package ferliniIT.Web;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.checkerframework.common.returnsreceiver.qual.This;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import groovy.util.NodeList;

//This Class cover reading xml and adding data to foeld and submitting form
public class XmlReader extends Base{


	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		
		// TODO Auto-generated method stub
		//Reading XML
	
			String filePath = "C:\\Users\\Techment Technology\\Downloads\\formInput.xml";
			File file = new File(filePath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			String messaggio = doc.getElementsByTagName("messaggio").item(0).getTextContent();
            String nomecognome = doc.getElementsByTagName("nomecognome").item(0).getTextContent();
            String azienda = doc.getElementsByTagName("azienda").item(0).getTextContent();
            String email = doc.getElementsByTagName("email").item(0).getTextContent();
            String recapito = doc.getElementsByTagName("recapito").item(0).getTextContent();
		
            //creating Substring for recapito
            String cc=recapito.substring(0,1);
            String ac=recapito.substring(1,4);
            String lc=recapito.substring(4,7);
            String ls=recapito.substring(7,11);
            System.out.println(cc);
            
            
            System.out.println("\n [Debug Info]\n ------------"
                    + "\n Message:\t\t" + messaggio
                    + "\n Name:\t\t" + nomecognome
                    + "\n azienda:\t\t" + azienda
                    + "\n email:\t" + email
                    + "\n recapito:\t" + recapito
                    );
			
            XmlReader xr=new XmlReader();
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            try {
            	
            
            	//WebElement Element1=driver.findElement(By.xpath("//*[@class='secondary-nav']/div/ul/li[2]/a"));
            	// Scrolling down the page till the element is found		
               
            	 // js1.executeScript("arguments[0].scrollIntoView();", Element1);
                 // Element1.click();
            	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Techment Technology\\Downloads\\Selenium Downloads\\chromedriver_win32\\chromedriver.exe");
    			WebDriver driver = new ChromeDriver();
                 driver.get("https://www.ferlini.it/contattaci");
                 driver.manage().window().maximize();
            	
            
                 
               //Verify the presence of Messaggio * 
                String vmsg=driver.findElement(By.xpath("//*[@id=\"textarea-yui_3_17_2_53_1489218200494_4206\"]/label")).getText();
       		    Assert.assertEquals("Messaggio *", vmsg);
       		//Verify the presence of Nome e Cognome 
       		    String vname=driver.findElement(By.xpath("//*[@id=\"text-yui_3_17_2_1_1490690886464_15563\"]/label")).getText();
    		    Assert.assertEquals("Nome e Cognome *", vname);
    		   
    		  //Verify the presence of Azienda 
    		    String vaz=driver.findElement(By.xpath("//*[@id=\"text-yui_3_17_2_1_1490690886464_16230\"]/label")).getText();
    		    Assert.assertEquals("Azienda *", vaz);
       		    
    		  //Verify the presence of Indirizzo Email  
    		    String vemail=driver.findElement(By.xpath("//*[@id=\"email-yui_3_17_2_53_1489218200494_4204\"]/label")).getText();
    		    Assert.assertEquals("Indirizzo Email *", vemail);
    		    
    		  //Verify the presence of Recapito Telefonico
    		    String vrecap=driver.findElement(By.xpath("//*[@id=\"phone-yui_3_17_2_1_1490690886464_16897\"]/legend")).getText();
    		    Assert.assertEquals("Recapito Telefonico", vrecap);
    		    
                //enter details for messaggio
				driver.findElement(By.id("textarea-yui_3_17_2_53_1489218200494_4206-field")).sendKeys(messaggio);
			//enter detail for	nomecognome
				driver.findElement(By.id("text-yui_3_17_2_1_1490690886464_15563-field")).sendKeys(nomecognome);
			//enter detail for	azienda
				driver.findElement(By.id("text-yui_3_17_2_1_1490690886464_16230-field")).sendKeys(azienda);
			//enter detail for	email
				
				driver.findElement(By.id("email-yui_3_17_2_53_1489218200494_4204-field")).sendKeys(email);
			//enter detail for recapito by substring created
				driver.findElement(By.xpath("//*[@id=\"phone-yui_3_17_2_1_1490690886464_16897\"]/div[1]/label/input")).sendKeys(cc);
				driver.findElement(By.xpath("//*[@id=\"phone-yui_3_17_2_1_1490690886464_16897\"]/div[2]/label/input")).sendKeys(ac);
				driver.findElement(By.xpath("//*[@id=\"phone-yui_3_17_2_1_1490690886464_16897\"]/div[3]/label/input")).sendKeys(lc);
				driver.findElement(By.xpath("//*[@id=\"phone-yui_3_17_2_1_1490690886464_16897\"]/div[4]/label/input")).sendKeys(ls);
			//select submit buttom
				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@class='button sqs-system-button sqs-editable-button sqs-button-element--primary']")).click();
				
				//Verify for Thank you message after form submission
				driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//div[@class='form-submission-text']")).isDisplayed();           
				String confirmationmsg=driver.findElement(By.xpath("//div[@class='form-submission-text']")).getText();
                System.out.print(confirmationmsg);
            } 
            catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
	}

	

	


