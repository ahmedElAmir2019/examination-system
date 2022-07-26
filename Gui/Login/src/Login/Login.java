package Login;
import form.form;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import  javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.awt.*;
public class Login {
    @FXML BorderPane rootpane ;
 @FXML TextField user =new TextField();
 @FXML PasswordField pass =new PasswordField();
 @FXML
 Label text ;
    public void login () throws ParseException
    {
        form login =new form();
        String s = user.getText();
        String m = pass.getText();
        login.login(s,m);

    }
    public void confirm (Event event) throws IOException,ParseException
    {
        login();
        String s = user.getText();
        text.setText(" in valid answer");
        System.out.println(s);
       AnchorPane pane =   FXMLLoader.load(getClass().getResource("Registration.fxml"));
        System.out.println("laaaaaaaaaaaaaaa");
    }
    public void validation  (Event event) throws IOException,ParseException
    {
        text.setText(" in valid answer");

    }

}



