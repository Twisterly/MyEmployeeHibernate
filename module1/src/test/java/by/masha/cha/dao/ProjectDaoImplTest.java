package by.masha.cha.dao;

import by.masha.cha.model.Project;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectDaoImplTest extends BaseDaoTest {

    @Autowired
    ProjectDao targetObject;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void create() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from t_projectg;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);
        Project project = new Project();
        project.setProjectName("TestProject");

        //When
        targetObject.create(project);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from t_project;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);

        conn.createStatement().executeUpdate("delete from t_project;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet projectDataSet = new FlatXmlDataSetBuilder()
                .build(ProjectDaoImplTest.class.getResourceAsStream(
                        "ProjectDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, projectDataSet);

        //When
        List<Project> projectList = targetObject.findAll();

        //Then
        assertEquals(2, projectList.size());
        for(Project project: projectList) {
            assertTrue(project.getEmployees().size() > 0);
        }
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, projectDataSet);
    }
}
