/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esperio.AdapterCoordinator;
import com.espertech.esperio.AdapterCoordinatorImpl;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.espertech.esperio.csv.CSVInputAdapterSpec;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dbase.Accounts;
import dbase.Assets;
import dbase.Boutransfers;
import dbase.Budget;
import dbase.Casetrans;
import dbase.Contracts;
import dbase.Emails;
import dbase.Income;
import dbase.Phonelogs;
import dbase.Realtime;
import dbase.Request;
import dbase.Tasks;
import dbase.Transfers;
import dbase.Userrights;
import dbase.Workplan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Osbert
 */
@ManagedBean
@SessionScoped
@RequestScoped
public class MainBean1 {
    //

    //private String reloadsys;
// make CEPlistener property
    private CEPListener pojo;
    //
    // Document document;
    //
    private String symbol;
    private Double price;
    private String result;
    private String cfile;
    private String caseNo;
    private String filepath;
    private String filepath2;
    private boolean hasErrors;
    private String casefile;
    private String filepath11;
    private String filepath12;
    private String filepath13;
    private String filepath14;
    private String filepath15;
    private String filepath16;
    private String filepath17;
    private String fp11;
    private String period;
    private String cfile8;
    private String cfile9;
    private String fp12;
    private String fp13;
    private String cfile10;
    private String cfile11;
    private String fp14;
    private String fp15;
    private String fp16;
    private String fp17;
    private String cfile12;
    private String cfile13;
    private String cfile14;
    private String pdf;
    private ArrayList<String> pats;
    private int ct1;
    private ArrayList<String> pats2;
    private int ct2;
    private ArrayList<String> pats3;
    private int ct3;
    private ArrayList<String> pats4;
    private int ct4;
    private ArrayList<String> pats5;
    private int ct5;
    private ArrayList<String> pats6;
    private int ct6;
    private ArrayList<String> pats8;
    private int ct8;
    private ArrayList<String> pats12;
    private int ct12;
    private String rs;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String fspath = "c:\\kriminofiles\\symbols.txt";
    private String csno;
    private int marker;
    private String tpats12;
    private String tpats8;
    private String tpats6;
    private String tpats5;
    private String tpats4;
    private String tpats3;
    private String tpats2;
    private String tpats;
    private int counter2;
    private Document document;

