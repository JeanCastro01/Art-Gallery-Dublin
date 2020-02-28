/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 * This class is modelling the user. We can have an object
 * that encapsulates everything that has to do with the user
 * @author apont
 */
public class User {
    
    private String un;
    private String pw;
    
    public User(String un, String pw){
        this.un = un;
        this.pw = pw;
    }

    public String getUn() {
        return un;
    }

    public String getPw() {
        return pw;
    }
    
}
