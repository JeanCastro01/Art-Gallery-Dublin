/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import newartist.artistregister;




/**
 * The model is the DB connection
 * @author apont
 */
public class newadminModel {
    
    String dbServer = "jdbc:mysql://database​-1.​cptrcvahtkfl.eu-west​-1.​rds.amazonaws.com:3306/jeancastro_2018368";
    String user = "jeancastro_2018368";
    String password = "pass1234!";
    Connection conn = null;
    Statement stmt = null;
    
    // Constructor. This guy is starting the DB connection and 
    // putting everything in the variables declared above
    public newadminModel(){
        
        try{
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password) ;

            // Get a statement from the connection
            stmt = conn.createStatement() ;

        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
    }
    
    // This method is only in charge of asking the DB if a user exists
    // Notice that it is using the variables initialised by the constructor
    public void register (newadminregister newadmin){
        
        // Variable to define if the login is successful
   
        try{
            // Building the query
            String query2 = "INSERT INTO admin (admin_fName, admin_lName,  admin_email, admin_username, admin_password ) VALUES ('" + newadmin.getfirstname() + "','" + newadmin.getlastname() + "','" + newadmin.getemail() + "','" + newadmin.getpassword() + "','" + newadmin.getusername() +"');";

            // Sending the query to the database
             stmt.executeUpdate(query2) ;

            // If there is an entry in the database that satisfies
            // the username and password, then the login is successful
            // otherwise it fails
          

            // Close the result set, statement and the connection
           

            // Calling the method in charge of closing the connections
            closings();
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }

        // Retuning the login status
      
    }
        
    // This method is only in charge of saving a new user into the the DB
   
    
    // Separeating closing statements for better code structure
    private void closings(){
        try {            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(newadminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

