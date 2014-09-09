package dbase;

import dbase.Cases;
import dbase.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Phonelogs.class)
public class Phonelogs_ { 

    public static volatile SingularAttribute<Phonelogs, Request> requestID;
    public static volatile SingularAttribute<Phonelogs, Cases> caseCode;
    public static volatile SingularAttribute<Phonelogs, String> fromNo;
    public static volatile SingularAttribute<Phonelogs, String> toNo;
    public static volatile SingularAttribute<Phonelogs, Integer> callId;
    public static volatile SingularAttribute<Phonelogs, Date> callDate;
    public static volatile SingularAttribute<Phonelogs, Date> timestamp1;

}