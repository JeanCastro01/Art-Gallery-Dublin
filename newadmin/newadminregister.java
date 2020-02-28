/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newadmin;

//**

public class newadminregister {
    
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    
    
    public newadminregister (String firstname, String lastname,String email, String username, String password){
        this.firstname = firstname;
        this.lastname= lastname;
        this.email= email;
        this.username = username;
        this.password = password;
       
        
        
    }

        public String getfirstname() {
        return firstname;
    }

        public String getlastname() {
        return lastname;
    }
        public String getemail() {
        return email;
    }
        public String getusername() {
        return username;
    }
        public String getpassword() {
        return password;
    }

    
}
