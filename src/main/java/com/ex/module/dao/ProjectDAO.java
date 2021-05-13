package com.ex.module.dao;

import com.ex.module.entities.project.Project;

import java.sql.SQLException;
import java.util.List;

/*
 * @vlahdu
 *
 * */
public interface ProjectDAO {
    boolean addProject(Project project)throws SQLException;
    List<Project> getAll()throws SQLException;
    Project getById(long id)throws SQLException;
    void update(Project project)throws SQLException;
    void remove(Project project)throws SQLException;
}