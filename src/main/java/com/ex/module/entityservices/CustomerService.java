package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.CustomerDAO;
import com.ex.module.entities.actors.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @vlahdu
 *
 * */
public class CustomerService extends SessionUtil implements CustomerDAO, UserDetailsService {
    //    @Autowired
    private static Map<String, Customer> customerRepository =null;
    public  CustomerService() throws SQLException {
        customerRepository=getInstance();
        loadRepository();
    }
    public static Map<String, Customer> getInstance(){
        if(customerRepository == null){
            customerRepository =new HashMap<>();
        }
        return customerRepository;
    }
    public void loadRepository() throws SQLException {
        List<Customer> customers=getAll();
        customers.forEach((x) -> customerRepository.put(x.getUsername(),x));
    }
    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        if(customerRepository.containsKey(customer.getUsername())){
            return false;
        }else{
            customer.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
            customerRepository.put(customer.getUsername(),customer);
            System.out.println(customer.getPassword());
            openTransactionSession();
            Session session=getSession();
            getSave(customer, session);
            closeTransactionSession();
            return true;
        }
    }

    private Object getSave(Customer customer, Session session) {
        return session.save(customer);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        openTransactionSession();
        String sql ="select customer from Customer customer";
        Query query=getSession().createQuery(sql,Customer.class);
        List<Customer> customerList=query.getResultList();
        System.out.println(customerList);
        customerList.forEach((x)-> System.out.println(x.getLikedProjects()));
        customerList.forEach((x)-> System.out.println());
        closeTransactionSession();
        return customerList;
    }
    @Override
    public Customer getById(long id) throws SQLException {
        List<Customer> customerList=getAll();
        return (Customer)customerList.stream().filter((x) -> x.getId() == id).toArray()[0];
    }
    @Override
    public void update(Customer customer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(customer);
        closeTransactionSession();
    }
    @Override
    public void remove(Customer customer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(customer);
        closeTransactionSession();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer =customerRepository.get(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return customer;
    }
}