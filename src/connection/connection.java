package connection;

import java.sql.*;

public class connection {
    private String user="root";
    private String password="samar9876543210";
    private String url="jdbc:mysql://localhost/examination";

    public Connection connect() throws SQLException {
        Connection con ;
        con = DriverManager.getConnection(this.url,this.user,this.password);
         return con;
    }
}