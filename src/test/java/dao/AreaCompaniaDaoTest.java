package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.inte_soft.gestionconsumibles.dao.AreaCompaniaDao;
import com.inte_soft.gestionconsumibles.entity.AreaCompania;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaCompaniaDaoTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private AreaCompaniaDao areaCompaniaDao;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistencetest");
        entityManager = entityManagerFactory.createEntityManager();
        areaCompaniaDao = new AreaCompaniaDao(entityManagerFactory);
        entityManager.getTransaction().begin();
        AreaCompania area1 = new AreaCompania();
        area1.setNombreArea("IT");
        entityManager.persist(area1);
        AreaCompania area2 = new AreaCompania();
        area2.setNombreArea("HR");
        entityManager.persist(area2);
        entityManager.getTransaction().commit();
    }

    @After
    public void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void atestGetAll() {
        areaCompaniaDao = new AreaCompaniaDao(entityManagerFactory);
        List<AreaCompania> areas = areaCompaniaDao.getAll();
        assertNotNull(areas);
        System.out.println("son:" + areas.size());
        assertEquals(4, areas.size());
    }

    @Test
    public void testGetById() {
        areaCompaniaDao = new AreaCompaniaDao(entityManagerFactory);
        AreaCompania area = areaCompaniaDao.getById(1);
        assertNotNull(area);
        assertEquals("IT", area.getNombreArea());
    }

    @Test
    public void testGetByNombreArea() {
        areaCompaniaDao = new AreaCompaniaDao(entityManagerFactory);
        AreaCompania area = areaCompaniaDao.getByNombreArea("HR");
        if (area == null) {
            System.out.println("area es null");
        }
        assertNotNull(area);
        System.out.println("nombre:" + area.getNombreArea());
        assertEquals("HR", area.getNombreArea());
    }
}