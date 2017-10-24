package de.nordakademie.iaa.test.dao;

import de.nordakademie.iaa.ApplicationConfig;
import de.nordakademie.iaa.dao.CenturyDAO;
import de.nordakademie.iaa.model.Century;
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

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arvid on 24.10.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class})
@Transactional
public class CenturyDAOTest {
    @Autowired
    private CenturyDAO centuryDAO;
    @PersistenceContext
    private EntityManager entityManager;

    private Century century;

    @Before
    public void setupData() {
        century = new Century("I14a",42);
        centuryDAO.save(century);
    }

    @After
    public void tearDown() {
        entityManager.clear();
    }

    @Test
    public void testFindOne() {
        Century century = centuryDAO.findOne(this.century.getId());

        assertEquals(this.century.getNumberOfStudents(), century.getNumberOfStudents());
        assertEquals(this.century.getName(), century.getName());
    }

    @Test
    public void testFindAll() {
        List<Century> centurys = centuryDAO.findAll();

        assertEquals(1, centurys.size());

        for(Century century : centurys) {
            assertEquals(this.century.getNumberOfStudents(), century.getNumberOfStudents());
            assertEquals(this.century.getName(), century.getName());
        }
    }

    @Test
    public void testDelete() {
        centuryDAO.delete(this.century);
        List<Century> centurys = centuryDAO.findAll();

        assertTrue(centurys.isEmpty());

    }

    @Test
    public void testDeleteById() {
        centuryDAO.deleteById(this.century.getId());
        List<Century> centurys = centuryDAO.findAll();

        assertTrue(centurys.isEmpty());
    }
}