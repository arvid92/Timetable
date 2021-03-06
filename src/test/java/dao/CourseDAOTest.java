package dao;

import de.nordakademie.iaa.Application;
import de.nordakademie.iaa.dao.CourseDAO;
import de.nordakademie.iaa.model.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for CourseDAO class.
 *
 * @author Arvid Ottenberg
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class})
@Transactional
public class CourseDAOTest {

    @Autowired
    private CourseDAO courseDAO;

    @PersistenceContext
    private EntityManager entityManager;

    private Course course;

    @Before
    public void setupData() {
        course = new Course("Test Driven Development", "I", 123 );
        courseDAO.save(course);
    }

    @Test
    public void testFindOne() {
        Course course = courseDAO.findOne(this.course.getId());
        compareCourses(course);
    }

    @Test
    public void testFindAll() {
        List<Course> courses = courseDAO.findAll();
        assertEquals(1, courses.size());
        courses.forEach(this::compareCourses);
    }

    @Test
    public void testFindByTitle() {
        Course course = courseDAO.findByTitle(this.course.getTitle());
        compareCourses(course);
    }

    @Test
    public void testDelete() {
        courseDAO.delete(course);
        assertTrue(courseDAO.findAll().isEmpty());
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }

    private void compareCourses(Course course) {
        assertEquals(this.course.getField(), course.getField());
        assertEquals(this.course.getNumber(), course.getNumber());
        assertEquals(this.course.getTitle(), course.getTitle());
    }
}