/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Report.Reps;
import Report.Reps11;
import Report.Reps12;
import Report.Reps2;
import Report.Reps3;
import Report.Reps4;
import Report.Reps5;
import Report.Reps6;
import Report.Reps8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author pc
 */
@ManagedBean
@RequestScoped
public class Bean implements Serializable{
//

    //
   // private CartesianChartModel model;
    private CartesianChartModel model2;
   // private boolean hasErrors;
    // private final ArrayList<Reps7> pats7;
    // private  ArrayList<Reps8> pats8 =null;;
    private int ct8 = 0;
    private List<Reps11> pats11;
    private int perc11;
    private int perc2;
    private int perc3;
    private int perc6;
    private int perc8;
    private double tperc;
    private int totn2;

    public CartesianChartModel getModel2() {
        return model2;
    }

    public void setModel2(CartesianChartModel model2) {
        this.model2 = model2;
    }
    //
    private List<Reps> pats;
    private List<Reps2> pats2;
    private List<Reps3> pats3;
    private List<Reps4> pats4;
    private List<Reps5> pats5;
    private List<Reps6> pats6;
    private List<Reps8> pats8;
    private List<Reps12> pats12;

    public List<Reps12> getPats12() {
        return pats12;
    }

    public void setPats12(List<Reps12> pats12) {
        this.pats12 = pats12;
    }

    public List<Reps8> getPats8() {
        return pats8;
    }

    public void setPats8(List<Reps8> pats8) {
        this.pats8 = pats8;
    }
    // record counts for the six reports
    private int ct1;
    private int ct2;
    private int ct3;
    private int ct4;
    private int ct5;
    private int ct6;
    private int ct12;
    private int ct11;
    //
    private int totcnt = 0;
    private float totperc = 0;
    // private int totperc2;
//
    private int totp = 0;
    private int totn = 5;
    //
    private String cntmsg1;
    private String cntmsg2;
    private String cntmsg3;
    private String cntmsg4;
    private String cntmsg5;
    private String cntmsg6;
    private String cntmsg11;

    public String getCntmsg11() {
        if (ct11 >= 1) {
            cntmsg11 = ct11 + "" + "- Record(s) Found (Emails Event - No Pattern Match)";
        } else {
            cntmsg11 = "No Record(s) Found (Emails  Event - Pattern Match)";
        }

        return cntmsg11;
    }
    //
    private String cntmsg8;
    private String cntmsg12;

    public String getCntmsg12() {
        if (ct12 >= 1) {
            cntmsg12 = ct12 + "" + "- Record(s) Found Matching Pattern (Event Name - Budget Event)";
        } else {
            cntmsg12 = "No Record(s) Matching Pattern (Event Name - Budget Event)";
        }
        return cntmsg12;
    }

    public void setCntmsg12(String cntmsg12) {
        this.cntmsg12 = cntmsg12;
    }

    public String getCntmsg8() {
        if (ct8 >= 1) {
            cntmsg8 = ct8 + "" + "- Record(s) Found (Funds Release Event - Pattern Match)";
        } else {
            cntmsg8 = "No Record(s) Found(Funds Release Event - No Pattern Match)";
        }
        return cntmsg8;
    }

    public void setCntmsg8(String cntmsg8) {
        this.cntmsg8 = cntmsg8;
    }

    public List<Reps11> getPats11() {
        return pats11;
    }

    public void setPats11(List<Reps11> pats11) {
        this.pats11 = pats11;
    }
    private String tcntmsg;
    private String tpercmsg;
    // param fields
    private int bgamt;
    private int pamt;
    private int inamt;
    private int assetval;

    //
    public List<Reps2> getPats2() {
        return pats2;
    }

    public List<Reps3> getPats3() {
        return pats3;
    }

    public List<Reps4> getPats4() {
        return pats4;
    }

    public List<Reps5> getPats5() {
        return pats5;
    }

