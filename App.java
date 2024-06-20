import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;


public class App {
    public static void main(String[] args) throws Exception {
        ChromeDriver driver = new ChromeDriver();
        PrintWriter out = new PrintWriter("class.txt");
        BufferedWriter bf = new BufferedWriter(out);
        driver.get("https://sis.nyu.edu/psc/csprod/EMPLOYEE/SA/c/NYU_SR.NYU_CLS_SRCH.GBL");
        Thread.sleep(30000);

        String courseID = "win0divSELECT_COURSE_row$";
        for (int i = 0 ; i <= 65 ; i ++){
            try{
                
                courseID = courseID + String.valueOf(i);
                WebElement Course = driver.findElement(By.id(courseID));
                WebElement htmlArea = Course.findElement(By.className("ps_box-htmlarea"));
                //coursename
                String CourseName = htmlArea.findElement(By.xpath("./div/span/b")).getText();
                CourseName = CourseName.replace("\n","");
                CourseName = CourseName.replace(",", " ");
                //school
                String school = Course.findElement(By.xpath("./div/div[2]/span")).getText();
                school = school.replace("\n","");
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
                    //String sessionNO = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[1]")).getText();
                    //String status = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[4]/span[2]")).getText();
                    //String instructionMode = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[6]/span")).getText();
                    //String courseLocation = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[7]")).getText();
                    //String component = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/div[2]/div[8]")).getText();
                    WebElement brElement = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/br[1]"));

                    // Use JavaScript to get the text following the <br> element
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    String script = "return arguments[0].nextSibling.nodeValue;";
                    String room_time = (String) js.executeScript(script, brElement);

                    //String room_time = session.findElement(By.xpath("./div/div/div/table/tbody/tr/td/br[1]")).getText();
                    
                    String[] array = time_date_professor.split("\n");
                    String sessionNo = array[0].substring(8);
                    String date = array[1].substring(11);
                    String status = array[3].substring(14);
                    String instructionMode = array[5].substring(18);
                    String courseLocation = array[6].substring(17);
                    String component = array[7].substring(11);
                    room_time = room_time.substring(24);
                    room_time.replace("\n","");
                    room_time = room_time.substring(0,room_time.length()-2);
                    bf.write(CourseName+","+school+","+classNO+","+sessionNo+","+date+","+room_time+","+instructionMode+","+courseLocation+","+component+","+status);
                    
                    bf.newLine();

                }
                courseID = "win0divSELECT_COURSE_row$";

            }catch(Exception e){

                System.out.println("Element not found or error occurred for index: " + i);
                System.out.println(e.toString());
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
        Thread.sleep(30000);
        driver.quit();

    }
}
