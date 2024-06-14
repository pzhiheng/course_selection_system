import java.util.*;
public class course {

    public ArrayList<session> sessions = new ArrayList<>();
    public String name;

    public course(String name){
        this.name = name;
        sessions = new ArrayList<>();
    }

    public boolean addSession(session s){
        return sessions.add(s);
    }

}
