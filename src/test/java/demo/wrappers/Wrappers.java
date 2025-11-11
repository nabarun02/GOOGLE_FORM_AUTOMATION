package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

     ChromeDriver driver;

     String formUrl = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform?pli=1";

     public Wrappers(ChromeDriver driver){
        this.driver = driver;
     }

     public void navigateToForm(){

        if(!driver.getCurrentUrl().equals(formUrl)){
            driver.get(formUrl);
        }

     }

     public void enterTextByXpath(String xPath, String text){

         try{

            WebElement textArea = driver.findElement(By.xpath(xPath));
            
            textArea.click();

            Thread.sleep(300);
            
            textArea.clear();
            textArea.sendKeys(text);
      
         }

         catch(Exception e){
            System.out.println("Failed to enter text: " + e.getMessage());
         }

     }

     public void clickElementByXpath(String xPath){

         try{
            driver.findElement(By.xpath(xPath)).click();
         }

         catch(Exception e){
            System.out.println("Failed to click on element: "+ e.getMessage());
         }

     }

     public void selectOptions(String xPath, List<String> optionsToSelect){
         
        List<WebElement> options = driver.findElements(By.xpath(xPath));

        int sz = optionsToSelect.size();

        for(WebElement option : options){

            String optionText = option.getText().trim();
            
            if(optionsToSelect.contains(optionText)){
               
               option.click();
               
               sz--;

               if(sz == 0){
                  break;
               }

            }

        }
     }

}
