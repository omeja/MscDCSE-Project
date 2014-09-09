package dbase;

import dbase.Cases;
import dbase.Entities;
import dbase.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-23T14:22:48")
@StaticMetamodel(Userrights.class)
public class Userrights_ { 

    public static volatile SingularAttribute<Userrights, String> userID;
    public static volatile SingularAttribute<Userrights, String> staffLevel;
    public static volatile SingularAttribute<Userrights, Entities> entity;
    public static volatile SingularAttribute<Userrights, String> userAuthority;
    public static volatile SingularAttribute<Userrights, String> dateCreated;
    public static volatile SingularAttribute<Userrights, String> creater;
    public static volatile CollectionAttribute<Userrights, Request> requestCollection;
    public static volatile SingularAttribute<Userrights, Cases> casecode;

}