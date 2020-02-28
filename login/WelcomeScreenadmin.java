/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;




import deleteadmin.DeleteadminWindow;
import deleteart.deleteartWindow;

import deleteartist.deleteartistWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import newadmin.newadminController;
import newart.newartController;
import newartist.artistController;
import user.UserController;

/**
 * This class is going to come up only when the login is successful
 * @author apont
 */
public class WelcomeScreenadmin extends JFrame implements ActionListener{
    
    
    public WelcomeScreenadmin(User userLogged){
        
        this.setVisible(true);
        this.setSize(800, 500);
        this.setTitle("Admin Dashboard");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        
        BorderLayout border = new BorderLayout ();
        this.setLayout(border);
        
        JPanel p = new JPanel();
        this.add(p, BorderLayout.CENTER);
        p.setBackground(Color.GRAY);
        
        
        
        JLabel label = new JLabel("Welcome: " + userLogged.getUn()+" to Dublin Art Gallery ");
        p.add(label);
        
        
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        p.add(label, BorderLayout.CENTER);
         
       
        
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        
        JMenu newartist = new JMenu("New Artist");
        menubar.add(newartist);
        newartist.addActionListener(this);
        newartist.setActionCommand("New Artist");
        
        JMenu deleteartist = new JMenu("Delete Artist");
        JMenuItem deleteartist2 = new JMenuItem("deleteartist");
        deleteartist.add(deleteartist2);
        menubar.add(deleteartist);
        deleteartist2.addActionListener(this);
        deleteartist2.setActionCommand("deleteartist");
        
     
        
        
        
        
        
        JMenuItem close = new JMenuItem("newartist");
        newartist.add(close);
        close.addActionListener(this);
        close.setActionCommand("newartist");
        
        JMenu newart = new JMenu("New Art");
        JMenuItem newart2 = new JMenuItem("newart");
        menubar.add(newart);
        newart.add(newart2);
        newart2.addActionListener(this);
        newart2.setActionCommand("newart");
        
        
        JMenu deleteart = new JMenu("Delete Art");
        JMenuItem deleteart2 = new JMenuItem("deleteart");
        deleteart.add(deleteart2);
        menubar.add(deleteart);
        deleteart2.addActionListener(this);
        deleteart2.setActionCommand("deleteart");
             
        
        JMenu updatemydetails = new JMenu("Update My Details");
        menubar.add(updatemydetails);
        
        
        JMenu deleteadmin = new JMenu("Delete Admin");
        JMenuItem deleteadmin2 = new JMenuItem("deleteadmin");
        menubar.add(deleteadmin);
        deleteadmin.add(deleteadmin2);
        deleteadmin2.addActionListener(this);
        deleteadmin2.setActionCommand("deleteadmin");
        
        JMenuItem newadmin2 = new JMenuItem("newadmin");
        JMenu newadmin = new JMenu(" New Admin");
        menubar.add(newadmin);
        newadmin.add(newadmin2);
        newadmin2.addActionListener(this);
        newadmin2.setActionCommand("newadmin");
    
        JMenuItem logout2 = new JMenuItem("logout");
        JMenu logout = new JMenu(" Log out");
        menubar.add(logout);
        logout.add(logout2);
        logout2.addActionListener(this);
        logout2.setActionCommand("logout");
        
   
        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String ac = e.getActionCommand();
        if (ac.equals("newartist")) {
            
            new artistController();
        }
        else if (e.getActionCommand().equals("newadmin")) {
            new newadminController();
        }
         else if (e.getActionCommand().equals("deleteadmin")) {
             new DeleteadminWindow();
        }
           else if (e.getActionCommand().equals("newart")) {
             new newartController();
        }
        
             else if (e.getActionCommand().equals("deleteartist")) {
             new deleteartistWindow();
        }
             else if (e.getActionCommand().equals("deleteart")) {
             new deleteartWindow();
        }
             else if (e.getActionCommand().equals("logout")) {
           this.dispose();
           new LoginController();
           new index();
        }
    }
    
}
