/*
FECHA: Agosto 7/2021
TEMA: Reto 5

AUTOR: Claudia Marcela
 */

package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Customer {
    
    
    //Attributes
    private int id;
    private String name;
    private String email;
    private long phone;
    private Store store;
    
    //Constructor
    public Customer() {
    }
    
    //Methods getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    //Methods CRUD
    
    //Insert a new customer on DB
    public void createCustomer(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command INSERT INTO to table customers of database
        //ID, name, email, phone, store
        try{
            String sql = "INSERT INTO customers VALUES "
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            stm.setInt(1, this.id);
            stm.setString(2, this.name);
            stm.setString(3, this.email);
            stm.setLong(4, this.phone);
            stm.setInt(5, this.store.getCode());
            stm.execute();
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
        
    }
    
    //Check for a customer from DB
    public ResultSet readCustomer(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command SELECT * to table customers of database
        try{
            String sql = "SELECT * FROM customers "
                    + "WHERE nameCustomer LIKE ?;";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            stm.setString(1, "%" + this.name + "%");
            ResultSet consult = stm.executeQuery();
            
            return consult;
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
        
        return null; //If there is an exception in try-catch
        
    }
    
    //Update information about a customer from DB
    public void updateCustomer(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command UPDATE SET to table customers of database
        //ID, name, email, phone, store
        try{
            String sql = "UPDATE customers SET "
                    + "nameCustomer = ?, emailCustomer = ?, phoneCustomer = ? WHERE idCustomerPk = ?;";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            stm.setString(1, this.name);
            stm.setString(2, this.email);
            stm.setLong(3, this.phone);
            stm.setInt(4, this.id);
            stm.execute();
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
        
    }
    
    //Delete a customer from DB
    public void deleteCustomer(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command DELETE to table customers of database
        //id
        try{
            String sql = "DELETE FROM customers "
                    + "WHERE idCustomerPk = ?;";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            stm.setInt(1, this.id);
            stm.execute();
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
    }
    
    //Check for all customers from DB
    public ResultSet listCustomers(){
        
        //Connect to database customersMyCompany
        MyConnection objConector = new MyConnection();
        objConector.connect();
        
        //Send the command SELECT * to table customers of database
        try{
            String sql = "SELECT * FROM customers";
            PreparedStatement stm = objConector.conn.prepareStatement(sql);
            ResultSet consult = stm.executeQuery();
            
            return consult;
        }
        catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
        
        //Disconnect to database customersMyCompany
        objConector.disconnect();
        
        return null; //If there is an exception in try-catch
        
    }
    
}
