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
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@ManagedBean
public class CEPListener7 implements UpdateListener {

    private String response;
    private String rptpath = "C:\\kriminofiles\\report7.txt";
    private ArrayList<String> lstarray;
    private int count;
    //
     private String logpath = "C:\\kriminoZclient\\web\\systemlogs.txt";
 public HttpServletResponse resp;
    @Override
    public void update(EventBean[] newData, EventBean[] oldData) {
        EventBean event = newData[0];

        String lst = null;
        lst = event.getUnderlying().toString();
            //    lst ="";
        // declare new array list
        lstarray = new ArrayList<String>();
//if (lst==null)
//{
//   response ="";
//  savefile(response);
//}
        if (!lstarray.contains(lst)) {
            // add to array list
           // lst = "";
            lstarray.add(lst);
            response = lstarray.get(0);
           savefile(response);
        }
        // savefile(response);

        // read file to create filename using case number


    }

//        public CEPListener() {
//        }
//        //
    public String getResponse() {
        // 

        return "Testing";
    }

    public void setResponse(String response) {
        this.response = response;
    }
    //

    private void savefile(String response) {

        // write to text file
        // rptpath = "C:\\kriminofiles\\report.txt";
//
//

//               // }
//	{
        FileWriter writer;
         FileWriter writer2;
        try {
//            File yourFile = new File(rptpath);
//            if (!yourFile.exists()) {
//                yourFile.createNewFile();
            writer = new FileWriter(rptpath, true);
//
            //
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dt = dateFormat.format(date);
//
            writer2 = new FileWriter(logpath, true);
            //
            writer2.append('\n');
            writer2.append(dt+":"+response);
            writer2.append('\n');

            writer2.flush();
            writer2.close();

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');

            // writer.append('\n');


            //
            writer.append(response);
            writer.append('\n');



            //generate whatever data you want

            writer.flush();
            writer.close();
            response = "";

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
