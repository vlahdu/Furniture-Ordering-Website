package com.fow.demo.repository;


import com.fow.demo.model.actors.Designer;
import com.fow.demo.model.projects.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);
    List<Project> findByDesigner(Designer designer);
    List<Project> findAllBy();
    Project findById(long id);
}
