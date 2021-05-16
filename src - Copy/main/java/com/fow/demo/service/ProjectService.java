package com.fow.demo.service;


import com.fow.demo.model.actors.Designer;
import com.fow.demo.model.projects.Project;
import com.fow.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.projectRepository = projectRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public Project findByName(String name){
        return projectRepository.findByName(name);
    }
    public List<Project> findByDesigner(Designer designer){
        return projectRepository.findByDesigner(designer);
    }
    public Project saveProject(Project project){
        return projectRepository.save(project);
    }
    public List<Project> findAllBy(){ return  projectRepository.findAllBy();}
    public  Project findById(long id){ return projectRepository.findById(id);}
}
