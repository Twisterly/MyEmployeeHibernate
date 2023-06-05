package by.masha.cha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "T_PROJECT")
@Getter
@Setter
public class Project {

    @Id
    @Column(name = "F_PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "t_project_seq")
    private Long id;

    @Column(name = "F_PROJECT_NAME")
    private String projectName;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<Employee> employees;

//    @PreRemove
//    private void removeEmployeeAssociations() {
//        for (Employee employee: this.employees) {
//            employee.getProjects().remove(this);
//        }
//        this.employees.clear();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName);
    }
}