    public List<Reps6> getPats6() {
        return pats6;
    }
    // Main series
    ChartSeries trans = new ChartSeries();
    ChartSeries trans2 = new ChartSeries();
    ChartSeries trans3 = new ChartSeries();
    ChartSeries trans4 = new ChartSeries();
    ChartSeries trans5 = new ChartSeries();
    ChartSeries trans6 = new ChartSeries();
    // parametr series
    ChartSeries transb = new ChartSeries();
    ChartSeries translim = new ChartSeries();
    ChartSeries transinamt = new ChartSeries();
    ChartSeries transassetval = new ChartSeries();
    //

    public List<Reps> getPats() {
        return pats;
    }

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public Bean() {
//        model = new CartesianChartModel();
        model2 = new CartesianChartModel();
        // Get Parameter file
        try {
            String fppath = "c:\\kriminofiles\\params.txt";
            //

            //
            FileReader fileReaderp = new FileReader(fppath);

            BufferedReader bufferedReaderp = new BufferedReader(fileReaderp);
            ArrayList<String> linesp = new ArrayList<String>();
            String linep;
            //

            //
            // int i = 0, cnt = 1;
            while ((linep = bufferedReaderp.readLine()) != null) {

                linesp.add(linep);
                // assign text 

                String ressp = "[,]";

                String resp = linesp.get(0);
                // split csv file

                String[] csvp = resp.split(ressp);
                //
                bgamt = Integer.parseInt(csvp[0]);
                pamt = Integer.parseInt(csvp[1]);
                inamt = Integer.parseInt(csvp[2]);
                assetval = Integer.parseInt(csvp[3]);
                //     String calldt = csvp[4];
//               

                // ct1 = pats.size();

                // close file stream
                bufferedReaderp.close();
                //
                // call budget amt from mainbean
//                transb.setLabel("Budget Check Amount");
//                transb.set("BValue", bgamt);
//                model.addSeries(transb);
                // ct2 = pats2.size();


                // transaction check value
//                translim.setLabel("Transaction Check Value");
//                translim.set("TValue", pamt);
//                model.addSeries(translim);

                //
//                // Income Amount series
//                transinamt.setLabel("Income Check Value");
//                transinamt.set("IValue", inamt);
//                model.addSeries(transinamt);
//                // Income Amount
//                transassetval.setLabel("Asset Check Value");
//                transassetval.set("AValue", assetval);
//                model.addSeries(transassetval);

            }






        } catch (Exception e) {
            e.getStackTrace();

        }



        // Get records from report file

//        try {
//
//
//            String fpath = "c:\\kriminofiles\\report.txt";
//            //
//
//            //
//            FileReader fileReader = new FileReader(fpath);
//            BufferedReader bufferedReader = new BufferedReader(fileReader) {
//                ArrayList<String> lines = new ArrayList<String>();
//                String line;
//                //
//                //
//
//                pats = new ArrayList<Reps>();
//                //
//                int i = 0, tranamt = 0, cnt = 1;
//                while ((line = bufferedReader.readLine()) != null) {
//
//
//                    if (!lines.contains(line)) {
//                        lines.add(line);
//                        // assign text 
//                        //  String res = "";
//                        String ress = "[=]";
//                        // int count1 = lines.size();
//
//                        // for (int i = 0; i < count1; i++) {
//                        // res = lines.get(i);
//                        //    res = res + "\n" + lines.get(i);
//                        String res2 = line.substring(1, line.length() - 1);
//                        // split csv file
//                        // int count1 = lines.size();
//                        String delims = "[,]";
//                        String[] csv = res2.split(delims);
//                        //
//                        String acctno = csv[0];
//                        String[] acctno2 = acctno.split(ress);
//                        String acct = acctno2[1];
//                        //
//                        String tramt = csv[1];
//                        String[] tramt2 = tramt.split(ress);
//                        tranamt = Integer.parseInt(tramt2[1]);
//                        //               
//                        //
//                        String trandt = csv[2];
//                        String[] td2 = trandt.split(ress);
//                        String tdt = td2[1];
//                        //
//                        String trt = csv[3];
//                        String[] trt2 = trt.split(ress);
//                        String ttyp = trt2[1];
//                        //
//
//                        // add to table list
//                        pats.add(new Reps(acct, tranamt, tdt, ttyp));
//
//                        //                        pats.add(tranamt);
//
//                        //                        pats.add(tranamt);
//                        // }
//
//                        // }
//
//
////                        trans.setLabel("Transaction Amount");
////                        trans.set("Event" + "" + cnt, tranamt);
//
//
//                    }
//                    i++;
//                    cnt++;
//                }
//                // model2.addSeries(trans);
//
//
//
//
//                //
//                ct1 = pats.size();
//            }
//
//
//
//
//        } catch (Exception e) {
//            e.getStackTrace();
//
//        }
// Read Report2
        // Get records from report file

        try {
           String fpath2 = "c:\\kriminofiles\\report2.txt";
            
            //

            //
            FileReader fileReader = new FileReader(fpath2);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines2 = new ArrayList<String>();
            String line2;
            //
            //

            pats2 = new ArrayList<Reps2>();
            //
            int i = 0, cnt = 1;
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
                    String[] statt = stat.split(ress);
                    stat = statt[1];
                    //
                    String damt = csv[3];
                    String[] da2 = damt.split(ress);
                   // int debitamt = Integer.parseInt(da2[1]);
                    String debitamt = da2[1];
                    //
                    String lim = csv[0];
                    String[] dac2 = lim.split(ress);
                    lim = dac2[1];
                    //
                    String bdate = csv[7];
                    String[] bd2 = bdate.split(ress);
                    bdate = bd2[1];
                    //
                    String dacct = csv[6];
                    String[] tf2 = dacct.split(ress);
                    dacct = tf2[1];
                    //
                    String cacc = csv[4];
                    String[] ca2 = cacc.split(ress);
                    cacc = ca2[1];
                    //
                    String ttype = csv[8];
                    String[] crb2 = ttype.split(ress);
                    ttype = crb2[1];
                    //
                    String staff2 = csv[1];
                    String[] stf = staff2.split(ress);
                    staff2 = stf[1];
                    //
//               tranamt += 1;
                    //


                    // add to table list
                    pats2.add(new Reps2(bdate, ttype, debitamt, dacct, cacc, lim, stat, staff2));
//                        pats.add(tranamt);

                    //
                    // }



                    //




                }
               
                //
                i++;
                cnt++;
            }
             trans2.setLabel("BOU Transfer");
                trans2.set("Bank of Uganda Transfers Event", pats2.size());
            model2.addSeries(trans2);
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
            FileReader fileReader = new FileReader(fpath3);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines3 = new ArrayList<String>();
            String line3;
            //
            //

