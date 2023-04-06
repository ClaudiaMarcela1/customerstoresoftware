/*
FECHA: Agosto 7/2021
TEMA: Reto 5

AUTOR: Claudia Marcela
 */

package Controller;

import Model.Customer;
import Model.Store;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlCustomer {

    //Attribute
    private Customer objCustomer = new Customer();

    //Method for create a new customer in model cap with data from visual cap
    public void create(String id, String name, String email, String phone, Store store) { //Data from Text Field of application form 
        try {
            objCustomer.setId(Integer.parseInt(id));
            objCustomer.setName(name);
            objCustomer.setEmail(email);
            objCustomer.setPhone(Long.parseLong(phone));
            objCustomer.setStore(store);

            objCustomer.createCustomer();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }

    }

    //Method for check for all customer in model cap with a request from visual cap
    public ArrayList list() {

        try {
            ResultSet consult = this.objCustomer.listCustomers();
            ArrayList<Customer> listCustomer = new ArrayList<>();

            while (consult.next()) {
                objCustomer = new Customer();
                objCustomer.setId(consult.getInt(1));
                objCustomer.setName(consult.getString(2));
                objCustomer.setEmail(consult.getString(3));
                objCustomer.setPhone(consult.getLong(4));

                listCustomer.add(objCustomer);
            }
            return listCustomer;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }

        return null;
    }

    //Method for update a customer in model cap with data from visual cap
    public void update(String id, String name, String email, String phone) {

        try {
            objCustomer.setId(Integer.parseInt(id));
            objCustomer.setName(name);
            objCustomer.setEmail(email);
            objCustomer.setPhone(Long.parseLong(phone));

            objCustomer.updateCustomer();
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
    }
    
    //Method for delete a customer in model cap with data from visual cap
    public void delete(String id) {
        
        try {
            objCustomer.setId(Integer.parseInt(id));
            
            objCustomer.deleteCustomer();
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }
    }
    
    //Method for check for a customer in model cap with data from visual cap
    public ArrayList check(String name) {
        
        try {
            this.objCustomer.setName(name);
            ResultSet consult = this.objCustomer.readCustomer();
            ArrayList<Customer> checkCostumer = new ArrayList<>();

            while (consult.next()) {
                objCustomer = new Customer();
                objCustomer.setId(consult.getInt(1));
                objCustomer.setName(consult.getString(2));
                objCustomer.setEmail(consult.getString(3));
                objCustomer.setPhone(consult.getLong(4));

                checkCostumer.add(objCustomer);
            }
            return checkCostumer;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }

        return null;
        
    }
    
}
