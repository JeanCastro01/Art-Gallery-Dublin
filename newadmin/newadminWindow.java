/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newadmin;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import newartist.artistController;


/**
 *
 * @author jeancastro
 */
public class newadminWindow extends JFrame {
    
     // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
  
    // This window needs to know who the controller is
    private newadminController controllerInternalRef;
    
    public newadminWindow (newadminController controller){
        
        // Putting the reference of the controller in the local reference
        this.controllerInternalRef = controller;
        
        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }


    // Setting attributes
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(350,400);
        this.setTitle("New Admin");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
          
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        p.setBackground(Color.GRAY);
        
        JLabel label = new JLabel("Please insert all the Admin information");
        p.add(label);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        tf5 = new JTextField(20);
       
        
        JLabel custfirstname = new JLabel ("Firstname");
        JLabel custlastname = new JLabel ("lastname");
        JLabel email = new JLabel ("email");
        JLabel password = new JLabel ("password");
        JLabel username = new JLabel ("username");
    
        
        JButton button = new JButton("Submit");
        button.addActionListener((ActionListener) controllerInternalRef);
        button.setActionCommand("Submit");
     
        
        
        
        p.add(tf1);
        p.add(custfirstname);
        p.add(tf2);
        p.add(custlastname);
        p.add(tf3);
        p.add(email);
        p.add(tf4);
        p.add(password);
        p.add(tf5);
        p.add(username);
   
        
        p.add(button);

    
        
    }
    
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    // Getters for username and password
    public String getfirstname(){
        return tf1.getText();
    }
    public String getlastname(){
        return tf2.getText();
    }
    public String getemail(){
        return tf3.getText();
    }
    public String getpassword(){
        return tf4.getText();
    }
    public String getusername(){
        return tf5.getText();
    }


}
    