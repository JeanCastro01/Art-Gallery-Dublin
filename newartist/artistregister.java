/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newartist;

/**
 *
 * @author jeancastro
 */
public class artistregister {
    
    private String firstname;
    private String lastname;
    private String address;
    private String website;
    
    
    public artistregister (String firstname, String lastname,String address, String website){
        this.firstname = firstname;
        this.lastname= lastname;
        this.address= address;
        this.website = website;
       
        
        
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
        public String getwebsite() {
        return website;
    }

    
}

    

