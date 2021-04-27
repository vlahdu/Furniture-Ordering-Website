package com.ex;

import com.ex.bl.SessionUtil;
<<<<<<< HEAD
=======
//import com.ex.config.SpringConfig;

>>>>>>> IonToncu
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
//       sessionUtil.closeTransactionSession();
//        //context.close();
<<<<<<< HEAD
       sessionUtil.openTransactionSession();
//        Session session=sessionUtil.getSession();
//        Customer c= new Customer();
//        c.setName("customer1");
//        session.save(c);
                String sql="SELECT * FROM customer";
                Session session1=sessionUtil.getSession();
                Query query =session1.createNativeQuery(sql).addEntity(Customer.class);
                List<Customer> customerList=query.list();
                for(Customer c:customerList)
=======
        sessionUtil.openTransactionSession();
      Session session=sessionUtil.getSession();
//        Customer c= new Customer();
//        c.setName("customer1");
//        session.save(c);
//        for(int i=0;i<10;i++){
//            A a=new A();
//            a.setName("a=efgsege");
//            session.save(a);
//        }
        String sql ="select * from a";
        Query query=session.createNativeQuery(sql).addEntity(A.class);
        List<A> aList=query.list();
        for(A a:aList) System.out.println(a);
//
//                String sql="SELECT * FROM customer";
//                Session session1=sessionUtil.getSession();
//                Query query =session1.createNativeQuery(sql).addEntity(Customer.class);
//                List<Customer> customerList=query.list();
//                for(Customer c:customerList)
>>>>>>> IonToncu

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

