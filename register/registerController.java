/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import login.index;






/**
 * This is the action listener
 * The controller (brain) of the 
 * @author apont
 */
public class registerController implements ActionListener {
    
    // This class has to have a reference to all elements of the program
    registerModel model;
    registerWindow view;
    
    
    // When the  controller starts, we need a new model and a new view
    public registerController(){
        view = new registerWindow(this); 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        model = new registerModel();

     
        String firstname = view.getfirstname();
        String lastname = view.getlastname();
        String address = view.getaddress();
        String email = view.getemail();
        String password = view.getpassword();
        String username = view.getusername();

        // Create an instance of the user class with the data collated
       custregister newcust = new custregister(firstname,lastname, address,email,password, username);
        
      
        if(e.getActionCommand().equals("Submit")){

         model.register(newcust);
         JOptionPane.showMessageDialog(null, "Submited");
         new index();
         
                view.dispose();
            }
        else if (e.getActionCommand().equals("Return")) {
        
        
           
         view.dispose();
        
    }
       
    }
}
    
    





        
    
    
    

