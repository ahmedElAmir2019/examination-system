package form;
import java.sql.*;
import java.util.*;
import connection.connection;
import database.Database;
import date.date_of_birth;
import user.instructor;
import user.student;
import java.text.ParseException;
public class form {
    private Scanner input = new Scanner(System.in);
    private boolean loginig=true;
   /* public */ static String Semail;
    public void  choiceing () throws ParseException {
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
                login();
                break;
            case (2):
                registration();
                break;

        }

    }
    public  void  login() throws ParseException {
        while(loginig) {
            String user_name, password;
            System.out.println("please enter your User Name: ");
            user_name = input.next();
            System.out.println("please enter your password: ");
            password = input.next();
            try {
                //setup driver.
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("MySql Driver not found");
            }
            Connection conn = null;


            try
            {
                connection con=new connection();
               Class.forName("com.mysql.jdbc.Driver");
                conn = con.connect();
              //conn = DriverManager.getConnection("jdbc:mysql://localhost/examination", "root", "samar9876543210");
                //create query
                String query = "select user_name ,Password from instructor";
                //open the statement
                Statement st = conn.createStatement();
                //handle the results
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    String Username = rs.getString("user_name");
                    String pass = rs.getString("Password");

                    if (user_name.equals(Username) && password.equals(pass)) {
                       // System.out.format("%s ", "%s ", Username, pass);//علشان انت عامل

                        date_of_birth date=new date_of_birth();
                        instructor sa=new instructor(date,"sasa","dddd",user_name, "1111","email","phone_number");
                        instrucor_form(user_name,sa);
                        break;

                    } else {
                        System.out.println("it is not stored");

                    }
                }

                st.close();
            }
            catch (Exception e)
            {
                System.out.println("The Error is\n" + e.getMessage());
            }
            finally
            {
                try
                {
                    if (conn != null)
                    {
                        conn.close();
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
    public String registration () {
        date_of_birth dob =new date_of_birth();
        int year_of_birth;
        int month_of_birth;
        int day_of_birth;
        String first_name;
        String last_name;
        String user_name;
        String password;
        String email;
        String phone_number;
        String status;
        System.out.println("please enter your first name: ");
        first_name=input.next();
        for(int c=0;c<=100;c++){
        if(first_name.startsWith("@")||first_name.startsWith("!")||first_name.startsWith("#")||first_name.startsWith("$")||first_name.startsWith("%")||first_name.startsWith("&")||first_name.startsWith("*")){
            System.out.println("please enter your first  name correctly : ");

            first_name=input.next();
        }

        else{break;}
        }
        System.out.println("please enter your last Name: ");
        last_name=input.next();
        for(int b=0;b<=100;b++){

                if (last_name.startsWith("@") || last_name.startsWith("!") || last_name.startsWith("#") || last_name.startsWith("$") || last_name.startsWith("%") || last_name.startsWith("&") || last_name.startsWith("*")) {
                    System.out.println("please enter your last  name correctly");
                    last_name=input.next();
                }else{break;}
            }
        System.out.println("please enter your email: ");
        email=input.next();
        for(int d=0;d<=100;d++){
            if(email.indexOf('@')>=0){
                if(email.indexOf('.')>=0){break;}
                else{
                        System.out.println("please enter the correct email");
                email=input.next();
            }
                break;
            }else{
                System.out.println("please enter the correct email");
                email=input.next();
            }
        }
        System.out.println("please enter your User Name: ");
        user_name=input.next();
        System.out.println("please enter your password: ");
        password=input.next();
        for (int e=0;e<=100;e++){
            if(password.length()<=8){
                System.out.println("weak password");
                System.out.println("please enter your password: ");
                password=input.next();
            }else{break;}
        }
        System.out.println("please enter your phone number : ");
        phone_number=input.next();
        for(int f=0;f<=100;f++){
            if(phone_number.length()!=11){
                System.out.println("please enter a real number");
                phone_number=input.next();
            }else{break;}
        }
        System.out.println("please enter your status (Student or Instructor) : ");
        status=input.next();
        for (int g=0;g<=100;g++){
            if(status.equals("Student")||status.equals("Instructor")){
                break;
            }else{ System.out.println("please enter your status (Student or Instructor) : ");
                status=input.next();
            }

        }
        System.out.println("please enter your year of birth: ");
        year_of_birth=input.nextInt();
        for(int h=0;h<=100;h++){
            if(year_of_birth<=2021&&year_of_birth>=1930){
                break;
            }else{
                System.out.println("please enter a right year");
                year_of_birth=input.nextInt();
            }
        }
        System.out.println("please enter your month of birth: ");
        month_of_birth=input.nextInt();
        for(int k=0;k<=100;k++){
            if(month_of_birth<=12&&month_of_birth>=1){
                break;
            }
            else{
                System.out.println("please enter your month of birth correctly: ");
                month_of_birth=input.nextInt();
            }
        }
        System.out.println("please enter your day of birth: ");
        day_of_birth=input.nextInt();
        for (int l=0;l<100;l++){
            if(day_of_birth>=1&&day_of_birth<=31){
                break;
            }else{
                System.out.println("please enter your day of birth correctly: ");
                day_of_birth=input.nextInt();
            }
        }
        dob.set_date_of_birth(year_of_birth,month_of_birth,day_of_birth);
        String DOB;

                DOB=String.valueOf(dob);
        switch (status.toLowerCase()){
            case ("student"):
                Database.student(DOB,first_name,last_name,user_name, password,email, phone_number);
                student student1 =new student(year_of_birth,month_of_birth,day_of_birth,first_name,last_name,user_name,
                        password,email,phone_number);
                Semail=email;
                Database.student(DOB,first_name,last_name,user_name, password,email, phone_number);
                break;
            case ("instructor")   :
                Database.instructor( DOB, first_name,last_name,user_name,password,email,phone_number);
                int number_of_courses;
                String [] course_id;
                String [] course_name = new String[20];
                System.out.println("please enter the number of courses which you teach : ");
                number_of_courses=input.nextInt();
                course_id = new String[number_of_courses];
                for (int i =0; i<number_of_courses;i++) {
                    System.out.println("please enter your course name "+i+1+" : ");
                    course_name[i] = input.next();
                   System.out.println("please enter your course code number "+i+1+" : ");
                    course_id[i] = input.next();
                    Database.course(course_name[i],course_id[i],email);
                }
                instructor instructor1 =new instructor(dob,first_name,last_name,user_name, password,email,phone_number,course_id);
                System.out.println("donr");
                          break;
        }
        return null;
    }
    public void student_form() {

    }
    public void instrucor_form(String user_name,instructor i1) throws ParseException {
        int choice ;
        System.out.println( "hello "  + user_name);
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
public static String student_email(){
        return Semail;
}
}
