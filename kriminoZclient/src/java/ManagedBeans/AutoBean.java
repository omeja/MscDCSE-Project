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
import dbase.Assets;
import dbase.Boutransfers;
import dbase.Casetrans;
import dbase.Income;
import dbase.Phonelogs;
import dbase.Transfers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Osbert
 */
@ManagedBean
//@SessionScoped
@RequestScoped
public class AutoBean {
// make CEPlistener property

    private CEPListener pojo;
    //
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
    private String res;
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
        //

        String classp = "C:\\kriminoZclient\\src\\java\\javabeans\\phonelogs.csv";
        String classp1 = "C:\\kriminoZclient\\src\\java\\javabeans\\transactionlogs.csv";
        String classp2 = "C:\\kriminoZclient\\src\\java\\javabeans\\transferlogs.csv";
        String classp3 = "C:\\kriminoZclient\\src\\java\\javabeans\\boulogs.csv";
        String classp4 = "C:\\kriminoZclient\\src\\java\\javabeans\\budgetlogs.csv";
        String classp5 = "C:\\kriminoZclient\\src\\java\\javabeans\\incomelogs.csv";
        String classp6 = "C:\\kriminoZclient\\src\\java\\javabeans\\assetlogs.csv";


        //
        String classparam = "c:\\kriminofiles\\params.txt";
        String classym = "c:\\kriminofiles\\symbols.txt";
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
        //
        fp = cp;
        fp1 = cp1;
        fp2 = cp2;
        fp3 = cp3;
        fp4 = cp4;
        fp5 = cp5;
        fp6 = cp6;
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
        ftp.delete();
        ftp1.delete();
        ftp2.delete();
        ftp3.delete();
        ftp4.delete();
        ftp5.delete();
        ftp6.delete();
        filelog.delete();

        //
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
        // Delete Existing
//String classp = System.getProperty("user.home");



        //

        //

        // 1.Read from Database table phonelogs
//        List<Phonelogs> itemList = emf.createEntityManager().
//                createNamedQuery("Phonelogs.findAll").getResultList();
        //
        List<Phonelogs> itemList = emf.createEntityManager().
                createNamedQuery("Phonelogs.findByCasecode").setParameter("caseCode", caseNo).getResultList();
        //Iterator i = itemList.iterator();
        // count records
        cnt = itemList.size();
        int cnt2 = cnt - 1;
        // int idx=0;
//        if (cnt==0){
//                
//            fileTemp4.delete();
//        
//        }

