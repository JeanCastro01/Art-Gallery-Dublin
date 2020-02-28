/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newart;

/**
 *
 * @author jeancastro
 */
public class newartregister {
    
    private String title;
    private String type;
    private String artist;
   
    
    public newartregister (String title, String type,String artist){
        this.title = title;
        this.type= type;
        this.artist= artist;
        
       
        
        
    }

        public String gettitle() {
        return title;
    }

        public String gettype() {
        return type;
    }
        public String getartist() {
        return artist;
    }
  

    
}
