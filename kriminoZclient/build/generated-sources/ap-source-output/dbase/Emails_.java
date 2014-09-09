package dbase;

import dbase.Cases;
import dbase.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Emails.class)
public class Emails_ { 

    public static volatile SingularAttribute<Emails, Integer> emailID;
    public static volatile SingularAttribute<Emails, String> edate;
    public static volatile SingularAttribute<Emails, Request> reqidd;
    public static volatile SingularAttribute<Emails, String> destAddr;
    public static volatile SingularAttribute<Emails, Date> timestamp11;
    public static volatile SingularAttribute<Emails, String> sourceAddr;
    public static volatile SingularAttribute<Emails, Cases> casecode;

}