            pats3 = new ArrayList<Reps3>();
            //
            int i = 0, cnt = 1;
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
                    String facct = csv[1];
                    String[] fac2 = facct.split(ress);
                    String froacct = fac2[1];
                    //
                    String tstat = csv[0];
                    String[] tr3 = tstat.split(ress);
                    tstat = tr3[1];
                    //

                    String tamt = csv[6];
                    String[] tra = tamt.split(ress);
             //       int tamt2 = Integer.parseInt(tra[1]);
                     String tamt2 = tra[1];
                    //

                    String tacct = csv[3];
                    String[] tacct3 = tacct.split(ress);
                    String toacct = tacct3[1];
                    //
                    String trdt = csv[4];
                    String[] trdt3 = trdt.split(ress);
                    String trdate = trdt3[1];
                    //
                    String wplan = csv[5];
                    String[] fbnk3 = wplan.split(ress);
                    wplan = fbnk3[1];
                    //
                    String fbnk = csv[5];
                    String[] cam = fbnk.split(ress);
                    //int camt = Integer.parseInt(cam[1]);
                    String camt = cam[1];
                    //

//               tranamt += 1;
                    //


                    // add to table list
                    pats3.add(new Reps3(froacct, tamt2, tstat, toacct, trdate, wplan, camt));
                    //




                }
               
                //
                i++;
                cnt++;
            }
             trans3.setLabel("Account Transfers");
                trans3.set("Payments Event", pats3.size());
            model2.addSeries(trans3);
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
            FileReader fileReader = new FileReader(fpath4);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines4 = new ArrayList<String>();
            String line4;
            //
            //

            pats4 = new ArrayList<Reps4>();
            //
            int i = 0, cnt = 1;
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
                    pats4.add(new Reps4(incometype, incdes, netinc, incomeamt, incfreq));
                    //
