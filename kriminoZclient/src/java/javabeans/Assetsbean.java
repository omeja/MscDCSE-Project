/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import com.espertech.esper.client.util.DateTime;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Assetsbean {
     private String assetcode;
    private String assettype;
    private String marketvalue;
    private String acquiredate;
    private String acquirecost;
    private String acquiremode;
    private String sourceoffunds;
   private String casecode;
   private Date timestamp4;

    public Date getTimestamp4() {
        return timestamp4;
    }

    public void setTimestamp4(Long timestamp4) {
        this.timestamp4 = new Date(timestamp4);
    }

    public Assetsbean(String assetcode, String assettype, String marketvalue, String acquiredate, String acquirecost, String acquiremode, String sourceoffunds, String casecode) {
        this.assetcode = assetcode;
        this.assettype = assettype;
        this.marketvalue = marketvalue;
        this.acquiredate = acquiredate;
        this.acquirecost = acquirecost;
        this.acquiremode = acquiremode;
        this.sourceoffunds = sourceoffunds;
        this.casecode = casecode;
    }

    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    public String getAssettype() {
        return assettype;
    }

    public void setAssettype(String assettype) {
        this.assettype = assettype;
    }

    public String getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(String marketvalue) {
        this.marketvalue = marketvalue;
    }

    public String getAcquiredate() {
        return acquiredate;
    }

    public void setAcquiredate(String acquiredate) {
        this.acquiredate = acquiredate;
    }

    public String getAcquirecost() {
        return acquirecost;
    }

    public void setAcquirecost(String acquirecost) {
        this.acquirecost = acquirecost;
    }

    public String getAcquiremode() {
        return acquiremode;
    }

    public void setAcquiremode(String acquiremode) {
        this.acquiremode = acquiremode;
    }

    public String getSourceoffunds() {
        return sourceoffunds;
    }

    public void setSourceoffunds(String sourceoffunds) {
        this.sourceoffunds = sourceoffunds;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }
   
   
}
