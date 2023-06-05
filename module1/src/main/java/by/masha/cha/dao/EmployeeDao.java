package by.masha.cha.dao;

import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee findById(Long id);

    void update(Employee employee);

    void delete(Employee employee);

    boolean isAlreadyExist(Employee employee);

    List<Employee> findAll();
    
    List<Employee> findAllByDepartment(Long id);

    List<Employee> findEmployeesById(Long id);
}

