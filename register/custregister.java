/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

/**
 *
 * @author jeancastro
 */
public class custregister {
    
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;
    private String username;
    
    public custregister (String firstname, String lastname,String address, String email,String password, String username){
        this.firstname = firstname;
        this.lastname= lastname;
        this.address= address;
        this.email= email;
        this.email= password;
        this.username= username;
        
        
    }

        public String getfirstname() {
        return firstname;
    }

        public String getlastname() {
        return lastname;
    }
        public String getaddress() {
        return address;
    }
        public String getemail() {
        return email;
    }
        public String getpassword() {
        return password;
    }
        public String getusername() {
        return username;
    }
    
}
