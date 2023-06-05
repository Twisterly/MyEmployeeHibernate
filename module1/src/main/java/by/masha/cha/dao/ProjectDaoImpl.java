package by.masha.cha.dao;

import by.masha.cha.model.Employee;
import by.masha.cha.model.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Project project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    @Override
    public List<Project> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Project",
                Project.class).list();
    }

    @Override
    public void update(Project project) {
        create(project);
    }


    @Override
    public List<Project> findByEmployeeId(Long id) {
        return sessionFactory.getCurrentSession().createQuery("From " +
                "Project p where p.id=?", Project.class).list();

    }

    @Override
    public Project findById(Long id) {
        return sessionFactory.getCurrentSession().get(Project.class, id);
    }

    @Override
    public void delete(Project project) {

        Project loadedProject =
                sessionFactory.getCurrentSession().load(Project.class,
                        project.getId());
        for (Employee employee : loadedProject.getEmployees()) {
            employee.getProjects().remove(loadedProject);
        }
        loadedProject.getEmployees().clear();
        sessionFactory.getCurrentSession().update(loadedProject);
        sessionFactory.getCurrentSession().delete(loadedProject);
    }

    public boolean isAlreadyExist(Project project) {
        String query =
                "From Project P WHERE P.projectName='" + project.getProjectName() + "'";
        List<Project> projects =
                sessionFactory.getCurrentSession().createQuery(query,
                Project.class).list();
        if (projects.size() == 0) {
            return false;
        } else
            return true;
    }
}

