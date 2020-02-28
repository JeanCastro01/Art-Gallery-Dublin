/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import artgallery.view.homeuser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import register.registerController;
import user.UserController;

/**
 *
 * @author jeancastro
 */
public class index  extends JFrame implements ActionListener {
    
  
    
    public index () {
        
        this.setVisible(true);
        this.setSize(700,500);
        this.setTitle("index");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
    
        //JPanel p = new JPanel();
        //this.add(p);
        
        
        BorderLayout border = new BorderLayout ();
        this.setLayout(border);
        
        
    
        
        JLabel label = new JLabel ("Dublin Art Gallery");
        this.add(label, BorderLayout.CENTER);
        label.setForeground(Color.WHITE);
        
        label.setFont(new Font("Verdana", Font.BOLD, 50));
        this.add(label, BorderLayout.NORTH);
         
        JPanel panelnorth = new JPanel ();
        this.add(panelnorth, BorderLayout.NORTH);
        panelnorth.setBackground(Color.BLACK);
       
         JButton admin = new JButton ("Admin");
         panelnorth.add(admin);
        
         JButton customer = new JButton ("Customer");
         panelnorth.add(customer);
         
        JButton register = new JButton ("Register");
        panelnorth.add(register);
        
        JPanel center = new JPanel();
        this.add(center, BorderLayout.CENTER);
        center.setBackground(Color.BLACK);
        
        center.add(label, BorderLayout.SOUTH);
        
      
        
         
        
  
       
         
         admin.setActionCommand("Admin");
         admin.addActionListener(this);
         
         customer.setActionCommand("Customer");
         customer.addActionListener(this);
         
         register.setActionCommand("Register");
         register.addActionListener(this);
        
        this.validate();
        this.repaint();
         
}
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         
        
        if (e.getActionCommand().equals("Admin")) {
            

       
       new LoginController();
       this.dispose();
       
           
            
        }
        else if (e.getActionCommand().equals("Customer")){
           new UserController();
           this.dispose();
        
        }
        else if (e.getActionCommand().equals("Register")) {
        
          new registerController();
    }
            
    }       
     
}

        
        
    
    
    
    
    


