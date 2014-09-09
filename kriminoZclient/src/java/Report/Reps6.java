/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author pc
 */
public class Reps6 {
private String tono;
private String calldate;
private String frono;
private String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Reps6(String tono, String calldate, String frono,String fname) {
        this.tono = tono;
        this.calldate = calldate;
        this.frono = frono;
        this.fname = fname;
    }

    public String getTono() {
        return tono;
    }

    public void setTono(String tono) {
        this.tono = tono;
    }

    public String getCalldate() {
        return calldate;
    }

    public void setCalldate(String calldate) {
        this.calldate = calldate;
    }

    public String getFrono() {
        return frono;
    }

    public void setFrono(String frono) {
        this.frono = frono;
    }


    
}
