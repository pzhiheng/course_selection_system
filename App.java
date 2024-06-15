import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;


public class App {
    public static void main(String[] args) throws Exception {
        ChromeDriver driver = new ChromeDriver();
        PrintWriter out = new PrintWriter("class.txt");
        BufferedWriter bf = new BufferedWriter(out);
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
        ArrayList<String> testing = new ArrayList<>();

        String courseID = "win0divSELECT_COURSE_row$";
        for (int i = 0 ; i <= 87 ; i ++){
            try{
                
                courseID = courseID + String.valueOf(i);
                WebElement Course = driver.findElement(By.id(courseID));
                WebElement htmlArea = Course.findElement(By.className("ps_box-htmlarea"));
                //coursename
                String CourseName = htmlArea.findElement(By.xpath("./div/span/b")).getText();
                //school
                String school = Course.findElement(By.xpath("./div/div[2]/span")).getText();
                //session
                bf.write(CourseName + "," + school);
                bf.newLine();
                List<WebElement> list = new ArrayList<>();
                list = Course.findElements(By.xpath("./div/div[3]/div/div/div/div[2]/div"));
                for (WebElement session : list){
                    ///html/body/form/div[2]/div[4]/div[2]/div/div/div/div/div[7]/div[2]/div[2]/div[2]/div/div[3]/div/div/div/div[2]/div[1]
                    //first session xpath
                    String time_date_professor = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]")).getText();
                    String classNO = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[1]/b")).getText();
                    String sessionNO = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[1]")).getText();
                    String status = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[4]/span[2]")).getText();
                    String instructionMode = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[6]/span")).getText();
                    String courseLocation = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[7]")).getText();
                    String component = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[8]")).getText();
                    bf.write(classNO+","+sessionNO+","+time_date_professor+","+status+","+instructionMode+","+courseLocation+","+component);
                    bf.newLine();
                    bf.newLine();

                }
                courseID = "win0divSELECT_COURSE_row$";
                bf.newLine();
                bf.newLine();
                

            }catch(Exception e){

                System.out.println("Element not found or error occurred for index: " + i);
            }
        }


       /*try{
       // List<WebElement> elements = driver.findElements(By.xpath("//div[@class='quote']/span[@class='text']"));
       //String str = driver.findElement(By.className("ps_box-value")).getText();
       String courseID = "win0divSELECT_COURSE_row$";
       for (int i = 0 ; i <= 86 ; i ++){
        courseID = courseID + String.valueOf(i);
        ListOfCourses.add(driver.findElement(By.id(courseID)));
        System.out.println(courseID);
        courseID = courseID.substring(0,25);
    }
        ArrayList<String> testing = new ArrayList<>();

        for (WebElement e: ListOfCourses){
             String CourseName = e.findElement(By.xpath("./b")).getText();
             testing.add(CourseName);

        }

    


       }
       catch (Exception e){
        System.out.println("hhhhh");
        System.out.println(e.toString());

       }*/
        driver.quit();

    }
}

