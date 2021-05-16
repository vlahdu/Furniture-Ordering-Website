package com.fow.demo.repository;


import com.fow.demo.model.actors.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerRepository extends JpaRepository<Designer, Long> {
    Designer findByUserName(String userName);
    Designer findByEmail(String email);
}
