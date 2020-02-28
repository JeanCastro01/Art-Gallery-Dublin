/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import newartist.artistController;


/**
 *
 * @author jeancastro
 */
public class newartWindow extends JFrame {
    
     // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    //private JTextField tf3;
    private JComboBox jc;
   
  
    // This window needs to know who the controller is
    private newartController controllerInternalRef;
    
    public newartWindow (newartController controller){
        
        // Putting the reference of the controller in the local reference
        this.controllerInternalRef = controller;
        
        // encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }


    // Setting attributes
    private void attributesSetter(){
        this.setVisible(true);
        this.setSize(350,300);
        this.setTitle("New Art");
        this.setLocationRelativeTo(null);
         this.setResizable(false);
    }
    
    // Organising components
    private void components(){
        JPanel p = new JPanel();
        this.add(p);
        p.setBackground(Color.GRAY);
        
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
       
        
        JLabel arttile = new JLabel ("title");
        JLabel arttype = new JLabel ("type");
        JLabel message = new JLabel ("Please Select the artist ID instead the name!!!!");
        
        jc = new JComboBox();
        p.add(jc, BorderLayout.WEST);
        
    Connection con;
    Statement st;
    ResultSet rs;
   
   
        
    try {
    con = DriverManager.getConnection("jdbc:mysql://database​-1.​cptrcvahtkfl.eu-west​-1.​rds.amazonaws.com:3306/jeancastro_2018368","jeancastro_2018368","pass1234!");
    
    Statement stmt = null;
   
    
    st = con.createStatement();
    String sql = "SELECT artist_id, artist_fName, artist_lName FROM artist";
    
    rs = st.executeQuery(sql);
    while(rs.next())
    {
       
        jc.addItem(rs.getString("artist_id"));
        jc.addItem(rs.getString("artist_fName"));
        jc.addItem(rs.getString("artist_lName"));
    }
   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error");
            {
                
            }
        }
      
        JButton button = new JButton("Submit");
        button.addActionListener((ActionListener) controllerInternalRef);
        button.setActionCommand("Submit");
      
        
        
        
        p.add(tf1);
        p.add(arttile);
        p.add(tf2);
        p.add(arttype);
        
   
        p.add(message);
        p.add(button);

    
        
    }
    
    // Validation and repainting
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    // Getters for username and password
    public String gettitle(){
        return tf1.getText();
    }
    public String gettype(){
        return tf2.getText();
    }
    public String getartist(){
    return (String) jc.getSelectedItem();
    }
 

}
    