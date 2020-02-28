/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * This is the login window
 * @author apont
 */
public class registerWindow extends JFrame{
    
    // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    // This window needs to know who the controller is
    private registerController controllerInternalRef;
    
    public registerWindow (registerController controller){
        
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
        this.setSize(400,300);
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
           this.setResizable(false);
        
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        p.setBackground(Color.darkGray);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        tf5 = new JTextField(20);
        tf6 = new JTextField(20);
        
        JLabel custfirstname = new JLabel ("Firstname");
        custfirstname.setForeground(Color.WHITE);
        
        JLabel custlastname = new JLabel ("lastname");
        custlastname.setForeground(Color.WHITE);
        
        JLabel custaddress = new JLabel ("Address");
        custaddress.setForeground(Color.WHITE);
        
        JLabel custemail = new JLabel ("Email");
        custemail.setForeground(Color.WHITE);
        
        JLabel custpassword = new JLabel ("Password");
        custpassword.setForeground(Color.WHITE);
        
        JLabel custusername = new JLabel ("Username");
        custusername.setForeground(Color.WHITE);
        
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
        p.add(custemail);
        p.add(tf5);
        p.add(custpassword);
        p.add(tf6);
        p.add(custusername);
        
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
    public String getemail(){
        return tf4.getText();
    }
    public String getpassword(){
        return tf5.getText();
    }
    public String getusername(){
        return tf6.getText();
    }

}