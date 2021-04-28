package com.ex.dao;

import com.ex.entities.project.Project;

import java.sql.SQLException;
import java.util.List;

/*
 * @vlahdu
 *
 * */
public interface ProjectDAO {
    void addProject(Project project)throws SQLException;
    List<Project> getAll()throws SQLException;
    Project getById(long id)throws SQLException;
    void update(Project project)throws SQLException;
    void remove(Project project)throws SQLException;
}