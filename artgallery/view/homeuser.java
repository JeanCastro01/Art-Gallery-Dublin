/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artgallery.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author jeancastro
 */
public class homeuser extends JFrame  implements ActionListener {
    
    
    public homeuser(){
        
         this.setVisible(true);
        this.setSize(400,600);
        this.setTitle("Login");
        
        JPanel p = new JPanel();
        this.add(p);
        
        JLabel label = new JLabel ("Dublin Art Gallery / User");
        p.add(label);
        
         
        JMenuBar menubar = new JMenuBar ();
        this.setJMenuBar(menubar);
        
        JMenu file =  new JMenu ("Menu");
        menubar.add(file);
        
        JMenuItem updatemydetails = new JMenuItem("Update my Details");
        file.add(updatemydetails);
        
        JMenuItem Searchnewart = new JMenuItem("Search New Art");
        file.add(Searchnewart);
        
        JMenuItem favorites = new JMenuItem("My Favorites");
        file.add(favorites);
        
        this.validate();
        this.repaint();
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
