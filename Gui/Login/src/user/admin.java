package user;

public class admin extends user {
    public admin(int year_of_birth, int month_of_birth, int day_of_birth, String first_name, String last_name, String user_name, String password, String email, String phone_number) {
        super( first_name, last_name, user_name, password, email, phone_number);
    }
}
