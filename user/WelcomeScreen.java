/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author jeancastro
 */

import favorites.myfavoritesWindow;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import login.User;
import login.WelcomeScreenadmin;
import login.index;
import updateuser.updateuserController;


/**
 * This class is going to come up only when the login is successful
 * @author apont
 */
public class WelcomeScreen extends JFrame implements ActionListener{
       
   UserWindow view;
   UserModel model;
   UserController controller;
   WelcomeScreen welcome;
   private String userLogged;
    
   public WelcomeScreen(String un){
       
       
        this.userLogged = un;
        this.setVisible(true);
        this.setSize(550, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        JPanel p = new JPanel();
        this.add(p);
        p.setBackground(Color.gray);
        
        JLabel label = new JLabel("Welcome: " + this.userLogged +" to Dublin Art Gallery ");
        p.add(label);
        
        JLabel label2 = new JLabel(" Please select Art and click on the button to add to favorites ");
        p.add(label2);
        
        JButton addfavorites = new JButton("Favorites");
        p.add(addfavorites);
        
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        
        JMenu update = new JMenu("Update my Details");
        JMenuItem update2 = new JMenuItem("updatemydetails");
        update.add(update2);
        menubar.add(update);
        update2.addActionListener(this);
        update2.setActionCommand("updatemydetails");
        
        JMenu favorite = new JMenu("My Favorites");
        JMenuItem favorite2 = new JMenuItem("favorites");
        favorite.add(favorite2);
        menubar.add(favorite);
        favorite2.addActionListener(this);
        favorite2.setActionCommand("favorites");
        
        JMenu logout = new JMenu("Log Out");
        JMenuItem logout2 = new JMenuItem("logout");
        logout.add(logout2);
        menubar.add(logout);
        logout2.addActionListener(this);
        logout2.setActionCommand("logout");
        
        
        
         String[] columnNames = {"Art ID", "Art Title", "Art Type", "Artist First Name", "Artist last Name"};

        //second array for data
        String[][] data = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                    
                    
            String dbServer = "jdbc:mysql://52.215.185.140:3306/jeancastro_2018368";
            String user = "jeancastro_2018368";
            String password2 = "pass1234!";
            String query = "select art_id, art_title, art_type, artist.artist_fName,\n" +
            "artist.artist_lName FROM art \n" +
            "inner join artist on art.artist_id = artist.artist_id;";

            Statement stmt = null;
             ResultSet rs;

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password2);

            // Get a statement from the connection
            stmt = conn.createStatement();

            // Execute the query
             rs = stmt.executeQuery(query);

            // Instantiating the array, didn't figure howe to make with a dynamic size
            data = new String[25][7];
            // Counter
            int row = 0;

            // Loop through the result set
            while (rs.next()) {

                //adding the data to the second array
                data[row][0] = rs.getString("art_id");
                data[row][1] = rs.getString("art_title");
                data[row][2] = rs.getString("art_type");
                data[row][3] = rs.getString("artist_fName");
                data[row][4] = rs.getString("artist_lName");
              
                
               
                row++;
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {

        }

       
        //p.setLayout(new BorderLayout());

        // Setting the table
        JTable Table = new JTable();
        // Setting a scroll pane
        JScrollPane adminPane = new JScrollPane(Table);
        // add data to Table Model
        DefaultTableModel adminModel = new DefaultTableModel(data, columnNames);
        Table.setModel(adminModel);

       p.add(Table);
       p.add(adminPane);
        

       addfavorites.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                String[] options = {"Yes", "No"};
                int confirm = JOptionPane.showOptionDialog(null, "Are you sure ?", "Insert Confirmed", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

                if (confirm == 0) {
                if(e.getActionCommand().equals("Favorites")){
                    int index = Table.getSelectedRow();
                    String id = Table.getValueAt(index, 0).toString();
                    String title = Table.getValueAt(index, 1).toString();
                    String type = Table.getValueAt(index, 2).toString();
                    String firstname = Table.getValueAt(index, 3).toString();
                    String lastname = Table.getValueAt(index, 4).toString();
                    
                    
                    
                    if(new favoritesModel().addfavorites(id,title,type,firstname,lastname)){
                        JOptionPane.showMessageDialog(null, "Inserted");
                        
                    }
                }
                } else{
                JOptionPane.showMessageDialog(null, "Not inserted");
                }
            }
        });

        this.validate();
        this.repaint();
    }


    
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       if (e.getActionCommand().equals("favorites")) {
            

       
       new myfavoritesWindow();
           
            
        }
       
       
         if (e.getActionCommand().equals("logout")) {
             
          
        this.dispose();
       new UserController();
       
        }
         
                
         if (e.getActionCommand().equals("updatemydetails")) {
             
          
      
      
       new updateuserController(this.userLogged);
       
       
       
        }
       
       
       
    }
    
}
