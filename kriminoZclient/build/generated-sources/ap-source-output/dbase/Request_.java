package dbase;

import dbase.Boutransfers;
import dbase.Cases;
import dbase.Emails;
import dbase.Entities;
import dbase.Phonelogs;
import dbase.Userrights;
import dbase.Workplan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, String> creditaccount;
    public static volatile CollectionAttribute<Request, Boutransfers> boutransfersCollection;
    public static volatile SingularAttribute<Request, String> debitaccount;
    public static volatile SingularAttribute<Request, String> filenme;
    public static volatile SingularAttribute<Request, Date> timestamp7;
    public static volatile SingularAttribute<Request, Date> reqDate;
    public static volatile SingularAttribute<Request, Integer> amount;
    public static volatile CollectionAttribute<Request, Phonelogs> phonelogsCollection;
    public static volatile SingularAttribute<Request, Userrights> userId;
    public static volatile SingularAttribute<Request, Workplan> workplnId;
    public static volatile CollectionAttribute<Request, Emails> emailsCollection;
    public static volatile SingularAttribute<Request, Entities> entcode;
    public static volatile SingularAttribute<Request, Cases> casecode;

}