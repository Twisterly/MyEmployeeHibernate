package by.masha.cha.service;

import by.masha.cha.dao.EmployeeDao;
import by.masha.cha.model.Employee;
import by.masha.cha.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    public void add(Employee employee, List<String> projects) {
        if (employee.getProjects() == null) {
            employee.setProjects(new HashSet<>());
        }
        for (String id : projects) {
            Project m = new Project();
            m.setId(Long.valueOf(id));
            employee.getProjects().add(m);
        }

        employeeDao.create(employee);
    }

    public List<Employee> getAll() {

        return employeeDao.findAll();
    }

    public Employee getById(long employeeId) {
        return employeeDao.findById(employeeId);
    }

    public void addMeetingToEmployee(Employee employee, Project project) {
        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);
        employeeDao.update(employee);
    }

    public List<Employee> findAllByDepartment(Long id) {
        return employeeDao.findAllByDepartment(id);
    }

    public Employee update(Employee employee, Long id, List<String> projects) {
        Employee updatedEmployee = employeeDao.findById(id);
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setBirthDate(employee.getBirthDate());
        updatedEmployee.setCellPhone(employee.getCellPhone());
        updatedEmployee.setDepartment(employee.getDepartment());
        if (updatedEmployee.getProjects() == null) {
            updatedEmployee.setProjects(new HashSet<>());
        }
        Set<Project> projectListUpdated = new HashSet<>();
        for (String ID : projects) {
            Project m = new Project();
            m.setId(Long.valueOf(ID));
            projectListUpdated.add(m);
        }
//        Set<Project> projectSet = new HashSet<>(projectListUpdated);
//        List<Project> projectList = new ArrayList<>(projectSet);
        updatedEmployee.setProjects(projectListUpdated);
        employeeDao.update(updatedEmployee);
        return employeeDao.findById(id);
    }

    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    public boolean isAlreadyExist(Employee employee) {
      return   employeeDao.isAlreadyExist(employee);
    }

   public List<Employee> findEmployeesById(List<String> employees){
       List<Employee> result = new ArrayList<>();
       for(String id : employees){
           result.add(employeeDao.findById(Long.valueOf(id)));
       }
       return result;
   }

}
