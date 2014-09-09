package dbase;

import dbase.Cases;
import dbase.Transfers;
import dbase.Workplan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Contracts.class)
public class Contracts_ { 

    public static volatile SingularAttribute<Contracts, Workplan> workPlanID;
    public static volatile SingularAttribute<Contracts, Date> timestamp9;
    public static volatile SingularAttribute<Contracts, String> contractor;
    public static volatile CollectionAttribute<Contracts, Transfers> transfersCollection;
    public static volatile SingularAttribute<Contracts, String> contractID;
    public static volatile SingularAttribute<Contracts, Integer> contractAmt;
    public static volatile SingularAttribute<Contracts, String> contractAcct;
    public static volatile SingularAttribute<Contracts, Cases> casecode;

}