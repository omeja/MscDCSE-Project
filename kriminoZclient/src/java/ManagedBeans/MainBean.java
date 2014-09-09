/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Report.Reps11;
import Report.Reps2;
import Report.Reps3;
import Report.Reps6;
import Report.Reps8;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Osbert
 */
@ManagedBean
@SessionScoped
//@ViewScoped
@RequestScoped
public class MainBean implements Serializable {
    //
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.BLUE);
    private static Font red = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    //
    private String sfile = "c:\\kriminofiles\\cases.txt";
    File sf = new File(sfile);
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
    //private String fspath = "c:\\kriminofiles\\symbols.txt";
    private String csno;
    private int marker;
    private int counter2;
    private ArrayList<String> pats11;
//
    //
    private ArrayList[] listf;
    private int xy;
    private int ik;
    private Document document;
    private int number;
    private String tpats;
    private String tpats2;
    private String tpats12;
    private String tpats8;
    private String tpats6;
    private String tpats5;
    private String tpats4;
    private String tpats3;
    private String ts;
    private String frs;
    private String mrs;
//
    private String clr;

    public String getClr() {
        File csfile = new File("c:\\kriminofiles\\cases.txt");
        if (csfile.exists()) {
            csfile.delete();
        }

        return "Case File Reset succesfully";
    }
    //
    private String userlev;
    private String wp1;
    private String accstat;
    private String suserlev;
    private String swp1;
    private String saccstat;
    private String limsymb;
    private String statsymb;
    private String status;
    private String reqsymb;
    private String request2;
//    private ArrayList<Object> pats11;
    private String tpats11;
    private int ct11;
    //  private ArrayList<Object> pats11;
    private boolean limsymb2;
    private int lim2;
    private int debitamt;
    private String stat;
    private ArrayList<Reps2> pats22;
    private ArrayList<Reps3> pats33;
    private ArrayList<Reps6> pats66;
    private ArrayList<Reps11> pats111;
    private ArrayList<Reps8> pats77;
    private int count = 0;
    private String parampath;
    private String sympath;
    // chart
    private CartesianChartModel model2;
