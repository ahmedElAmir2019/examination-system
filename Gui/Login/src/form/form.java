package form;
import java.util.*;
import date.date_of_birth;
import java.util.Date;
import user.instructor;
import user.student;
import java.text.ParseException;
public class form {
    private Scanner input = new Scanner(System.in);
    private boolean loginig=true;
  /*  public void  choiceing (String user ,String password) throws ParseException {
        int choice ;

        System.out.println("to login press 1 or press 2 to registering ");
        choice=input.nextInt();
        if (choice !=1 )
        {
            if(choice != 2) {
                System.out.println("wrong answer");
            }
        }
        switch (choice)
        {
            case (1) :
                login(user,password);
                break;
            case (2):
                registration();
                break;

        }

    }*/
    public  void  login(String user,String pass)throws ParseException
    {
        String user_name,password;
        user_name=user;
        password=pass;
        System.out.println("please enter your User Name: "+user_name);
        System.out.println(password);
     /*   while (loginig)
        {
            date_of_birth date=new date_of_birth();
            instructor sa=new instructor(date,"sasa","dddd",user_name, "1111","email","phone_number");
            instrucor_form(user_name,sa);
        }*/
    }
    public  void  registration (String First_name,String Last_name,String User_name,String Email,String Password,
    String Phone_number,int Year_of_birth,int Month_of_birth,int Day_of_birth)
    {
        date_of_birth dob =new date_of_birth();
        int year_of_birth=Year_of_birth;
        int month_of_birth =Month_of_birth;
        int day_of_birth =Day_of_birth;
        String first_name =First_name;
        String last_name =Last_name;
        String user_name =User_name;
        String password =Password;
        String email =Email;
        String phone_number =Phone_number;
        String status="student";

        dob.set_date_of_birth(year_of_birth,month_of_birth,day_of_birth);
    switch (status.toLowerCase()){
        case ("student"):

                student student1 =new student(year_of_birth,month_of_birth,day_of_birth,first_name,last_name,user_name,
                        password,email,phone_number);

                break;
            case ("instructor")   :
                int number_of_courses;
                String [] course_id;
                System.out.println("please enter the number of courses which you teach : ");
                number_of_courses=input.nextInt();
                course_id = new String[number_of_courses];
                for (int i =0; i<number_of_courses;i++) {
                    System.out.println("please enter your course code number "+i+" : ");
                    course_id[i] = input.next();
                }
                instructor instructor1 =new instructor(dob,first_name,last_name,user_name, password,email,phone_number,course_id);
                break;
        }

    }
    public void student_form()
    {

    }
    public void instrucor_form(String user_name,instructor i1) throws ParseException {
        int choice ;
        System.out.println( "hello"  + user_name);
        System.out.println("i will give you your choice");
        System.out.println("to make a new exam press one or press 2 to take rebort of particular exam  or press 3 to log out ");
        choice=input.nextInt();

        switch (choice)
        {
            case (1) :
                i1.making_exam();
                break;
            case (2):
                System.out.println("please enter exam id ");
                String id =input.next();
                i1.view_an_evaluation_exam_report(id);
                break;
            case (3):
                System.out.println("see you soon "+user_name);
                loginig=false;
        }
        if (choice !=1 ||choice != 2 ||choice != 3)
        {
            System.out.println("wrong answer");

        }
    }
}
