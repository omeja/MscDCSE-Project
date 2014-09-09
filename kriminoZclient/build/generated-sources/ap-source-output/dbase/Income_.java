package dbase;

import dbase.Cases;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Income.class)
public class Income_ { 

    public static volatile SingularAttribute<Income, Integer> amount;
    public static volatile SingularAttribute<Income, String> incometype;
    public static volatile SingularAttribute<Income, Date> timestamp6;
    public static volatile SingularAttribute<Income, String> description;
    public static volatile SingularAttribute<Income, Integer> itemno;
    public static volatile SingularAttribute<Income, String> frequency;
    public static volatile SingularAttribute<Income, Cases> casecode;

}