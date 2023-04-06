/*
FECHA: Agosto 7/2021
TEMA: Reto 5

AUTOR: Claudia Marcela
 */

package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Store {
    
    //Attributes
    private int code;
    private String nameStore;
    
    //Methods getter and setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }
    
    //Insert a new store on DB
    public void createStore(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command INSERT INTO to table stores of database
        //code, nameStore
        try{
            String sql = "INSERT INTO stores VALUES "
                    + "(?, ?)";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            stm.setInt(1, this.code);
            stm.setString(2, this.nameStore);
            stm.execute();
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
        
    }
    
    //Check for all store names from DB
    public ResultSet showStore(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command SELECT nameStore to table stores of database
        try{
            String sql = "SELECT nameStore FROM stores";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            ResultSet consult = stm.executeQuery();
            
            return consult;
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
        
        return null;
        
    }
    
}
