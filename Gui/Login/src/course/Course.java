package course;
import user.instructor;
public class Course {
    private String ID;
    private String Name;
    private final String Course_Code;
    private instructor Instructor ;
    private String set_of_added_exams;
    public Course(  String ID,String Name, String Course_Code,instructor Instructor ,String set_of_added_exams) {
        this.ID=ID;
        this.Name=Name;
        this.Course_Code=Course_Code;
        this.Instructor =Instructor ;
        this.set_of_added_exams=set_of_added_exams;
    }
}
