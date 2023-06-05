package by.masha.cha.dao;

import by.masha.cha.model.Project;

import java.util.List;

public interface ProjectDao {

    void create(Project project);

    List<Project> findAll();

    void update(Project project);

    List<Project> findByEmployeeId(Long id);

    Project findById(Long id);

    void delete(Project project);

    boolean isAlreadyExist(Project project);

}