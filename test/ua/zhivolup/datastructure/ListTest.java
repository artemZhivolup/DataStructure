package ua.zhivolup.datastructure;

import org.junit.Before;
import org.junit.Test;
import ua.zhivolup.datastructure.arraylist.*;
import ua.zhivolup.datastructure.arraylist.ArrayList;
import ua.zhivolup.datastructure.linkedlist.LinkedList;

import static org.junit.Assert.*;

public class ListTest {

    private List list;

    @Before
    public void before(){
        list = new LinkedList();
    }

    @Test
    public void testSize() throws Exception {
        list.add(new Object());
        assertEquals(1, list.size());
    }

    @Test
    public void testAdd() throws Exception {
        list.add("Artem");
        list.add("Tolik");
        list.add("Chika");
        list.add("Sasha");
        assertTrue(list.size() == 4);
        assertEquals("Tolik", list.get(1));
        System.out.println(list);
    }

    @Test
    public void testAddByIndex() throws Exception {
        list.add("Artem");
        assertTrue(list.size() == 1);
        list.add(0, "Chika");
        assertTrue(list.size() == 2);
        assertEquals("Chika", list.get(0));
        assertEquals("Artem", list.get(1));
        list.add(2, "Sasha");
        assertTrue(list.size() == 3);
        assertEquals("Sasha", list.get(2));
        list.add(1, "Tolik");
        assertTrue(list.size() == 4);
        assertEquals("Tolik", list.get(1));
        assertEquals("Artem", list.get(2));
        System.out.println(list);
    }

    @Test
    public void testGetObjectByIndex() throws Exception {
        list.add("Chika");
        list.add("Tolik");
        list.add("Artem");
        assertTrue(list.size() == 3);
        assertEquals("Chika", list.get(0));
        assertEquals("Tolik", list.get(1));
        assertEquals("Artem", list.get(2));
    }

    @Test
    public void testGetIndexByObject() throws Exception {
        list.add("Artem");
        list.add("Tolik");
        list.add("Sasha");
        assertTrue(list.size() == 3);
        assertEquals(1, list.indexOf("Tolik"));
        assertEquals(0, list.indexOf("Artem"));
        assertEquals(2, list.indexOf("Sasha"));
    }

    @Test
    public void testRemoveByIndex() throws Exception {
        list.add("Chika");
        list.add("Tolik");
        list.add("Artem");
        list.add("Sasha");
        assertTrue(list.size() == 4);
        list.remove(0);
        assertTrue(list.size() == 3);
        assertEquals("Tolik", list.get(0));
        list.remove(1);
        assertTrue(list.size() == 2);
        assertEquals("Sasha", list.get(1));
        list.remove(1);
        assertTrue(list.size() == 1);
    }

    @Test
    public void testRemoveByObject() throws Exception {
        list.add("Chika");
        list.add("Tolik");
        list.add("Artem");
        list.add("Sasha");
        assertTrue(list.size() == 4);
        list.remove("Sasha");
        assertTrue(list.size() == 3);
        list.remove("Tolik");
        assertTrue(list.size() == 2);
        assertEquals("Artem", list.get(1));
        list.remove("Chika");
        assertTrue(list.size() == 1);
    }

    @Test
    public void testSet() throws Exception {
        list.add("Artem");
        list.add("Tolik");
        list.add("Sasha");
        assertTrue(list.size() == 3);
        list.set(1, "Chika");
        assertEquals("Chika", list.get(1));
        assertTrue(list.size() == 3);
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add("Chika");
        list.add("Tolik");
        list.add("Artem");
        list.add("Tolik");
        assertTrue(list.size() == 4);
        assertEquals(1, list.indexOf("Tolik"));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        list.add("Chika");
        list.add("Tolik");
        list.add("Artem");
        list.add("Tolik");
        assertTrue(list.size() == 4);
        assertEquals(3, list.lastIndexOf("Tolik"));
    }

    @Test
    public void testContains() throws Exception {
        list.add("Artem");
        list.add("Tolik");
        assertTrue(list.size() == 2);
        assertTrue(list.contains("Tolik"));
    }

    @Test
    public void testClear() throws Exception {
        list.add("Tolik");
        list.add("Artem");
        assertTrue(list.size() == 2);
        list.clear();
        assertTrue(list.size() == 0);
        System.out.println(list);
    }

    @Test
    public void testIsEmpty() throws Exception {
        list.add("Tolik");
        list.add("Artem");
        assertTrue(list.size() == 2);
        list.clear();
        assertTrue(list.isEmpty());
    }
}