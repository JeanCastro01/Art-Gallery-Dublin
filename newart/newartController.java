/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import login.index;



/**
 * This is the action listener
 * The controller (brain) of the 
 * @author apont
 */
public class newartController implements ActionListener {
    
    // This class has to have a reference to all elements of the program
    newartModel model;
    newartWindow view;
    
    
    // When the  controller starts, we need a new model and a new view
    public newartController(){
        view = new newartWindow(this); 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        model = new newartModel();

     
        String title = view.gettitle();
        String type = view.gettype();
        String artist = view.getartist();
     
       
        // Create an instance of the user class with the data collated
       newartregister newart = new newartregister(title,type, artist);
        
      
        if(e.getActionCommand().equals("Submit")){

         model.register(newart);
         JOptionPane.showMessageDialog(null, "Submited");
        //
         
                view.dispose();
            }
        else if (e.getActionCommand().equals("Return")) {
        
        
         view.dispose();
        
    }
       
    }
}
    