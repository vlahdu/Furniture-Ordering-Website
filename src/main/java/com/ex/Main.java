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

        String sql = "select  * from customer";
        Query query = session.createNativeQuery(sql).addEntity(Customer.class);

        List <Customer> customerList = query.list();

        for (Customer customer : customerList)
        {
            System.out.println(customer);

        }


        sessionUtil.closeTransactionSession();
        System.out.println("done");


    }
}

