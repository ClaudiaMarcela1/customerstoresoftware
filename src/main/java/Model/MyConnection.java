/*
FECHA: Agosto 7/2021
TEMA: Reto 5

AUTOR: Claudia Marcela
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MyConnection {

    //Attributes
    public Connection conn;
    private String host = "localhost:3306";
    private String user = "root";
    private String password = "";
    private String dataBase = "customersmycompany";

    //Method: connect to database
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.dataBase + "?zeroDateTimeBechavior=CONVERT_TO_NULL", this.user, this.password);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
    }

    //Method: disconnect from database
    public void disconnect() {
        conn = null;
    }
}
