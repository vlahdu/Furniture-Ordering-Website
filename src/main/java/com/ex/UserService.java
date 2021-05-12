package com.ex;


import com.ex.bl.SessionUtil;

import com.ex.module.entities.actors.Company;
import com.ex.module.entities.actors.Customer;
import com.ex.module.entities.actors.Designer;
import com.ex.module.entities.actors.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService extends SessionUtil implements UserDetailsService {
    //    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();;
    //    @Autowired
    private static Map<String, User> usersRepository =null;

    public UserService(){

            usersRepository =new HashMap<>();

    }

    public boolean saveUser(User user){
        if(usersRepository.containsKey(user.getUsername())){
            return false;
        }else{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            usersRepository.put(user.getUsername(),user);
            System.out.println(user.getPassword());
            return true;
        }
    }
    public static Map<String, User> getInstance(){
        if(usersRepository == null){
            usersRepository =new HashMap<>();
        }
        return  usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Designer d1 =new Designer();
        d1.setUsername("Designer1");
        d1.setPassword(bCryptPasswordEncoder.encode("password1"));
        Customer customer = new Customer();
        customer.setUsername("Customer1");
        customer.setPassword(bCryptPasswordEncoder.encode("password2"));
        Company company = new Company();
        company.setUsername("Company1");
        company.setPassword(bCryptPasswordEncoder.encode("password3"));
        //System.out.println("Parola este "+d1.getPassword());
        usersRepository.put(d1.getUsername(),d1);
        usersRepository.put(company.getUsername(),company);
        usersRepository.put(customer.getUsername(),customer);

        User user =usersRepository.get(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
    @Bean
    public Map<String,User> getAllUsers(){
        openTransactionSession();
        String sql="SELECT * FROM user";
        Session session=getSession();
        Query query =session.createNativeQuery(sql).addEntity(User.class);
        List<User> userList=query.list();

        closeTransactionSession();

        Map<String,User> usersMap=new HashMap<>();
        for(User user: userList)
            usersMap.put(user.getUsername(),user);

        return usersMap;
    }
    //@Bean
    private PasswordEncoder bCryptPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }

}
