/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newartist;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author jeancastro
 */
public class artistWindow extends JFrame {
    
     // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
  
    // This window needs to know who the controller is
    private artistController controllerInternalRef;
    
    public artistWindow (artistController controller){
        
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
        this.setSize(400,400);
        this.setTitle("New Artist");
        this.setLocationRelativeTo(null);
        
        this.setResizable(false);
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        p.setBackground(Color.GRAY);
        
         JLabel label = new JLabel("Please insert all the Artist information");
        p.add(label);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
       
        
        JLabel custfirstname = new JLabel ("Firstname");
        custfirstname.setForeground(Color.BLACK);
        
        JLabel custlastname = new JLabel ("lastname");
        custlastname.setForeground(Color.BLACK);
        
        JLabel custaddress = new JLabel ("Address");
        custaddress.setForeground(Color.BLACK);
        
        JLabel website = new JLabel ("website");
        website.setForeground(Color.BLACK);
    
        
        JButton button = new JButton("Submit");
        button.addActionListener((ActionListener) controllerInternalRef);
        button.setActionCommand("Submit");
   
        
        
        
        p.add(tf1);
        p.add(custfirstname);
        p.add(tf2);
        p.add(custlastname);
        p.add(tf3);
        p.add(custaddress);
        p.add(tf4);
        p.add(website);
   
        
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
    public String getaddress(){
        return tf3.getText();
    }
    public String getwebsite(){
        return tf4.getText();
    }


}
    
    