        //   while (i.hasNext()) {
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
                //
                // symbol = item.getToNo();
                //  price = 9.5;
                // create csv file from entity/database
                //   String hdr1 = "Call_id,case_code,call_date,from_No,to_No";
                cfile = callid + "," + casecode1 + "," + calldate + "," + froNo + "," + toNo;
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
                if (idx == 0) {
                    String phonehdr = "callid" + "," + "ccode1" + "," + "calldate" + "," + "frono" + "," + "tono";
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


//                    File x = new File(fpath);
//               File y = new File(classp);
//                //
//               copyFileUsingStream(x,y);
                // split
//                // Esper call
                //                // Configure Esper Engine
////
//                Configuration cepConfig = new Configuration();
//
//                cepConfig.addEventType("Phonelogbean", Phonelogbean.class.getName());
//           //     cepConfig.addEventType("Transferbean", Transferbean.class.getName());
//             //   cepConfig.addEventType("Transactionbean", Transactionbean.class.getName());
//                EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
//                EPRuntime cepRT = cep.getEPRuntime();
//                //
//
//                //
//                EPAdministrator cepAdm = cep.getEPAdministrator();
//                // Test combined Stmt
//                EPStatement cepStatement = cepAdm.createEPL("select calldate,frono,tono from "
//                        + "Phonelogbean().win:length(200)");
////
////
////
////
//                cepStatement.addListener(new CEPListener());
//                Phonelogbean phonelogbean = new Phonelogbean(callid, casecode1, calldate, froNo, toNo);
//                cepRT.sendEvent(phonelogbean);

                // Get results
//                SafeIterator<EventBean> safeIter = cepStatement.safeIterator();
//                try {
//                    for (; safeIter.hasNext();) {
//// .. process event ..
//                        EventBean event = safeIter.next();
//                        result = event.get("Phonelogbean").toString();
//                    }
//                } finally {
//                    safeIter.close(); // Note: safe iterators must be closed
//                }




                // CEPListener cl = new CEPListener();
                //  result =  cl.;
//	}
//	catch(IOException e)
//	{
//	     e.printStackTrace();
//	} 

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
                if (idxx == 0) {
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
//                   File x = new File(filepath);
//               File y = new File(classp);
//                //
//               copyFileUsingStream(x,y);
                // Esper call                 
//                cepConfig.addEventType("Transactionbean", javabeans.Transactionbean.class.getName());
//        cepStatement.addListener(new CEPListener());
//                Transactionbean transactionbean = new Transactionbean(tranid, ccode2, transdate, trancode, transamount, trantype, tranacct);
//                cepRT.sendEvent(transactionbean);
//	}
//	catch(IOException e)
//	{
//	     e.printStackTrace();
//	} 
//                Configuration cepConfig2 = new Configuration();
//                cepConfig2.addEventType("Transactionbean", Transactionbean.class.getName());
//                EPServiceProvider cep2 = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig2);
//                EPRuntime cepRT2 = cep2.getEPRuntime();
//                //
//
//                //
//                EPAdministrator cepAdm2 = cep2.getEPAdministrator();
//                // split
//                EPStatement cepStatement2 = cepAdm2.createEPL("select * from "
//                        + "Transactionbean().win:length(2)");
//
//                //    CEPListener listener = new CEPListener();
//                cepStatement2.addListener(new CEPListener());
//                Transactionbean transactionbean = new Transactionbean(tranid, ccode2, transdate, trancode, transamount, trantype, tranacct);
//                cepRT2.sendEvent(transactionbean);
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
                //
                // symbol = item.getToNo();
                //  price = 9.5;
                // create csv file from entity/database
                cfile3 = trid + "," + ccode3 + "," + tfdt + "," + tramount + ","
                        + froAcct + "," + toAcct + "," + frobnk + "," + tobnk;
//            write to csv file
                //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                //    filepath3 = classp2;
//
//try
//	{
                FileWriter writer = new FileWriter(filepath3, true);
                //
                FileWriter writer2 = new FileWriter(fp2, true);

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                if (idxxx == 0) {
                    String tfhdr = "tfid" + "," + "ccode3" + ","
                            + "tdate" + "," + "tamount" + ","
                            + "tfroacct" + "," + "ttoacct" + "," + "frobank" + "," + "ttobank";
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

                // Phone fields
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
                // Budget itemcode = item3.getItemcode();
                int itemcode = item3.getItemcode().getAmount();
                bgamt = itemcode;
                //call budget amount value form budget table
//                   String budgetamt = itemcode.toString();
//                //
//                   try{
//                String delims = "=";
//                String delims2 = "]";
//               String[] b = budgetamt.split(delims);
//               budgetamt = b[1];
//               String [] c = budgetamt.split(delims2);
//               String btamt = c[0];
//               int bamt = Integer.parseInt(btamt);
//                bamt2 = bamt;
                //   bamt = 1;
                //
//                List<Budget> itemListb = emf.createEntityManager().
//                createNamedQuery("Budget.findByItemcode").setParameter("itemcode", itemcode).getResultList();
//                //
//                Budget itemb = itemListb.get(0);
//             int amt = itemb.getAmount();

                // symbol = item.getToNo();
                //  price = 9.5;
                // create csv file from entity/database
                cfile4 = bid + "," + bdate + "," + transfertype + "," + debitacct + ","
                        + debitacctname + "," + debitamt + "," + crbank + "," + cracct
                        + "," + bankstaff + "," + govtstaff + "," + ccode4 + "," + itemcode;
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
                if (idxxxx == 0) {
                    String tfhdr = "idbou" + "," + "bdate" + ","
                            + "transfertype" + "," + "debitacctno" + ","
                            + "debitacctname" + "," + "debitamount" + "," + "creditbank" + "," + "creditacct"
                            + "," + "bankstaffid" + "," + "govtstaffid" + "," + "casecode" + "," + "budgetamt";
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
                if (id5 == 0) {
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
                if (id6 == 0) {
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
                    Logger.getLogger(AutoBean.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AutoBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // idx++;
        }



        // Read Incoming Events
        try {
            // Phone Calls

            FileReader fileReader = new FileReader(classp);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
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

            FileReader fileReader = new FileReader(classp1);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
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

            FileReader fileReader = new FileReader(classp2);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
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

            FileReader fileReader = new FileReader(classp3);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
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

            FileReader fileReader = new FileReader(classp5);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
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

            FileReader fileReader = new FileReader(classp6);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
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

        String pmsg = "Events Generated succesfully from Database at Locations \n";
        //

        return "\n" + pmsg;

    }

    //
    public void setCfile(String cfile) {
        this.cfile = cfile;
    }

    public String getResult() throws FileNotFoundException, IOException {
// Read Report text file from disk
//        if (cnt==0)
//{
//     File fileTemp4 = new File(filepath4);
// fileTemp4.delete();
// 
//}



        //
        try {

            Configuration config = new Configuration();
            config.addEventTypeAutoName("esper.example");

            /*
             * declare event type map
             */
            // Event 1 - Phonelogs
            Map typeMap = new HashMap();
            typeMap.put("callid", Integer.class);
            typeMap.put("ccode1", String.class);
            typeMap.put("callid", Integer.class);
            typeMap.put("calldate", String.class);
            typeMap.put("frono", String.class);
            typeMap.put("tono", String.class);
            config.addEventType("Phonelogbean", typeMap);
// Event 2 - Transactions
            Map typeMap2 = new HashMap();
            typeMap2.put("tranid", Integer.class);
            typeMap2.put("ccode2", String.class);
            typeMap2.put("transdate", String.class);
            typeMap2.put("transamount", Integer.class);
            typeMap2.put("transtype", String.class);
            typeMap2.put("transaccount", String.class);
            config.addEventType("Transactionbean", typeMap2);

// Event 3 - Cash Transfers to other Banks
            Map typeMap3 = new HashMap();
            typeMap3.put("tfid", Integer.class);
            typeMap3.put("ccode3", String.class);
            typeMap3.put("tdate", String.class);
            typeMap3.put("tamount", Integer.class);
            typeMap3.put("tfroacct", String.class);
            typeMap3.put("ttoacct", String.class);
            typeMap3.put("frobank", String.class);
            typeMap3.put("ttobank", String.class);
            //
            config.addEventType("Transferbean", typeMap3);
            //
            // Event 4 - Assets 
            Map typeMap4 = new HashMap();
            typeMap4.put("assetcode", Integer.class);
            typeMap4.put("assettype", String.class);
            typeMap4.put("marketvalue", Integer.class);
            typeMap4.put("acquiredate", String.class);
            typeMap4.put("acquirecost", Integer.class);
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
            //
            EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
            //   String expression1 = " select * Phonelogbean.win:time(30 sec)";
// Read comparison values from path

            // Get symbols file
            try {
                String fspath = "c:\\kriminofiles\\symbols.txt";
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
                    //     String calldt = csvp[4];
//               

                    // ct1 = pats.size();


                    //


                }
                // close file stream
                bufferedReaders.close();





            } catch (Exception e) {
                e.getStackTrace();

            }










            //

            // working OK
//        String expression ="select a.ccode1,b.transamount,b.transaccount"
//                + " from pattern [every a=Phonelogbean -> b=Transactionbean"
//                + "(ccode2= a.ccode1) ]where b.transamount>100000"
//                + "";
            // working OK



            // convert comparison operators to strings

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

//   if (bousymb.startsWith("Equal")) {
//                bousymb2 = "=";
//
//            }
//            else if (bousymb.startsWith("Less")) {
//                bousymb2 = "<";
//
//            }
//            else {
//                bousymb2 = ">";
//
//            }


            //
            // ok live
//            String expression1 = "select b.transtype,b.transamount,"
//                    + "b.transaccount,"
//                    + "c.marketvalue,"
//                    + "d.amount,e.debitamount from pattern"
//                    + " [every (b=Transactionbean(b.transamount>" + pamt + ") "
//                    + "and b=Transactionbean(b.transtype ='CR') "
//                    + "or c=Assetsbean(c.casecode = 'JJRD001')"
//                    + "or d=Incomebean(d.amount > " + inamt + ")"
//                    + "or e=Boubean(e.debitamount > " + bgamt + ")"
//                    + ")]";
//
//            //pattern ok
// Personal/company Account Transactions
            String expression1 = "select b.transdate,b.transtype,"
                    + "b.transamount,"
                    + "b.transaccount from pattern"
                    + " [every (b=Transactionbean(b.transamount" + transymb2 + pamt + ")"
                    + "and b=Transactionbean(b.transtype='CR') "
                    + ")]";
            // BOU Electronic Transfer Details
            String expression2 = "select "
                    + "a.bdate,a.transfertype,"
                    + "a.debitacctname,a.debitamount,"
                    + "a.creditbank,a.creditacct,a.govtstaffid from pattern"
                    + " [every (a=Boubean(a.debitamount>" + bgamt + ")"
                    + " "
                    + ")]";

            //
            // Personal/Company Account Transfer Details
            String expression3 = "select "
                    + "c.tdate,c.tamount,"
                    + "c.frobank,c.tfroacct,"
                    + "c.ttobank,c.ttoacct from pattern"
                    + " [every (c=Transferbean(c.tamount>" + tfamt + ")"
                    + " "
                    + ")]";
            //
            // Personal Income Details
            String expression4 = "select "
                    + "d.description,d.incometype,"
                    + "d.frequency,d.amount,"
                    + "sum(d.amount) as NetIncome from pattern"
                    + " [every (d=Incomebean(d.amount>" + inamt + ")"
                    + " "
                    + ")]";
            //
            // Personal Assets Details
            String expression5 = "select "
                    + "e.assettype,e.marketvalue,"
                    + "e.acquiredate,e.acquirecost,"
                    + "e.sourceoffunds from pattern"
                    + " [every (e=Assetsbean(e.marketvalue>" + assetval + ")"
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
            //

//    String expression2 = "select b.transdate,b.transtype,b.transamount,"
//                    + "b.transaccount from Transactiobean.win:time(10) as b,c.tdate,c.tamount,c.frobank,c.ttobank"
//                    + "from Transferbean..win:time(10) as c"
//                    + "where b.ccode1=c.ccode2";
//"every (amounts=" + eventName2 +
//"(transamount>100000))]" ;

            // for statement
            // read stmts to array list
//            ArrayList<String> stmts = new ArrayList<String>();
//            stmts.add(expression1);
//            stmts.add(expression2);
//            int stmtcnt = stmts.size();
//            int i = 0;
//            while (i <= stmtcnt) {

//                expression1 = stmts.get(i);
            //

//            if (selector.endsWith("Transaction Logs"))
//            {
            // Expressions
            String exp = expression1;
            String exp2 = expression2;
            String exp3 = expression3;
            String exp4 = expression4;
            String exp5 = expression5;
            String exp6 = expression6;

            // statements

            EPStatement statement = epService.getEPAdministrator().createEPL(exp);
            EPStatement statement2 = epService.getEPAdministrator().createEPL(exp2);
            EPStatement statement3 = epService.getEPAdministrator().createEPL(exp3);
            EPStatement statement4 = epService.getEPAdministrator().createEPL(exp4);
            EPStatement statement5 = epService.getEPAdministrator().createEPL(exp5);
            EPStatement statement6 = epService.getEPAdministrator().createEPL(exp6);
// New Listeners
            CEPListener listener = new CEPListener();
            CEPListener2 listener2 = new CEPListener2();
            CEPListener3 listener3 = new CEPListener3();
            CEPListener4 listener4 = new CEPListener4();
            CEPListener5 listener5 = new CEPListener5();
            CEPListener6 listener6 = new CEPListener6();
            //
            // Add Listeners
            statement.addListener(listener);
            statement2.addListener(listener2);
            statement3.addListener(listener3);
            statement4.addListener(listener4);
            statement5.addListener(listener5);
            statement6.addListener(listener6);

            /*
             * publish events from csv file
             */
            AdapterInputSource adapterInputSource1 = new AdapterInputSource("/javabeans/phonelogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource1, "Phonelogbean")).start();
            //
            CSVInputAdapterSpec inputOne = new CSVInputAdapterSpec(adapterInputSource1, "Phonelogbean");
            inputOne.setTimestampColumn("timestamp1");
//
            AdapterInputSource adapterInputSource2 = new AdapterInputSource("/javabeans/transactionlogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource2, "Transactionbean")).start();
            //
            CSVInputAdapterSpec inputTwo = new CSVInputAdapterSpec(adapterInputSource2, "Transactionbean");
            inputTwo.setTimestampColumn("timestamp2");
//
            //
            AdapterInputSource adapterInputSource3 = new AdapterInputSource("/javabeans/transferlogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource3, "Transferbean")).start();
            //
            CSVInputAdapterSpec inputThree = new CSVInputAdapterSpec(adapterInputSource3, "Transferbean");
            inputThree.setTimestampColumn("timestamp3");
//
            //
            AdapterInputSource adapterInputSource4 = new AdapterInputSource("/javabeans/assetlogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource4, "Assetsbean")).start();
            //
            CSVInputAdapterSpec inputfour = new CSVInputAdapterSpec(adapterInputSource4, "Assetsbean");
            inputfour.setTimestampColumn("timestamp4");
            //
            AdapterInputSource adapterInputSource5 = new AdapterInputSource("/javabeans/boulogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource5, "Boubean")).start();
            //
            CSVInputAdapterSpec inputfive = new CSVInputAdapterSpec(adapterInputSource5, "Boubean");
            inputfive.setTimestampColumn("timestamp5");
            //
            AdapterInputSource adapterInputSource6 = new AdapterInputSource("/javabeans/incomelogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource6, "Incomebean")).start();
            //
            CSVInputAdapterSpec inputsix = new CSVInputAdapterSpec(adapterInputSource6, "Incomebean");
            inputsix.setTimestampColumn("timestamp6");
            //
            AdapterCoordinator coordinator = new AdapterCoordinatorImpl(epService, true);
            coordinator.coordinate(new CSVInputAdapter(inputOne));
            coordinator.coordinate(new CSVInputAdapter(inputTwo));
            coordinator.coordinate(new CSVInputAdapter(inputThree));
            coordinator.coordinate(new CSVInputAdapter(inputfour));
            coordinator.coordinate(new CSVInputAdapter(inputfive));
            coordinator.coordinate(new CSVInputAdapter(inputsix));
            coordinator.start();
//
            // }
            // end while
            // i++;
            // }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            fpath = "c:\\kriminofiles\\report.txt";
            //
//        }
//        catch(Exception e)
//        {
//        mes1 = "No Pattern Matched: ";
//            mes2 = " No Records Found";
//        }



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
                        // create data table

//                    String res2 = line.substring(1, line.length()-1);
//                    // split csv file
//                  //  String csv = r
//                    String delims = "[,]";
//                    String ress = "[=]";
//               String[] csv = res2.split(delims);
//               //
//               String acctno = csv[0];
//               String [] acctno2 = acctno.split(ress);
//               String acct = acctno2[1];
//               //
//               String tramt = csv[1];
//               String [] tramt2 = tramt.split(ress);
//               int tranamt = Integer.parseInt(tramt2[1]);
//                    
//                    
//                    
//                    


                        //
                    }
                }

            }

            bufferedReader.close();




//        Scanner s = new Scanner(new File(fpath));
//
//while (s.hasNext()){
//   
//    list.add(s.next());
//    
//}
//s.close();
            // Add to set
// list is some List of Strings

//Set<String> s2;
//        s2 = new LinkedHashSet<String>(list);
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
//        return re

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
    public AutoBean() {
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
}
