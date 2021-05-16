package com.fow.demo.service;
import com.fow.demo.model.actors.Designer;
import com.fow.demo.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DesignerService {
    private DesignerRepository designerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DesignerService(DesignerRepository designerRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.designerRepository = designerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public Designer findDesignerByEmail(String email){
        return designerRepository.findByEmail(email);
    }
    public Designer findByUsername(String username){
        return designerRepository.findByUserName(username);
    }
    public Designer saveDesigner(Designer designer){
        designer.setPassword(bCryptPasswordEncoder.encode(designer.getPassword()));
        designer.setActive(true);
        designer.setRole("DESIGNER");
        return designerRepository.save(designer);
    }
}
