/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updateuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db {
    
    Statement stmt;
    ResultSet rs;
    
    // Constructor. This guy is starting the DB connection and 
    // putting everything in the variables declared above
    public db(){
        
        
    String dbServer = "jdbc:mysql://database​-1.​cptrcvahtkfl.eu-west​-1.​rds.amazonaws.com:3306/jeancastro_2018368";
    String user = "jeancastro_2018368";
    String password = "pass1234!";
    Connection conn = null;
    Statement stmt = null;
    
    
    
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
    
    public ResultSet executeQuery(String query) {

        try {
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }

    }

    public void ExecuteSet(String query) {
        try {
            stmt.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}