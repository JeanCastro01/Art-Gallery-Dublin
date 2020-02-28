/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteartist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class deleteartistModel {
    
    String dbServer = "jdbc:mysql://database​-1.​cptrcvahtkfl.eu-west​-1.​rds.amazonaws.com:3306/jeancastro_2018368";
    String user = "jeancastro_2018368";
    String password = "pass1234!";
    Connection conn = null;
    Statement stmt = null;
    
    
    deleteartistWindow view;
    
    // Constructor. This guy is starting the DB connection and 
    // putting everything in the variables declared above
    public deleteartistModel(){
        
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

public boolean deleteartist (String index) {

        try {
            // Building the query
            String queryDelete = "DELETE FROM artist WHERE artist_id = ('" + index + "');";

            stmt.execute(queryDelete);
               closing();

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
        return true;

    }

   private void closing(){
        try {            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(deleteartistModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


   
