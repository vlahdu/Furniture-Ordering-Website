package com.ex;

import com.ex.bl.SessionUtil;
import com.ex.config.SpringConfig;

import com.ex.entities.actors.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @IonToncu
 *
 * */
public class Main {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        SessionUtil sessionUtil=new SessionUtil();
//        sessionUtil.openTransactionSession();
//        Session session= sessionUtil.getSession();
////
//        Customer customer=new Customer();
//        customer.setName("Customer 1");
//
//
//
////        session.save(customer);
//        sessionUtil.closeTransactionSession();
//        //context.close();
        sessionUtil.openTransactionSession();
        Session session=sessionUtil.getSession();
        Customer c= new Customer();
        c.setName("customer1");
        session.save(c);
//                String sql="SELECT * FROM customer";
//                Session session1=sessionUtil.getSession();
//                Query query =session1.createNativeQuery(sql).addEntity(Customer.class);
//                List<Customer> customerList=query.list();
//                for(Customer c:customerList)

//                String sql="select * from customer";
//                Session session=sessionUtil.getSession();
//                Query query=session.createNativeQuery(sql).addEntity(Customer.class);
//                List<Customer>customerList=query.list();
//                System.out.println(customerList);
            //openTransactionSession();
//            long id=1;
//            Session session=sessionUtil.getSession();
//            String sql="SELECT * FROM customer WHERE ID =:id";
//            Query query=session.createNativeQuery(sql).addEntity(Customer.class);
//            query.setParameter("id",id);
//            Customer customer=(Customer)query.getSingleResult();
//            System.out.println(customer.getName());
//            //closeTransactionSession();
                sessionUtil.closeTransactionSession();
        System.out.println("ceva");


    }
}

