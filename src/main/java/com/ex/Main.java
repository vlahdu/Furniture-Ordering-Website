package com.ex;

import com.ex.bl.SessionUtil;
import com.ex.config.SpringConfig;
import com.ex.entities.actors.Customer;
import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * @IonToncu
 *
 * */
public class Main {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        SessionUtil sessionUtil=new SessionUtil();
        sessionUtil.openTransactionSession();
        Session session= sessionUtil.getSession();

        Customer customer=new Customer();
        customer.setName("Customer 1");

        session.save(customer);
        sessionUtil.closeTransactionSession();
        //context.close();

    }
}
