/*
FECHA: Agosto 7/2021
TEMA: Reto 5

AUTOR: Claudia Marcela
 */

package Controller;

import Model.Store;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlStore {
    
    //Attribute
    private Store objStore = new Store();
    
    public ArrayList uploadCbx(){
        
        try {
            ResultSet consult = this.objStore.showStore();
            ArrayList<Store> listStores = new ArrayList<>();

            while (consult.next()) {
                objStore = new Store();
                objStore.setNameStore(consult.getString(1));

                listStores.add(objStore);
            }
            return listStores;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error: " + error);
        }

        return null;
    }
}
