/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.util.DateTime;
import com.espertech.esperio.AdapterCoordinator;
import com.espertech.esperio.AdapterCoordinatorImpl;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.espertech.esperio.csv.CSVInputAdapterSpec;
import dbase.Assets;
import dbase.Boutransfers;
import dbase.Budget;
import dbase.Casetrans;
import dbase.Phonelogs;
import dbase.Transfers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Osbert
 */
@ManagedBean
@RequestScoped
public class MainBean {
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
    private int cnt, cntt, cnttt;
//    public void reset() {
    private String filepath4 = "C:\\kriminofiles\\report.txt";
    String filepath5;
    String filepath6;
    String filepath7;
    String filepath8;
    //    File fileTemp4 = new File(filepath4);

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
    EntityManagerFactory emf ;
    //   EntityManagerFactory emf1;
    //  EntityManagerFactory emf2;
    //

    public String getCfile() {
        //
        String classp = "C:\\kriminoZclient\\src\\java\\javabeans\\phonelogs.csv";
        String classp1 = "C:\\kriminoZclient\\src\\java\\javabeans\\transactionlogs.csv";
        String classp2 = "C:\\kriminoZclient\\src\\java\\javabeans\\transferlogs.csv";
        String classp3 = "C:\\kriminoZclient\\src\\java\\javabeans\\boulogs.csv";
        String classp4 = "C:\\kriminoZclient\\src\\java\\javabeans\\budgetlogs.csv";
        String classp5 = "C:\\kriminoZclient\\src\\java\\javabeans\\incomelogs.csv";
        String classp6 = "C:\\kriminoZclient\\src\\java\\javabeans\\assetlogs.csv";
        //
        filepath = classp;
        filepath2 = classp1;
        filepath3 = classp2;
        filepath5 = classp3;
        filepath6 = classp4;
        filepath7 = classp5;
        filepath8 = classp6;

//Delete if tempFile exists
        File fileTemp = new File(filepath);
        File fileTemp2 = new File(filepath2);
        File fileTemp3 = new File(filepath3);
        File fileTemp4 = new File(filepath4);
        File fileTemp5 = new File(filepath5);
        File fileTemp6 = new File(filepath6);
        File fileTemp7 = new File(filepath7);
        File fileTemp8 = new File(filepath8);

//              //  if (fileTemp.exists()) {
        fileTemp.delete();
        fileTemp2.delete();
        fileTemp3.delete();
        fileTemp4.delete();
        fileTemp5.delete();
        fileTemp6.delete();
        fileTemp7.delete();
        fileTemp8.delete();
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
                Date calldate = item.getCallDate();
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

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                if (idx == 0) {
                    String phonehdr = "callid" + "," + "ccode1" + "," + "calldate" + "," + "frono" + "," + "tono";
                    writer.append(phonehdr);
                }
                writer.append('\n');
                writer.append(cfile);
                writer.append('\n');

// copy to classpath


                //Files.copy(filepath, classp,Boolean.TRUE);

                //

                //generate whatever data you want

                writer.flush();
                writer.close();
//


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
                Date transdate = item1.getTransdate();
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

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                if (idxx == 0) {
                    String txnhdr = "tranid" + "," + "ccode2" + ","
                            + "transdate" + "," + "transcode" + ","
                            + "transamount" + "," + "transtype" + "," + "transaccount";
                    writer.append(txnhdr);
                }
                writer.append('\n');
                writer.append(cfile2);
                writer.append('\n');



                //generate whatever data you want

                writer.flush();
                writer.close();
                //

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
                Date tfdt = item2.getTdate();
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

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                if (idxxx == 0) {
                    String tfhdr = "tfid" + "," + "ccode3" + ","
                            + "tdate" + "," + "tamount" + ","
                            + "tfroacct" + "," + "ttoacct" + "," + "frobank" + "," + "ttobank";
                    writer.append(tfhdr);
                }
                writer.append('\n');
                writer.append(cfile3);
                writer.append('\n');



                //generate whatever data you want

                writer.flush();
                writer.close();
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
                Date bdate = item3.getDate();
                String transfertype = item3.getTransfertype();
                String debitacct = item3.getDebitacctno();
                String debitacctname = item3.getDebitacctname();
                int debitamt = item3.getDebitamount();
                String crbank = item3.getCreditbank();
                String cracct = item3.getCreditacct();
                String bankstaff = item3.getBankstaffid();
                String govtstaff = item3.getGovtstaffid();
                String ccode4 = caseNo;
                Budget itemcode = item3.getItemcode();

                //
                // symbol = item.getToNo();
                //  price = 9.5;
                // create csv file from entity/database
                cfile4 = bid + "," + bdate + "," + transfertype + "," + debitacct + ","
                        + debitacctname + "," + debitamt + "," + crbank + "," + cracct +
                        "," + bankstaff+ "," + govtstaff + "," + ccode4 + "," + itemcode ;
//            write to csv file
                //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                //    filepath3 = classp2;
//
//try
//	{
                FileWriter writer = new FileWriter(filepath5, true);

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                if (idxxxx == 0) {
                    String tfhdr = "bouid" + "," + "bdate" + ","
                            + "tranfertype" + "," + "debitacct" + ","
                            + "debitacctname" + "," + "debitamt" + "," + "crbank" + "," + "cracct"
                            + "," + "bankstaff" + "," + "govtstaff" + "," + "ccode4" + "," + "itemcode";
                    writer.append(tfhdr);
                }
                writer.append('\n');
                writer.append(cfile4);
                writer.append('\n');



                //generate whatever data you want

                writer.flush();
                writer.close();
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
                Date acqdate = item5.getAcquiredate();
                int acqcost = item5.getAcquirecost();
                String acqmode = item5.getAcquiremode();
                String acqsource = item5.getSourceoffunds();
               
                //
                // symbol = item.getToNo();
                //  price = 9.5;
                // create csv file from entity/database
                cfile5 = assetid + "," + assettype+  "," + marketval + "," + acqdate + ","
                        + acqcost + "," + acqmode + "," + acqsource ;
//            write to csv file
                //filepath3 = "c:\\kriminofiles\\transferlogs.csv";
                //    filepath3 = classp2;
//
//try
//	{
                FileWriter writer = new FileWriter(filepath8, true);

//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                if (id5 == 0) {
                    String tfhdr = "Assetid" + "," + "Assettype" + ","
                            + "Marketval" + "," + "Acqdate" + ","
                            + "Acqcost" + "," + "Acqmode" + "," + "Acqsource" ;
                    writer.append(tfhdr);
                }
                writer.append('\n');
                writer.append(cfile5);
                writer.append('\n');