//                    trans4.setLabel("Income Amount");
//                    trans4.set("Event" + "" + cnt, incomeamt);



                }
                i++;
                cnt++;
            }
//            model2.addSeries(trans4);
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
            FileReader fileReader = new FileReader(fpath5);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines5 = new ArrayList<String>();
            String line5;
            //
            //

            pats5 = new ArrayList<Reps5>();
            //
            int i = 0, cnt = 1;
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
                    pats5.add(new Reps5(asstype, sofunds, acqcost, makvalue, acdate));
//
//                    trans5.setLabel("Asset Value");
//                    trans5.set("Event" + "" + cnt, makvalue);



                }
                i++;
                cnt++;
            }
            //   model2.addSeries(trans5);
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
            FileReader fileReader = new FileReader(fpath6);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines6 = new ArrayList<String>();
            String line6;
            //
            //

            pats6 = new ArrayList<Reps6>();
            //
            int i = 0, cnt = 1;
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
                    pats6.add(new Reps6(tono, calldate, frono,tono));
                    //
                   



                }

                i++;
                cnt++;
            }
             trans6.setLabel("Phone Calls");
                    trans6.set("Phone  calls Event", pats6.size());

            model2.addSeries(trans6);
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
            FileReader fileReader = new FileReader(fpath8);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines8 = new ArrayList<String>();
            String line8;
            //
            //

            pats8 = new ArrayList<Reps8>();
            //
            int i = 0, cnt = 1;
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
                    String fname = csv[5];
                    String[] fn7 = fname.split(ress);
                    fname = fn7[1];
                    //
                    String cracct = csv[3];
                    String[] c7 = cracct.split(ress);
                    cracct = c7[1];
                    //
                    String dbacct = csv[2];
                    String[] db7 = dbacct.split(ress);
                    dbacct = db7[1];

                    String wpid = csv[1];
                    String[] wp7 = wpid.split(ress);
                    wpid = wp7[1];
                    //
                    String userlev = csv[0];
                    String[] us7 = userlev.split(ress);
                    userlev = us7[1];
                    //
                    String reqdt = csv[6];
                    String[] rdt7 = reqdt.split(ress);
                    reqdt = rdt7[1];
                    //
                    String usr = csv[4];
                    String[] usr7 = usr.split(ress);
                    usr = usr7[1];
                    //
                    String ent = csv[7];
                    String[] ent7 = ent.split(ress);
                    ent = ent7[1];
//               tranamt += 1;
                    //


                    // add to table list
                    pats8.add(new Reps8(fname, cracct, dbacct, wpid, reqdt, usr, userlev, ent));
                    //




                }
            
                i++;
                cnt++;
            }
                trans.setLabel("Funds Request");
                trans.set("Funds Request Event", pats8.size());

            model2.addSeries(trans);
            ct8 = pats8.size();
            bufferedReader.close();




        } catch (Exception e) {
            e.getStackTrace();

        }

