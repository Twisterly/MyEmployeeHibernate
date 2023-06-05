package by.masha.cha.dao;

import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public Department findById(Long id) {
        return sessionFactory.getCurrentSession().get(Department.class, id);
    }

    @Override
    public List<String> findAllDepartmentNames() {
        String query = "SELECT d.departmentName FROM Department AS d";
        return sessionFactory.getCurrentSession().createQuery(query,
                String.class).list();
    }

    @Override
    public void update(Department department) {
        create(department);
    }

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void delete(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete from " +
                "Department where id=" + id).executeUpdate();
    }

    @Override
    public void delete(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.refresh(department);
        session.delete(department);
    }

    @Override
    public List<Department> findAll() {
        String query = "FROM Department";
        return sessionFactory.getCurrentSession().createQuery(query,
                Department.class).list();
    }

    @Override
    public boolean isAlreadyExist(Department department) {
        String query =
                "From Department D WHERE D.departmentName='" + department.getDepartmentName() + "'";
        List<Department> departments =
                sessionFactory.getCurrentSession().createQuery(query,
                Department.class).list();
        if (departments.size() == 0) {
            return false;
        } else
            return true;
    }

}
