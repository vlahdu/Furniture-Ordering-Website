package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.DesignerDAO;
import com.ex.module.entities.actors.Customer;
import com.ex.module.entities.actors.Designer;
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

/**
 * @author IonToncu
 *
 * */
public class DesignerService extends SessionUtil implements DesignerDAO, UserDetailsService {
    //    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //    @Autowired
    private static Map<String, Designer> designerRepository =null;

    public DesignerService() throws SQLException {
        designerRepository=getInstance();
        loadRepository();
    }

    public static Map<String, Designer> getInstance(){
        if(designerRepository == null){
            designerRepository =new HashMap<>();
        }
        return designerRepository;
    }
    public void loadRepository() throws SQLException {
        List<Designer> designers=getAll();
        designers.forEach((x) -> designerRepository.put(x.getUsername(),x));
    }
    @Override
    public boolean addDesigner(Designer designer) throws SQLException {
        if (!designerRepository.containsKey(designer.getUsername())) {
            designer.setPassword(bCryptPasswordEncoder.encode(designer.getPassword()));
            designerRepository.put(designer.getUsername(),designer);
            System.out.println(designer.getPassword());
            openTransactionSession();
            Session session=getSession();
            session.save(designer);
            closeTransactionSession();
            return true;
        } else {
            return false;
        }
    }
    @Override
    public List<Designer> getAll() throws SQLException {
        openTransactionSession();
        String sql ="select designer from Designer designer";
        Query query=getSession().createQuery(sql,Designer.class);
        List<Designer> designerList=query.getResultList();
        designerList.forEach((x)-> System.out.println(x));
        System.out.println("*******************initialization of fields***************");
        designerList.forEach((x)-> System.out.println(x.getCompanyCollaboration()));
        designerList.forEach((x)-> System.out.println(x.getOwnProjects()));
        designerList.forEach((x)-> System.out.println(x.getCustomerSet()));
        designerList.forEach((x)-> System.out.println(x.getWantToCollaborate()));
        System.out.println("**********************************");
        closeTransactionSession();
        return designerList;
    }
    @Override
    public Designer getById(long id) throws SQLException {
        List<Designer> designerList =getAll();
        return (Designer)designerList.stream().filter((x) -> x.getId() == id).toArray()[0];
    }
    @Override
    public void update(Designer designer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(designer);
        closeTransactionSession();
    }
    @Override
    public void remove(Designer designer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(designer);
        closeTransactionSession();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Designer designer =designerRepository.get(username);
        if (designer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return designer;
    }
}