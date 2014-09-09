package dbase;

import dbase.Accounts;
import dbase.Boutransfers;
import dbase.Budget;
import dbase.Cases;
import dbase.Request;
import dbase.Userrights;
import dbase.Workplan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Entities.class)
public class Entities_ { 

    public static volatile CollectionAttribute<Entities, Budget> budgetCollection;
    public static volatile CollectionAttribute<Entities, Userrights> userrightsCollection;
    public static volatile CollectionAttribute<Entities, Boutransfers> boutransfersCollection;
    public static volatile CollectionAttribute<Entities, Accounts> accountsCollection;
    public static volatile SingularAttribute<Entities, String> description;
    public static volatile CollectionAttribute<Entities, Cases> casesCollection;
    public static volatile SingularAttribute<Entities, String> code;
    public static volatile CollectionAttribute<Entities, Request> requestCollection;
    public static volatile CollectionAttribute<Entities, Workplan> workplanCollection;

}