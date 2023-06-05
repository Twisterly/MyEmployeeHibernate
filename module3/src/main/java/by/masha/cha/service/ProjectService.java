package by.masha.cha.service;

import by.masha.cha.dao.ProjectDao;
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
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Transactional
    public void add(Project project) {
        projectDao.create(project);
    }

    public List<Project> getAll() {
        return projectDao.findAll();
    }

    public Project update(Project project, Long id) {
        Project updatedProject = projectDao.findById(id);
        updatedProject.setProjectName(project.getProjectName());

//        Set<Project> projectSet = new HashSet<>(projectListUpdated);
//        List<Project> projectList = new ArrayList<>(projectSet);

        projectDao.update(updatedProject);
        return projectDao.findById(id);
    }


    public Project findById(Long id) {
        return projectDao.findById(id);
    }

    public void delete(Project project) {
        projectDao.delete(project);
    }

    public boolean isAlreadyExist(Project project) {
        return projectDao.isAlreadyExist(project);
    }

    public List<Project> findProjectsById(List<String> projects) {
        List<Project> result = new ArrayList<>();
        for (String id : projects) {
            result.add(projectDao.findById(Long.valueOf(id)));
        }
        return result;
    }
}