//
        // get report11
        try {
            String fpath11 = "c:\\kriminofiles\\report11.txt";
            //

            //
            FileReader fileReader = new FileReader(fpath11);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines11 = new ArrayList<String>();
            String line11;
            //
            //

            pats11 = new ArrayList<Reps11>();
            //
            int i = 0, cnt = 1;
            while ((line11 = bufferedReader.readLine()) != null) {


                if (!lines11.contains(line11)) {
                    lines11.add(line11);
                    // assign text 
                    //  String res = "";
                    String ress = "[=]";
                    // int count1 = lines.size();

                    // for (int i = 0; i < count1; i++) {
                    // res = lines.get(i);
                    //    res = res + "\n" + lines.get(i);
                    String res2 = line11.substring(1, line11.length() - 1);
                    // split csv file
                    //  String csv = r
                    String delims = "[,]";
                    String[] csv = res2.split(delims);
                    //
                    String ed = csv[0];
                    String[] fn7 = ed.split(ress);
                    ed = fn7[1];
                    //
                    String reqid = csv[1];
                    String[] c7 = reqid.split(ress);
                    reqid = c7[1];
                    //


                    String srcadd = csv[3];
                    String[] wp7 = srcadd.split(ress);
                    srcadd = wp7[1];
                    //

                    //
                    String dadd = csv[5];
                    String[] rdt7 = dadd.split(ress);
                    dadd = rdt7[1];
                    //
                    String eid = csv[2];
                    String[] ei = eid.split(ress);
                    eid = ei[1];
//               tranamt += 1;
                    //


                    // add to table list
                    pats11.add(new Reps11(ed, reqid, eid, srcadd, dadd));
                    //
                   




                }
 
                i++;
                cnt++;
            }
            translim.setLabel("Emails");
                    translim.set("Emails Event" + "" + cnt, pats11.size());
              model2.addSeries(translim);
            ct11 = pats11.size();
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
            FileReader fileReader = new FileReader(fpath12);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines12 = new ArrayList<String>();
            String line12;
            //
            //

            pats12 = new ArrayList<Reps12>();
            //
            int i = 0, cnt = 1;
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
                    pats12.add(new Reps12(ent, accno, per, src, amt2));
                    //
//                    trans6.setLabel("Phone Calls");
//                    trans6.set("Event" + "" + cnt, tono);




                }

                i++;
                cnt++;
            }
            //   model2.addSeries(trans6);
            ct12 = pats12.size();
            bufferedReader.close();





            //


        } catch (Exception e) {
            e.getStackTrace();

        }

        //
        try {
            String fppath = "c:\\kriminofiles\\params.txt";
            //

            //
            FileReader fileReaderp = new FileReader(fppath);

            BufferedReader bufferedReaderp = new BufferedReader(fileReaderp);
            ArrayList<String> linesp = new ArrayList<String>();
            String linep;
            //

            //
            // int i = 0, cnt = 1;
            while ((linep = bufferedReaderp.readLine()) != null) {

                linesp.add(linep);
                // assign text 

                String ressp = "[,]";

                String resp = linesp.get(0);
                // split csv file

                String[] csvp = resp.split(ressp);
                //
                bgamt = Integer.parseInt(csvp[0]);
                pamt = Integer.parseInt(csvp[1]);
                inamt = Integer.parseInt(csvp[2]);
                assetval = Integer.parseInt(csvp[3]);
                //     String calldt = csvp[4];
//               

                // ct1 = pats.size();

                // close file stream
                bufferedReaderp.close();
                //
                // call budget amt from mainbean
//                transb.setLabel("Budget Check Amount");
//                transb.set("BValue", bgamt);
//                model2.addSeries(transb);
                // ct2 = pats2.size();


                // transaction check value
//                translim.setLabel("Transaction Check Value");
//                translim.set("TValue", pamt);
//                model2.addSeries(translim);

                //
//                // Income Amount series
//                transinamt.setLabel("Income Check Value");
//                transinamt.set("IValue", inamt);
//                model2.addSeries(transinamt);
//                // Income Amount
//                transassetval.setLabel("Asset Check Value");
//                transassetval.set("AValue", assetval);
//                model2.addSeries(transassetval);

            }






        } catch (Exception e) {
            e.getStackTrace();

        }

    }
