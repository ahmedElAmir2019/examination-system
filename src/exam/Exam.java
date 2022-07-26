package exam;
import database.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

import static form.form.student_email;
public class Exam {
    private boolean submit=false;
    private Scanner input =new Scanner(System.in);
    private String ID;
    private float total_degree=0;
    private final String Course_Code;
    private String instructor_name;
    private LocalTime duration;
    private LocalTime start_time;
    private LocalTime end_time;
    private float Mark;
    private Date Release_date;
    private int Number_of_question;
    private String validation_status;
    private Question[] questions = new Question[100]  ;
    private String Date;
    private SimpleDateFormat spd = new SimpleDateFormat("yyyy/mm/dd");
    public java.util.Date getRelease_date() {
        return Release_date;
    }
    public Exam( String ID,String Course_Code,String instructor_name,LocalTime start_time,LocalTime end_time,String Release_date,int Number_of_questions)
    throws ParseException {
        this.ID=ID;
        this.Course_Code=Course_Code;
        this.instructor_name=instructor_name;
        this.start_time=start_time;
        this.end_time=end_time;
        this.Release_date=spd.parse(Release_date);
        this.Number_of_question=Number_of_questions;
        exam_content();
        duration= duration();
        total_grade_calculator();
        validation_check();
        marking();
    }
    public void validation_check ()
    {
        Date today = new Date();
        boolean date=false;
        boolean clock =false;
        if (today.compareTo(Release_date)==0)
        {
            date=true;
        }
        LocalTime now =LocalTime.now();
        if (start_time.isBefore(now)&end_time.isAfter(now))
        {
            clock=true;
        }
        if (date & clock)
        {
            validation_status="valid";
        }
        else
        {
            validation_status="not valid";
        }

    }
    public LocalTime duration()
    {
        int x=(int)  Duration.between(start_time,end_time).getSeconds();
        int hours = x/3600;
        int min=0;
        int reminder =x%3600;
        if (reminder!=0)
        {
            min=reminder/60;
        }
        LocalTime duration =LocalTime.of(hours,min);
        return duration;
    }
    public void total_grade_calculator ()
    {
        for (int i=0;i<Number_of_question;i++)
        {
            total_degree=+questions[i].get_degree();
        }
     float total_mark=total_degree;
       Database.exam_grade(total_mark,ID);
    }
    public void marking ()
    {
        for (int i=0;i<Number_of_question;i++)
        {
            Mark = questions[i].getMark();
        }

        String email = student_email();
       Database.student_marks(Mark,email,ID);
    }
    public void exam_content()
    {
        String question_Real_correct_choice;
        float degree;
        System.out.println("please enter your question and it's details");
        for (int i=0; i < Number_of_question ;i++)
        {
            Question question = null;
            System.out.println("please enter your question degree");
            degree=input.nextFloat();
            System.out.println("please enter your question Real answer");
            question_Real_correct_choice=input.next();
            questions[i] =new Question(question_Real_correct_choice,degree);
            questions[i].setQuestion();
            questions[i].setChoice();
            Database.question(question_Real_correct_choice,question.getQuestion(),degree,this.ID);
        }
        total_grade_calculator();
    }
    public void  during_exam()
    {
        while (validation_status.equals("valid")&&submit==false)
        {
            int number;
            System.out.println("please enter number of question");
            number=input.nextInt();
            questions[number-1].getQuestion();
            questions[number-1].getChoice();
            questions[number-1].getAnswer();
        }
        for (int i=0;i<Number_of_question;i++)
        {
            questions[i].marking();
        }
    }
}