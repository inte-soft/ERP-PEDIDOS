package dao;


import com.inte_soft.gestionconsumibles.dao.ItemDao;
import com.inte_soft.gestionconsumibles.dao.OtDao;
import com.inte_soft.gestionconsumibles.entity.Item;
import com.inte_soft.gestionconsumibles.entity.Ot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDaoTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private ItemDao itemDao;

    @BeforeEach
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistencetest");
        entityManager = entityManagerFactory.createEntityManager();
        itemDao = new ItemDao(entityManagerFactory);
    }

    @AfterEach
    public void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void testCreateItem() {
        Ot ot = new Ot("OT001", false, false);
        Item item = new Item(null, "Item1", ot, false, new Date(), false);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item);

        List<Item> items = itemDao.getItems();
        assertFalse(items.isEmpty());
        assertEquals("Item1", items.get(0).getItem());
    }

    @Test
    public void testGetItems() {
        Ot ot = new Ot("OT001", false, false);
        Item item1 = new Item(null, "Item1", ot, false, new Date(), false);
        Item item2 = new Item(null, "Item2", ot, false, new Date(), false);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item1);
        itemDao.createItem(item2);

        List<Item> items = itemDao.getItems();
        assertEquals(2, items.size());
    }

    @Test
    public void testGetItemByOtAndItem() {
        Ot ot = new Ot("OT001", false, false);
        Item item = new Item(null, "Item1", ot, false, new Date(), false);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item);

        Optional<Item> foundItem = itemDao.getItemByOtAndItem(ot, "Item1");
        assertTrue(foundItem.isPresent());
        assertEquals("Item1", foundItem.get().getItem());
    }

    @Test
    public void testUpdateItem() {
        Ot ot = new Ot("OT001", false, false);
        Item item = new Item(null, "Item1", ot, false, new Date(), false);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item);

        item.setItem("UpdatedItem");
        itemDao.updateItem(item);

        Optional<Item> updatedItem = itemDao.getItemByOtAndItem(ot, "UpdatedItem");
        assertTrue(updatedItem.isPresent());
        assertEquals("UpdatedItem", updatedItem.get().getItem());
    }

    @Test
    public void testGetItemsByOt() {
        Ot ot = new Ot("OT001", false, false);
        Item item1 = new Item(null, "Item1", ot, false, new Date(), false);
        Item item2 = new Item(null, "Item2", ot, false, new Date(), false);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item1);
        itemDao.createItem(item2);

        List<Item> items = itemDao.getItemsByOt(ot);
        assertEquals(2, items.size());
    }

    @Test
    public void testUpdateItemAlistado() {
        Ot ot = new Ot("OT001", false, false);
        Item item = new Item(null, "Item1", ot, false, new Date(), false);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item);

        itemDao.updateItemAlistado(ot, "Item1");

        Optional<Item> updatedItem = itemDao.getItemByOtAndItem(ot, "Item1");
        assertTrue(updatedItem.isPresent());
        assertTrue(updatedItem.get().getAlistado());
    }

    @Test
    public void testUpdateItemAlistadoFalse() {
        Ot ot = new Ot("OT001", false, false);
        Item item = new Item(null, "Item1", ot, false, new Date(), true);
        OtDao otDao = new OtDao(entityManagerFactory);
        otDao.createOt(ot);
        itemDao.createItem(item);

        itemDao.updateItemAlistadoFalse(ot, "Item1");

        Optional<Item> updatedItem = itemDao.getItemByOtAndItem(ot, "Item1");
        assertTrue(updatedItem.isPresent());
        assertFalse(updatedItem.get().getAlistado());
    }
}