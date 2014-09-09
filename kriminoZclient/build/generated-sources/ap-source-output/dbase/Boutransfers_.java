package dbase;

import dbase.Budget;
import dbase.Cases;
import dbase.Entities;
import dbase.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Boutransfers.class)
public class Boutransfers_ { 

    public static volatile SingularAttribute<Boutransfers, String> bankstaffid;
    public static volatile SingularAttribute<Boutransfers, String> creditacct;
    public static volatile SingularAttribute<Boutransfers, String> debitacctname;
    public static volatile SingularAttribute<Boutransfers, Integer> limitamt;
    public static volatile SingularAttribute<Boutransfers, Cases> casecode5;
    public static volatile SingularAttribute<Boutransfers, Budget> itemcode;
    public static volatile SingularAttribute<Boutransfers, String> govtstaffid;
    public static volatile SingularAttribute<Boutransfers, String> debitacctno;
    public static volatile SingularAttribute<Boutransfers, String> workplanid;
    public static volatile SingularAttribute<Boutransfers, Request> reqid;
    public static volatile SingularAttribute<Boutransfers, String> transfertype;
    public static volatile SingularAttribute<Boutransfers, Entities> entityCode;
    public static volatile SingularAttribute<Boutransfers, Integer> debitamount;
    public static volatile SingularAttribute<Boutransfers, String> creditbank;
    public static volatile SingularAttribute<Boutransfers, Integer> idbou;
    public static volatile SingularAttribute<Boutransfers, String> craccstat;
    public static volatile SingularAttribute<Boutransfers, Date> timestamp5;
    public static volatile SingularAttribute<Boutransfers, Date> bdate;

}