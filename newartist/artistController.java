/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newartist;

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



/**
 * This is the action listener
 * The controller (brain) of the 
 * @author apont
 */
public class artistController implements ActionListener {
    
    // This class has to have a reference to all elements of the program
    artistModel model;
    artistWindow view;
    
    
    // When the  controller starts, we need a new model and a new view
    public artistController(){
        view = new artistWindow(this); 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        model = new artistModel();

     
        String firstname = view.getfirstname();
        String lastname = view.getlastname();
        String address = view.getaddress();
        String website = view.getwebsite();
       
        // Create an instance of the user class with the data collated
       artistregister newartist = new artistregister(firstname,lastname, address,website);
        
      
        if(e.getActionCommand().equals("Submit")){

         model.register(newartist);
           JOptionPane.showMessageDialog(null, "Submited");
        //
         
                view.dispose();
            }
        else if (e.getActionCommand().equals("Return")) {
        
    
         view.dispose();
        
    }
       
    }
}
    
    





        
    
    
    

