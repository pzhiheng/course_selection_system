import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.*;
import java.io.*;
public class testing {
    public static void main(String[] args) throws Exception {
        ChromeDriver driver = new ChromeDriver();
        PrintWriter out = new PrintWriter("class.txt");
        ArrayList<WebElement> ListOfCourses = new ArrayList<>(); 
        driver.get("https://quotes.toscrape.com/");
        try{
            WebElement web= driver.findElement(By.className("quote"));
            System.out.println(web.getText());
            List<WebElement> list = web.findElements(By.xpath("//span"));
            for(WebElement e : list){
                System.out.println(e.getText());
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
    driver.quit();
}}
