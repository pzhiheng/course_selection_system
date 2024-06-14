public class session {


    private String name;
    private String No;
    private String weekdays;
    private time time;
    private String professor;
    private String location;

    public session(String name, String No, String weekdays, String start, String end, String professor, String location){
        this.name = name;
        this.No = No;
        this.weekdays = weekdays;
        this.time = new time(start, end);
        this.professor = professor;
        this.location = location;
    }

    private class time{
        private String start;
        private String end;
        private time(String start, String end){
            this.start = start;
            this.end = end;

        }
    }


}
