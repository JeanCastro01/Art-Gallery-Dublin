/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteadmin;






import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteadminWindow extends JFrame implements ActionListener {

    DeleteadminModel model;
    //AdminDeleteModel model1;

    public DeleteadminWindow() {

        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Delete Admin");
        this.setLocationRelativeTo(null);
         this.setResizable(false);

        //first array for column names
        String[] columnNames = {"ID","First Name", "Last Name", "Email", "Username", "Password"};

        //second array for data
        String[][] data = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String dbServer = "jdbc:mysql://52.215.185.140:3306/jeancastro_2018368";
            String user = "jeancastro_2018368";
            String password = "pass1234!";
            String query = "SELECT * FROM admin";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Instantiating the array, didn't figure how to make with a dynamic size
            data = new String[15][7];
            // Counter
            int row = 0;

            // Loop through the result set
            while (rs.next()) {

                //adding the data to the second array
                data[row][0] = rs.getString("admin_id");
                data[row][1] = rs.getString("admin_fName");
                data[row][2] = rs.getString("admin_lName");
                data[row][3] = rs.getString("admin_email");
                data[row][4] = rs.getString("admin_username");
                data[row][5] = rs.getString("admin_password");
                
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

        JPanel p = new JPanel();
        this.add(p);
        p.setBackground(Color.GRAY);
        JLabel label = new JLabel("Please Select the Admin and Click on Delete");
        p.add(label);
        //p.setLayout(new BorderLayout());

        // Setting the table
        JTable adminTable = new JTable();
        // Setting a scroll pane
        JScrollPane adminPane = new JScrollPane(adminTable);
        // add data to Table Model
        DefaultTableModel adminModel = new DefaultTableModel(data, columnNames);
        adminTable.setModel(adminModel);

        
        //JButton updateAdmin = new JButton("Update");
        JButton deleteAdmin = new JButton("Delete");
        //JLabel label = new JLabel("Registered Administrators:");
        
        
        //p.add(label);
        p.add(adminPane);
        p.add(deleteAdmin);
        deleteAdmin.setSize(10, 20);
       // p.add(updateAdmin);
        //updateAdmin.setSize(10, 20);
        

        deleteAdmin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                String[] options = {"Yes", "No"};
                int confirm = JOptionPane.showOptionDialog(null, "Are you sure ?", "Delete Confirm", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

                if (confirm == 0) {
                if(e.getActionCommand().equals("Delete")){
                    int index = adminTable.getSelectedRow();
                    String username = adminTable.getValueAt(index, 0).toString();
                    
                    if(new DeleteadminModel().adminDelete(username)){
                        JOptionPane.showMessageDialog(null, "Deleted");
                        
                    }
                }
                } else{
                JOptionPane.showMessageDialog(null, "Not Deleted");
                }
            }
        });

        this.validate();
        this.repaint();
    }
    
    @Override

    public void actionPerformed(ActionEvent e) {
    }

}

    
          


   


