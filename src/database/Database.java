package database;

import connection.connection;
import date.date_of_birth;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.*;
import java.time.LocalTime;
import java.util.Scanner;

public class Database{
    public static void student(String DOB, String first_name, String last_name, String user_name, String password, String email, String phone_number){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry="Insert into student(Fname,Lname,ID,Email,User_Name,Password,Phone_Number,DOB) " +
                 "VALUES('"+first_name+"','"+last_name+"',null,'"+email+"','"+user_name+"','"+password+"','"+phone_number+"','"+DOB+"')";
            stat.execute(quarry);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

    public static void instructor(String DOB, String first_name, String last_name, String user_name, String password, String email, String phone_number) {
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry="Insert into instructor(Fname,Lname,ID,Email,User_Name,Password,Phone_Number,DOB) " +
                    "VALUES('"+first_name+"','"+last_name+"',null,'"+email+"','"+user_name+"','"+password+"','"+phone_number+"','"+DOB+"')";
            stat.execute(quarry);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }
 
    public static void  course( String course_name,String course_id,String email){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry3="Insert into course(Name,ID,Einstructor) " +
                    "VALUES('"+course_name+"','"+course_id+"','"+email+"')";
            stat.execute(quarry3);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

    public static void exam(String ID,String Course_Code ,String name,LocalTime start_time, LocalTime end_time,String Release_date,int number_of_question){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry4="Insert into exam(ID,Course_code,Name,start_time,end_time,releaser_date,Number_of_question) " +
                    "VALUES('"+ID+"','"+Course_Code+"','"+name+"','"+start_time+"','"+end_time+"','"+Release_date+"','"+number_of_question+"')";
            stat.execute(quarry4);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

    public static void exam_grade(float total_mark,String Eid){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry4_2="Insert into exam_grade(total_grade,EID) " +
                    "VALUES('"+total_mark+"','"+Eid+"')";
            stat.execute(quarry4_2);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

    public static void student_marks(float mark,String semail,String Eid){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry_2="Insert into exam_grade(mark,Estudent,exam_id) " +
                    "VALUES('"+mark+"','"+semail+"','"+Eid+"')";
            stat.execute(quarry_2);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

    public static void question( String question_Real_correct_choice,String question,float degree,String Eid){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry5="Insert into question(ID,question_name,degree,Real_correct_choice,EID) " +
                    "VALUES(null,'"+degree+"','"+question+"','"+question_Real_correct_choice+"','"+Eid+"')";
            stat.execute(quarry5);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

    public static void set_choice( String choice,String QN){
        try
        {
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry6="Insert into set choice(choice,QN) " +
                    "VALUES('"+choice+"','"+QN+"')";
            stat.execute(quarry6);
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }
    public static void show_instructor(){
        try
        {
            String User;
            System.out.println("please enter the user you want to know his/her Email");
            Scanner input = new Scanner(System.in);
            User= input.next();
            ResultSet r;
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry="Select Fname,Email,User_Name from instructor";
            r= stat.executeQuery(quarry);
            boolean trace = true;
            boolean process_done = false;

            while(r.next()&&trace){
                String user_name = r.getString("User_Name");
                if (User.equals(user_name))
                {
                    System.out.print(r.getString("Fname"));
                    System.out.print("  ");
                    System.out.print(r.getString("Email"));
                    System.out.println();
                    process_done=true;
                    trace=false;
                    break;
                }
            }
            if (process_done == false)
            {
                System.out.println("This user name is not found");
                System.out.println("Please enter a valid user");

            }
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
    }

  /*public static void show_instructor(){
        try
        {
            ResultSet r;
            connection c=new connection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =c.connect() ;
            Statement stat=con.createStatement();
            String quarry="Select Fname,Email from instructor";
            r= stat.executeQuery(quarry);
            r.next();
            r.next();
            System.out.print(r.getString("Fname"));
            System.out.print("  ");
            System.out.print(r.getString("Email"));
            System.out.println();
        }
        catch(Exception e)
        {
            System.out.println("The Error is\n"+e.getMessage()) ;
        }
}*/


}