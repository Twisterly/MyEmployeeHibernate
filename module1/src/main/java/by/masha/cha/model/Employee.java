package by.masha.cha.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "t_employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "t_employee_seq")
    private Long id;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "F_DEPARTMENTID")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE})
    @JoinTable(
            name = "t_employee_project",
            joinColumns = @JoinColumn(name = "F_EMPLOYEEID"),
            inverseJoinColumns = @JoinColumn(name = "F_PROJECT_ID")
    )
    private Set<Project> projects;

//    @PreRemove
//    private void removeProjectsAssociations() {
//        for (Project project: this.projects) {
//            project.getEmployees().remove(this);
//        }
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", cellPhone='" + cellPhone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}

