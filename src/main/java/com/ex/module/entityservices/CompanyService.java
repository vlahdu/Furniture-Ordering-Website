package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.CompanyDAO;
import com.ex.module.entities.actors.Company;
import com.ex.module.entities.actors.User;
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

public class CompanyService extends SessionUtil implements CompanyDAO, UserDetailsService {
    private static Map<String, Company> companyRepository =null;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public CompanyService() throws SQLException {
        companyRepository=getInstance();
        loadRepository();
    }
    public static Map<String, Company> getInstance(){
        if(companyRepository == null){
            companyRepository =new HashMap<>();
        }
        return companyRepository;
    }
    public void loadRepository() throws SQLException {
        List<Company> companies=getAll();
        companies.forEach((x) -> companyRepository.put(x.getUsername(),x));
    }

    @Override
    public boolean addCompany(Company company) throws SQLException {
        if(companyRepository.containsKey(company.getUsername())){
            return false;
        }else{
            company.setPassword(bCryptPasswordEncoder.encode(company.getPassword()));
            companyRepository.put(company.getUsername(),company);
            System.out.println(company.getPassword());
            openTransactionSession();
            Session session=getSession();
            session.save(company);
            closeTransactionSession();
            return true;
        }
    }
    @Override
    public List<Company> getAll() throws SQLException {
        openTransactionSession();
        String sql ="select company from Company company";
        Query query=getSession().createQuery(sql,Company.class);
        List<Company> companyList=query.getResultList();
        companyList.forEach((x)-> System.out.println(x.getCustomerSet()));
        companyList.forEach((x)-> System.out.println(x.getDesignerSet()));
        companyList.forEach((x)-> System.out.println(x.getWantToCollaborate()));
        System.out.println(companyList);
        closeTransactionSession();
        return companyList;
    }
    @Override
    public Company getById(long id) throws SQLException {
        List<Company> companyList=getAll();
        return (Company)companyList.stream().filter((x) -> x.getId() == id).toArray()[0];
    }
    @Override
    public void update(Company company) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(company);
        closeTransactionSession();
    }
    @Override
    public void remove(Company company) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(company);
        closeTransactionSession();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Company company =companyRepository.get(username);
        if (company == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return company;
    }
}