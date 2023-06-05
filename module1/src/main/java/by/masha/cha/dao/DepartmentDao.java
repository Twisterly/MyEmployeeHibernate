package by.masha.cha.dao;

import by.masha.cha.model.Department;

import java.util.List;

public interface DepartmentDao {

    void create(Department department);

    Department findById(Long id);

    List<String> findAllDepartmentNames();

    void update(Department department);

    void delete(Long id);

    void delete(Department department);

    List<Department> findAll();

    boolean isAlreadyExist(Department department);
}