    public String getCn() {

        //
        FileWriter writer;

        try {
//            File yourFile = new File(rptpath);
//            if (!yourFile.exists()) {
//                yourFile.createNewFile();
            writer = new FileWriter("c:\\kriminofiles\\cases.txt", true);
            //
            int i = 0;
            while ((i == 0) && (csno != null)) {
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
        if (csno == null) {
            return "No Case Added";
        } else {
            return "Case" + " " + csno + " " + " Added";
        }
    }

    public String getCasefile() {
        return casefile;
    }

    public void setCasefile(String casefile) {
        this.casefile = casefile;
    }

    public String getFilepath2() {
        return filepath2;
    }

    public void setFilepath2(String filepath2) {
        this.filepath2 = filepath2;
    }

    public String getFilepath3() {
        return filepath3;
    }

    public void setFilepath3(String filepath3) {
        this.filepath3 = filepath3;
    }

    public String getFilepath5() {
        return filepath5;
    }

    public void setFilepath5(String filepath5) {
        this.filepath5 = filepath5;
    }

    public String getFilepath7() {
        return filepath7;
    }

    public void setFilepath7(String filepath7) {
        this.filepath7 = filepath7;
    }

    public String getFilepath8() {
        return filepath8;
    }

    public void setFilepath8(String filepath8) {
        this.filepath8 = filepath8;
    }
    private String filepath3;
    private String cfile2;
    private String cfile3;
    private String cfile4;
    private String cfile5;
    private String cfile6;
    private String cfile7;
    private ArrayList<String> lines = new ArrayList<String>();
    private static String res;
    private int count1;
    private String mes1;
    private String selector;
    private String txnop;
    private int txnamt;
    private String txntype;
    // private String filepath4;
    private String fpath;
    private int cnt, cntt, cnttt, bamt2;
//    public void reset() {
    private String filepath4 = "C:\\kriminofiles\\report.txt";
    private String filepath42 = "C:\\kriminofiles\\report2.txt";
    private String filepath43 = "C:\\kriminofiles\\report3.txt";
    private String filepath44 = "C:\\kriminofiles\\report4.txt";
    private String filepath45 = "C:\\kriminofiles\\report5.txt";
    private String filepath46 = "C:\\kriminofiles\\report6.txt";
    private String logpath = "C:\\kriminoZclient\\web\\systemlogs.txt";
    String filepath5;
    String filepath6;
    String filepath7;
    String filepath8;
    //
    String fp;
    String fp1;
    String fp2;
    String fp3;
    String fp4;
    String fp5;
    String fp6;
    //
    // parameter fields
    private int bgamt;
    private int pamt;
    private int inamt;
    private int assetval;
    private Date calldt;
    //    File fileTemp4 = new File(filepath4);
    // comparison symbols
    private String transymb;
    private String assetsymb;
    private String incsymb;
    private String bousymb;
    private String tfsymb;
    private String filepath10;
    //
    private String eol = System.getProperty("line.separator");

    //
    public String getTfsymb() {
        return tfsymb;
    }

    public void setTfsymb(String tfsymb) {
        this.tfsymb = tfsymb;
    }
    //
    private String filepath9;
//
    private String vf;

    public String getVf() {
        return vf;
    }

    public void setVf(String vf) {
        this.vf = vf;
    }

    public String getVf1() {
        return vf1;
    }

    public void setVf1(String vf1) {
        this.vf1 = vf1;
    }

    public String getVf2() {
        return vf2;
    }

    public void setVf2(String vf2) {
        this.vf2 = vf2;
    }

    public String getVf3() {
        return vf3;
    }

    public void setVf3(String vf3) {
        this.vf3 = vf3;
    }

    public String getVf4() {
        return vf4;
    }

    public void setVf4(String vf4) {
        this.vf4 = vf4;
    }

    public String getVf5() {
        return vf5;
    }

    public void setVf5(String vf5) {
        this.vf5 = vf5;
    }
    private String vf1;
    private String vf2;
    private String vf3;
    private String vf4;
    private String vf5;
    //
    private String transymb2, asetsymb2, incsymb2, bousymb2, assetsymb2;

    //
    public Date getCalldt() {
        return calldt;
    }

    public void setCalldt(Date calldt) {
        this.calldt = calldt;
    }

    public String getTransymb() {

        return transymb;
    }

    public void setTransymb(String transymb) {
        this.transymb = transymb;
    }

    public String getAssetsymb() {
        return assetsymb;
    }

    public void setAssetsymb(String assetsymb) {
        this.assetsymb = assetsymb;
    }

    public String getIncsymb() {
        return incsymb;
    }

    public void setIncsymb(String incsymb) {
        this.incsymb = incsymb;
    }

    public String getBousymb() {
        return bousymb;
    }

    public void setBousymb(String bousymb) {
        this.bousymb = bousymb;
    }

    //
    public int getAssetval() {
        return assetval;
    }

    public void setAssetval(int assetval) {
        this.assetval = assetval;
    }

    public int getInamt() {
        return inamt;
    }

    public void setInamt(int inamt) {
        this.inamt = inamt;
    }

    public int getPamt() {
        return pamt;
    }

    public void setPamt(int pamt) {
        this.pamt = pamt;
    }

    public int getBgamt() {
        return bgamt;
    }

    public void setBgamt(int bgamt) {
        this.bgamt = bgamt;
    }

    //               fileTemp4.delete();
//    }
    //
    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }
    //
    // Add Persistence
    @PersistenceUnit
    EntityManagerFactory emf;
    //   EntityManagerFactory emf1;
    //  EntityManagerFactory emf2;
    //

    public String getCfile() {
        //
        String cp = "C:\\kriminoZclient\\web\\phonelogs.csv";
        String cp1 = "C:\\kriminoZclient\\web\\transactionlogs.csv";
        String cp2 = "C:\\kriminoZclient\\web\\transferlogs.csv";
        String cp3 = "C:\\kriminoZclient\\web\\boulogs.csv";
        String cp4 = "C:\\kriminoZclient\\web\\budgetlogs.csv";
        String cp5 = "C:\\kriminoZclient\\web\\incomelogs.csv";
        String cp6 = "C:\\kriminoZclient\\web\\assetlogs.csv";
        String cp11 = "C:\\kriminoZclient\\web\\accountlogs.csv";
        String cp12 = "C:\\kriminoZclient\\web\\contractlogs.csv";
        String cp13 = "C:\\kriminoZclient\\web\\Emaillogs.csv";
        String cp14 = "C:\\kriminoZclient\\web\\Requestlogs.csv";
        String cp15 = "C:\\kriminoZclient\\web\\Tasklogs.csv";
        String cp16 = "C:\\kriminoZclient\\web\\Workplanlogs.csv";
        String cp17 = "C:\\kriminoZclient\\web\\userlogs.csv";
        //

        String classp = "C:\\kriminoZclient\\src\\java\\javabeans\\phonelogs.csv";
        String classp1 = "C:\\kriminoZclient\\src\\java\\javabeans\\transactionlogs.csv";
        String classp2 = "C:\\kriminoZclient\\src\\java\\javabeans\\transferlogs.csv";
        String classp3 = "C:\\kriminoZclient\\src\\java\\javabeans\\boulogs.csv";
        String classp4 = "C:\\kriminoZclient\\src\\java\\javabeans\\budgetlogs.csv";
        String classp5 = "C:\\kriminoZclient\\src\\java\\javabeans\\incomelogs.csv";
        String classp6 = "C:\\kriminoZclient\\src\\java\\javabeans\\assetlogs.csv";
        String classp11 = "C:\\kriminoZclient\\src\\java\\javabeans\\accountlogs.csv";
        String classp12 = "C:\\kriminoZclient\\src\\java\\javabeans\\contractlogs.csv";
        String classp13 = "C:\\kriminoZclient\\src\\java\\javabeans\\Emaillogs.csv";
        String classp14 = "C:\\kriminoZclient\\src\\java\\javabeans\\Requestlogs.csv";
        String classp15 = "C:\\kriminoZclient\\src\\java\\javabeans\\Tasklogs.csv";
        String classp16 = "C:\\kriminoZclient\\src\\java\\javabeans\\Workplanlogs.csv";
        String classp17 = "C:\\kriminoZclient\\src\\java\\javabeans\\userlogs.csv";
        //
        String classparam = "c:\\kriminofiles\\params.txt";
        String classym = "c:\\kriminofiles\\symbols.txt";
        //
        // Read case number from file
        try {
            String casepath = "c:\\kriminofiles\\cases.txt";
            //

            //
            FileReader fileReaderc = new FileReader(casepath);

            BufferedReader bufferedReaderc = new BufferedReader(fileReaderc);

            String lin;
            //
            marker = 0;
            //
            while ((lin = bufferedReaderc.readLine()) != null) {
//if (lin.startsWith("CPS001")){

                caseNo = lin;


//}

                pats2 = new ArrayList<String>();
                //



                filepath = classp;
                filepath2 = classp1;
                filepath3 = classp2;
                filepath5 = classp3;
                filepath6 = classp4;
                filepath7 = classp5;
                filepath8 = classp6;
                filepath9 = classparam;
                filepath10 = classym;
                filepath11 = classp11;
                filepath12 = classp12;
                filepath13 = classp13;
                filepath14 = classp14;
                filepath15 = classp15;
                filepath16 = classp16;
                filepath17 = classp17;
                //
                fp = cp;
                fp1 = cp1;
                fp2 = cp2;
                fp3 = cp3;
                fp4 = cp4;
                fp5 = cp5;
                fp6 = cp6;
                //
                fp11 = cp11;
                fp12 = cp12;
                fp13 = cp13;
                fp14 = cp14;
                fp15 = cp15;
                fp16 = cp16;
                fp17 = cp17;
//Delete if tempFile exists
                File fileTemp = new File(filepath);
                File fileTemp2 = new File(filepath2);
                File fileTemp3 = new File(filepath3);
                File fileTemp4 = new File(filepath4);
                File fileTemp5 = new File(filepath5);
                File fileTemp6 = new File(filepath6);
                File fileTemp7 = new File(filepath7);
                File fileTemp8 = new File(filepath8);
                File fileTemp9 = new File(filepath9);
                File fileTemp10 = new File(filepath10);
//
                File fileTemp42 = new File(filepath42);
                File fileTemp43 = new File(filepath43);
                File fileTemp44 = new File(filepath44);
                File fileTemp45 = new File(filepath45);
                File fileTemp46 = new File(filepath46);
                File filelog = new File(logpath);
                //
                File ftp = new File(fp);
                File ftp1 = new File(fp1);
                File ftp2 = new File(fp2);
                File ftp3 = new File(fp3);
                File ftp4 = new File(fp4);
                File ftp5 = new File(fp5);
                File ftp6 = new File(fp6);
                //
                File ftp11 = new File(fp11);
                File ftp112 = new File(filepath11);
                //
                File ftp12 = new File(fp12);
                File ftp122 = new File(filepath12);
                //
                File ftp16 = new File(fp16);
                File ftp162 = new File(filepath16);
                //
                File ftp13 = new File(fp13);
                File ftp132 = new File(filepath13);
                //
                File ftp14 = new File(fp14);
                File ftp142 = new File(filepath14);
                //
                File ftp15 = new File(fp15);
                File ftp152 = new File(filepath15);
                //
                ftp.delete();
                ftp1.delete();
                ftp2.delete();
                ftp3.delete();
                ftp4.delete();
                ftp5.delete();
                ftp6.delete();
                filelog.delete();
                //
                ftp11.delete();
                ftp112.delete();
                //
                ftp12.delete();
                ftp122.delete();
                ftp13.delete();
                ftp132.delete();
                ftp14.delete();
                ftp142.delete();
                ftp15.delete();
                ftp152.delete();
                ftp16.delete();
                ftp162.delete();
//              //  if (fileTemp.exists()) {
                fileTemp.delete();
                fileTemp2.delete();
                fileTemp3.delete();
                fileTemp4.delete();
                fileTemp5.delete();
                fileTemp6.delete();
                fileTemp7.delete();
                fileTemp8.delete();
                //
                fileTemp42.delete();
                fileTemp43.delete();
                fileTemp44.delete();
                fileTemp45.delete();
                fileTemp46.delete();
                fileTemp9.delete();
                fileTemp10.delete();
                // }
// write headers



                //
// realtime mode
                emf.getCache().evictAll();

                if (caseNo == null) {
                    //
                    List<Realtime> iteml = emf.createEntityManager().
                            createNamedQuery("Realtime.findAll").getResultList();
                    int cnn = iteml.size() - 1;
                    for (int idx5 = 0; idx5 <= cnn; idx5++) {
                        try {


                            dbase.Realtime rt = iteml.get(idx5);
                            caseNo = rt.getValue();

                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                    }


                }

                //
                List<Phonelogs> itemList = emf.createEntityManager().
                        createNamedQuery("Phonelogs.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                cnt = itemList.size();
                int cnt2 = cnt - 1;

                //for loop here
                for (int idx = 0; idx <= cnt2; idx++) {
                    try {
                        Phonelogs item = itemList.get(idx);

                        // Phone fields
                        int callid = item.getCallId();
                        String casecode1 = caseNo;
                        String froNo = item.getFromNo();
                        String toNo = item.getToNo();
                        String calldate = item.getCallDate().toString();
                        String requestID = item.getRequestID().getFilenme();
                        // Timestamp
                        //  DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        //  Date dt1 = new Date();
                        //
                        //  String dt2 = dateFormat.format(dt1);
                        //
                        //  SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
                        // Date d = f.parse(dt2);
                        //long ts1 = d.getTime();
                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        //   String hdr1 = "Call_id,case_code,call_date,from_No,to_No";
                        cfile = callid + "," + casecode1 + "," + calldate + "," + froNo + "," + toNo + "," + requestID;
//            write to csv file
                        // filepath = "c:\\kriminofiles\\phonelogs.csv";
                        // filepath = classp;

//
//try
//	{
                        FileWriter writer = new FileWriter(filepath, true);
                        //
                        FileWriter writer2 = new FileWriter(fp, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((idx == 0) && (marker == 0)) {
                            String phonehdr = "callid" + "," + "ccode1" + "," + "calldate" + "," + "frono" + "," + "tono" + "," + "reqid";
                            writer.append(phonehdr);
                            //
                            writer2.append(phonehdr);
                        }
                        writer.append('\n');
                        writer.append(cfile);
                        writer.append('\n');
//
                        writer2.append('\n');
                        writer2.append(cfile);
                        writer2.append('\n');
// copy to classpath


                        //Files.copy(filepath, classp,Boolean.TRUE);

                        //

                        //generate whatever data you want

                        writer.flush();
                        writer.close();
//
                        writer2.flush();
                        writer2.close();




                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }
                //
                // 2.Read Case Transations table data
                // 
//        List<Phonelogs> itemList = emf.createEntityManager().
//                createNamedQuery("Phonelogs.findAll").getResultList();
                //
                List<Casetrans> itemList1 = emf.createEntityManager().
                        createNamedQuery("Casetrans.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                cntt = itemList1.size();
                int cntt2 = cntt - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int idxx = 0; idxx <= cntt2; idxx++) {
                    try {
                        Casetrans item1 = itemList1.get(idxx);
                        // Phone fields
                        int tranid = item1.getTransactionid();
                        String ccode2 = caseNo;
                        String transdate = item1.getTransdate().toString();
                        String trancode = item1.getTranscode();
                        Number transamount = item1.getTransAmount();
                        String trantype = item1.getTransType();
                        String tranacct = item1.getTransaccount();
                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile2 = tranid + "," + ccode2 + "," + transdate + ","
                                + trancode + "," + transamount + "," + trantype + ","
                                + tranacct;
//            write to csv file
                        // filepath2 = "c:\\kriminofiles\\transactionlogs.csv";
                        // filepath2 = classp1;
//
//try
//	{
                        FileWriter writer = new FileWriter(filepath2, true);
//
                        FileWriter writer2 = new FileWriter(fp1, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((idxx == 0) && (marker == 0)) {
                            String txnhdr = "tranid" + "," + "ccode2" + ","
                                    + "transdate" + "," + "transcode" + ","
                                    + "transamount" + "," + "transtype" + "," + "transaccount";
                            writer.append(txnhdr);
                            //
                            writer2.append(txnhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile2);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile2);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }
                //
                // 3. Read case transfers table data
                //
//        List<Phonelogs> itemList = emf.createEntityManager().
//                createNamedQuery("Phonelogs.findAll").getResultList();
                //
                List<Transfers> itemList2 = emf.createEntityManager().
                        createNamedQuery("Transfers.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                cnttt = itemList2.size();
                int cnttt2 = cnttt - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int idxxx = 0; idxxx <= cnttt2; idxxx++) {
                    try {
                        Transfers item2 = itemList2.get(idxxx);

                        // Phone fields
                        int trid = item2.getId();
                        String ccode3 = caseNo;
                        String tfdt = item2.getTdate().toString();
                        Number tramount = item2.getTamount();
                        String froAcct = item2.getFroaccount();
                        String toAcct = item2.getToaccount();
                        String frobnk = item2.getFrobank();
                        String tobnk = item2.getTobank();
                        String wkplanid = item2.getWrkplanid().getWorkPlanCode();
                        int contrid = item2.getContractid().getContractAmt();
                        String Taskid = item2.getTaskid().getStatus();
                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile3 = trid + "," + ccode3 + "," + tfdt + "," + tramount + ","
                                + froAcct + "," + toAcct + "," + frobnk + "," + tobnk
                                + "," + wkplanid + "," + contrid + "," + Taskid;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath3, true);
                        //
                        FileWriter writer2 = new FileWriter(fp2, true);

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((idxxx == 0) && (marker == 0)) {
                            String tfhdr = "tfid" + "," + "ccode3" + ","
                                    + "tdate" + "," + "tamount" + ","
                                    + "tfroacct" + "," + "ttoacct" + "," + "frobank" + "," + "ttobank"
                                    + "," + "wkplanid" + "," + "contrid" + "," + "Taskid";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile3);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile3);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
//                   File x = new File(filepath3);
//               File y = new File(classp2);
//                //
//               copyFileUsingStream(x,y);
                        //
                        // Esper call
//                 cepConfig.addEventType("Transferbean", javabeans.Transferbean.class.getName());
//        cepStatement.addListener(new CEPListener());
//                Transferbean transferbean = new Transferbean(trid, ccode3, tfdt, tramount, froAcct, toAcct, frobnk, tobnk);
//                cepRT.sendEvent(transferbean);
//               
//	}
//	catch(IOException e)
//	{
//	     e.printStackTrace();
//	} 
//                Configuration cepConfig3 = new Configuration();
//                cepConfig3.addEventType("Transferbean", Transactionbean.class.getName());
//                EPServiceProvider cep3 = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig3);
//                EPRuntime cepRT3 = cep3.getEPRuntime();
//                //
//
//                //
//                EPAdministrator cepAdm3 = cep3.getEPAdministrator();
//                // split
//                EPStatement cepStatement3 = cepAdm3.createEPL("select * from "
//                        + "Transferbean().win:length(2)");
//
//                //    CEPListener listener = new CEPListener();
//                cepStatement3.addListener(new CEPListener());
//                Transferbean transferbean = new Transferbean(trid, ccode3, tfdt, tramount, froAcct, toAcct, frobnk, tobnk);
//                cepRT3.sendEvent(transferbean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }
                // Listener Static class
                // BOUtransfer file
                List<Boutransfers> itemList3 = emf.createEntityManager().
                        createNamedQuery("Boutransfers.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt3 = itemList3.size();
                int cntttt3 = cnt3 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int idxxxx = 0; idxxxx <= cntttt3; idxxxx++) {
                    try {
                        Boutransfers item3 = itemList3.get(idxxxx);

                        // fields
                        int bid = item3.getIdbou();
                        String bdate = item3.getBdate().toString();
                        String transfertype = item3.getTransfertype();
                        String debitacct = item3.getDebitacctno();
                        String debitacctname = item3.getDebitacctname();
                        int debitamt = item3.getDebitamount();
                        String crbank = item3.getCreditbank();
                        String cracct = item3.getCreditacct();
                        String bankstaff = item3.getBankstaffid();
                        String govtstaff = item3.getGovtstaffid();
                        String ccode4 = caseNo;
                        // add status and limit values
                        String astatus = item3.getCraccstat();
                        int limit = item3.getLimitamt();
                        // Budget itemcode = item3.getItemcode();
                        int itemcode = item3.getItemcode().getAmount();

                        bgamt = itemcode;

                        // create csv file from entity/database
                        cfile4 = bid + "," + bdate + "," + transfertype + "," + debitacct + ","
                                + debitacctname + "," + debitamt + "," + crbank + "," + cracct
                                + "," + bankstaff + "," + govtstaff + "," + ccode4 + ","
                                + itemcode + "," + astatus + "," + limit;
//            write to csv file
                        //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                        //    filepath3 = classp2;
//
//try
//	{
                        FileWriter writer = new FileWriter(filepath5, true);
//
                        FileWriter writer2 = new FileWriter(fp3, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((idxxxx == 0) && (marker == 0)) {
                            String tfhdr = "idbou" + "," + "bdate" + ","
                                    + "transfertype" + "," + "debitacctno" + ","
                                    + "debitacctname" + "," + "debitamount" + "," + "creditbank" + "," + "creditacct"
                                    + "," + "bankstaffid" + "," + "govtstaffid" + "," + "casecode" + "," + "budgetamt"
                                    + "," + "status" + "," + "limit2";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile4);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile4);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //



                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }




                // Budget file

                // Asset file
                List<Assets> itemList5 = emf.createEntityManager().
                        createNamedQuery("Assets.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt5 = itemList5.size();
                int cnttt5 = cnt5 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id5 = 0; id5 <= cnttt5; id5++) {
                    try {
                        Assets item5 = itemList5.get(id5);

                        // Phone fields
                        int assetid = item5.getAssetcode();
                        String assettype = item5.getAssettype();
                        int marketval = item5.getMarketvalue();
                        String acqdate = item5.getAcquiredate().toString();
                        int acqcost = item5.getAcquirecost();
                        String acqmode = item5.getAcquiremode();
                        String acqsource = item5.getSourceoffunds();
                        String ccode5 = caseNo;

                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile5 = assetid + "," + assettype + "," + marketval + "," + acqdate + ","
                                + acqcost + "," + acqmode + "," + acqsource + "," + ccode5;
//            write to csv file
                        //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                        //    filepath3 = classp2;
//
//try
//	{
                        FileWriter writer = new FileWriter(filepath8, true);
//
                        FileWriter writer2 = new FileWriter(fp6, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((id5 == 0) && (marker == 0)) {
                            String tfhdr = "assetcode" + "," + "assettype" + ","
                                    + "marketvalue" + "," + "acquiredate" + ","
                                    + "acquirecost" + "," + "acquiremode" + "," + "sourceoffunds"
                                    + "," + "casecode";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile5);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile5);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //
//                   File x = new File(filepath3);
//               File y = new File(classp2);
//                //
//               copyFileUsingStream(x,y);
                        //
                        // Esper call
//                 cepConfig.addEventType("Transferbean", javabeans.Transferbean.class.getName());
//        cepStatement.addListener(new CEPListener());
//                Transferbean transferbean = new Transferbean(trid, ccode3, tfdt, tramount, froAcct, toAcct, frobnk, tobnk);
//                cepRT.sendEvent(transferbean);
//               
//	}
//	catch(IOException e)
//	{
//	     e.printStackTrace();
//	} 
//                Configuration cepConfig3 = new Configuration();
//                cepConfig3.addEventType("Transferbean", Transactionbean.class.getName());
//                EPServiceProvider cep3 = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig3);
//                EPRuntime cepRT3 = cep3.getEPRuntime();
//                //
//
//                //
//                EPAdministrator cepAdm3 = cep3.getEPAdministrator();
//                // split
//                EPStatement cepStatement3 = cepAdm3.createEPL("select * from "
//                        + "Transferbean().win:length(2)");
//
//                //    CEPListener listener = new CEPListener();
//                cepStatement3.addListener(new CEPListener());
//                Transferbean transferbean = new Transferbean(trid, ccode3, tfdt, tramount, froAcct, toAcct, frobnk, tobnk);
//                cepRT3.sendEvent(transferbean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }


                // Income file
                List<Income> itemList6 = emf.createEntityManager().
                        createNamedQuery("Income.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt6 = itemList6.size();
                int cnttt6 = cnt6 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id6 = 0; id6 <= cnttt6; id6++) {
                    try {
                        Income item6 = itemList6.get(id6);

                        // Phone fields
                        int itemno = item6.getItemno();
                        String incdesc = item6.getDescription();
                        String inctype = item6.getIncometype();
                        String incfreq = item6.getFrequency();
                        int incamt = item6.getAmount();
                        String ccode6 = caseNo;

                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile6 = itemno + "," + incdesc + "," + inctype + "," + incfreq + ","
                                + incamt + "," + ccode6;
//            write to csv file
                        //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                        //    filepath3 = classp2;
//
//try
//	{
                        FileWriter writer = new FileWriter(filepath7, true);
//
                        FileWriter writer2 = new FileWriter(fp5, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((id6 == 0) && (marker == 0)) {
                            String tfhdr = "itemno" + "," + "description" + ","
                                    + "incometype" + "," + "frequency" + ","
                                    + "amount" + "," + "casecode";
                            writer.append(tfhdr);
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile6);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile6);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }

//                //
                List<Budget> itemList7 = emf.createEntityManager().
                        createNamedQuery("Budget.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt7 = itemList7.size();
                int cnttt7 = cnt7 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id7 = 0; id7 <= cnttt7; id7++) {
                    try {
                        Budget item7 = itemList7.get(id7);

                        //  fields
                        String entid = item7.getEntityNo().getCode();
                        String period2 = item7.getYearPeriod();
                        int amount = item7.getAmount();
                        String source = item7.getSource().toString();
                        String accno = item7.getAccountNo();
                        String ccode7 = caseNo;

                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile7 = entid + "," + period2 + "," + amount + "," + source + ","
                                + accno + "," + ccode7;
//            write to csv file
                        //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                        //    filepath3 = classp2;
//
//try
//	{
                        FileWriter writer = new FileWriter(filepath6, true);
//
                        FileWriter writer2 = new FileWriter(fp4, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((id7 == 0) && (marker == 0)) {
                            String tfhdr = "Entity" + "," + "Period" + ","
                                    + "amount" + "," + "source" + ","
                                    + "accno" + "," + "casecode";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile7);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile7);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //
                        // Generate Accounts











                        // End Accounts

                        //write parameter text file
                        String fparam = bgamt + "," + pamt + "," + inamt + "," + assetval + ","
                                + tfamt;
//            write to csv file
                        String parampath = "c:\\kriminofiles\\params.txt";
                        //    filepath3 = classp2;
//
                        String fsymbol = transymb + "," + tfsymb + "," + incsymb + "," + assetsymb + "," + caseNo;
//            write to csv file
                        String sympath = "c:\\kriminofiles\\symbols.txt";
                        //    filepath3 = classp2;
//try
//	{
                        FileWriter writerp;
                        try {
                            writerp = new FileWriter(parampath, true);

                            writerp.append(fparam);
                            writerp.append('\n');



                            //generate whatever data you want

                            writerp.flush();
                            writerp.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        //
                        FileWriter writers;
                        try {
                            writers = new FileWriter(sympath, true);

                            writers.append(fsymbol);
                            writers.append('\n');



                            //generate whatever data you want

                            writers.flush();
                            writers.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // idx++;
                }
// Account

                List<Accounts> itemList8 = emf.createEntityManager().createNamedQuery("Accounts.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt8 = itemList8.size();
                int cnttt8 = cnt8 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id8 = 0; id8 <= cnttt8; id8++) {
                    try {
                        Accounts item8 = itemList8.get(id8);

                        //  fields
                        String Acct = item8.getNo();
                        String Ent = item8.getEntityID().getCode();
                        String Accname = item8.getAccountName();
                        String status = item8.getStatus();
                        int limit = item8.getLimitAmt();
                        String ccode8 = caseNo;

                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile8 = Acct + "," + Ent + "," + Accname + "," + status + ","
                                + limit + "," + ccode8;
//            write to csv file
                        //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                        //    filepath3 = classp2;
//
//try
//	{
                        FileWriter writer = new FileWriter(filepath11, true);
//
                        FileWriter writer2 = new FileWriter(fp11, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        if ((id8 == 0) && (marker == 0)) {
                            String tfhdr = "Acct" + "," + "Ent" + ","
                                    + "Accname" + "," + "status" + ","
                                    + "limit" + "," + "ccode8";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile8);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile7);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }






                //
// contracts

                List<Contracts> itemList9 = emf.createEntityManager().createNamedQuery("Contracts.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt9 = itemList9.size();
                int cnttt9 = cnt9 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id9 = 0; id9 <= cnttt9; id9++) {
                    try {
                        Contracts item9 = itemList9.get(id9);

                        //  fields
                        String contractid = item9.getContractID();
                        String workplanid = item9.getWorkPlanID().getDescription();
                        String contractacct = item9.getContractAcct();
                        int contractamt = item9.getContractAmt();
                        String contractor = item9.getContractor();
                        String ccode9 = caseNo;

                        //
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile9 = contractid + "," + workplanid + "," + contractacct + "," + contractamt + ","
                                + contractor + "," + ccode9;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath12, true);
//
                        FileWriter writer2 = new FileWriter(fp12, true);

                        if ((id9 == 0) && (marker == 0)) {
                            String tfhdr = "contractid" + "," + "workplanid" + ","
                                    + "contractacct" + "," + "contractamt" + ","
                                    + "contractor" + "," + "ccode9";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile9);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile9);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }

                // emails

                List<Emails> itemList10 = emf.createEntityManager().createNamedQuery("Emails.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt10 = itemList10.size();
                int cnttt10 = cnt10 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id10 = 0; id10 <= cnttt10; id10++) {
                    try {
                        Emails item10 = itemList10.get(id10);

                        //  fields
                        int Emailid = item10.getEmailID();
                        String Emaildate = item10.getEdate().toString();
                        String sourceadd = item10.getSourceAddr();
                        String destadd = item10.getDestAddr();
                        String requestId = item10.getReqidd().getFilenme();
                        String ccode10 = item10.getCasecode().getCaseCode();

                        //

                        // create csv file from entity/database
                        cfile10 = Emailid + "," + Emaildate + "," + sourceadd + "," + destadd + ","
                                + requestId + "," + ccode10;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath13, true);
//
                        FileWriter writer2 = new FileWriter(fp13, true);

                        if ((id10 == 0) && (marker == 0)) {
                            String tfhdr = "Emailid" + "," + "Emaildate" + ","
                                    + "sourceadd" + "," + "destadd" + ","
                                    + "requestId" + "," + "ccode10";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile10);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile10);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }

                // Requests
                List<Request> itemList11 = emf.createEntityManager().createNamedQuery("Request.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt11 = itemList11.size();
                int cnttt11 = cnt11 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id11 = 0; id11 <= cnttt11; id11++) {
                    try {
                        Request item11 = itemList11.get(id11);

                        //  fields
                        String filename = item11.getFilenme();
                        String dbAcct = item11.getDebitaccount();
                        String cracct = item11.getCreditaccount();
                        String reqdate = item11.getReqDate().toString();
                        String userid = item11.getUserId().getUserID();
                        String wrkid = item11.getWorkplnId().getWorkPlanCode();
                        String ccode11 = item11.getCasecode().getCaseCode();
                        String Entcode = item11.getEntcode().getDescription();
                        String userlevel = item11.getUserId().getStaffLevel();
                        //

                        // create csv file from entity/database
                        cfile11 = filename + "," + dbAcct + "," + cracct + "," + reqdate + ","
                                + userid + "," + userlevel + "," + wrkid + "," + ccode11 + "," + Entcode;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath14, true);
//
                        FileWriter writer2 = new FileWriter(fp14, true);

                        if ((id11 == 0) && (marker == 0)) {
                            String tfhdr = "filename" + "," + "dbacct" + ","
                                    + "cracct" + "," + "reqdate" + ","
                                    + "userid" + "," + "userlevel" + "," + "wrkid" + "," + "ccode11" + "," + "entcode";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile11);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile11);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }


// Tasks
                List<Tasks> itemList12 = emf.createEntityManager().createNamedQuery("Tasks.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt12 = itemList12.size();
                int cnttt12 = cnt12 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id12 = 0; id12 <= cnttt12; id12++) {
                    try {
                        Tasks item12 = itemList12.get(id12);

                        //  fields
                        String Taskcode = item12.getTaskCode();
                        String Taskname = item12.getTaskName();
                        String Status = item12.getStatus();
                        String ccode12 = item12.getCasecode().getCaseCode();
                        String Contractcode = item12.getContractcode();

                        //

                        // create csv file from entity/database
                        cfile12 = Taskcode + "," + Taskname + "," + Status + "," + ccode12 + ","
                                + Contractcode;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath15, true);
//
                        FileWriter writer2 = new FileWriter(fp15, true);

                        if ((id12 == 0) && (marker == 0)) {
                            String tfhdr = "Taskcode" + "," + "Taskname" + ","
                                    + "Status" + "," + "ccode12" + ","
                                    + "Contractcode";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile12);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile12);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }

// 
                List<Workplan> itemList13 = emf.createEntityManager().createNamedQuery("Workplan.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt13 = itemList13.size();
                int cnttt13 = cnt13 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id13 = 0; id13 <= cnttt13; id13++) {
                    try {
                        Workplan item13 = itemList13.get(id13);

                        //  fields
                        String Workplancode = item13.getWorkPlanCode();
                        int Amount = item13.getAmount();
                        String ccode13 = item13.getCasecode().getCaseCode();
                        String Desc = item13.getDescription();
                        String sdate = item13.getStartDate().toString();
                        String edate = item13.getEndDate().toString();
                        String Entcd = item13.getEntitycd().getCode();

                        //

                        // create csv file from entity/database
                        cfile13 = Workplancode + "," + Amount + "," + ccode13 + "," + Desc + ","
                                + sdate + "," + edate + "," + Entcd;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath16, true);
//
                        FileWriter writer2 = new FileWriter(fp16, true);

                        if ((id13 == 0) && (marker == 0)) {
                            String tfhdr = "Workplancode" + "," + "Amount" + ","
                                    + "ccode13" + "," + "Desc" + ","
                                    + "sdate" + ","
                                    + "edate" + "," + "Entcd";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile13);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile13);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }
                //

                List<Userrights> itemList14 = emf.createEntityManager().createNamedQuery("Userrights.findByCasecode").setParameter("caseCode", caseNo).getResultList();
                //Iterator i = itemList.iterator();
                // count records
                int cnt14 = itemList14.size();
                int cnttt14 = cnt14 - 1;
                // int idx=0;

                //   while (i.hasNext()) {
                //for loop here
                for (int id14 = 0; id14 <= cnttt14; id14++) {
                    try {
                        Userrights item14 = itemList14.get(id14);

                        //  fields
                        String userid = item14.getUserID();
                        String dtcrt = item14.getDateCreated();
                        String auth = item14.getUserAuthority();
                        String level = item14.getStaffLevel();
                        String crt = item14.getCreater();


                        //

                        // create csv file from entity/database
                        cfile14 = userid + "," + dtcrt + "," + auth + "," + level + ","
                                + crt;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath17, true);
//
                        FileWriter writer2 = new FileWriter(fp17, true);

                        if ((id14 == 0) && (marker == 0)) {
                            String tfhdr = "userid" + "," + "dtcrt" + ","
                                    + "auth" + "," + "level" + ","
                                    + "crt";
                            writer.append(tfhdr);
                            //
                            writer2.append(tfhdr);
                        }
                        writer.append('\n');
                        writer.append(cfile14);
                        writer.append('\n');

                        writer.flush();
                        writer.close();
                        //
                        writer2.append('\n');
                        writer2.append(cfile14);
                        writer2.append('\n');

                        writer2.flush();
                        writer2.close();
                        //

                    } catch (Exception ex) {

                        ex.printStackTrace();

                    }
                }
                //
// 
                // Read Incoming Events
                try {
                    // Phone Calls

                    fileReader = new FileReader(classp);

                    bufferedReader = new BufferedReader(fileReader);
                    String views = "\n";
                    String view1;
                    //
                    //int i = 0, cnt = 1;
                    while ((view1 = bufferedReader.readLine()) != null) {

                        views = views + "" + view1 + eol;

                    }
                    vf = views;

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    // Transaction 

                    fileReader = new FileReader(classp1);

                    bufferedReader = new BufferedReader(fileReader);
                    String views2 = "\n";
                    String view2;
                    //
                    //int i = 0, cnt = 1;
                    while ((view2 = bufferedReader.readLine()) != null) {

                        views2 = views2 + "" + view2;
                        System.out.println();
                        vf1 = views2;
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    // Transfers 

                    fileReader = new FileReader(classp2);

                    bufferedReader = new BufferedReader(fileReader);
                    String views3 = "\n";
                    String view3;
                    //
                    //int i = 0, cnt = 1;
                    while ((view3 = bufferedReader.readLine()) != null) {

                        views3 = views3 + "" + view3;
                        System.out.println();
                        vf2 = views3;
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    // BOU

                    fileReader = new FileReader(classp3);

                    bufferedReader = new BufferedReader(fileReader);
                    String views4 = "\n";
                    String view4;
                    //
                    //int i = 0, cnt = 1;
                    while ((view4 = bufferedReader.readLine()) != null) {

                        views4 = views4 + "" + view4;
                        System.out.println();
                        vf3 = views4;
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    // Income

                    fileReader = new FileReader(classp5);

                    bufferedReader = new BufferedReader(fileReader);
                    String views5 = "\n";
                    String view5;
                    //
                    //int i = 0, cnt = 1;
                    while ((view5 = bufferedReader.readLine()) != null) {

                        views5 = views5 + "" + view5;
                        System.out.println();
                        vf4 = views5;
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    // Assets

                    fileReader = new FileReader(classp6);

                    bufferedReader = new BufferedReader(fileReader);
                    String views6 = "\n";
                    String view6;
                    //
                    //int i = 0, cnt = 1;
                    while ((view6 = bufferedReader.readLine()) != null) {

                        views6 = views6 + "" + view6;
                        System.out.println();
                        vf5 = views6;
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
// PROCESS IN ENGINE


                //
                try {

                    Configuration config = new Configuration();
                    config.addEventTypeAutoName("esper.example");

                    /*
                     * declare event type map
                     */
                    // Event 1 - Phonelogs
                    Map typeMap = new HashMap();
                    typeMap.put("callid", String.class);
                    typeMap.put("ccode1", String.class);
                    typeMap.put("calldate", String.class);
                    typeMap.put("frono", String.class);
                    typeMap.put("tono", String.class);
                    typeMap.put("reqid", String.class);
                    config.addEventType("Phonelogbean", typeMap);
// Event 2 - Transactions
                    Map typeMap2 = new HashMap();
                    typeMap2.put("tranid", Integer.class);
                    typeMap2.put("ccode2", String.class);
                    typeMap2.put("transdate", String.class);
                    typeMap2.put("transamount", Integer.class);
                    typeMap2.put("transcode", String.class);
                    typeMap2.put("transtype", String.class);
                    typeMap2.put("transaccount", String.class);
                    config.addEventType("Transactionbean", typeMap2);

// Event 3 - cash Transfers to suppliers/staff
                    Map typeMap3 = new HashMap();
                    typeMap3.put("tfid", Integer.class);
                    typeMap3.put("ccode3", String.class);
                    typeMap3.put("tdate", String.class);
                    typeMap3.put("tamount", Integer.class);
                    typeMap3.put("tfroacct", String.class);
                    typeMap3.put("ttoacct", String.class);
                    typeMap3.put("frobank", String.class);
                    typeMap3.put("ttobank", String.class);
                    typeMap3.put("wkplanid", String.class);
                    typeMap3.put("contrid", Integer.class);
                    typeMap3.put("Taskid", String.class);
                    //
                    config.addEventType("Transferbean", typeMap3);
                    //
                    // Event 4 - Assets 
                    Map typeMap4 = new HashMap();
                    typeMap4.put("assetcode", String.class);
                    typeMap4.put("assettype", String.class);
                    typeMap4.put("marketvalue", String.class);
                    typeMap4.put("acquiredate", String.class);
                    typeMap4.put("acquirecost", String.class);
                    typeMap4.put("acquiremode", String.class);
                    typeMap4.put("sourceoffunds", String.class);
                    typeMap4.put("casecode", String.class);
                    //
                    config.addEventType("Assetsbean", typeMap4);
                    // Event 5 - BOU transfers event
                    Map typeMap5 = new HashMap();
                    typeMap5.put("idbou", Integer.class);
                    typeMap5.put("bdate", String.class);
                    typeMap5.put("transfertype", String.class);
                    typeMap5.put("debitacctno", String.class);
                    typeMap5.put("debitacctname", String.class);
                    typeMap5.put("debitamount", Integer.class);
                    typeMap5.put("creditbank", String.class);
                    typeMap5.put("creditacct", String.class);
                    typeMap5.put("bankstaffid", String.class);
                    typeMap5.put("govtstaffid", String.class);
                    typeMap5.put("casecode", String.class);
                    typeMap5.put("budgetamt", Integer.class);
                    typeMap5.put("status", String.class);
                    typeMap5.put("limit2", String.class);
                    //
                    //
                    config.addEventType("Boubean", typeMap5);
                    //
                    // Event 6 - Income event
                    Map typeMap6 = new HashMap();
                    typeMap6.put("itemno", Integer.class);
                    typeMap6.put("description", String.class);
                    typeMap6.put("incometype", String.class);
                    typeMap6.put("frequency", String.class);
                    typeMap6.put("amount", Integer.class);
                    typeMap6.put("casecode", String.class);

                    //
                    //
                    config.addEventType("Incomebean", typeMap6);
                    // Event 7 - Request event
                    Map typeMap7 = new HashMap();
                    typeMap7.put("filename", String.class);
                    typeMap7.put("dbacct", String.class);
                    typeMap7.put("cracct", String.class);
                    typeMap7.put("reqdate", String.class);
                    typeMap7.put("userid", String.class);
                    typeMap7.put("userlevel", String.class);
                    typeMap7.put("wrkid", String.class);
                    typeMap7.put("ccode11", String.class);
                    typeMap7.put("entcode", String.class);


                    //
                    //
                    config.addEventType("Requestbean", typeMap7);
                    // Event 8 - Workplan event
                    Map typeMap8 = new HashMap();
                    typeMap8.put("Workplancode", String.class);
                    typeMap8.put("Amount", Integer.class);
                    typeMap8.put("ccode13", String.class);
                    typeMap8.put("Desc", String.class);
                    typeMap8.put("sdate", String.class);
                    typeMap8.put("edate", String.class);



                    //
                    //
                    config.addEventType("Workplanbean", typeMap8);
                    // Event 9 - Contract event
                    Map typeMap9 = new HashMap();
                    typeMap9.put("contractid", String.class);
                    typeMap9.put("workplanid", String.class);
                    typeMap9.put("contractacct", String.class);
                    typeMap9.put("contractamt", Integer.class);
                    typeMap9.put("contractor", String.class);
                    typeMap9.put("ccode9", String.class);

                    //
                    //
                    config.addEventType("Contractbean", typeMap9);
                    //
                    // Event 10 - Activity event
                    Map typeMap10 = new HashMap();
                    typeMap10.put("Taskcode", String.class);
                    typeMap10.put("Taskname", String.class);
                    typeMap10.put("Status", String.class);
                    typeMap10.put("ccode12", String.class);
                    typeMap10.put("Contractcode", String.class);

                    //
                    //
                    config.addEventType("Activitybean", typeMap10);
                    //
                    // Event 11 - Email event
                    Map typeMap11 = new HashMap();
                    typeMap11.put("Emailid", Integer.class);
                    typeMap11.put("Emaildate", String.class);
                    typeMap11.put("sourceadd", String.class);
                    typeMap11.put("destadd", String.class);
                    typeMap11.put("requestId", String.class);
                    typeMap11.put("ccode10", String.class);

                    //
                    //
                    config.addEventType("Emailbean", typeMap11);
                    // Event 11 - Email event
                    Map typeMap12 = new HashMap();
                    typeMap12.put("Entity", String.class);
                    typeMap12.put("Period", String.class);
                    typeMap12.put("amount", Integer.class);
                    typeMap12.put("source", String.class);
                    typeMap12.put("accno", String.class);
                    typeMap12.put("casecode", String.class);

                    //
                    //
                    config.addEventType("Budgetbean", typeMap12);
                    //
                    EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
                    //   String expression1 = " select * Phonelogbean.win:time(30 sec)";
// Read comparison values from path

                    // Get symbols file
                    try {
                        //  File fs = new File("c:\\kriminofiles\\symbols.txt");
                        //  fs.delete();
                        //

                        //

                        //
                        FileReader fileReaders = new FileReader(fspath);

                        BufferedReader bufferedReaders = new BufferedReader(fileReaders);
                        ArrayList<String> liness = new ArrayList<String>();
                        String linesym;
                        //

                        //
                        // int i = 0, cnt = 1;
                        while ((linesym = bufferedReaders.readLine()) != null) {

                            liness.add(linesym);
                            // assign text 

                            String resss = "[,]";

                            String resp = liness.get(0);
                            // split csv file

                            String[] csvs = resp.split(resss);
                            //
                            transymb = csvs[0];
                            tfsymb = csvs[1];
                            incsymb = csvs[2];
                            assetsymb = csvs[3];
                            casefile = csvs[4];

                        }
                        // close file stream
                        bufferedReaders.close();





                    } catch (Exception e) {
                        e.getStackTrace();

                    }


                    if (transymb.startsWith("Equal")) {
                        transymb2 = "=";

                    } else if (transymb.startsWith("Less")) {
                        transymb2 = "<";

                    } else {
                        transymb2 = ">";
//
                    }
                    //     
                    if (assetsymb.startsWith("Equal")) {
                        assetsymb2 = "=";

                    } else if (assetsymb.startsWith("Less")) {
                        assetsymb2 = "<";

                    } else {
                        assetsymb2 = ">";

                    }
                    //
                    if (incsymb.startsWith("Equal")) {
                        incsymb2 = "=";

                    } else if (incsymb.startsWith("Less")) {
                        incsymb2 = "<";

                    } else {
                        incsymb2 = ">";

                    }


// Personal/company Account Transactions
                    String expression1 = "select b.transdate,b.transtype,"
                            + "b.transamount,"
                            + "b.transaccount from pattern "
                            + " [every (b=Transactionbean(b.transamount" + transymb2 + pamt + ")"
                            + "and b=Transactionbean(b.transtype='CR') "
                            + ")]";
                    // BOU Electronic Transfer Details
                    String expression2 = "select "
                            + "a.bdate,a.transfertype,"
                            + "a.debitacctno,a.debitamount,"
                            + "a.creditbank,a.creditacct,a.govtstaffid,a.status,a.limit2 from pattern"
                            + " [every (a=Boubean(a.debitamount>" + bgamt + ")"
                            + " "
                            + ")]";

                    //
                    // Personal/Company Account Transfer Details
                    String expression3 = "select "
                            + "c.tdate,c.tamount,"
                            + "c.tfroacct,"
                            + "c.ttoacct,c.wkplanid,c.contrid,c.Taskid from pattern"
                            + " [every (c=Transferbean(c.tamount>" + tfamt + ")"
                            + " "
                            + ")]";
                    //
                    // Personal Income Details
                    String expression4 = "select "
                            + "d.description,d.incometype,"
                            + "d.frequency,d.amount,"
                            + "d.amount as NetIncome from pattern"
                            + " [every (d=Incomebean(d.amount>" + inamt + ")"
                            + " "
                            + ")]";
                    //
                    // Personal Assets Details
                    String expression5 = "select "
                            + "e.assettype,e.marketvalue,"
                            + "e.acquiredate,e.acquirecost,"
                            + "e.sourceoffunds from pattern"
                            + " [every (e=Assetsbean"
                            + " "
                            + ")]";
                    //
                    // Phone call Details
                    String expression6 = "select "
                            + "f.calldate,f.frono,"
                            + "f.tono from pattern"
                            + " [every (f=Phonelogbean "
                            + " "
                            + ")]";
                    // Request Details
                    String expression7 = "select "
                            + "g.filename,g.dbacct,"
                            + "g.cracct,g.reqdate,"
                            + "g.userid,g.userlevel,g.wrkid,g.entcode"
                            + " from pattern"
                            + " [every (g=Requestbean(g.userlevel != 'senior-level' ) "
                            + " "
                            + ")]";
                    // Workplan Details
                    String expression8 = "select t.Workplancode,t.Amount "
                            + " from pattern"
                            + " [every(t=Workplanbean)]";
                    // Contract Details
                    String expression9 = "select "
                            + "i.contractid,i.workplanid,i.contractacct,i.contractamt,"
                            + "i.contractor,i.ccode9"
                            + ""
                            + " from pattern"
                            + " [every (i=Contractbean "
                            + " "
                            + ")]";
                    //
                    // Activity Details
                    String expression10 = "select "
                            + "j.Taskcode,j.Taskname,"
                            + "j.Status,j.ccode12,"
                            + "j.Contractcode"
                            + " from pattern"
                            + " [every (j=Activitybean "
                            + " "
                            + ")]";
                    // emails
                    String expression11 = "select "
                            + "k.Emailid,k.Emaildate,"
                            + "k.sourceadd,k.destadd,"
                            + "k.requestId,k.ccode10"
                            + " from pattern"
                            + " [every (k=Emailbean "
                            + " "
                            + ")]";
                    //

                    // emails
                    String expression12 = "select "
                            + "o.Entity,o.Period,"
                            + "o.amount,o.source,"
                            + "o.accno,o.casecode"
                            + " from pattern"
                            + " [every (o=Budgetbean "
                            + " "
                            + ")]";
                    //
                    // Expressions
                    String exp = expression1;
                    String exp2 = expression2;
                    String exp3 = expression3;
                    String exp4 = expression4;
                    String exp5 = expression5;
                    String exp6 = expression6;
                    String exp7 = expression7;
                    String exp8 = expression8;
                    String exp9 = expression9;
                    String exp10 = expression10;
                    String exp11 = expression11;
                    String exp12 = expression12;

                    // statements

                    EPStatement statement = epService.getEPAdministrator().createEPL(exp);
                    EPStatement statement2 = epService.getEPAdministrator().createEPL(exp2);
                    EPStatement statement3 = epService.getEPAdministrator().createEPL(exp3);
                    EPStatement statement4 = epService.getEPAdministrator().createEPL(exp4);
                    EPStatement statement5 = epService.getEPAdministrator().createEPL(exp5);
                    EPStatement statement6 = epService.getEPAdministrator().createEPL(exp6);
                    EPStatement statement7 = epService.getEPAdministrator().createEPL(exp7);
                    EPStatement statement8 = epService.getEPAdministrator().createEPL(exp8);
                    EPStatement statement9 = epService.getEPAdministrator().createEPL(exp9);
                    EPStatement statement10 = epService.getEPAdministrator().createEPL(exp10);
                    EPStatement statement11 = epService.getEPAdministrator().createEPL(exp11);
                    EPStatement statement12 = epService.getEPAdministrator().createEPL(exp12);
// New Listeners
                    CEPListener listener = new CEPListener();
                    CEPListener2 listener2 = new CEPListener2();
                    CEPListener3 listener3 = new CEPListener3();
                    CEPListener4 listener4 = new CEPListener4();
                    CEPListener5 listener5 = new CEPListener5();
                    CEPListener6 listener6 = new CEPListener6();
                    CEPListener7 listener7 = new CEPListener7();
                    CEPListener8 listener8 = new CEPListener8();
                    CEPListener9 listener9 = new CEPListener9();
                    CEPListener10 listener10 = new CEPListener10();
                    CEPListener11 listener11 = new CEPListener11();
                    CEPListener12 listener12 = new CEPListener12();
                    //
                    // Add Listeners
                    statement.addListener(listener);
                    statement2.addListener(listener2);
                    statement3.addListener(listener3);
                    statement4.addListener(listener4);
                    statement5.addListener(listener5);
                    statement6.addListener(listener6);
                    statement7.addListener(listener7);
                    statement8.addListener(listener8);
                    statement9.addListener(listener9);
                    statement10.addListener(listener10);
                    statement11.addListener(listener11);
                    statement12.addListener(listener12);

                    /*
                     * publish events from csv file
                     */
                    AdapterInputSource adapterInputSource1 = new AdapterInputSource("/javabeans/phonelogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource1, "Phonelogbean")).start();
                    //
                    CSVInputAdapterSpec inputOne = new CSVInputAdapterSpec(adapterInputSource1, "Phonelogbean");
//            inputOne.setTimestampColumn("timestamp1");
//
                    AdapterInputSource adapterInputSource2 = new AdapterInputSource("/javabeans/transactionlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource2, "Transactionbean")).start();
//            //
                    CSVInputAdapterSpec inputTwo = new CSVInputAdapterSpec(adapterInputSource2, "Transactionbean");
//            inputTwo.setTimestampColumn("timestamp2");
////
//            //
                    AdapterInputSource adapterInputSource3 = new AdapterInputSource("/javabeans/transferlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource3, "Transferbean")).start();
//
                    CSVInputAdapterSpec inputThree = new CSVInputAdapterSpec(adapterInputSource3, "Transferbean");
//            inputThree.setTimestampColumn("timestamp3");
//////
//            //
                    AdapterInputSource adapterInputSource4 = new AdapterInputSource("/javabeans/assetlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource4, "Assetsbean")).start();
//            //
                    CSVInputAdapterSpec inputfour = new CSVInputAdapterSpec(adapterInputSource4, "Assetsbean");
//            inputfour.setTimestampColumn("timestamp4");
//            //
                    AdapterInputSource adapterInputSource5 = new AdapterInputSource("/javabeans/boulogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource5, "Boubean")).start();
//            //
                    CSVInputAdapterSpec inputfive = new CSVInputAdapterSpec(adapterInputSource5, "Boubean");
//            inputfive.setTimestampColumn("timestamp5");
//            //
                    AdapterInputSource adapterInputSource6 = new AdapterInputSource("/javabeans/incomelogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource6, "Incomebean")).start();
//            //
                    CSVInputAdapterSpec inputsix = new CSVInputAdapterSpec(adapterInputSource6, "Incomebean");
//            inputsix.setTimestampColumn("timestamp6");
                    // Added
                    AdapterInputSource adapterInputSource7 = new AdapterInputSource("/javabeans/Requestlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource7, "Requestbean")).start();
//            //
                    CSVInputAdapterSpec inputseven = new CSVInputAdapterSpec(adapterInputSource7, "Requestbean");
//            inputseven.setTimestampColumn("timestamp7");
                    //
                    AdapterInputSource adapterInputSource8 = new AdapterInputSource("/javabeans/Workplanlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource8, "Workplanbean")).start();
//            //
                    CSVInputAdapterSpec inputeight = new CSVInputAdapterSpec(adapterInputSource8, "Workplanbean");
//            inputeight.setTimestampColumn("timestamp8");
                    //
                    AdapterInputSource adapterInputSource9 = new AdapterInputSource("/javabeans/contractlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource9, "Contractbean")).start();
//            //
                    CSVInputAdapterSpec inputnine = new CSVInputAdapterSpec(adapterInputSource9, "Contractbean");
//            inputnine.setTimestampColumn("timestamp9");
                    //
                    AdapterInputSource adapterInputSource10 = new AdapterInputSource("/javabeans/Tasklogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource10, "Activitybean")).start();
//            //
                    CSVInputAdapterSpec inputten = new CSVInputAdapterSpec(adapterInputSource10, "Activitybean");
//            inputten.setTimestampColumn("timestamp10");
                    //
                    AdapterInputSource adapterInputSource11 = new AdapterInputSource("/javabeans/Emaillogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource11, "Emailbean")).start();
//            //
                    CSVInputAdapterSpec inputeleven = new CSVInputAdapterSpec(adapterInputSource11, "Emailbean");
//            inputeleven.setTimestampColumn("timestamp11");
                    //
                    AdapterInputSource adapterInputSource12 = new AdapterInputSource("/javabeans/budgetlogs.csv");
                    (new CSVInputAdapter(epService, adapterInputSource12, "Budgetbean")).start();
//            //
                    CSVInputAdapterSpec inputtwelve = new CSVInputAdapterSpec(adapterInputSource11, "Budgetbean");
//            inputtwelve.setTimestampColumn("timestamp12");
                    //
                    //

                    //
                    AdapterCoordinator coordinator = new AdapterCoordinatorImpl(epService, true);
                    coordinator.coordinate(new CSVInputAdapter(inputOne));
                    coordinator.coordinate(new CSVInputAdapter(inputTwo));
                    coordinator.coordinate(new CSVInputAdapter(inputThree));
                    coordinator.coordinate(new CSVInputAdapter(inputfour));
                    coordinator.coordinate(new CSVInputAdapter(inputfive));
                    coordinator.coordinate(new CSVInputAdapter(inputsix));
                    coordinator.coordinate(new CSVInputAdapter(inputseven));
                    coordinator.coordinate(new CSVInputAdapter(inputeight));
                    coordinator.coordinate(new CSVInputAdapter(inputnine));
                    coordinator.coordinate(new CSVInputAdapter(inputten));
                    coordinator.coordinate(new CSVInputAdapter(inputeleven));
                    coordinator.coordinate(new CSVInputAdapter(inputtwelve));
                    coordinator.start();
//

                } catch (Exception e2) {
                    e2.printStackTrace();
                }





//         CREATE  OUTPUT
//         Get records from report file

                try {


                    String fpath1 = "c:\\kriminofiles\\report.txt";
                    //

                    //
                    fileReader = new FileReader(fpath1);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines1 = new ArrayList<String>();
                    String line;
                    //
                    //

                    pats = new ArrayList<String>();
                    //
                    int i = 0, tranamt = 0, cnt1 = 1;
                    while ((line = bufferedReader.readLine()) != null) {


                        if (!lines1.contains(line)) {
                            lines1.add(line);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line.substring(1, line.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String acctno = csv[0];
                            String[] acctno2 = acctno.split(ress);
                            String acct = acctno2[1];
                            //
                            String tramt = csv[1];
                            String[] tramt2 = tramt.split(ress);
                            tranamt = Integer.parseInt(tramt2[1]);
//               
                            //
                            String trandt = csv[2];
                            String[] td2 = trandt.split(ress);
                            String tdt = td2[1];
                            //
                            String trt = csv[3];
                            String[] trt2 = trt.split(ress);
                            String ttyp = trt2[1];
                            //

                            // add to table list
                            pats.add(acct + "|" + tranamt + "|" + tdt + "|" + ttyp + "|");

                            tpats = "Transactions Event" + "(" + "|" + "AccountNo" + " |" + "Amount" + " |" + "Date" + " |" + "Type" + "|" + ")";

                            //
                            // }

//




                        }
                        i++;
                        cnt1++;
                    }





                    //
                    ct1 = pats.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }
// Read Report2
                // Get records from report file

                try {
                    String fpath2 = "c:\\kriminofiles\\report2.txt";
                    //

                    //
                    fileReader = new FileReader(fpath2);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines2 = new ArrayList<String>();
                    String line2;
                    //
                    //

                    pats2 = new ArrayList<String>();
                    //
//            int i = 0, cnt2 = 1;
                    while ((line2 = bufferedReader.readLine()) != null) {


                        if (!lines2.contains(line2)) {
                            lines2.add(line2);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line2.substring(1, line2.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String stat = csv[5];
                            String[] staff2 = stat.split(ress);
                            stat = staff2[1];
                            //
                            String damt = csv[4];
                            String[] da2 = damt.split(ress);
                            int debitamt = Integer.parseInt(da2[1]);
                            //
                            String lim = csv[1];
                            String[] dac2 = lim.split(ress);
                            lim = dac2[1];
                            //
                            String bdate = csv[3];
                            String[] bd2 = bdate.split(ress);
                            bdate = bd2[1];
                            //
                            String dacct = csv[2];
                            String[] tf2 = dacct.split(ress);
                            dacct = tf2[1];
                            //
                            String cacc = csv[7];
                            String[] ca2 = cacc.split(ress);
                            cacc = ca2[1];
                            //
                            String ttype = csv[6];
                            String[] crb2 = ttype.split(ress);
                            ttype = crb2[1];
                            //

//               tranamt += 1;
                            //


                            // add to table list
                            pats2.add(bdate + "|" + ttype + "|" + debitamt + "|" + dacct + "|" + cacc + "|" + lim + "|" + stat);
//                        pats.add(tranamt);
                           tpats2 = "BOU Transfers Event" + "(" + "Date" + "|" + "Transaction Type" + "|" + "Debit Amount" + "|" + "Debit Account" + "|" + "Credit Account" + "|" + "Limit Amount" + "|" + "Account Status" + ")";
                            //
                            // }



                            //

                        }
                        // i++;
                        // cnt2++;
                    }

                    ct2 = pats2.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }

// get report3
                try {
                    String fpath3 = "c:\\kriminofiles\\report3.txt";
                    //

                    //
                    fileReader = new FileReader(fpath3);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines3 = new ArrayList<String>();
                    String line3;
                    //
                    //

                    pats3 = new ArrayList<String>();
                    //
//            int i = 0, cnt3 = 1;
                    while ((line3 = bufferedReader.readLine()) != null) {


                        if (!lines3.contains(line3)) {
                            lines3.add(line3);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line3.substring(1, line3.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String facct = csv[0];
                            String[] fac2 = facct.split(ress);
                            String froacct = fac2[1];
                            //
                            String tstat = csv[1];
                            String[] tr3 = tstat.split(ress);
                            tstat = tr3[1];
                            //

                            String tamt = csv[2];
                            String[] tra = tamt.split(ress);
                            int tamt2 = Integer.parseInt(tra[1]);
                            //

                            String tacct = csv[3];
                            String[] tacct3 = tacct.split(ress);
                            String toacct = tacct3[1];
                            //
                            String trdt = csv[6];
                            String[] trdt3 = trdt.split(ress);
                            String trdate = trdt3[1];
                            //
                            String wplan = csv[4];
                            String[] fbnk3 = wplan.split(ress);
                            wplan = fbnk3[1];
                            //
                            String fbnk = csv[5];
                            String[] cam = fbnk.split(ress);
                            int camt = Integer.parseInt(cam[1]);
                            //

//               tranamt += 1;
                            //


                            // add to table list
                             pats3.add(froacct + " | "+ tamt2 + " | " + tstat + " | " + toacct + " | "
                                    + trdate + " | " + wplan + " | " + camt);
                            //
                       tpats3 = "Supplier Payments Event" + "(" + "Source Acct" + " | " + "Amount" + " | "
                                    + "Project Status" + " | " + "Destination Acct" + " | "
                                    + "Date" + " | " + "Workplan Code" + " | " + "Contract Amount" + ")";


                        }
//                i++;
                        cnt3++;
                    }

                    ct3 = pats3.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }

// get report4
                try {
                    String fpath4 = "c:\\kriminofiles\\report4.txt";
                    //

                    //
                    fileReader = new FileReader(fpath4);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines4 = new ArrayList<String>();
                    String line4;
                    //
                    //

                    pats4 = new ArrayList<String>();
                    //
                    int i = 0, cnt4 = 1;
                    while ((line4 = bufferedReader.readLine()) != null) {


                        if (!lines4.contains(line4)) {
                            lines4.add(line4);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line4.substring(1, line4.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String inct = csv[0];
                            String[] inct4 = inct.split(ress);
                            String incometype = inct4[1];
                            //
                            String incd = csv[1];
                            String[] incd4 = incd.split(ress);
                            String incdes = incd4[1];
                            //
                            String ninc = csv[2];
                            String[] ninc4 = ninc.split(ress);
                            int netinc = Integer.parseInt(ninc4[1]);
                            //
                            String incamt = csv[3];
                            String[] incamt4 = incamt.split(ress);
                            int incomeamt = Integer.parseInt(incamt4[1]);
                            //
                            String incfr = csv[4];
                            String[] incfr4 = incfr.split(ress);
                            String incfreq = incfr4[1];
                            //


                            //

//               tranamt += 1;
                            //


                            // add to table list
                            pats4.add(incometype + " | " + incdes + " | " + netinc + " | "
                                    + incomeamt + " | " + incfreq);
                            //
                               tpats4 = "Personal Income Event" + "(" + "Type" + " | " + "Description" + " | " + "Net Income"
                                    + " | " + "Income Amount" + " | " + "Frequency" + ")";



                        }
                        i++;
                        cnt4++;
                    }

                    ct4 = pats4.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }
// get report5
                try {
                    String fpath5 = "c:\\kriminofiles\\report5.txt";
                    //

                    //
                    fileReader = new FileReader(fpath5);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines5 = new ArrayList<String>();
                    String line5;
                    //
                    //

                    pats5 = new ArrayList<String>();
                    //
//            int i = 0, cnt5 = 1;
                    while ((line5 = bufferedReader.readLine()) != null) {


                        if (!lines5.contains(line5)) {
                            lines5.add(line5);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line5.substring(1, line5.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String asstyp = csv[0];
                            String[] asstyp5 = asstyp.split(ress);
                            String asstype = asstyp5[1];
                            //
                            String sof = csv[1];
                            String[] sof5 = sof.split(ress);
                            String sofunds = sof5[1];
                            //
                            String aqc = csv[2];
                            String[] aqc5 = aqc.split(ress);
                            int acqcost = Integer.parseInt(aqc5[1]);
                            //
                            String makval = csv[3];
                            String[] makval5 = makval.split(ress);
                            int makvalue = Integer.parseInt(makval5[1]);
                            //
                            String acdt = csv[4];
                            String[] acdt5 = acdt.split(ress);
                            String acdate = acdt5[1];
                            //


                            //

//               tranamt += 1;
                            //


                            // add to table list
                            pats5.add(asstype + " | " + sofunds + " | " + acqcost + " | " + makvalue
                                    + " | " + acdate);
//
                     tpats5 = "Type" + " | " + "Source" + " | " + "Cost" + " | "
                                    + "Market Value" + " | " + "Date Acquired";


                        }
//                i++;
                        cnt5++;
                    }

                    ct5 = pats5.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }

// get report6
                try {
                    String fpath6 = "c:\\kriminofiles\\report6.txt";
                    //

                    //
                    fileReader = new FileReader(fpath6);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines6 = new ArrayList<String>();
                    String line6;
                    //
                    //

                    pats6 = new ArrayList<String>();
                    //
//            int i = 0, cnt6 = 1;
                    while ((line6 = bufferedReader.readLine()) != null) {


                        if (!lines6.contains(line6)) {
                            lines6.add(line6);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line6.substring(1, line6.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String tno = csv[0];
                            String[] tno6 = tno.split(ress);
                            String tono = tno6[1];
                            //
                            String cdate = csv[1];
                            String[] cdate6 = cdate.split(ress);
                            String calldate = cdate6[1];
                            //
                            String fno = csv[2];
                            String[] fno6 = fno.split(ress);
                            String frono = fno6[1];


//               tranamt += 1;
                            //


                            // add to table list
                            pats6.add(tono + " | " + calldate + " | " + frono);
                            //
                           tpats6 = "Telephone Records Event" + "(" + "Dialled No" + " | " + "Date" + " | " + "Caller No" + ")";

                        }

//                i++;
                        cnt6++;
                    }
                    //   model2.addSeries(trans6);
                    ct6 = pats6.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }
                //
                // get report7
                try {
                    String fpath8 = "c:\\kriminofiles\\report7.txt";
                    //

                    //
                    fileReader = new FileReader(fpath8);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines8 = new ArrayList<String>();
                    String line8;
                    //
                    //

                    pats8 = new ArrayList<String>();
                    //
//            int i = 0, cnt8 = 1;
                    while ((line8 = bufferedReader.readLine()) != null) {


                        if (!lines8.contains(line8)) {
                            lines8.add(line8);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line8.substring(1, line8.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String fname = csv[0];
                            String[] fn7 = fname.split(ress);
                            fname = fn7[1];
                            //
                            String cracct = csv[1];
                            String[] c7 = cracct.split(ress);
                            cracct = c7[1];
                            //
                            String dbacct = csv[2];
                            String[] db7 = dbacct.split(ress);
                            dbacct = db7[1];

                            String wpid = csv[3];
                            String[] wp7 = wpid.split(ress);
                            wpid = wp7[1];
                            //
                            String userlev = csv[4];
                            String[] us7 = userlev.split(ress);
                            userlev = us7[1];
                            //
                            String reqdt = csv[5];
                            String[] rdt7 = reqdt.split(ress);
                            reqdt = rdt7[1];
                            //
                            String usr = csv[6];
                            String[] usr7 = usr.split(ress);
                            usr = usr7[1];
                            //
                            String ent = csv[7];
                            String[] ent7 = ent.split(ress);
                            ent = ent7[1];
//               tranamt += 1;
                            //


                            // add to table list
                            pats8.add(fname + " | " + cracct + " | " + dbacct + " | "
                                    + wpid + " | " + reqdt + " | " + usr + " | " + userlev
                                    + " | " + ent);
                            //
                        

                            tpats8 = "Funds Request Event" + "(" + "FileName" + " | " + "Credit Acct" + " | "
                                    + "Debit Acct" + " | "
                                    + "WorkPlan Code" + " | " + "Request Date" + " | "
                                    + "User" + " | " + "User Level"
                                    + " | " + "Ministry" + ")";

                        }

//                i++;
                        cnt8++;
                    }
                    //   model2.addSeries(trans6);
                    ct8 = pats8.size();
                    bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }

//
                // get report12
                try {
                    String fpath12 = "c:\\kriminofiles\\report12.txt";
                    //

                    //
                    fileReader = new FileReader(fpath12);

                    bufferedReader = new BufferedReader(fileReader);
                    ArrayList<String> lines12 = new ArrayList<String>();
                    String line12;
                    //
                    //

                    pats12 = new ArrayList<String>();
                    //
//            int i = 0, cnt12 = 1;
                    while ((line12 = bufferedReader.readLine()) != null) {


                        if (!lines12.contains(line12)) {
                            lines12.add(line12);
                            // assign text 
                            //  String res = "";
                            String ress = "[=]";
                            // int count1 = lines.size();

                            // for (int i = 0; i < count1; i++) {
                            // res = lines.get(i);
                            //    res = res + "\n" + lines.get(i);
                            String res2 = line12.substring(1, line12.length() - 1);
                            // split csv file
                            //  String csv = r
                            String delims = "[,]";
                            String[] csv = res2.split(delims);
                            //
                            String ent = csv[1];
                            String[] fn12 = ent.split(ress);
                            ent = fn12[1];
                            //
                            String accno = csv[2];
                            String[] c12 = accno.split(ress);
                            accno = c12[1];
                            //
                            String per = csv[3];
                            String[] per12 = per.split(ress);
                            per = per12[1];

                            String src = csv[4];
                            String[] src12 = src.split(ress);
                            src = src12[1];
                            //

                            //
                            String amt = csv[5];
                            String[] ent7 = amt.split(ress);
                            int amt2 = Integer.parseInt(ent7[1]);
//               tranamt += 1;
                            //


                            // add to table list
                          pats12.add(ent + " | " + accno + " | " + per + " | " + src
                                    + " | " + amt2);
                            //
                            tpats12 = "Budget Details Event" + "(" + "Ministry" + " | " + "Credit Acct" + " | "
                                    + "Budget Period" + " | "
                                    + "Source of Funds" + " | " + "Amount" + ")";



                        }

//                i++;
                        cnt12++;
                    }
                    //   model2.addSeries(trans6);
                    ct12 = pats12.size();
                    bufferedReader.close();





                    //


                } catch (Exception e) {
                    e.getStackTrace();

                }

                // write to pdf
                // add headers to array
                pats.add(0, tpats);
                pats.add("(" + ct1 + ")" + "--" + "Record(s) Matching Transactions Pattern");
                pats2.add(0, tpats2);
                pats2.add("(" + ct2 + ")" + "--" + "Record(s) Matching BOU Transfers Pattern");
                pats3.add(0, tpats3);
                pats3.add("(" + ct3 + ")" + "--" + "Record(s) Matching Payments Pattern");
                pats4.add(0, tpats4);
                pats4.add("(" + ct4 + ")" + "--" + "Record(s) Matching Income Pattern");
                pats5.add(0, tpats5);
                pats5.add("(" + ct5 + ")" + "--" + "Record(s) Matching Assets Pattern");
                pats6.add(0, tpats6);
                pats6.add("(" + ct6 + ")" + "--" + "Record(s) Matching Phone Logs Pattern");
                pats8.add(0, tpats8);
                pats8.add("(" + ct8 + ")" + "--" + "Record(s) Matching Funds Request Pattern");
                pats12.add(0, tpats12);
                pats12.add("(" + ct12 + ")" + "--" + "Record(s) Matching Budget Pattern");

                //
                ArrayList[] list;
                list = new ArrayList[]{pats12, pats8, pats2, pats3, pats, pats6};

                int counter = list.length;


                rs = "";
                for (int x = 0; x < counter; x++) {
                    counter2 = list[x].size();


                    for (int i = 0; i < counter2; i++) {


                        String gt = list[x].get(i).toString();
                        rs = rs + "\n" + gt + "\n";


                    }

                    String FILE = "c:/kriminofiles/" + casefile + "- Analysis Report" + ".pdf";
                    //
                    document = new Document();


                    try {
                        try {
                            PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    } catch (DocumentException ex) {
                        ex.printStackTrace();
                    }

                    document.open();
                    //

                    document.addTitle(
                            "Krimino Report");
                    document.addSubject(
                            "Crime Investigations");
                    document.addKeywords(
                            "Pattern");
                    document.addAuthor(
                            "Admin");
                    document.addCreator(
                            "Admin");
                    //
                    Paragraph preface = new Paragraph();
                    // We add one empty line

                    addEmptyLine(preface,
                            1);
                    // Lets write a big header
                    preface.add(
                            new Paragraph("Analysis Report for Case Number:" + "" + casefile));
                    preface.add(
                            new Paragraph("_________________________________________________"));

                    addEmptyLine(preface,
                            1);
                    // Will create: Report generated by: _name, _date
                    preface.add(
                            new Paragraph("Report generated By: " + System.getProperty("user.name") + ", " + new Date()));
                    addEmptyLine(preface,
                            3);
                    preface.add(
                            new Paragraph("_________________________________________________"));

                    preface.add(
                            new Paragraph(rs));
                    preface.add(
                            new Paragraph("_________________________________________________"));

                    try {
                        document.add(preface);
                    } catch (DocumentException ex) {
                        ex.printStackTrace();
                    }
                    // Start a new page
//                        document.newPage();
//                        //
//                        Anchor anchor = new Anchor("First Chapter");
//    anchor.setName("First Chapter");
//
//    // Second parameter is the number of the chapter
//    Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//
//   
//
//
//    Paragraph paragraph = new Paragraph();
//    addEmptyLine(paragraph, 5);
//    
//
//    // Now add all this to the document
//    document.add(catPart);


                    document.close();
                }

                //



                //

                //
                marker++;
            }



        } catch (Exception e) {
            e.getStackTrace();

        }
        String pmsg = "Events Generated succesfully from Database at Locations \n";
        return "\n" + pmsg;

    }
//

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    //

    public void setCfile(String cfile) {
        this.cfile = cfile;
    }

    public String getResult() throws FileNotFoundException, IOException {

        try {
            fpath = "c:\\kriminofiles\\report.txt";
            //
            //
            FileReader fileReader = new FileReader(fpath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //  ArrayList<String> lines = new ArrayList<String>();  
            String line;

            while ((line = bufferedReader.readLine()) != null) {


                if (!lines.contains(line)) {
                    lines.add(line);
                    // assign text 
                    res = "";

                    count1 = lines.size();
                    for (int i = 0; i < count1; i++) {
                        res = res + "\n" + lines.get(i);
                        //Read from Reports




                        //


                    }
                }

            }

            bufferedReader.close();


            //

////
        } catch (Exception e) {
            mes1 = "No Pattern Matched: ";
            mes2 = " No Records Found";

        }
        if (count1 == 1) {
            mes1 = "Succesful Pattern Match ! ";
            mes2 = count1 + "-" + "Record Found";
        } else if (count1 > 1) {
            mes1 = "Succesful Pattern Match: ";
            mes2 = count1 + "-" + "Records Found";
        } else {
            mes1 = "No Pattern Matched: ";
            mes2 = " No Pattern Matched - Records Found";
        }

        return res;
//  

    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Creates a new instance of MainBean
     */
    public MainBean1() {
        pojo = new CEPListener(); // Create/load it somehow.

    }

//    public String getPojo() {
//
//        return pojo.getResponse();
//    }
////    private String getstockparam(java.lang.String symbol, double price) {
////        services.KriminoWS port = service.getKriminoWSPort();
////        return port.getstockparam(symbol, price);
////    }
////
////    private String pushPhonelog(int callid, String ccode1, Date calldate, String frono, String tono) {
////        services.KriminoWS port = service.getKriminoWSPort();
////        return port.pushPhonelog(callid, ccode1, calldate, frono, tono);
////    }
////
////    private String pushTransaction(int tranid, String ccode2, Date transdate, String transcode, Number transamount, String transtype, String transaccount) {
////        services.KriminoWS port = service.getKriminoWSPort();
////        return port.pushTransaction(tranid, ccode2, transdate, transcode, transamount, transtype, transaccount);
////    }
////
////    private String pushTransfer(int tfid, String ccode3, Date tdate, Number tamount, String tfroacct, String ttoacct, String frobank, String ttobank) {
////        services.KriminoWS port = service.getKriminoWSPort();
////        return port.pushTransfer(tfid, ccode3, tdate, tamount, tfroacct, ttoacct, frobank, ttobank);
////    }

    public int getTfamt() {
        return tfamt;
    }

    public void setTfamt(int tfamt) {
        this.tfamt = tfamt;
    }

    public String getTxntype() {
        return txntype;
    }

    public void setTxntype(String txntype) {
        this.txntype = txntype;
    }
    private int tfamt;

    public int getTxnamt() {
        return txnamt;
    }

    public void setTxnamt(int txnamt) {
        this.txnamt = txnamt;
    }

    public String getTxnop() {
        return txnop;
    }

    public void setTxnop(String txnop) {
        this.txnop = txnop;
    }

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public String getMes2() {
        return mes2;
    }

    public void setMes2(String mes2) {
        this.mes2 = mes2;
    }
    private String mes2;
//
    // filed download

    public String getPdf() {

        //



        //










        return "PDF files created for Case Number:" + casefile;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getCsno() {
        return csno;
    }

    public void setCsno(String csno) {
        this.csno = csno;
    }
}
