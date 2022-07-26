package user;
import database.Database;
import date.date_of_birth;
import exam.*;
import exam_result_and_reports.Evaluation_exam_Report;
import java.text.ParseException;
import java.time.*;
import java.util.Date;
import java.util.Scanner;
public class instructor extends user{
    private String name;
    private int age;
    private Exam exam ;
    date_of_birth dob=new date_of_birth();
    private String [] course_code =new String[10];
    public instructor( date_of_birth dob,String first_name, String last_name, String user_name, String password, String email, String phone_number) {
        super( first_name, last_name, user_name, password, email, phone_number);
        name=first_name+" "+last_name;
        //age=dob.age();
    }
    public instructor(date_of_birth dob, String first_name, String last_name, String user_name, String password, String email, String phone_number,String [] course_code) {
        this( dob,first_name, last_name, user_name, password, email, phone_number);
    }
    private LocalTime end_time;
    public void  making_exam()throws ParseException
    {
        Scanner input = new Scanner(System.in);
         String ID;
          String Course_Code;
          String name;
        int end_time_hours;
        int start_time_hours;
        int start_time_minutes;
        LocalTime start_time;
        LocalTime end_time;
        int end_time_minutes;
        int number_of_question;
         String Mark;
         String Release_date;
        System.out.println("please enter your exam id : ");
        ID=input.next();
        System.out.println("please enter your Course Code : ");
        Course_Code=input.next();
        System.out.println("please enter your exam's name : ");
        name=input.next();
        System.out.println("please enter your start time hour : ");
        start_time_hours=input.nextInt();
        System.out.println("please enter your start time minue : ");
        start_time_minutes =input.nextInt();
        System.out.println("please enter your end time hour : ");
        end_time_hours=input.nextInt();
        System.out.println("please enter your end time minue : ");
        end_time_minutes =input.nextInt();
        System.out.println("please enter number of question : ");
        number_of_question=input.nextInt();
        System.out.println("please enter your Release date : ");
        Release_date=input.next();
        end_time=LocalTime.of(end_time_hours,end_time_minutes);
        start_time=LocalTime.of(start_time_hours,start_time_minutes);
        exam=new Exam(ID,Course_Code,name,start_time,end_time,Release_date,number_of_question);
        Database.exam(ID,Course_Code ,name, start_time,end_time,Release_date, number_of_question);
    }
    public void view_an_evaluation_exam_report (String exam_id)
    {
        LocalTime end_time_of_exam =end_time;
        LocalTime clock =LocalTime.now();
        Date today =new Date();
        boolean previos_date =false;
        if (clock.isAfter(end_time)) {
            if (today.compareTo(exam.getRelease_date()) >= 0) {
                Evaluation_exam_Report exam_report = new Evaluation_exam_Report(exam_id);
            }
        }
        else
        {
            System.out.println("sorry but you can,t view report becouse this exam doesn't end ");
        }

    }
}