                //generate whatever data you want

                writer.flush();
                writer.close();
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


        return "Events Processed succesfully";

    }

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
            typeMap.put("calldate", DateTime.class);
            typeMap.put("frono", String.class);
            typeMap.put("tono", String.class);
            config.addEventType("Phonelogbean", typeMap);
// Event 2 - Transactions
            Map typeMap2 = new HashMap();
            typeMap2.put("tranid", Integer.class);
            typeMap2.put("ccode2", String.class);
            typeMap2.put("transdate", DateTime.class);
            typeMap2.put("transamount", Integer.class);
            typeMap2.put("transtype", String.class);
            typeMap2.put("transaccount", String.class);
            config.addEventType("Transactionbean", typeMap2);

// Event 3 - Cash Transfers to other Banks
            Map typeMap3 = new HashMap();
            typeMap3.put("tfid", Integer.class);
            typeMap3.put("ccode3", String.class);
            typeMap3.put("tdate", DateTime.class);
            typeMap3.put("tamount", Integer.class);
            typeMap3.put("tfroacct", String.class);
            typeMap3.put("ttoacct", String.class);
            typeMap3.put("frobank", String.class);
            typeMap3.put("ttobank", String.class);
            //
            config.addEventType("Transferbean", typeMap3);

            //
            EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
            //   String expression1 = " select * Phonelogbean.win:time(30 sec)";


            // working OK
//        String expression ="select a.ccode1,b.transamount,b.transaccount"
//                + " from pattern [every a=Phonelogbean -> b=Transactionbean"
//                + "(ccode2= a.ccode1) ]where b.transamount>100000"
//                + "";
            // working OK
            String expression1 = "select b.transtype,b.transamount,"
                    + "b.transaccount from pattern"
                    + " [every (b=Transactionbean(b.transamount>80000) "
                    + "and b=Transactionbean(b.transtype='CR') "
                    + ""
                    + ")]";
//
//            //pattern ok
//             String expression1 = "select b.transdate,b.transtype,b.transamount,"
//                    + "b.transaccount,c.tdate,c.tamount,c.frobank,c.ttobank from pattern"
//                    + " [every (b=Transactionbean(b.transamount>" + txnamt + ") "
//                    + "and b=Transactionbean(b.transtype='CR') "
//                    + "or c=Transferbean(c.tamount>30000)"
//                    + ")]";
//    String expression1 = "select b.transdate,b.transtype,b.transamount,"
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
            String exp = "";
//            if (selector.endsWith("Transaction Logs"))
//            {
            exp = expression1;
            //   }
            EPStatement statement = epService.getEPAdministrator().createEPL(exp);

            CEPListener listener = new CEPListener();
            statement.addListener(listener);


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
            CSVInputAdapterSpec inputTwo = new CSVInputAdapterSpec(adapterInputSource1, "Transactionbean");
            inputTwo.setTimestampColumn("timestamp2");
//
            //
            AdapterInputSource adapterInputSource3 = new AdapterInputSource("/javabeans/transferlogs.csv");
            (new CSVInputAdapter(epService, adapterInputSource3, "Transferbean")).start();
            //
            CSVInputAdapterSpec inputThree = new CSVInputAdapterSpec(adapterInputSource1, "Transferbean");
            inputThree.setTimestampColumn("timestamp3");
//
            AdapterCoordinator coordinator = new AdapterCoordinatorImpl(epService, true);
//            coordinator.coordinate(new CSVInputAdapter(inputOne));
            coordinator.coordinate(new CSVInputAdapter(inputTwo));
//            coordinator.coordinate(new CSVInputAdapter(inputThree));
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
    public MainBean() {
        pojo = new CEPListener(); // Create/load it somehow.

    }

    public String getPojo() {

        return pojo.getResponse();
    }
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

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
