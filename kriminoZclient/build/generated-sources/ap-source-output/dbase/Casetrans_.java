package dbase;

import dbase.Cases;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Casetrans.class)
public class Casetrans_ { 

    public static volatile SingularAttribute<Casetrans, Integer> transAmount;
    public static volatile SingularAttribute<Casetrans, String> transType;
    public static volatile SingularAttribute<Casetrans, Date> transdate;
    public static volatile SingularAttribute<Casetrans, Cases> caseCode;
    public static volatile SingularAttribute<Casetrans, Integer> transactionid;
    public static volatile SingularAttribute<Casetrans, Date> timestamp2;
    public static volatile SingularAttribute<Casetrans, String> transaccount;
    public static volatile SingularAttribute<Casetrans, String> transcode;

}