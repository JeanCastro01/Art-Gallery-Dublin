/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newadmin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import login.WelcomeScreenadmin;
import login.index;
import newartist.artistModel;
import newartist.artistWindow;
import newartist.artistregister;



/**
 * This is the action listener
 * The controller (brain) of the 
 * @author apont
 */
public class newadminController implements ActionListener {
    
    // This class has to have a reference to all elements of the program
    newadminModel model;
    newadminWindow view;
    
    
    // When the  controller starts, we need a new model and a new view
    public newadminController(){
       
        view = new newadminWindow(this); 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        model = new newadminModel();

     
        String firstname = view.getfirstname();
        String lastname = view.getlastname();
        String email = view.getemail();
        String username = view.getusername();
        String password = view.getpassword();
       
        // Create an instance of the user class with the data collated
       newadminregister newadmin = new newadminregister(firstname,lastname,email,username,password);
        
      
        if(e.getActionCommand().equals("Submit")){

         model.register(newadmin);
           JOptionPane.showMessageDialog(null, "Submited");
        //
         
                view.dispose();
            }
        else if (e.getActionCommand().equals("Return")) {
        
       
         view.dispose();
        
    }
       
    }
}
 