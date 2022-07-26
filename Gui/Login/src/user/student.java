package user;

public class student extends user {
    private String [] List_of_taken_exams = new String[40];

    public student(int year_of_birth, int month_of_birth, int day_of_birth, String first_name, String last_name, String user_name, String password, String email, String phone_number) {
        super( first_name, last_name, user_name, password, email, phone_number);
    }
}
