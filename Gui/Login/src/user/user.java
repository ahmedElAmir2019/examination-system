package user;
import date .date_of_birth ;
public abstract class user {
    //private int age;
    private String first_name;
    private String last_name;
    private String user_name;
    private String password;
    private String email;
    private String phone_number;
    //private float age=dob.age(day_of_birth,month_of_birth,year_of_birth);
    public user ( String first_name, String last_name, String user_name, String password, String email, String phone_number)
    {
        this.first_name=first_name;
        this.last_name=last_name;
        this.user_name=user_name;
        this.password=password;
        this.email=email;
        this.phone_number=phone_number;

    }

}
