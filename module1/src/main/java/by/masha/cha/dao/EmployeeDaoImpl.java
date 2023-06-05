package by.masha.cha.dao;

import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;
import by.masha.cha.model.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee findById(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        create(employee);
    }

    @Override
    public void delete(Employee employee) {
        Employee loadedEmployee = sessionFactory.getCurrentSession().load(Employee.class, employee.getId());
        for (Project project : loadedEmployee.getProjects()) {
            project.getEmployees().remove(loadedEmployee);
        }
        loadedEmployee.getProjects().clear();
        sessionFactory.getCurrentSession().update(loadedEmployee);
        sessionFactory.getCurrentSession().delete(loadedEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class).list();
    }

    @Override
    public List<Employee> findAllByDepartment(Long id) {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e inner join e.department where e.department.id='" + id +"'", Employee.class).list();
    }

    @Override
    public List<Employee> findEmployeesById(Long id) {
        return sessionFactory.getCurrentSession().createQuery("From " +
                "Employee e where e.id=?", Employee.class).list();

    }

    @Override
    public boolean isAlreadyExist(Employee employee){
        String query = "From Employee E WHERE E.cellPhone='" + employee.getCellPhone() +"'";
        List<Employee> employees = sessionFactory.getCurrentSession().createQuery(query,
                Employee.class).list();
        if(employees.size() == 0){
            return false;
        } else
            return true;
    }
}

