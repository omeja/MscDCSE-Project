package dbase;

import dbase.Cases;
import dbase.Contracts;
import dbase.Tasks;
import dbase.Workplan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Transfers.class)
public class Transfers_ { 

    public static volatile SingularAttribute<Transfers, Integer> id;
    public static volatile SingularAttribute<Transfers, String> tobank;
    public static volatile SingularAttribute<Transfers, Cases> caseCode;
    public static volatile SingularAttribute<Transfers, String> frobank;
    public static volatile SingularAttribute<Transfers, Tasks> taskid;
    public static volatile SingularAttribute<Transfers, Contracts> contractid;
    public static volatile SingularAttribute<Transfers, Date> timestamp3;
    public static volatile SingularAttribute<Transfers, String> toaccount;
    public static volatile SingularAttribute<Transfers, Date> tdate;
    public static volatile SingularAttribute<Transfers, Workplan> wrkplanid;
    public static volatile SingularAttribute<Transfers, String> froaccount;
    public static volatile SingularAttribute<Transfers, Integer> tamount;

}