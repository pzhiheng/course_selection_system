import java.util.*;
public class session {


    private String sessionNo;
    private String classNo;
    private String status;
    private String instructionMode;
    private String courseLocation;
    private String professor = "unknown";
    private String dateRange;
    private String weekdays;
    private String time;
    private String room = "unknown";
    private boolean isLecture;
    private ArrayList<session> resitations = new ArrayList<>();
    

    public session(String classNo, String sessionNo, String status, String instructionMode, String courseLocation, String component, String other){
        this.classNo = classNo;
        this.sessionNo = sessionNo;
        this.status = status;
        this.instructionMode = instructionMode;
        this.courseLocation = courseLocation;

        if (component.contains("lecture")){
            this.isLecture = true;
        }
        else{
            this.isLecture = false;
        }

    }
    public String toString(){
        String str = "";
        str += "Session number: " + this.sessionNo + "\n";
        str += "Instruction Mode: " + this.instructionMode + "\n";
        str += "Course Location: " + this.courseLocation + "\n";
        str += "Lecture: " + this.isLecture + "\n";
    
        return str;

    }

}
