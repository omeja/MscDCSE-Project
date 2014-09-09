/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Osbert
 */
public class CEPListener implements UpdateListener {

    private String response;
    private String rptpath = "C:\\kriminofiles\\report.txt";
    private ArrayList<String> lstarray;
    private int count;
    // Path for System Logs
    private String logpath = "C:\\kriminoZclient\\web\\systemlogs.txt";
    //
    String lst;

    @Override
    public void update(EventBean[] newData, EventBean[] oldData) {
        EventBean event = newData[0];



        lst = event.getUnderlying().toString();

        lstarray = new ArrayList<>();
//
        while (!lstarray.contains(lst)) {
            //  add to array list
            //lst = "";
            lstarray.add(lst);
         //  response = lstarray.get(0);
        }
// for loop
        
        
         FileWriter writer;
        FileWriter writer2;
        try {

// 
            writer = new FileWriter(rptpath, true);
            //
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dt = dateFormat.format(date);
//
            writer2 = new FileWriter(logpath, true);
            //
            writer2.append('\n');
            writer2.append(dt + ":" + response);
            writer2.append('\n');

            writer2.flush();
            writer2.close();

            //
            writer.append(response);
            writer.append('\n');


            writer.flush();
            writer.close();
            response = "";

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

         
       

    }

    public String getResponse() {
        // 

        return "Testing";
    }

    public void setResponse(String response) {
        this.response = response;
    }
    //

    private void savefile(String response) {


        FileWriter writer;
        FileWriter writer2;
        try {

// 
            writer = new FileWriter(rptpath, true);
            //
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dt = dateFormat.format(date);
//
            writer2 = new FileWriter(logpath, true);
            //
            writer2.append('\n');
            writer2.append(dt + ":" + response);
            writer2.append('\n');

            writer2.flush();
            writer2.close();

            //
            writer.append(response);
            writer.append('\n');


            writer.flush();
            writer.close();
            response = "";

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
    //
    //
}
