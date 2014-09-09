package dbase;

import dbase.Accounts;
import dbase.Assets;
import dbase.Boutransfers;
import dbase.Budget;
import dbase.Casetrans;
import dbase.Contracts;
import dbase.Emails;
import dbase.Entities;
import dbase.Income;
import dbase.Phonelogs;
import dbase.Request;
import dbase.Tasks;
import dbase.Transfers;
import dbase.Userrights;
import dbase.Workplan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Cases.class)
public class Cases_ { 

    public static volatile CollectionAttribute<Cases, Boutransfers> boutransfersCollection;
    public static volatile CollectionAttribute<Cases, Accounts> accountsCollection;
    public static volatile SingularAttribute<Cases, String> station;
    public static volatile CollectionAttribute<Cases, Casetrans> casetransCollection;
    public static volatile CollectionAttribute<Cases, Request> requestCollection;
    public static volatile CollectionAttribute<Cases, Workplan> workplanCollection;
    public static volatile CollectionAttribute<Cases, Userrights> userrightsCollection;
    public static volatile CollectionAttribute<Cases, Budget> budgetCollection;
    public static volatile SingularAttribute<Cases, Entities> entityCode;
    public static volatile CollectionAttribute<Cases, Assets> assetsCollection;
    public static volatile CollectionAttribute<Cases, Contracts> contractsCollection;
    public static volatile SingularAttribute<Cases, String> caseCode;
    public static volatile CollectionAttribute<Cases, Phonelogs> phonelogsCollection;
    public static volatile CollectionAttribute<Cases, Income> incomeCollection;
    public static volatile CollectionAttribute<Cases, Transfers> transfersCollection;
    public static volatile CollectionAttribute<Cases, Tasks> tasksCollection;
    public static volatile SingularAttribute<Cases, String> district;
    public static volatile CollectionAttribute<Cases, Emails> emailsCollection;

}