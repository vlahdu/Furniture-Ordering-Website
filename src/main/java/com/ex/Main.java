package com.ex;

import com.ex.bl.SessionUtil;

//import com.ex.config.SpringConfig;

import com.ex.entities.actors.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/*
 * @IonToncu
 *
 * */
public class Main {
    public static void main(String[] args) {

       SessionUtil sessionUtil=new SessionUtil();
       sessionUtil.openTransactionSession();

        Session session=sessionUtil.getSession();
        String sql="select * from a";
        Query query=session.createNativeQuery(sql).addEntity(A.class);
        List<A> aList=query.list();
        for(A a:aList) System.out.println(a);

        sessionUtil.closeTransactionSession();
        System.out.println("done");


    }
}

