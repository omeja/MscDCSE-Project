/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
class export {
    private static String tranid;
    private static String ccode2;
    private static String transdate;
    private static String transcode;
    private static String transamt;
    private static String trantyp;
    private static String tracct;

    static void downloadFile() {
      try {

        String filename = "C://kriminoZclient//src//java//javabeans//assetlogs.csv";

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();

        response.reset();
        response.setContentType("text/comma-separated-values");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        OutputStream output = response.getOutputStream();

        // writing  data
        List<String> strings = new ArrayList<String>();
// Read csv files from class path
        
      // try {
            String tlogs = "C:\\kriminoZclient\\src\\java\\javabeans\\transactionlogs.csv";
            //

            //
            FileReader fileReader = new FileReader(tlogs);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            //
      
            while ((line = bufferedReader.readLine()) != null) {
                
                    lines.add(line);
                    // assign text 
                    
               
                    String res2 = line;
                    // split csv file
                
                    String delims = "[,]";
                    //
                    String[] csv = res2.split(delims);
                    //
                     tranid = csv[0];
                    ccode2 = csv[1];
                    //
                    transdate = csv[2];
                    transcode = csv[3];
                    transamt = csv[4];
                    //
                     trantyp = csv[5];
                     tracct = csv[6];
                    //


                    //

                       //
      //  strings.add("filename" + ";" + "description" + "\n");
        strings.add(tranid + "," + ccode2 + ","+ transdate+ "," +transcode + ","+transamt + ","+ trantyp + ","+tracct +"\n");

        for (String s : strings) {
            output.write(s.getBytes());
        }

        


            }
      output.flush();
        output.close();

        fc.responseComplete();
            bufferedReader.close();

        
 
//
//        } catch (Exception e) {
//            e.getStackTrace();
//
//        }  
//        
//             
             
               


    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
