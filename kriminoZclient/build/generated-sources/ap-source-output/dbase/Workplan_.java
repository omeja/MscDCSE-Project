package dbase;

import dbase.Cases;
import dbase.Contracts;
import dbase.Entities;
import dbase.Request;
import dbase.Transfers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Workplan.class)
public class Workplan_ { 

    public static volatile SingularAttribute<Workplan, Integer> amount;
    public static volatile SingularAttribute<Workplan, Date> startDate;
    public static volatile CollectionAttribute<Workplan, Contracts> contractsCollection;
    public static volatile SingularAttribute<Workplan, Date> timestamp8;
    public static volatile SingularAttribute<Workplan, String> description;
    public static volatile SingularAttribute<Workplan, Entities> entitycd;
    public static volatile SingularAttribute<Workplan, Date> endDate;
    public static volatile CollectionAttribute<Workplan, Transfers> transfersCollection;
    public static volatile CollectionAttribute<Workplan, Request> requestCollection;
    public static volatile SingularAttribute<Workplan, String> workPlanCode;
    public static volatile SingularAttribute<Workplan, Cases> casecode;

}