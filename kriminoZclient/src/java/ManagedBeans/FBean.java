/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.FileWriter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class FBean {
 private String csno;
   
    public String getCn() {
             
        //
          FileWriter writer;
  
        try {
//            File yourFile = new File(rptpath);
//            if (!yourFile.exists()) {
//                yourFile.createNewFile();
            writer = new FileWriter("c:\\kriminofiles\\cases.txt", true);
            //
            int i =0;
           while((i==0)&&(csno!=null)){
            writer.append(csno);
            writer.append('\n');



            //generate whatever data you want

            writer.flush();
            writer.close();
            i++;
           }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        //
    if (csno==null){
        return "No Case Added";
    }
    
    else{
        return "Case"+" "+csno+" "+" Added";
    }
    }

    public String getCsno() {
   
        return "";
    }

    public void setCsno(String csno) {
        this.csno = csno;
    }
    /**
     * Creates a new instance of FBean
     */
    public FBean() {
    }
}
