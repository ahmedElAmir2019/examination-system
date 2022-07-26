package date;
import java.text.ParseException;
import java.time.*;
import java.util.Scanner;

public class date_of_birth {
    private Scanner input = new Scanner(System.in);
    private int year_of_birth,month_of_birth,day_of_birth;
    private LocalDate Date_of_birth;
    public void set_date_of_birth (int year,int month,int day)
    {
        year_of_birth=year;
        month_of_birth=month;
        day_of_birth=day;
        Date_of_birth =LocalDate.of(year_of_birth,month_of_birth,day_of_birth);
    }
    public int age ()
    {
        int age ;
        LocalDate today =LocalDate.now();
        age =Period.between(today,Date_of_birth).getYears();
        return age;
    }
    public LocalDate  get_date ()
    {
       return Date_of_birth ;
    }
}
