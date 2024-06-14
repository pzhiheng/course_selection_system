import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.*;
import java.io.*;


public class App {
    public static void main(String[] args) throws Exception {
        Object obj = new Object();
        ChromeDriver driver = new ChromeDriver();
        PrintWriter out = new PrintWriter("class.txt");
        ArrayList<WebElement> ListOfCourses = new ArrayList<>(); 
        driver.get("https://sis.nyu.edu/psc/csprod/EMPLOYEE/SA/c/NYU_SR.NYU_CLS_SRCH.GBL");
        //driver.get("https://quotes.toscrape.com/");
        Thread.sleep(30000);
        /*synchronized (obj) {
            try {
                obj.wait(5000); // Must be called within a synchronized block
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        //obj.wait(500);
        //driver.manage().wait(5000);
        
       try{
       // List<WebElement> elements = driver.findElements(By.xpath("//div[@class='quote']/span[@class='text']"));
       //String str = driver.findElement(By.className("ps_box-value")).getText();
       String courseID = "win0divSELECT_COURSE_row$";
       for (int i = 0 ; i < 86 ; i ++){
        courseID = courseID + String.valueOf(i);
        ListOfCourses.add(driver.findElement(By.id(courseID)));
        System.out.println(courseID);
        courseID = courseID.substring(0,25);}
        ArrayList<String> testing = new ArrayList<>();

        for (WebElement e: ListOfCourses){
             String CourseName = e.findElement(By.xpath("//b")).getText();
             testing.add(CourseName);

        }
        System.out.println(testing.toString());
    
       /*for(String str: list){
        System.out.println(str);
        out.println(str);

       }*/}
       catch (Exception e){
        System.out.println("hhhhh");
        System.out.println(e.toString());

       }
        driver.quit();

    }
}
