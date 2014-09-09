package dbase;

import dbase.Cases;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Assets.class)
public class Assets_ { 

    public static volatile SingularAttribute<Assets, Integer> marketvalue;
    public static volatile SingularAttribute<Assets, String> acquiremode;
    public static volatile SingularAttribute<Assets, Integer> acquirecost;
    public static volatile SingularAttribute<Assets, Date> timestamp4;
    public static volatile SingularAttribute<Assets, Integer> assetcode;
    public static volatile SingularAttribute<Assets, Date> acquiredate;
    public static volatile SingularAttribute<Assets, String> sourceoffunds;
    public static volatile SingularAttribute<Assets, String> assettype;
    public static volatile SingularAttribute<Assets, Cases> casecode;

}