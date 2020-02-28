/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteart;

import deleteadmin.DeleteadminWindow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class deleteartModel {

    // Connection values
    String dbServer = "jdbc:mysql://52.215.185.140:3306/jeancastro_2018368";
    String user = "jeancastro_2018368";
    String password = "pass1234!";
    Connection conn = null;
    Statement stmt = null;
    
    deleteartWindow view;

    // Starting the DB connection
    public deleteartModel() {

        try {
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            stmt = conn.createStatement();

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
            System.out.println(e);
        }

    }
  public boolean artdelete (String index) {

        try {
            // Building the query
            String query= "DELETE FROM art WHERE art_id = '" + index + "'";
           
            stmt.execute(query);

            closings();

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
            System.out.println(e);
        }
        return false;

    }
 private void closings(){
        try {            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(deleteartModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
