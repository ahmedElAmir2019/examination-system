package Login;

import form.form;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

public class Registration {
    @FXML TextField user =new TextField();
    @FXML PasswordField Password =new PasswordField();
    @FXML TextField First_name =new TextField();
    @FXML PasswordField Repassword =new PasswordField();
    @FXML TextField Last_name =new TextField();
    @FXML TextField Email =new TextField();
    @FXML TextField Year_of_birth =new TextField();
    @FXML TextField Month =new TextField();
    @FXML TextField Day =new TextField();
    @FXML TextField Phone_number =new TextField();
    @FXML AnchorPane rootpane =new AnchorPane();
    public void registration () throws ParseException
    {
        System.out.println("bbbbbbbbbbbbbb");
        form registraion =new form();
        String first_name = First_name.getText();
        String last_name = Last_name.getText();
        String user_name = user.getText();
        String email = Email.getText();
        String password = Password.getText();
        String repassword = Repassword.getText();
        String phone_number=Phone_number.getText();
        int day =Integer.parseInt(Day.getText());
        int month =Integer.parseInt(Month.getText());
        int year_of_birth =Integer.parseInt(Year_of_birth.getText());
        registraion.registration(first_name,last_name,user_name,email,password,phone_number,year_of_birth,month,day);
        System.out.println(first_name+last_name+email+password+repassword+user_name+day+year_of_birth+month+phone_number);
    }
    public void login (ActionEvent event) throws IOException, ParseException {
        registration();
        BorderPane pane =   FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootpane.getChildren().setAll(pane);
        /*Parent root =loader.load();
       /* Stage stage =new Stage();
        stage.setScene(new Scene(root));
        stage.show();
*/
        System.out.println("laaaaaaaaaaaaaaa");
    }
}