//
    ChartSeries trans2 = new ChartSeries();
    ChartSeries trans3 = new ChartSeries();
    ChartSeries trans6 = new ChartSeries();
    ChartSeries trans7 = new ChartSeries();
    ChartSeries trans11 = new ChartSeries();
    ChartSeries transtot = new ChartSeries();
    // parametr series
    ChartSeries transperc = new ChartSeries();
    //

    public CartesianChartModel getModel2() {
        return model2;
    }

    public void setModel2(CartesianChartModel model2) {
        this.model2 = model2;
    }

    //
    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment(ActionEvent event) {
        count++;
    }

    public ArrayList<Reps2> getPats22() {
        return pats22;
    }

    public void setPats22(ArrayList<Reps2> pats22) {
        this.pats22 = pats22;
    }

    public ArrayList<Reps3> getPats33() {
        return pats33;
    }

    public void setPats33(ArrayList<Reps3> pats33) {
        this.pats33 = pats33;
    }

    public ArrayList<Reps6> getPats66() {
        return pats66;
    }

    public void setPats66(ArrayList<Reps6> pats66) {
        this.pats66 = pats66;
    }

    public ArrayList<Reps11> getPats111() {
        return pats111;
    }

    public void setPats111(ArrayList<Reps11> pats111) {
        this.pats111 = pats111;
    }

    public ArrayList<Reps8> getPats77() {
        return pats77;
    }

    public void setPats77(ArrayList<Reps8> pats77) {
        this.pats77 = pats77;
    }

    public String getRequest2() {
        return request2;
    }

    public void setRequest2(String request2) {
        this.request2 = request2;
    }

    public String getReqsymb2() {
        return reqsymb2;
    }

    public void setReqsymb2(String reqsymb2) {
        this.reqsymb2 = reqsymb2;
    }
    private String reqsymb2;

    public String getReqsymb() {
        return reqsymb;
    }

    public void setReqsymb(String reqsymb) {
        this.reqsymb = reqsymb;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    private String request;

    public String getStatsymb() {
        return statsymb;
    }

    public void setStatsymb(String statsymb) {
        this.statsymb = statsymb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLimsymb() {
        return limsymb;
    }

    public void setLimsymb(String limsymb) {
        this.limsymb = limsymb;
    }

    public String getCfile12() {
        return cfile12;
    }

    public void setCfile12(String cfile12) {
        this.cfile12 = cfile12;
    }

    public String getSaccstat() {
        return saccstat;
    }

    public void setSaccstat(String saccstat) {
        this.saccstat = saccstat;
    }

    public String getSwp1() {
        return swp1;
    }

    public void setSwp1(String swp1) {
        this.swp1 = swp1;
    }

    public String getSuserlev() {
        return suserlev;
    }

    public void setSuserlev(String suserlev) {
        this.suserlev = suserlev;
    }

    public String getAccstat() {
        return accstat;
    }

    public void setAccstat(String accstat) {
        this.accstat = accstat;
    }

    public String getCfile14() {
        return cfile14;
    }

    public void setCfile14(String cfile14) {
        this.cfile14 = cfile14;
    }

    public String getWp1() {
        return wp1;
    }

    public void setWp1(String wp1) {
        this.wp1 = wp1;
    }

    public String getUserlev() {
        return userlev;
    }

    public void setUserlev(String userlev) {
        this.userlev = userlev;
    }
    //

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
    //
    //
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
    private int totcnt;

    public int getTotcnt() {
        return totcnt;
    }

    public void setTotcnt(int totcnt) {
        this.totcnt = totcnt;
    }
    //
    private int ct22, ct33, ct66, ct77, ct111;
    private int totp = 0;
    private int totn2;
    private int tperc;
    private int totn = 5;
    private double totperc;
    private String cntmsg8, cntmsg2, cntmsg3, cntmsg6, cntmsg11;
    private int perc111;
    private int perc22;
    private int perc33;
    private int perc66;
    private int perc77;
    //
    //
    // Add Persistence
    @PersistenceUnit
    EntityManagerFactory emf;
    //   EntityManagerFactory emf1;
    //  EntityManagerFactory emf2;
    //

    public void compute() {
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

            while (((lin = bufferedReaderc.readLine()) != null)) {
//if (lin.startsWith("CPS001")){

                caseNo = lin;

//if (caseNo ==null){
//    caseNo = csno;
//
//}
//}

                //         pats2 = new ArrayList<String>();
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
                // csv paths
                String p11 = "C:\\kriminofiles\\report11.csv";
                String p2 = "C:\\kriminofiles\\report2.csv";

                String p3 = "C:\\kriminofiles\\report3.csv";
                String p6 = "C:\\kriminofiles\\report6.csv";
                String p7 = "C:\\kriminofiles\\report7.csv";
//
                File f11 = new File(p11);
                File f22 = new File(p2);
                File f33 = new File(p3);
                File f66 = new File(p6);
                File f77 = new File(p7);


                // Delete
                f11.delete();
                f22.delete();
                f33.delete();
                f66.delete();
                f77.delete();
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
                //   fileTemp9.delete();
                // fileTemp10.delete();
                // }
// write headers

                if ((userlev != null) || (suserlev != null)) {

                    File sym = new File("c:\\kriminofiles\\symbols.txt");
                    sym.delete();
                    //
                    File pr = new File("c:\\kriminofiles\\params.txt");
                    pr.delete();
                }

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
                        //
                        Date dt = new Date();

                        long phdt = dt.getTime();


                        cfile = callid + "," + casecode1 + "," + calldate + "," + froNo + "," + toNo + "," + requestID;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath, true);
                        //
                        FileWriter writer2 = new FileWriter(fp, true);
//                writer.append("FromNo");
//                writer.append(',');
//                writer.append("ToNo");
//                writer.append('\n');
                        double s1 = ftp.length();
                        double s2 = fileTemp.length();
                        if ((idx == 0)) {
                            String phonehdr = "callid" + "," + "ccode1" + "," + "calldate" + "," + "frono" + "," + "tono" + "," + "reqid";


                            if ((s1 <= 0) && (s2 <= 0)) {
                                writer.append(phonehdr);
                                //
                                writer2.append(phonehdr);
                            }
                        }
                        writer.append('\n');
                        writer.append(cfile);
                        writer.append('\n');
                        writer.flush();
                        writer.close();
//
                        writer2.append('\n');
                        writer2.append(cfile);
                        writer2.append('\n');
// copy to classpath


                        //Files.copy(filepath, classp,Boolean.TRUE);

                        //

                        //generate whatever data you want


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
                        Date dt = new Date();
                        //  String pdt = dt.toString();
                        //convert to long
                        // SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
                        // String pdt = f.format(dt);
                        // Date d = f.parse(pdt);
                        Long phdt2 = dt.getTime();
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
                        double b1 = ftp1.length();
                        double b2 = fileTemp2.length();

                        if ((idxx == 0)) {
                            if ((b1 <= 0) && (b2 <= 0)) {
                                String txnhdr = "tranid" + "," + "ccode2" + ","
                                        + "transdate" + "," + "transcode" + ","
                                        + "transamount" + "," + "transtype" + "," + "transaccount";
                                writer.append(txnhdr);
                                //
                                writer2.append(txnhdr);
                            }
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
                        int tramount = Integer.decode(item2.getTamount().toString());
                        String froAcct = item2.getFroaccount();
                        String toAcct = item2.getToaccount();
                        String frobnk = item2.getFrobank();
                        String tobnk = item2.getTobank();
                        String wkplanid = item2.getWrkplanid().getWorkPlanCode();
                        int contrid = Integer.decode(item2.getContractid().getContractAmt().toString());
                        String Taskid = item2.getTaskid().getStatus();
                        //
                        Date dt = new Date();
                        //  String pdt = dt.toString();
                        //convert to long
                        // SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
                        // String pdt = f.format(dt);
                        // Date d = f.parse(pdt);
                        long phdt3 = dt.getTime();
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
                        double c1 = ftp2.length();
                        double c2 = fileTemp3.length();
                        if ((idxxx == 0)) {
                            if ((c1 <= 0) && (c2 <= 0)) {
                                String tfhdr = "tfid" + "," + "ccode3" + ","
                                        + "tdate" + "," + "tamount" + ","
                                        + "tfroacct" + "," + "ttoacct" + "," + "frobank" + "," + "ttobank"
                                        + "," + "wkplanid" + "," + "contrid" + "," + "Taskid";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        int debitamt2 = item3.getDebitamount();
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
//
                        Date dt = new Date();

                        long phdt5 = dt.getTime();
                        //
                        // create csv file from entity/database
                        cfile4 = bid + "," + bdate + "," + transfertype + "," + debitacct + ","
                                + debitacctname + "," + debitamt2 + "," + crbank + "," + cracct
                                + "," + bankstaff + "," + govtstaff + "," + ccode4 + ","
                                + itemcode + "," + astatus + "," + limit;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath5, true);
//
                        FileWriter writer2 = new FileWriter(fp3, true);
                        double d1 = ftp3.length();
                        double d2 = fileTemp5.length();
                        if ((idxxxx == 0)) {
                            if ((d1 <= 0) && (d2 <= 0)) {
                                String tfhdr = "idbou" + "," + "bdate" + ","
                                        + "transfertype" + "," + "debitacctno" + ","
                                        + "debitacctname" + "," + "debitamount" + "," + "creditbank" + "," + "creditacct"
                                        + "," + "bankstaffid" + "," + "govtstaffid" + "," + "casecode" + "," + "budgetamt"
                                        + "," + "status" + "," + "limits";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt4 = dt.getTime();
                        // symbol = item.getToNo();
                        //  price = 9.5;
                        // create csv file from entity/database
                        cfile5 = assetid + "," + assettype + "," + marketval + "," + acqdate + ","
                                + acqcost + "," + acqmode + "," + acqsource + "," + ccode5;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath8, true);
//
                        FileWriter writer2 = new FileWriter(fp6, true);
                        double e1 = ftp6.length();
                        double e2 = fileTemp8.length();
                        if ((id5 == 0)) {
                            if ((e1 <= 0) && (e2 <= 0)) {
                                String tfhdr = "assetcode" + "," + "assettype" + ","
                                        + "marketvalue" + "," + "acquiredate" + ","
                                        + "acquirecost" + "," + "acquiremode" + "," + "sourceoffunds"
                                        + "," + "casecode";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt6 = dt.getTime();
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
                        double f1 = ftp5.length();
                        double f2 = fileTemp7.length();
                        if ((id6 == 0)) {
                            if ((f1 <= 0) && (f2 <= 0)) {
                                String tfhdr = "itemno" + "," + "description" + ","
                                        + "incometype" + "," + "frequency" + ","
                                        + "amount" + "," + "casecode";
                                writer.append(tfhdr);
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt12 = dt.getTime();
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
                        double g1 = ftp4.length();
                        double g2 = fileTemp6.length();
                        if ((id7 == 0) && (marker == 0)) {
                            if ((g1 <= 0) && (g2 <= 0)) {
                                String tfhdr = "entity" + "," + "period" + ","
                                        + "amount" + "," + "source" + ","
                                        + "accno" + "," + "casecode";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        parampath = "c:\\kriminofiles\\params.txt";
                        sympath = "c:\\kriminofiles\\symbols.txt";
                        if ((userlev != null) || (suserlev != null)) {
//
                            //write parameter text file
                            String fparam = userlev + "," + wp1 + "," + accstat + "," + status + "," + request + "," + request2;
//            write to csv file

                            //    filepath3 = classp2;
//
                            String fsymbol = suserlev + "," + swp1 + "," + saccstat + "," + limsymb + "," + tfsymb + "," + statsymb + "," + reqsymb + "," + reqsymb2 + "," + caseNo;
//            write to csv file

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
                        //
                        double h1 = ftp6.length();
                        double h2 = fileTemp8.length();
                        if ((id8 == 0)) {
                            if ((h1 <= 0) && (h2 <= 0)) {
                                String tfhdr = "Acct" + "," + "Ent" + ","
                                        + "Accname" + "," + "status" + ","
                                        + "limit" + "," + "ccode8";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt9 = dt.getTime();
                        // create csv file from entity/database
                        cfile9 = contractid + "," + workplanid + "," + contractacct + "," + contractamt + ","
                                + contractor + "," + ccode9;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath12, true);
//
                        FileWriter writer2 = new FileWriter(fp12, true);
                        double j1 = ftp12.length();
                        double j2 = ftp122.length();
                        if ((id9 == 0)) {
                            if ((j1 <= 0) && (j2 <= 0)) {
                                String tfhdr = "contractid" + "," + "workplanid" + ","
                                        + "contractacct" + "," + "contractamt" + ","
                                        + "contractor" + "," + "ccode9";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt11 = dt.getTime();
                        // create csv file from entity/database
                        cfile10 = Emailid + "," + Emaildate + "," + sourceadd + "," + destadd + ","
                                + requestId + "," + ccode10;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath13, true);
//
                        FileWriter writer2 = new FileWriter(fp13, true);
                        double k1 = ftp13.length();
                        double k2 = ftp132.length();
                        if ((id10 == 0)) {
                            if ((k1 <= 0) && (k2 <= 0)) {
                                String tfhdr = "Emailid" + "," + "Emaildate" + ","
                                        + "sourceadd" + "," + "destadd" + ","
                                        + "requestId" + "," + "ccode10";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt7 = dt.getTime();
                        // create csv file from entity/database
                        cfile11 = filename + "," + dbAcct + "," + cracct + "," + reqdate + ","
                                + userid + "," + userlevel + "," + wrkid + "," + ccode11 + "," + Entcode;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath14, true);
//
                        FileWriter writer2 = new FileWriter(fp14, true);
                        double m1 = ftp14.length();
                        double m2 = ftp142.length();
                        if ((id11 == 0)) {
                            if ((m1 <= 0) && (m2 <= 0)) {
                                String tfhdr = "filename" + "," + "dbacct" + ","
                                        + "cracct" + "," + "reqdate" + ","
                                        + "userid" + "," + "userlevel" + "," + "wrkid" + "," + "ccode11" + "," + "entcode";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt10 = dt.getTime();
                        // create csv file from entity/database
                        cfile12 = Taskcode + "," + Taskname + "," + Status + "," + ccode12 + ","
                                + Contractcode;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath15, true);
//
                        FileWriter writer2 = new FileWriter(fp15, true);
                        double n1 = ftp15.length();
                        double n2 = ftp152.length();
                        if ((id12 == 0)) {
                            if ((n1 <= 0) && (n2 <= 0)) {
                                String tfhdr = "Taskcode" + "," + "Taskname" + ","
                                        + "Status" + "," + "ccode12" + ","
                                        + "Contractcode";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
                        Date dt = new Date();

                        long phdt8 = dt.getTime();
                        // create csv file from entity/database
                        cfile13 = Workplancode + "," + Amount + "," + ccode13 + "," + Desc + ","
                                + sdate + "," + edate + "," + Entcd;
//            write to csv file

                        FileWriter writer = new FileWriter(filepath16, true);
//
                        FileWriter writer2 = new FileWriter(fp16, true);
                        double t1 = ftp16.length();
                        double t2 = ftp162.length();
                        if ((id13 == 0)) {
                            if ((t1 <= 0) && (t2 <= 0)) {
                                String tfhdr = "Workplancode" + "," + "Amount" + ","
                                        + "ccode13" + "," + "Desc" + ","
                                        + "sdate" + ","
                                        + "edate" + "," + "Entcd";
                                writer.append(tfhdr);
                                //
                                writer2.append(tfhdr);
                            }
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
//                // Read Incoming Events
//                try {
//                    // Phone Calls
//
//                    fileReader = new FileReader(classp);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    String views = "\n";
//                    String view1;
//                    //
//                    //int i = 0, cnt = 1;
//                    while ((view1 = bufferedReader.readLine()) != null) {
//
//                        views = views + "" + view1 + eol;
//
//                    }
//                    vf = views;
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    // Transaction 
//
//                    fileReader = new FileReader(classp1);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    String views2 = "\n";
//                    String view2;
//                    //
//                    //int i = 0, cnt = 1;
//                    while ((view2 = bufferedReader.readLine()) != null) {
//
//                        views2 = views2 + "" + view2;
//                        System.out.println();
//                        vf1 = views2;
//                    }
//
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    // Transfers 
//
//                    fileReader = new FileReader(classp2);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    String views3 = "\n";
//                    String view3;
//                    //
//                    //int i = 0, cnt = 1;
//                    while ((view3 = bufferedReader.readLine()) != null) {
//
//                        views3 = views3 + "" + view3;
//                        System.out.println();
//                        vf2 = views3;
//                    }
//
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    // BOU
//
//                    fileReader = new FileReader(classp3);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    String views4 = "\n";
//                    String view4;
//                    //
//                    //int i = 0, cnt = 1;
//                    while ((view4 = bufferedReader.readLine()) != null) {
//
//                        views4 = views4 + "" + view4;
//                        System.out.println();
//                        vf3 = views4;
//                    }
//
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    // Income
//
//                    fileReader = new FileReader(classp5);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    String views5 = "\n";
//                    String view5;
//                    //
//                    //int i = 0, cnt = 1;
//                    while ((view5 = bufferedReader.readLine()) != null) {
//
//                        views5 = views5 + "" + view5;
//                        System.out.println();
//                        vf4 = views5;
//                    }
//
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    // Assets
//
//                    fileReader = new FileReader(classp6);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    String views6 = "\n";
//                    String view6;
//                    //
//                    //int i = 0, cnt = 1;
//                    while ((view6 = bufferedReader.readLine()) != null) {
//
//                        views6 = views6 + "" + view6;
//                        System.out.println();
//                        vf5 = views6;
//                    }
//
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
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
                    //typeMap.put("timestamp1", Long.class);
                    config.addEventType("Phonelogbean", typeMap);
// Event 2 - Transactions
                    Map typeMap2 = new HashMap();
                    typeMap2.put("tranid", String.class);
                    typeMap2.put("ccode2", String.class);
                    typeMap2.put("transdate", String.class);
                    typeMap2.put("transamount", String.class);
                    typeMap2.put("transcode", String.class);
                    typeMap2.put("transtype", String.class);
                    typeMap2.put("transaccount", String.class);
                    //  typeMap2.put("timestamp2", Long.class);
                    config.addEventType("Transactionbean", typeMap2);

// Event 3 - cash Transfers to suppliers/staff
                    Map typeMap3 = new HashMap();
                    typeMap3.put("tfid", String.class);
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
                    //typeMap3.put("timestamp3", Long.class);
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
                    //typeMap4.put("timestamp4", Long.class);
                    //
                    config.addEventType("Assetsbean", typeMap4);
                    // Event 5 - BOU transfers event
                    Map typeMap5 = new HashMap();
                    typeMap5.put("idbou", String.class);
                    typeMap5.put("bdate", String.class);
                    typeMap5.put("transfertype", String.class);
                    typeMap5.put("debitacctno", String.class);
                    typeMap5.put("debitacctname", String.class);
                    typeMap5.put("debitamount", String.class);
                    typeMap5.put("creditbank", String.class);
                    typeMap5.put("creditacct", String.class);
                    typeMap5.put("bankstaffid", String.class);
                    typeMap5.put("govtstaffid", String.class);
                    typeMap5.put("casecode", String.class);
                    typeMap5.put("budgetamt", String.class);
                    typeMap5.put("status", String.class);
                    typeMap5.put("limits", String.class);
                    //typeMap5.put("timestamp5", Long.class);
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
                    //typeMap6.put("timestamp6", Long.class);

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
                    //typeMap7.put("timestamp7", Long.class);

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
                    //typeMap8.put("timestamp8", Long.class);


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
                    //typeMap9.put("timestamp9", Long.class);
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
                    //typeMap10.put("timestamp10", Long.class);
                    //
                    //
                    config.addEventType("Activitybean", typeMap10);
                    //
                    // Event 11 - Email event
                    Map typeMap11 = new HashMap();
                    typeMap11.put("Emailid", String.class);
                    typeMap11.put("Emaildate", String.class);
                    typeMap11.put("sourceadd", String.class);
                    typeMap11.put("destadd", String.class);
                    typeMap11.put("requestId", String.class);
                    typeMap11.put("ccode10", String.class);
                    //typeMap11.put("timestamp11", Long.class);
                    //
                    //
                    config.addEventType("Emailbean", typeMap11);
                    // Event 11 - Email event
                    Map typeMap12 = new HashMap();
                    typeMap12.put("entity", String.class);
                    typeMap12.put("period", String.class);
                    typeMap12.put("amount", String.class);
                    typeMap12.put("source", String.class);
                    typeMap12.put("accno", String.class);
                    typeMap12.put("casecode", String.class);
                    //typeMap12.put("timestamp12", Long.class);
                    //
                    //
                    config.addEventType("Budgetbean", typeMap12);
                    //
                    EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

                    // if values null read from param and symbols txt files
                    if ((userlev == null) || (suserlev == null)) {
                        // get parameters
                        try {

                            fileReader = new FileReader(parampath);

                            bufferedReader = new BufferedReader(fileReader);
                            //
                            String line12;
                            //

                            while ((line12 = bufferedReader.readLine()) != null) {

                                String delims = "[,]";
                                String[] csv = line12.split(delims);
                                //
                                userlev = csv[0];

                                //
                                wp1 = csv[1];

                                //
                                accstat = csv[2];


                                status = csv[3];

                                //

                                //
                                request = csv[4];
                                //
                                request2 = csv[5];
                            }

                            bufferedReader.close();





                            //


                        } catch (Exception e) {
                            e.getStackTrace();

                        }
                        // get symbols                   
                        try {

                            fileReader = new FileReader(sympath);

                            bufferedReader = new BufferedReader(fileReader);
                            //
                            String line13;
                            //

                            while ((line13 = bufferedReader.readLine()) != null) {

                                String delims = "[,]";
                                String[] csv = line13.split(delims);
                                //
                                suserlev = csv[0];

                                //
                                swp1 = csv[1];

                                //
                                saccstat = csv[2];


                                limsymb = csv[3];

                                //

                                //
                                tfsymb = csv[4];
                                //
                                statsymb = csv[5];
                                //
                                reqsymb = csv[6];
                                //
                                reqsymb2 = csv[7];

                            }

                            bufferedReader.close();

                            //
                            if (suserlev.startsWith("Equal")) {
                                suserlev = "=";

                            } else {
                                suserlev = "!= ";

                            }
                            //     
                            if (swp1.startsWith("Equal")) {
                                swp1 = "=";

                            } else {
                                swp1 = "!= ";

                            }

                            //
                            if (saccstat.startsWith("Equal")) {
                                saccstat = "=";

                            }
                            //

                            //
                            if (limsymb.startsWith("Equal")) {
                                limsymb = "=";
                                limsymb2 = Boolean.getBoolean(limsymb);


                            } else if (limsymb.startsWith("Less")) {
                                limsymb = "<";
                                limsymb2 = Boolean.getBoolean(limsymb);
                            } else {
                                limsymb = ">";
                                limsymb2 = Boolean.getBoolean(limsymb);

                            }
//
                            if (tfsymb.startsWith("Equal")) {
                                tfsymb = "=";

                            } else if (tfsymb.startsWith("Less")) {
                                tfsymb = "<";

                            } else {
                                tfsymb = ">";

                            }
                            //
                            if (statsymb.startsWith("Equal")) {
                                statsymb = "=";

                            }
                            //
                            if (reqsymb.startsWith("Equal")) {
                                reqsymb = "=";

                            }
                            //
                            if (reqsymb2.startsWith("Equal")) {
                                reqsymb2 = "=";

                            }

                        } catch (Exception e) {
                            e.getStackTrace();

                        }

//


                    } else {
                        if (suserlev.startsWith("Equal")) {
                            suserlev = "=";

                        } else {
                            suserlev = "!= ";

                        }
                        //     
                        if (swp1.startsWith("Equal")) {
                            swp1 = "=";

                        } else {
                            swp1 = "!= ";

                        }

                        //
                        if (saccstat.startsWith("Equal")) {
                            saccstat = "=";

                        }
                        //

                        //
                        if (limsymb.startsWith("Equal")) {
                            limsymb = "=";
                            limsymb2 = Boolean.getBoolean(limsymb);


                        } else if (limsymb.startsWith("Less")) {
                            limsymb = "<";
                            limsymb2 = Boolean.getBoolean(limsymb);
                        } else {
                            limsymb = ">";
                            limsymb2 = Boolean.getBoolean(limsymb);

                        }
//
                        if (tfsymb.startsWith("Equal")) {
                            tfsymb = "=";

                        } else if (tfsymb.startsWith("Less")) {
                            tfsymb = "<";

                        } else {
                            tfsymb = ">";

                        }
                        //
                        if (statsymb.startsWith("Equal")) {
                            statsymb = "=";

                        }
                        //
                        if (reqsymb.startsWith("Equal")) {
                            reqsymb = "=";

                        }
                        //
                        if (reqsymb2.startsWith("Equal")) {
                            reqsymb2 = "=";

                        }
                    }
                    //

//                    if (suserlev.startsWith("Equal")) {
//                        suserlev = "=";
//
//                    } else {
//                        suserlev = "!= ";
//
//                    }
//                    //     
//                    if (swp1.startsWith("Equal")) {
//                        swp1 = "=";
//
//                    } else {
//                        swp1 = "!= ";
//
//                    }
//
//                    //
//                    if (saccstat.startsWith("Equal")) {
//                        saccstat = "=";
//
//                    }
//                    //
//
//                    //
//                    if (limsymb.startsWith("Equal")) {
//                        limsymb = "=";
//                        limsymb2 = Boolean.getBoolean(limsymb);
//
//
//                    } else if (limsymb.startsWith("Less")) {
//                        limsymb = "<";
//                        limsymb2 = Boolean.getBoolean(limsymb);
//                    } else {
//                        limsymb = ">";
//                        limsymb2 = Boolean.getBoolean(limsymb);
//
//                    }
////
//                    if (tfsymb.startsWith("Equal")) {
//                        tfsymb = "=";
//
//                    } else if (tfsymb.startsWith("Less")) {
//                        tfsymb = "<";
//
//                    } else {
//                        tfsymb = ">";
//
//                    }
//                    //
//                    if (statsymb.startsWith("Equal")) {
//                        statsymb = "=";
//
//                    }
//                    //
//                    if (reqsymb.startsWith("Equal")) {
//                        reqsymb = "=";
//
//                    }
//                    //
//                    if (reqsymb2.startsWith("Equal")) {
//                        reqsymb2 = "=";
//
//                    }


                    //
                    //
// Personal/company Account Transactions
//                    String expression1 = "select b.transdate,b.transtype,"
//                            + "b.transamount,"
//                            + "b.transaccount from pattern "
//                            + " [every (b=Transactionbean(b.transamount" + transymb2 + pamt + ")"
//                            + "and b=Transactionbean(b.transtype='CR') "
//                            + ")]";
                    //
//                    String expression1 = "select transdate,transtype,"
//                            + "transamount,"
//                            + "transaccount from "
//                            + " Transactionbean.win:time(10 seconds)"
//                            + " "
//                            + "";
                    // BOU Electronic Transfer Details
//                    String expression2 = "select "
//                            + "a.bdate,a.transfertype,"
//                            + "a.debitacctno,a.debitamount,"
//                            + "a.creditbank,a.creditacct,a.govtstaffid,a.status,a.limit2 from pattern"
//                            + " [every (a=Boubean(a.debitamount>" + bgamt + ")"
//                            + " "
//                            + ")]";
                    //
                    String expression2 = "select "
                            + "bdate,transfertype,"
                            + "debitacctno,debitamount,"
                            + "creditbank,creditacct,bankstaffid,status,limits from "
                            + " Boubean.win:length(1)"
                            + " where (debitamount " + limsymb + " limits) or (status " + saccstat + " " + "'" + accstat + "'" + ") "
                            + "";

                    //
                    // Personal/Company Account Transfer Details
//                    String expression3 = "select "
//                            + "c.tdate,c.tamount,"
//                            + "c.tfroacct,"
//                            + "c.ttoacct,c.wkplanid,c.contrid,c.Taskid from pattern"
//                            + " [every (c=Transferbean(c.tamount>" + tfamt + ")"
//                            + " "
//                            + ")]";
                    //


                    //
                    String expression3 = "select "
                            + "tdate,tamount,"
                            + "tfroacct,"
                            + "ttoacct,wkplanid,contrid,Taskid from "
                            + " Transferbean.win:time(10 seconds)"
                            + " where  (tamount " + tfsymb + " contrid) or (Taskid " + statsymb + " " + "'" + status + "'" + ")"
                            + "";
                    // Personal Income Details
//                    String expression4 = "select "
//                            + "d.description,d.incometype,"
//                            + "d.frequency,d.amount,"
//                            + "d.amount as NetIncome from pattern"
//                            + " [every (d=Incomebean(d.amount>" + inamt + ")"
//                            + " "
//                            + ")]";
                    //
//                    String expression4 = "select "
//                            + "description,incometype,"
//                            + "frequency,amount from "
//                            + " "
//                            + " Incomebean.win:time(10 seconds)";
                    // Personal Assets Details
//                    String expression5 = "select "
//                            + "e.assettype,e.marketvalue,"
//                            + "e.acquiredate,e.acquirecost,"
//                            + "e.sourceoffunds from pattern"
//                            + " [every (e=Assetsbean"
//                            + " "
//                            + ")]";
                    //
//                    String expression5 = "select "
//                            + "assettype,marketvalue,"
//                            + "acquiredate,acquirecost,"
//                            + "sourceoffunds from "
//                            + " Assetsbean.win:time(10 seconds)"
//                            + " "
//                            + "";
                    // Phone call Details
//                    String expression6 = "select "
//                            + "f.calldate,f.frono,"
//                            + "f.tono from pattern"
//                            + " [every (f=Phonelogbean "
//                            + " "
//                            + ")]";
                    String expression6 = "select calldate,frono,tono,reqid "
                            + "from "
                            + " Phonelogbean.win:time(10 seconds) "
                            + " where reqid " + reqsymb + " " + "'" + request + "'"
                            + "";
                    //

                    // Request Details
//                    String expression7 = "select "
//                            + "g.filename,g.dbacct,"
//                            + "g.cracct,g.reqdate,"
//                            + "g.userid,g.userlevel,g.wrkid,g.entcode"
//                            + " from pattern"
//                            + " [every (g=Requestbean(g.userlevel != 'senior-level' ) "
//                            + " "
//                            + ")]";
                    //
                    String expression7 = "select "
                            + "filename,dbacct,"
                            + "cracct,reqdate,"
                            + "userid,userlevel,wrkid,entcode"
                            + " from "
                            + " Requestbean.win:time(10 seconds) "
                            + " where userlevel " + suserlev + " " + "'" + userlev + "' "
                            + "";
                    // Workplan Details
//                    String expression8 = "select t.Workplancode,t.Amount "
//                            + " from pattern"
//                            + " [every(t=Workplanbean)]";
                    //
//                    String expression8 = "select Workplancode,Amount "
//                            + " from "
//                            + " Workplanbean.win:time(10 seconds)";
                    // Contract Details
//                    String expression9 = "select "
//                            + "i.contractid,i.workplanid,i.contractacct,i.contractamt,"
//                            + "i.contractor,i.ccode9"
//                            + ""
//                            + " from pattern"
//                            + " [every (i=Contractbean "
//                            + " "
//                            + ")]";
                    //
//                    String expression9 = "select "
//                            + "contractid,workplanid,contractacct,contractamt,"
//                            + "contractor,ccode9"
//                            + ""
//                            + " from "
//                            + " Contractbean.win:time(10 seconds) "
//                            + " "
//                            + "";
                    // Activity Details
//                    String expression10 = "select "
//                            + "j.Taskcode,j.Taskname,"
//                            + "j.Status,j.ccode12,"
//                            + "j.Contractcode"
//                            + " from pattern"
//                            + " [every (j=Activitybean "
//                            + " "
//                            + ")]";
                    //
//                    String expression10 = "select "
//                            + "Taskcode,Taskname,"
//                            + "Status,ccode12,"
//                            + "Contractcode"
//                            + " from "
//                            + " Activitybean.win:time(10 seconds) "
//                            + " "
//                            + "";
                    // emails
//                    String expression11 = "select "
//                            + "k.Emailid,k.Emaildate,"
//                            + "k.sourceadd,k.destadd,"
//                            + "k.requestId,k.ccode10"
//                            + " from pattern"
//                            + " [every (k=Emailbean "
//                            + " "
//                            + ")]";
                    //
                    String expression11 = "select "
                            + "Emailid,Emaildate,"
                            + "sourceadd,destadd,"
                            + "requestId,ccode10"
                            + " from "
                            + " Emailbean.win:time(10 seconds) "
                            + " where requestId " + reqsymb2 + " " + "'" + request2 + "'" + " "
                            + "";

                    // emails
//                    String expression12 = "select "
//                            + "o.entity,o.period,"
//                            + "o.amount,o.source,"
//                            + "o.accno,o.casecode"
//                            + " from pattern"
//                            + " [every (o=Budgetbean "
//                            + " "
//                            + ")]";
                    //
//                    String expression12 = "select "
//                            + "entity,period,"
//                            + "amount,source,"
//                            + "accno,casecode"
//                            + " from "
//                            + " Budgetbean.win:time(10 seconds)  "
//                            + " "
//                            + "";
                    // Expressions
                    // String exp = expression1;
                    String exp2 = expression2;
                    String exp3 = expression3;
                    // String exp4 = expression4;
                    // String exp5 = expression5;
                    String exp6 = expression6;
                    String exp7 = expression7;
                    // String exp8 = expression8;
                    // String exp9 = expression9;
                    // String exp10 = expression10;
                    String exp11 = expression11;
                    // String exp12 = expression12;

                    // statements

                    // EPStatement statement = epService.getEPAdministrator().createEPL(exp);
                    EPStatement statement2 = epService.getEPAdministrator().createEPL(exp2);
                    EPStatement statement3 = epService.getEPAdministrator().createEPL(exp3);
//                    EPStatement statement4 = epService.getEPAdministrator().createEPL(exp4);
//                    EPStatement statement5 = epService.getEPAdministrator().createEPL(exp5);
                    EPStatement statement6 = epService.getEPAdministrator().createEPL(exp6);
                    EPStatement statement7 = epService.getEPAdministrator().createEPL(exp7);
                    // EPStatement statement8 = epService.getEPAdministrator().createEPL(exp8);
                    // EPStatement statement9 = epService.getEPAdministrator().createEPL(exp9);
                    // EPStatement statement10 = epService.getEPAdministrator().createEPL(exp10);
                    EPStatement statement11 = epService.getEPAdministrator().createEPL(exp11);
                    // EPStatement statement12 = epService.getEPAdministrator().createEPL(exp12);
// New Listeners
                    //  CEPListener listener = new CEPListener();
                    CEPListener2 listener2 = new CEPListener2();
                    CEPListener3 listener3 = new CEPListener3();
//                    CEPListener4 listener4 = new CEPListener4();
//                    CEPListener5 listener5 = new CEPListener5();
                    CEPListener6 listener6 = new CEPListener6();
                    CEPListener7 listener7 = new CEPListener7();
//                    CEPListener8 listener8 = new CEPListener8();
//                    CEPListener9 listener9 = new CEPListener9();
//                    CEPListener10 listener10 = new CEPListener10();
                    CEPListener11 listener11 = new CEPListener11();
                    // CEPListener12 listener12 = new CEPListener12();
                    //
                    // Add Listeners
                    //  statement.addListener(listener);
                    statement2.addListener(listener2);
                    statement3.addListener(listener3);
//                    statement4.addListener(listener4);
//                    statement5.addListener(listener5);
                    statement6.addListener(listener6);
                    statement7.addListener(listener7);
//                    statement8.addListener(listener8);
//                    statement9.addListener(listener9);
//                    statement10.addListener(listener10);
                    statement11.addListener(listener11);
                    // statement12.addListener(listener12);

                    /*
                     * publish events from csv file
                     */
                    File f1 = new File(classp);
                    if (f1.exists()) {
                        AdapterInputSource adapterInputSource1 = new AdapterInputSource("/javabeans/phonelogs.csv");
                        (new CSVInputAdapter(epService, adapterInputSource1, "Phonelogbean")).start();
                    }
                    //
//                    CSVInputAdapterSpec inputOne = new CSVInputAdapterSpec(adapterInputSource1, "Phonelogbean");
//                    // inputOne.setTimestampColumn("timestamp1");
//                    inputOne.setLooping(false);

//                    AdapterInputSource adapterInputSource2 = new AdapterInputSource("/javabeans/transactionlogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource2, "Transactionbean")).start();
//            //

//                    CSVInputAdapterSpec inputTwo = new CSVInputAdapterSpec(adapterInputSource2, "Transactionbean");
//                    //     inputTwo.setTimestampColumn("timestamp2");
//                    inputTwo.setLooping(false);
////
//            //
                    File f2 = new File(classp2);
                    if (f2.exists()) {
                        AdapterInputSource adapterInputSource3 = new AdapterInputSource("/javabeans/transferlogs.csv");
                        (new CSVInputAdapter(epService, adapterInputSource3, "Transferbean")).start();
                    }
////
//                    CSVInputAdapterSpec inputThree = new CSVInputAdapterSpec(adapterInputSource3, "Transferbean");
//                    // inputThree.setTimestampColumn("timestamp3");
//                    inputThree.setLooping(false);
////////
//            //
//                    AdapterInputSource adapterInputSource4 = new AdapterInputSource("/javabeans/assetlogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource4, "Assetsbean")).start();
//            //
//                    CSVInputAdapterSpec inputfour = new CSVInputAdapterSpec(adapterInputSource4, "Assetsbean");
//                    // inputfour.setTimestampColumn("timestamp4");
//                    inputfour.setLooping(false);
//            //
                    File f3 = new File(classp3);
                    if (f3.exists()) {
                        AdapterInputSource adapterInputSource5 = new AdapterInputSource("/javabeans/boulogs.csv");
                        (new CSVInputAdapter(epService, adapterInputSource5, "Boubean")).start();
                    }
//            //
//                    CSVInputAdapterSpec inputfive = new CSVInputAdapterSpec(adapterInputSource5, "Boubean");
//                    //  inputfive.setTimestampColumn("timestamp5");
//                    inputfive.setLooping(false);
//            //
//                    AdapterInputSource adapterInputSource6 = new AdapterInputSource("/javabeans/incomelogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource6, "Incomebean")).start();
//            //
//                    CSVInputAdapterSpec inputsix = new CSVInputAdapterSpec(adapterInputSource6, "Incomebean");
//                    //  inputsix.setTimestampColumn("timestamp6");
//                    inputsix.setLooping(false);
                    // Added
                    File f4 = new File(classp14);
                    if (f4.exists()) {
                        AdapterInputSource adapterInputSource7 = new AdapterInputSource("/javabeans/Requestlogs.csv");
                        (new CSVInputAdapter(epService, adapterInputSource7, "Requestbean")).start();
                    }
//            //
//                    CSVInputAdapterSpec inputseven = new CSVInputAdapterSpec(adapterInputSource7, "Requestbean");
//                    //  inputseven.setTimestampColumn("timestamp7");
//                    inputseven.setLooping(false);
//                    //
//                    AdapterInputSource adapterInputSource8 = new AdapterInputSource("/javabeans/Workplanlogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource8, "Workplanbean")).start();
//            //
//                    CSVInputAdapterSpec inputeight = new CSVInputAdapterSpec(adapterInputSource8, "Workplanbean");
//                    //inputeight.setTimestampColumn("timestamp8");
//                    inputeight.setLooping(false);
                    //
//                    AdapterInputSource adapterInputSource9 = new AdapterInputSource("/javabeans/contractlogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource9, "Contractbean")).start();
//            //
//                    CSVInputAdapterSpec inputnine = new CSVInputAdapterSpec(adapterInputSource9, "Contractbean");
//                    // inputnine.setTimestampColumn("timestamp9");
//                    inputnine.setLooping(false);
                    //
//                    AdapterInputSource adapterInputSource10 = new AdapterInputSource("/javabeans/Tasklogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource10, "Activitybean")).start();
//            //
//                    CSVInputAdapterSpec inputten = new CSVInputAdapterSpec(adapterInputSource10, "Activitybean");
//                    //  inputten.setTimestampColumn("timestamp10");
//                    inputten.setLooping(false);
                    //
                    File f5 = new File(classp13);
                    if (f5.exists()) {
                        AdapterInputSource adapterInputSource11 = new AdapterInputSource("/javabeans/Emaillogs.csv");
                        (new CSVInputAdapter(epService, adapterInputSource11, "Emailbean")).start();
                    }
//            //
//                    CSVInputAdapterSpec inputeleven = new CSVInputAdapterSpec(adapterInputSource11, "Emailbean");
//                    //inputeleven.setTimestampColumn("timestamp11");
//                    inputeleven.setLooping(false);
                    //
//                    AdapterInputSource adapterInputSource12 = new AdapterInputSource("/javabeans/budgetlogs.csv");
//                    (new CSVInputAdapter(epService, adapterInputSource12, "Budgetbean")).start();
                    //
//                    CSVInputAdapterSpec inputtwelve = new CSVInputAdapterSpec(adapterInputSource12, "Budgetbean");
//                    // inputtwelve.setTimestampColumn("timestamp12");
//                    inputtwelve.setLooping(false);
                    //
                    //

                    //
//                    AdapterCoordinator coordinator = new AdapterCoordinatorImpl(epService, true);
//                    coordinator.coordinate(new CSVInputAdapter(inputOne));
//                    coordinator.coordinate(new CSVInputAdapter(inputTwo));
//                    coordinator.coordinate(new CSVInputAdapter(inputThree));
//                    coordinator.coordinate(new CSVInputAdapter(inputfour));
//                    coordinator.coordinate(new CSVInputAdapter(inputfive));
//                    coordinator.coordinate(new CSVInputAdapter(inputsix));
//                    coordinator.coordinate(new CSVInputAdapter(inputseven));
//                    coordinator.coordinate(new CSVInputAdapter(inputeight));
//                    coordinator.coordinate(new CSVInputAdapter(inputnine));
//                    coordinator.coordinate(new CSVInputAdapter(inputten));
//                    coordinator.coordinate(new CSVInputAdapter(inputeleven));
//                    coordinator.coordinate(new CSVInputAdapter(inputtwelve));
//                    coordinator.start();
////
//                    epService.removeAllStatementStateListeners();
                    //
// Generate CSV Report Files
// Report 2
                    try {
                        String fpath2 = classp3;
                        //

                        //
                        fileReader = new FileReader(fpath2);

                        bufferedReader = new BufferedReader(fileReader);
                        ArrayList<String> lines2 = new ArrayList<>();
                        String line2;
                        //
                        //

                        //     pats2 = new ArrayList<String>();
                        int r2 = 0;
                        while (((line2 = bufferedReader.readLine()) != null)) {

                            if (r2 > 0) {
                                if (!lines2.contains(line2)) {
                                    lines2.add(line2);

                                    //
                                    String res2 = line2;
                                    // split csv file
                                    //  
                                    String delims = "[,]";
                                    String[] csv = res2.split(delims);
                                    //
                                    stat = csv[12];

                                    //
                                    String damt = csv[5];

                                    debitamt = Integer.parseInt(damt);

                                    //
                                    String lim = csv[13];

                                    lim2 = Integer.parseInt(lim);

                                    //
                                    String bdate = csv[1];

                                    //
                                    String dacct = csv[3];

                                    //
                                    String cacc = csv[7];

                                    //
                                    String ttype = csv[2];

                                    //
                                    String bstaff = csv[8];
                                    //
                                    String ccode = csv[10];
                                    //
                                    //  pats22 = new ArrayList<>();
                                    //
                                    if (limsymb.startsWith(">")) {
                                        if ((debitamt > lim2) || (stat.equals(accstat)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            //  String csv2 = stat + "," + damt + "," + lim + "," + bdate + "," + dacct + "," + cacc + "," + ttype + "," + bstaff;
                                            //
                                            try {
//                                            try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report2.csv", true)) {
//                                                writer.append('\n');
//
//                                                writer.append(csv2);
//                                                writer.append('\n');
//
//                                                writer.flush();
//                                            }

//
                                                pats22 = new ArrayList<Reps2>();



                                                pats22.add(new Reps2(bdate, ttype, damt, dacct, cacc, lim, stat, bstaff));

                                                ct22 = pats22.size();

                                                //
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }
//                                    else 
                                    if (limsymb.startsWith("<")) {
                                        if ((debitamt < lim2) || (stat.equals(accstat)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            //   String csv2 = stat + "," + damt + "," + lim + "," + bdate + "," + dacct + "," + cacc + "," + ttype + "," + bstaff;
                                            //
                                            try {
//                                            try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report2.csv", true)) {
//                                                writer.append('\n');
//
//                                                writer.append(csv2);
//                                                writer.append('\n');
//
//                                                writer.flush();
//                                            }
                                                pats22 = new ArrayList<Reps2>();



                                                pats22.add(new Reps2(bdate, ttype, damt, dacct, cacc, lim, stat, bstaff));
                                                ct22 = pats22.size();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            //
                                        }

                                    }

                                    //else {
//
                                    if ((debitamt == lim2) || (stat.equals(accstat)) && (ccode.equals(caseNo))) {
                                        // write to csv file - check condition
                                        //  String csv2 = stat + "," + damt + "," + lim + "," + bdate + "," + dacct + "," + cacc + "," + ttype + "," + bstaff;
                                        //
                                        try {
//                                            try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report2.csv", true)) {
//                                                writer.append('\n');
//
//                                                writer.append(csv2);
//                                                writer.append('\n');
//
//                                                writer.flush();
//                                            }
                                            pats22 = new ArrayList<Reps2>();



                                            pats22.add(new Reps2(bdate, ttype, damt, dacct, cacc, lim, stat, bstaff));
                                            ct22 = pats22.size();

                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                        //
                                    }

                                    //  }
//
                                }
//
                            }
                            r2++;
                        }
                        //
                        trans2.setLabel("BOU Transfers Event");
                        trans2.set("Bank of Uganda Transfers Event", ct22);
                        model2 = new CartesianChartModel();
                        model2.addSeries(trans2);

                        //
                        bufferedReader.close();
                        // ct22 = pats22.size();
                        //
                        //int cty = pats22.size();
                        // totcnt = totcnt + cty;

                    } // }
                    catch (Exception e) {
                        e.getStackTrace();

                    }

// Report 3
                    try {
                        String fpath2 = classp2;
                        //

                        //
                        fileReader = new FileReader(fpath2);

                        bufferedReader = new BufferedReader(fileReader);
                        ArrayList<String> lines2 = new ArrayList<>();
                        String line2;
                        //
                        //

                        //     pats2 = new ArrayList<String>();
                        int r2 = 0;
                        while (((line2 = bufferedReader.readLine()) != null)) {
                            int conamt, tfamt3;
                            if (r2 > 0) {
                                if (!lines2.contains(line2)) {
                                    lines2.add(line2);

                                    //
                                    String res2 = line2;
                                    // split csv file
                                    //  
                                    String delims = "[,]";
                                    String[] csv = res2.split(delims);
                                    //
                                    String tstat = csv[10];


                                    //
                                    String contramt = csv[9];

                                    conamt = Integer.parseInt(contramt);

                                    //
                                    String tdate = csv[2];

                                    //
                                    String froacct = csv[4];

                                    //
                                    String toacc = csv[5];

                                    //
                                    String frobnk = csv[6];

                                    //
                                    String tobnk = csv[7];
                                    //
                                    String wpid = csv[8];

                                    //
                                    String tamount = csv[3];
                                    tfamt3 = Integer.parseInt(tamount);
                                    //
                                    String ccode = csv[1];
                                    //
                                    if (tfsymb.startsWith(">")) {
                                        if ((tfamt3 > conamt) || (tstat.equals(accstat)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            //String csv2 = tstat + "," + tamount + "," + contramt + "," + tdate + "," + froacct + "," + toacc + "," + frobnk + "," + tobnk + "," + wpid + "," + ccode;
                                            //
                                            try {
//                                            try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report3.csv", true)) {
//                                                writer.append('\n');
//
//                                                writer.append(csv2);
//                                                writer.append('\n');
//
//                                                writer.flush();
//                                            }
                                                pats33 = new ArrayList<Reps3>();


                                                pats33.add(new Reps3(froacct, tamount, tstat, toacc, tdate, wpid, contramt));
                                                ct33 = pats33.size();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    } else if (tfsymb.startsWith("<") && (ccode.equals(caseNo))) {
                                        if ((tfamt3 < conamt) || (tstat.equals(accstat))) {
                                            // write to csv file - check condition
                                            // String csv2 = tstat + "," + tamount + "," + contramt + "," + tdate + "," + froacct + "," + toacc + "," + frobnk + "," + tobnk + "," + wpid + "," + ccode;
                                            //
                                            try {
//                                            try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report3.csv", true)) {
//                                                writer.append('\n');
//
//                                                writer.append(csv2);
//                                                writer.append('\n');
//
//                                                writer.flush();
//                                            }
                                                pats33 = new ArrayList<Reps3>();


                                                pats33.add(new Reps3(froacct, tamount, tstat, toacc, tdate, wpid, contramt));
                                                ct33 = pats33.size();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            //
                                        }

                                    } else {

                                        if ((tfamt3 == conamt) || (tstat.equals(accstat)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            //  String csv2 = tstat + "," + tamount + "," + contramt + "," + tdate + "," + froacct + "," + toacc + "," + frobnk + "," + tobnk + "," + wpid + "," + ccode;
                                            //
                                            try {
//                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report3.csv", true)) {
//                                                    writer.append('\n');
//
//                                                    writer.append(csv2);
//                                                    writer.append('\n');
//
//                                                    writer.flush();
//                                                }
                                                pats33 = new ArrayList<Reps3>();


                                                pats33.add(new Reps3(froacct, tamount, tstat, toacc, tdate, wpid, contramt));
                                                ct33 = pats33.size();

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                            //
                                        }

                                    }

                                }

                            }
                            r2++;
                        }
                        trans3.setLabel("Payments Event");
                        trans3.set("Payments Event", ct33);
                        // model2 = new CartesianChartModel();
                        model2.addSeries(trans3);
                        bufferedReader.close();
                        // ct33 = pats33.size();
                        //
//                        int ctx = pats33.size();
//                          totcnt = totcnt + ctx;

                    } // }
                    catch (Exception e) {
                        e.getStackTrace();

                    }

// Report 6
                    try {
                        String fpath2 = classp;
                        //

                        //
                        fileReader = new FileReader(fpath2);

                        bufferedReader = new BufferedReader(fileReader);
                        ArrayList<String> lines2 = new ArrayList<>();
                        String line2;
                        //
                        //

                        //     pats2 = new ArrayList<String>();
                        int r2 = 0;
                        while (((line2 = bufferedReader.readLine()) != null)) {
                            String filenm, ccode;
                            if (r2 > 0) {
                                if ((!lines2.contains(line2)) && (!line2.isEmpty())) {
                                    lines2.add(line2);

                                    //
                                    String res2 = line2;
                                    // split csv file
                                    //  
                                    String delims = "[,]";
                                    String[] csv = res2.split(delims);
                                    //
                                    ccode = csv[1];

                                    //
                                    String dt = csv[2];



                                    //
                                    String frono = csv[3];



                                    //
                                    String tono = csv[4];

                                    //
                                    filenm = csv[5];


                                    //
                                    if (reqsymb.startsWith("=")) {
                                        if ((filenm.equals(request)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            //   String csv2 = dt + "," + frono + "," + tono + "," + filenm;
                                            //
                                            try {
//                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report6.csv", true)) {
//                                                    writer.append('\n');
//
//                                                    writer.append(csv2);
//                                                    writer.append('\n');
//
//                                                    writer.flush();
//                                                }
                                                pats66 = new ArrayList<Reps6>();


                                                pats66.add(new Reps6(tono, dt, frono, filenm));

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }


                                }

                            }
                            r2++;
                        }
                        bufferedReader.close();
                        ct66 = pats66.size();
                        // totcnt = totcnt + ct66;
                        trans6.setLabel("Phone Logs Event");
                        trans6.set("Phone Logs Event", ct66);
                        // model2 = new CartesianChartModel();
                        model2.addSeries(trans6);

                    } // }
                    catch (Exception e) {
                        e.getStackTrace();

                    }

// Report 11
                    try {
                        String fpath2 = classp13;
                        //

                        //
                        fileReader = new FileReader(fpath2);

                        bufferedReader = new BufferedReader(fileReader);
                        ArrayList<String> lines2 = new ArrayList<>();
                        String line2;
                        //
                        //

                        //     pats2 = new ArrayList<String>();
                        int r2 = 0;
                        while (((line2 = bufferedReader.readLine()) != null)) {
                            String filenm, ccode;
                            if (r2 > 0) {
                                if (!lines2.contains(line2)) {
                                    lines2.add(line2);

                                    //
                                    String res2 = line2;
                                    // split csv file
                                    //  
                                    String delims = "[,]";
                                    String[] csv = res2.split(delims);
                                    //
                                    ccode = csv[5];

                                    //
                                    String dt = csv[1];



                                    //
                                    String src = csv[2];



                                    //
                                    String dest = csv[3];

                                    //
                                    filenm = csv[4];

//
                                    String emref = csv[0];
                                    //
                                    if (reqsymb.startsWith("=")) {
                                        if ((filenm.equals(request2)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            //  String csv2 = emref + "," + dt + "," + src + "," + dest + "," + filenm;
                                            //
                                            try {
//                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report11.csv", true)) {
//                                                    writer.append('\n');
//
//                                                    writer.append(csv2);
//                                                    writer.append('\n');
//
//                                                    writer.flush();
//                                                }
                                                //
                                                pats111 = new ArrayList<Reps11>();

                                                pats111.add(new Reps11(dt, filenm, emref, src, dest));


                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }


                                }

                            }
                            r2++;
                        }
                        bufferedReader.close();

                        ct111 = pats111.size();

                        trans11.setLabel("Emails Event");
                        trans11.set("Emails Event", ct111);
                        // model2 = new CartesianChartModel();
                        model2.addSeries(trans11);
                        //  totcnt = totcnt + ct111;

                    } // }
                    catch (Exception e) {
                        e.getStackTrace();

                    }

                    //
                    // Report 7
                    try {
                        String fpath2 = classp14;
                        //

                        //
                        fileReader = new FileReader(fpath2);

                        bufferedReader = new BufferedReader(fileReader);
                        ArrayList<String> lines2 = new ArrayList<>();
                        String line2;
                        //
                        //

                        //     pats2 = new ArrayList<String>();
                        int r2 = 0;
                        while (((line2 = bufferedReader.readLine()) != null)) {

                            if (r2 > 0) {
                                if (!lines2.contains(line2)) {
                                    lines2.add(line2);

                                    //
                                    String res2 = line2;
                                    // split csv file
                                    //  
                                    String delims = "[,]";
                                    String[] csv = res2.split(delims);
                                    //
                                    String fname = csv[0];


                                    //
                                    String dbacct = csv[1];


                                    //
                                    String reqdt = csv[3];

                                    //
                                    String userid = csv[4];

                                    //
                                    String userlev7 = csv[5];

                                    //
                                    String wrkpln = csv[6];

                                    //
                                    String ccode = csv[7];
                                    //
                                    String ent = csv[8];

                                    //
                                    String crac = csv[2];
                                    //
                                    if ((suserlev.startsWith("=")) && (swp1.startsWith("=")) && (ccode.equals(caseNo))) {
                                        if ((userlev7.equals(userlev)) || (wrkpln.equals(wp1))) {
                                            // write to csv file - check condition
                                            String csv2 = fname + "," + dbacct + "," + reqdt + "," + userid + "," + userlev7 + "," + wrkpln + "," + ent + "," + ccode + "," + crac;
                                            //
                                            try {
//                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report7.csv", true)) {
//                                                    writer.append('\n');
//
//                                                    writer.append(csv2);
//                                                    writer.append('\n');
//
//                                                    writer.flush();
//                                                }

                                                pats77 = new ArrayList<Reps8>();
                                                pats77.add(new Reps8(fname, crac, dbacct, wrkpln, reqdt, userid, userlev, ent));

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    } else if ((suserlev.startsWith("=")) && (swp1.startsWith("!=")) && (ccode.equals(caseNo))) {

                                        if ((userlev7.equals(userlev)) || (!wrkpln.equals(wp1))) {
                                            // write to csv file - check condition
                                            String csv2 = fname + "," + dbacct + "," + reqdt + "," + userid + "," + userlev7 + "," + wrkpln + "," + ent + "," + ccode;
                                            //
                                            try {
//                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report7.csv", true)) {
//                                                    writer.append('\n');
//
//                                                    writer.append(csv2);
//                                                    writer.append('\n');
//
//                                                    writer.flush();
//                                                }

                                                pats77 = new ArrayList<Reps8>();
                                                pats77.add(new Reps8(fname, crac, dbacct, wrkpln, reqdt, userid, userlev, ent));
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    } else if ((suserlev.startsWith("!=")) && (swp1.startsWith("!=")) && (ccode.equals(caseNo))) {

                                        if ((!userlev7.equals(userlev)) || (!wrkpln.equals(wp1))) {
                                            // write to csv file - check condition
                                            String csv2 = fname + "," + dbacct + "," + reqdt + "," + userid + "," + userlev7 + "," + wrkpln + "," + ent + "," + ccode;
                                            //
                                            try {
//                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report7.csv", true)) {
//                                                    writer.append('\n');
//
//                                                    writer.append(csv2);
//                                                    writer.append('\n');
//
//                                                    writer.flush();
//                                                }
                                                pats77 = new ArrayList<Reps8>();
                                                pats77.add(new Reps8(fname, crac, dbacct, wrkpln, reqdt, userid, userlev, ent));
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }


                                    } else {
                                        if ((!userlev7.equals(userlev)) || (wrkpln.equals(wp1)) && (ccode.equals(caseNo))) {
                                            // write to csv file - check condition
                                            String csv2 = fname + "," + dbacct + "," + reqdt + "," + userid + "," + userlev7 + "," + wrkpln + "," + ent + "," + ccode;
                                            //
                                            try {
                                                try (FileWriter writer = new FileWriter("C:\\kriminofiles\\report7.csv", true)) {
                                                    writer.append('\n');

                                                    writer.append(csv2);
                                                    writer.append('\n');

                                                    writer.flush();
                                                }

                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }



                                    }

                                }

                            }
                            r2++;
                        }
                        bufferedReader.close();

                        ct77 = pats77.size();
                        //
                        trans7.setLabel("Funds Request Event");
                        trans7.set("Funds Request Event", ct77);
                        //  model2 = new CartesianChartModel();
                        model2.addSeries(trans7);
                        // totcnt = totcnt + ct77;
                    } // }
                    catch (Exception e) {
                        e.getStackTrace();

                    }
// CSV Report Files
//                    ct77 = pats77.size();
//                    ct22 = pats22.size();
//                    ct33 = pats33.size();
//                    ct66 = pats66.size();
//                    ct111 = pats11.size();
                    //Totals and percentages


                } catch (Exception e2) {
                    e2.printStackTrace();
                }

// Read csvs







                //

                //
                //
                //
                try {
//                    String fpath2 = "c:\\kriminofiles\\report2.txt";
//                    //
//
//                    //
//                    fileReader = new FileReader(fpath2);
//
//                    bufferedReader = new BufferedReader(fileReader);
                    //
                    for (int x = 0; x < ct22; x++) {



                        //
                        //ArrayList<String> lines2 = new ArrayList<String>();
                        //   String line2=null;
                        //
                        //

                        pats2 = new ArrayList<String>();
                        //
//            int i = 0, cnt2 = 1;
                        //     while ((line2 = bufferedReader.readLine()) != null) {


                        //  if (!lines2.contains(line2)) {
                        // lines2.add(line2);
                        // assign text 
                        //  String res = "";
                        //  String ress = "[=]";
                        // int count1 = lines.size();

                        // for (int i = 0; i < count1; i++) {
                        // res = lines.get(i);
                        //    res = res + "\n" + lines.get(i);
                        //   String res2 = line2.substring(1, line2.length() - 1);
                        // split csv file
                        //  String csv = r
                        //   String delims = "[,]";
                        // String[] csv = res2.split(delims);
                        //
                        String stat2 = pats22.get(x).getStatus();

                        //
                        String damt = pats22.get(x).getDebitamt();

                        //
                        String lim = pats22.get(x).getLimit();

                        //
                        String bdate = pats22.get(x).getBdate();

                        //
                        String dacct = pats22.get(x).getDacct();

                        //
                        String cacc = pats22.get(x).getCreditacct();

                        //
                        String ttype = pats22.get(x).getTransfertype();

                        //
                        String bstaff = pats22.get(x).getStaff2();



                        // add to table list
                        pats2.add(bdate + "|" + ttype + "|" + damt + "|" + dacct + "|" + cacc + "|" + lim + "|" + stat2 + "|" + bstaff);
//                        pats.add(tranamt);
                        //
                        // }



                        //

                        // // i++;
                        // cnt2++;
                        //  }

                        ct2 = pats2.size();
                        //  bufferedReader.close();

                    }

                } catch (Exception e) {
                    e.getStackTrace();

                }
                tpats2 = "Event 2 - BOU Transfers Event" + "(" + "Date" + "|" + "Transaction Type" + "|" + "Debit Amount" + "|" + "Debit Account" + "|" + "Credit Account" + "|" + "Limit Amount" + "|" + "Account Status" + "Bank Authoriser" + ")";

// get report3
                try {
//                    String fpath3 = "c:\\kriminofiles\\report3.txt";
//                    //
//
//                    //
//                    fileReader = new FileReader(fpath3);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    ArrayList<String> lines3 = new ArrayList<String>();
//                    String line3;
                    //
                    //

                    pats3 = new ArrayList<String>();
                    //
//            int i = 0, cnt3 = 1;
                    for (int x = 0; x < ct33; x++) {

                        String froacct = pats33.get(x).getFroacct();
                        //
                        String tstat = pats33.get(x).getTstat();

                        //

                        String tamt2 = pats33.get(x).getTamount();

                        //


                        String toacct = pats33.get(x).getToacct();
                        //

                        String trdate = pats33.get(x).getTrdate();
                        //
                        String wplan = pats33.get(x).getWplan();

                        //

                        String camt = pats33.get(x).getCamt();
                        //

//               tranamt += 1;
                        //


                        // add to table list
                        pats3.add(froacct + " | " + tamt2 + " | " + tstat + " | " + toacct + " | "
                                + trdate + " | " + wplan + " | " + camt);


                        //


                    }
                    ct3 = pats3.size();





                } catch (Exception e) {
                    e.getStackTrace();

                }
                tpats3 = "Event 3 -  Payments Event" + "(" + "Source Acct" + " | " + "Amount" + " | "
                        + "Project Status" + " | " + "Destination Acct" + " | "
                        + "Date" + " | " + "Workplan Code" + " | " + "Contract Amount" + ")";


// get report6
                try {
//                    String fpath6 = "c:\\kriminofiles\\report6.txt";
//                    //
//
//                    //
//                    fileReader = new FileReader(fpath6);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    ArrayList<String> lines6 = new ArrayList<String>();
//                    String line6;
                    //
                    //

                    pats6 = new ArrayList<String>();
                    //
                    for (int x = 0; x < ct66; x++) {

                        String tono = pats66.get(x).getTono();
                        //

                        String calldate = pats66.get(x).getCalldate();
                        //

                        String frono = pats66.get(x).getFrono();

                        String filen = pats66.get(x).getFname();
                        // add to table list
                        pats6.add(tono + " | " + calldate + " | " + frono + " | " + filen);
                        //



                    }
                    ct6 = pats6.size();




                } catch (Exception e) {
                    e.getStackTrace();

                }
                tpats6 = "Event 4 - Telephone Records Event" + "(" + "Dialled No" + " | " + "Date" + " | " + "Caller No" + " | " + "Filename" + ")";

                // get report7
                try {
//                    String fpath8 = "c:\\kriminofiles\\report7.txt";
//                    //
//
//                    //
//                    fileReader = new FileReader(fpath8);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    ArrayList<String> lines8 = new ArrayList<String>();
//                    String line8;
//                    //
//                    //

                    pats8 = new ArrayList<String>();
                    //
                    for (int x = 0; x < ct77; x++) {
                        String fname = pats77.get(x).getFilename();

                        //
                        String cracct = pats77.get(x).getCracct();

                        //
                        String dbacct = pats77.get(x).getDbAcct();


                        String wpid = pats77.get(x).getWrkid();

                        //
                        String userlev2 = pats77.get(x).getUserlevel();

                        //
                        String reqdt = pats77.get(x).getReqdate();

                        //
                        String usr = pats77.get(x).getUserid();

                        //
                        String ent = pats77.get(x).getEntcode();



                        // add to table list
                        pats8.add(fname + " | " + cracct + " | " + dbacct + " | "
                                + wpid + " | " + reqdt + " | " + usr + " | " + userlev2
                                + " | " + ent);
                        //




                    }


                    //   model2.addSeries(trans6);

                    ct8 = pats8.size();
                    //   bufferedReader.close();




                } catch (Exception e) {
                    e.getStackTrace();

                }
                tpats8 = "Event 1 - Funds Request Event" + "(" + "FileName" + " | " + "Credit Acct" + " | "
                        + "Debit Acct" + " | "
                        + "WorkPlan Code" + " | " + "Request Date" + " | "
                        + "User" + " | " + "User Level"
                        + " | " + "Ministry" + ")";

                // get report11
                try {
//                    String fpath11 = "c:\\kriminofiles\\report11.txt";
//                    //
//
//                    //
//                    fileReader = new FileReader(fpath11);
//
//                    bufferedReader = new BufferedReader(fileReader);
//                    ArrayList<String> lines11 = new ArrayList<String>();
//                    String line11;
//                    //
//                    //


                    pats11 = new ArrayList<String>();
                    //
                    for (int x = 0; x < ct111; x++) {
                        String emdate = pats111.get(x).getEmaildate();

                        //
                        String fileno = pats111.get(x).getRequestid();

                        //
                        String emref = pats111.get(x).getEmailid();


                        String srcadd = pats111.get(x).getSourceadd();

                        //

                        //
                        String dadd = pats111.get(x).getDestadd();

                        //


                        // add to table list
                        pats11.add(emdate + " | " + fileno + " | " + emref + " | " + srcadd
                                + " | " + dadd);
                        //






                        //  pats11.add(0,tpats11);
                    }
                    ct11 = pats11.size();
                    //     bufferedReader.close();

                    //


                } catch (Exception e) {
                    e.getStackTrace();

                }
                tpats11 = "Event 5 - Emails Event" + "(" + "Email Date" + " | " + "File Number" + " | "
                        + "Email Reference" + " | "
                        + "Source Address" + " | " + "Destination Address" + ")";
                // pdf
                // write to pdf
                // add headers to array
                // pats.add(0, tpats);
                // pats.add("(" + ct1 + ")" + "--" + "Record(s) Matching Transactions Pattern");
                if ((pats2 != null) && (ct2 > 0)) {
                    pats2.add(0, tpats2);
                    pats2.add("(" + ct2 + ")" + "--" + "Record(s) Matching BOU Transfers Pattern");
                } else {
                    pats2 = new ArrayList<>();
                    pats2.add("\n" + "(No Record(s) Matching BOU Transfers Pattern)");
                    tpats2 = "\n" + "(No Record(s) Matching BOU Transfers Pattern)";
                }
                if ((pats3 != null) && (ct3 > 0)) {
                    pats3.add(0, tpats3);
                    pats3.add("(" + ct3 + ")" + "--" + "Record(s) Matching Payments Pattern");
                } else {
                    pats3 = new ArrayList<>();
                    pats3.add("\n" + "(No Record(s) Matching Payments Pattern )");
                    // pats3.add(0,"(No Record(s) Matching Payments Pattern)");
                    tpats3 = "\n" + "(No Record(s) Matching Payments Pattern )";
                }
//                pats4.add(0, tpats4);
//                pats4.add("(" + ct4 + ")" + "--" + "Record(s) Matching Income Pattern");
//                pats5.add(0, tpats5);
//                pats5.add("(" + ct5 + ")" + "--" + "Record(s) Matching Assets Pattern");
                if ((pats6 != null) && (ct6 > 0)) {
                    pats6.add(0, tpats6);
                    pats6.add(ct6 + "-" + "  Record(s) - Phone Logs Pattern Not Matched");
                } else {

                    pats6 = new ArrayList<>();
                    pats6.add("\n" + "(No Records - Phone Logs Event Pattern Matched )");
                    tpats6 = "\n" + "(No Records - Phone Logs Pattern Matched )";
                }
                if ((pats8 != null) && (ct8 > 0)) {
                    pats8.add(0, tpats8);
                    pats8.add("(" + ct8 + ")" + "--" + "Record(s) Matching Funds Request Pattern");
                } else {
                    pats8 = new ArrayList<>();
                    pats8.add("\n" + "(No Record(s) Matching Payments Pattern )");
                    tpats8 = "\n" + "(No Record(s) Matching Payments Pattern )";
                }
                if ((pats11 != null) && (ct11 > 0)) {
                    pats11.add(0, tpats11);
                    pats11.add("(" + ct11 + ")" + "--" + "Record(s) - Emails Pattern Not Matched");
                } else {
                    pats11 = new ArrayList<>();
                    pats11.add("\n" + "(No Record(s) - Emails Pattern Matched )");
                    tpats11 = "\n" + "(No Record(s) - Emails Pattern Matched )";

                }
//                if (pats12 != null) {
//                    pats12.add(0, tpats12);
//                    pats12.add("(" + ct12 + ")" + "--" + "Record(s) ");
//                } else {
//                    pats12 = new ArrayList<>();
//                    pats12.add("");
//                    tpats12 = "\n" + "(No Record(s) Matching Budgets Pattern )";
//                }
                totcnt = ct77 + ct22 + ct33 + ct66 + ct111;
                //
                if (ct111 >= 1) {
                    perc111 = 0;

                } else {
                    perc111 = 1;
                }
                if (ct22 >= 1) {
                    perc22 = 1;

                } else {
                    perc22 = 0;
                }
                if (ct33 >= 1) {
                    perc33 = 1;

                } else {
                    perc33 = 0;
                }

                if (ct66 >= 1) {
                    perc66 = 0;

                } else {
                    perc66 = 1;
                }
                if (ct77 >= 1) {
                    perc77 = 1;

                } else {
                    perc77 = 0;
                }
                //
                totp = perc111 + perc22 + perc33 + perc66 + perc77;

                //
                //
                if (totp == 0) {
                    tperc = 0;
                } else {
                    totperc = ((float) totp / (float) totn) * 100;
                    tperc = (int) totperc;
                }
                ArrayList[] list;
                list = new ArrayList[]{pats8, pats2, pats3, pats6, pats11};

                int counter = list.length;


                rs = "";
                for (int x = 0; x < counter; x++) {
                    counter2 = list[x].size();

                    //  String itm = list[x].toString();
                    //  if (counter2!=0) {
                    for (int i = 0; i < counter2; i++) {


                        String gt = list[x].get(i).toString();
                        rs = rs + "\n" + gt + "\n";


                    }

                    String file1 = "c:/kriminofiles/" + caseNo + "- Analysis Report" + ".pdf";
                    //
                    document = new Document();


                    try {
                        try {
                            PdfWriter.getInstance(document, new FileOutputStream(file1));
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
                            new Paragraph("Analysis Report for Case Number:" + "" + caseNo, smallBold));
                    preface.add(
                            new Paragraph("_________________________________________________"));

                    addEmptyLine(preface,
                            1);
                    // Will create: Report generated by: _name, _date
                    preface.add(
                            new Paragraph("Report generated By: " + System.getProperty("user.name") + ", " + new Date(), redFont));
                    addEmptyLine(preface,
                            3);
                    preface.add(
                            new Paragraph("Total Records" + "(" + totcnt + ")", smallBold));
                    preface.add(
                            new Paragraph("Pattern Match Rate" + "(" + (int)totperc + "%" + ")", smallBold));
                    preface.add(
                            new Paragraph("_________________________________________________", red));

                    preface.add(
                            new Paragraph(rs));
                    preface.add(
                            new Paragraph("_________________________________________________", red));

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
                    //  }
                }

                //
                marker++;



            
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        String pmsg = "Events Processed Succesfully By Engine \n";
        //  refresh();
        //return "\n" + pmsg;
        count++;
        //return pmsg;

    }
    // pdf methods
    //methods

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void refresh() {

        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        ViewHandler handler = context.getApplication().getViewHandler();
        UIViewRoot root = handler.createView(context, viewId);
        root.setViewId(viewId);
        context.setViewRoot(root);

    }

    //
//    public void setCfile(String cfile) {
//        this.cfile = cfile;
//    }
    // COUNTS
    //
    public String getResult() throws FileNotFoundException, IOException {

//        try {
//            fpath = "c:\\kriminofiles\\report.txt";
//            //
//            //
//            FileReader fileReaderx = new FileReader(fpath);
//
//            BufferedReader bufferedReaderx = new BufferedReader(fileReaderx);
//            //  ArrayList<String> lines = new ArrayList<String>();  
//            String line;
//
//            while ((line = bufferedReaderx.readLine()) != null) {
//
//
//                if (!lines.contains(line)) {
//                    lines.add(line);
//                    // assign text 
//                    res = "";
//
//                    count1 = lines.size();
//                    for (int i = 0; i < count1; i++) {
//                        res = res + "\n" + lines.get(i);
//                        //Read from Reports
//
//
//
//
//                        //
//
//
//                    }
//                }
//
//            }
//
//            bufferedReader.close();
//
//
//            //
//
//////
//        } catch (Exception e) {
////            mes1 = "No Pattern Matched: ";
////            mes2 = " No Records Found";
//            e.printStackTrace();
//
//        }
//        if (count1 == 1) {
//            mes1 = "Succesful Pattern Match ! ";
//            mes2 = count1 + "-" + "Record Found";
//        } else if (count1 > 1) {
//            mes1 = "Succesful Pattern Match: ";
//            mes2 = count1 + "-" + "Records Found";
//        } else {
//            mes1 = "No Pattern Matched: ";
//            mes2 = " No Pattern Matched - Records Found";
//        }

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

    public String getCntmsg6() {
        if (ct66 >= 1) {
            cntmsg6 = pats66.size() + "" + "- Record(s) Found  (Phone calls Event - No Pattern Match)";
        } else {
            cntmsg6 = "No Record(s) Found(Phone Calls  Event - Pattern  Match)";
        }
        return cntmsg6;
    }

    public void setCntmsg6(String cntmsg6) {
        this.cntmsg6 = cntmsg6;
    }

    public int getCt111() {
        return ct111;
    }

    public void setCt111(int ct111) {
        this.ct111 = ct111;
    }

    public int getCt22() {
        return ct22;
    }

    public void setCt22(int ct22) {
        this.ct22 = ct22;
    }

    public int getCt33() {

        return ct33;
    }

    public void setCt33(int ct33) {
        this.ct33 = ct33;
    }

    public int getCt66() {
        return ct66;
    }

    public void setCt66(int ct66) {
        this.ct66 = ct66;
    }

    public int getCt77() {
        return ct77;
    }

    public void setCt77(int ct77) {
        this.ct77 = ct77;
    }
//

    /**
     * Creates a new instance of MainBean
     */
//    public MainBean() {
//        pojo = new CEPListener(); // Create/load it somehow.
//
//    }
//
//    public String getPojo() {
//
//        return pojo.getResponse();
//    }
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

//    public String getPdf() {
//
//        return "PDF files created for Case Number:" + casefile;
//    }
//
//    public void setPdf(String pdf) {
//        this.pdf = pdf;
//    }
    public String getCsno() {
        return csno;
    }

    public void setCsno(String csno) {
        this.csno = csno;
    }

    //
    public String getCntmsg2() {
        if (ct22 >= 1) {
            cntmsg2 = pats22.size() + "" + "- Record(s) Found  (Bank of Uganda Transfers Event - Pattern Match)";
        } else {
            cntmsg2 = "No Record(s) Found (Bank of Uganda Transfers Event - No Pattern Match)";
        }
        return cntmsg2;
    }

    public void setCntmsg2(String cntmsg2) {
        this.cntmsg2 = cntmsg2;
    }
    //

    public int getTotp() {
        return totp;
    }

    public void setTotp(int totp) {
        this.totp = totp;
    }

    public double getTotn() {
        totn2 = (int) totn;
        return totn2;

    }

    public void setTotn(int totn) {
        this.totn = totn;
    }

    public String getCntmsg8() {

        if (ct77 >= 1) {
            cntmsg8 = pats77.size() + "" + "- Record(s) Found (Funds Release Event - Pattern Match)";
        } else {
            cntmsg8 = "No Record(s) Found(Funds Release Event - No Pattern Match)";
        }
        return cntmsg8;
    }

    public void setCntmsg8(String cntmsg8) {
        this.cntmsg8 = cntmsg8;
    }

    public String getCntmsg3() {
        if (ct33 >= 1) {
            cntmsg3 = pats33.size() + "" + "- Record(s) Found (Account Transfers Event - Pattern Match)";
        } else {
            cntmsg3 = "No Record(s) Found(Account Transfers Event - No Pattern Match)";
        }
        return cntmsg3;
    }

    public void setCntmsg3(String cntmsg3) {
        this.cntmsg3 = cntmsg3;
    }

    public String getCntmsg11() {
        if (ct111 >= 1) {
            cntmsg11 = pats111.size() + "" + "- Record(s) Found  (Emails Event - No Pattern Match)";
        } else {
            cntmsg11 = "No Record(s) Found(Email Logs  Event - Pattern  Match)";
        }
        return cntmsg11;
    }

    public void setCntmsg11(String cntmsg11) {
        this.cntmsg11 = cntmsg11;
    }

    public double getTotperc() {


        return tperc;

    }

    public void setTotperc(double totperc) {
        this.totperc = totperc;
    }
//    public void clrfile() {
//        sf.delete();
//    }
}
