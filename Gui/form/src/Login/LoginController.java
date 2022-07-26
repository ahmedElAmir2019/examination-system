 package Login;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import java.awt.*;
import java.text.ParseException;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import  javax.swing.JOptionPane;
import javafx.fxml.FXML;
import java.awt.*;

public class LoginController {
  @FXML
    TextField user =new TextField();
  TextField pass =new TextField();
    public void press (ActionEvent ae) {
         String m =pass.getText();
        System.out.println(m);
    }
    }
