/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class CounterBean implements Serializable{
     private int count = 10;  
  
    public String getCount() {  
        
        return "Automatic Page Refresh -----> "+"     ("+count+")";  
    }  
  
    public void setCount(int count) {  
        this.count = count;  
    }  
      
    public void increment(ActionEvent event) {  
      
          count--; 

        //
       
          if(count==0)
          {
          count = 10;
          }
    }  
    
}
