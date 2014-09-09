package dbase;

import dbase.Boutransfers;
import dbase.Cases;
import dbase.Entities;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Budget.class)
public class Budget_ { 

    public static volatile SingularAttribute<Budget, Integer> amount;
    public static volatile CollectionAttribute<Budget, Boutransfers> boutransfersCollection;
    public static volatile SingularAttribute<Budget, String> source;
    public static volatile SingularAttribute<Budget, Entities> entityNo;
    public static volatile SingularAttribute<Budget, Date> creditDate;
    public static volatile SingularAttribute<Budget, String> description;
    public static volatile SingularAttribute<Budget, String> yearPeriod;
    public static volatile SingularAttribute<Budget, Date> timestamp12;
    public static volatile SingularAttribute<Budget, String> accountNo;
    public static volatile SingularAttribute<Budget, Integer> itemcode;
    public static volatile SingularAttribute<Budget, Cases> casecode;

}