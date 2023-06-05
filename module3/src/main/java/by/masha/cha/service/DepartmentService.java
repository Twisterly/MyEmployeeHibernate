package by.masha.cha.service;

import by.masha.cha.dao.DepartmentDao;
import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public void add(Department department) {
        departmentDao.create(department);
    }

    public List<Department> getAll() {
        return departmentDao.findAll();
    }

    public void delete(Department department) {
        departmentDao.delete(department);
    }

    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    public Department update(Department department, Long id) {
        Department updatedDepartment = departmentDao.findById(id);
        updatedDepartment.setDepartmentName(department.getDepartmentName());
        departmentDao.update(updatedDepartment);
        return departmentDao.findById(id);
    }

    public boolean isAlreadyExist(Department department){
        return  departmentDao.isAlreadyExist(department);
    }

}


