/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updateuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import user.User2;


/**
 * This is the action listener
 * The controller (brain) of the 
 * @author apont
 */
public class updateuserController implements ActionListener {
    
    // This class has to have a reference to all elements of the program
    updateuserController model;
    updateuserWindow view;
        private String userLogged;
        User2 user;
    // When the  controller starts, we need a new model and a new view
    public updateuserController(String un){
    
      
       view = new updateuserWindow(this, this.userLogged); 
    
     
    
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        //model = new updateuserModel();

     
        String firstname = view.getfirstname();
        String lastname = view.getlastname();
        String address = view.getaddress();
       // String website = view.getwebsite();
       
        // Create an instance of the user class with the data collated
     // artistregister update = new artistregister(firstname,lastname, address,website);
        
      
        if(e.getActionCommand().equals("Submit")){

        // model.custupdate(update);
           JOptionPane.showMessageDialog(null, "Submited");
        //
         
                view.dispose();
            }
        else if (e.getActionCommand().equals("Return")) {
        
    
         view.dispose();
        
    }
       
    }
}
    