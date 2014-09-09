package dbase;

import dbase.Cases;
import dbase.Entities;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Accounts.class)
public class Accounts_ { 

    public static volatile SingularAttribute<Accounts, String> num;
    public static volatile SingularAttribute<Accounts, String> accountName;
    public static volatile SingularAttribute<Accounts, String> status;
    public static volatile SingularAttribute<Accounts, Cases> csscode;
    public static volatile SingularAttribute<Accounts, Integer> limitAmt;
    public static volatile SingularAttribute<Accounts, Entities> entityID;

}