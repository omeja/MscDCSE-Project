package dbase;

import dbase.Cases;
import dbase.Transfers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Tasks.class)
public class Tasks_ { 

    public static volatile SingularAttribute<Tasks, String> status;
    public static volatile SingularAttribute<Tasks, String> contractcode;
    public static volatile SingularAttribute<Tasks, Date> timestamp10;
    public static volatile CollectionAttribute<Tasks, Transfers> transfersCollection;
    public static volatile SingularAttribute<Tasks, String> taskCode;
    public static volatile SingularAttribute<Tasks, String> taskName;
    public static volatile SingularAttribute<Tasks, Cases> casecode;

}