//    public int getCount1() {
//        
//        return count1;
//    }
//
//    public void setCount1(int count1) {
//        this.count1 = count1;
//    }
//
//    public int getCount2() {
//        return count2;
//    }
//
//    public void setCount2(int count2) {
//        this.count2 = count2;
//    }
//
//    public int getCount3() {
//        return count3;
//    }
//
//    public void setCount3(int count3) {
//        this.count3 = count3;
//    }
//
//    public int getCount4() {
//        return count4;
//    }
//
//    public void setCount4(int count4) {
//        this.count4 = count4;
//    }
//
//    public int getCount5() {
//        return count5;
//    }
//
//    public void setCount5(int count5) {
//        this.count5 = count5;
//    }
//
//    public int getCount6() {
//        return count6;
//    }
//
//    public void setCount6(int count6) {
//        this.count6 = count6;
//    }
//
//    public int getTotcnt() {
//        return totcnt;
//    }
//
//    public void setTotcnt(int totcnt) {
//        this.totcnt = totcnt;
//    }
//

    public String getCntmsg1() {
        if (ct1 >= 1) {
            cntmsg1 = ct1 + "" + "- Record(s) Found Matching Pattern (Event Name - Transactions Event)";
        } else {
            cntmsg1 = "No Record(s) Matching Pattern (Event Name - Transactions Event)";
        }
        return cntmsg1;
    }

    public String getCntmsg2() {
        if (ct2 >= 1) {
            cntmsg2 = ct2 + "" + "- Record(s) Found  (Bank of Uganda Transfers Event - Pattern Match)";
        } else {
            cntmsg2 = "No Record(s) Found (Bank of Uganda Transfers Event - No Pattern Match)";
        }

        return cntmsg2;
    }

    public String getCntmsg3() {
        if (ct3 >= 1) {
            cntmsg3 = ct3 + "" + "- Record(s) Found (Account Transfers Event - Pattern Match)";
        } else {
            cntmsg3 = "No Record(s) Found(Account Transfers Event - No Pattern Match)";
        }
        return cntmsg3;
    }

    public String getCntmsg4() {
        if (ct4 >= 1) {
            cntmsg4 = ct4 + "" + "- Record(s) Found Matching Pattern (Event Name - Personal Income Event)";
        } else {
            cntmsg4 = "No Record(s) Matching Pattern (Event Name - Personal Income Event)";
        }
        return cntmsg4;
    }

    public String getCntmsg5() {
        if (ct5 >= 1) {
            cntmsg5 = ct5 + "" + "- Record(s) Found Matching Pattern (Event Name - Personal Assets Event)";
        } else {
            cntmsg5 = "No Record(s) Matching Pattern (Event Name - Personal Assets Event)";
        }
        return cntmsg5;
    }

    public String getCntmsg6() {
        if (ct6 >= 1) {
            cntmsg6 = ct6 + "" + "- Record(s) Found  (Phone calls Event - No Pattern Match)";
        } else {
            cntmsg6 = "No Record(s) Found(Phone Calls  Event - Pattern  Match)";
        }
        return cntmsg6;
    }
//

    public int getTotcnt() {
        int tot = ct8 + ct2 + ct3 + ct6 + ct11;
        totcnt = totcnt + tot;
        return totcnt;
    }

    public int getTotp() {

        if (ct11 >= 1) {
            perc11 = 0;

        } else {
            perc11 = 1;
        }
        if (ct2 >= 1) {
            perc2 = 1;

        } else {
            perc2 = 0;
        }
        if (ct3 >= 1) {
            perc3 = 1;

        } else {
            perc3 = 0;
        }

        if (ct6 >= 1) {
            perc6 = 0;

        } else {
            perc6 = 1;
        }
        if (ct8 >= 1) {
            perc8 = 1;

        } else {
            perc8 = 0;
        }
        //
        totp = perc11 + perc2 + perc3 + perc6 + perc8;
        return totp;
    }

    public void setTotp(int totp) {
        this.totp = totp;
    }

//    public int getTotperc() {
//
//        //
//        if (totp == 0) {
//            totperc = 0;
//        } else {
//            totperc = totp/totn;
//        }
//        return totperc;
//    }
    public double getTotn() {
        totn2 = (int) totn;
        return totn2;
    }
    //chart

    public double getTotperc() {
        if (totp == 0) {
            totperc = 0;
        } else {
            totperc = ((float) totp / (float) totn) * 100;
            tperc = (int) totperc;
        }
        return tperc;
    }

//    public CartesianChartModel getModel() {
//        return model;
//    }
    // open files
}
