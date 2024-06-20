import java.util.*;
public class course {

    public ArrayList<session> sessions = new ArrayList<>();
    public String name;
    public String courseNo;

    public course(String name, String courseNo){
        this.name = name;
        this.courseNo = courseNo;
        sessions = new ArrayList<>();
    }

    public boolean addSession(session s){
        return sessions.add(s);
    }

    public String toString(){
        String str = "";
        str += "Course name: " + this.name + "\n";
        str += "Course number: " + this.courseNo + "\n";
        for (session s : this.sessions  ){
            str += s.toString();
        }
        return str;
    }

}
