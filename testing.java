import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
public class testing {
        public static void main(String[] args) throws Exception{
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://sis.nyu.edu/psc/csprod/EMPLOYEE/SA/c/NYU_SR.NYU_CLS_SRCH.GBL");
            Thread.sleep(30000);
    
            String courseID = "win0divSELECT_COURSE_row$1";
            try{
                WebElement test = driver.findElement(By.id(courseID));
                System.out.println(test.getText());
                //school
                System.out.println(test.findElement(By.xpath("./div/div[2]/span")));
                //session
                List<WebElement> list = new ArrayList<>();
                list = test.findElements(By.xpath("./div/div[3]/div/div/div/div[2]/div"));
                for (WebElement e : list){
                    System.out.println(e.getText());
                }


            }
            catch (Exception e){
                System.out.println("faile1");


            }

            driver.quit();
            }
    
    
    
        }
    
