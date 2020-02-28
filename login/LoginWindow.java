/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This is the login window
 * @author apont
 */
public class LoginWindow extends JFrame{
    
    // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JPasswordField tf2;
    
    // This window needs to know who the controller is
    private LoginController controllerInternalRef;
    
    public LoginWindow(LoginController controller){
        
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
        this.setTitle("Login Admin");
        this.setLocationRelativeTo(null);
           this.setResizable(false);
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        
        p.setBackground(Color.GRAY);
        
        tf1 = new JTextField(20);
        tf2 = new JPasswordField(20);
        
        JLabel username = new JLabel ("Username");
        username.setForeground(Color.WHITE);
        JLabel password = new JLabel ("Password");
        password.setForeground(Color.WHITE);
        
        JButton button = new JButton("Login");
        button.addActionListener((ActionListener) controllerInternalRef);
        button.setActionCommand("b");
        
              
        
        p.add(tf1);
        p.add(username);
        p.add(tf2);
        p.add(password);
        p.add(button);
    
        
    }
    
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    // Getters for username and password
    public String getUsername(){
        return tf1.getText();
    }
    public String getPassword(){
        return tf2.getText();
    }

}
