package testHashMap;

import com.kostin.algorithms.MapInterface;
import com.kostin.algorithms.MyHashMap;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HashMapTest {

    @Test
    void testSortedFunction() {
        MapInterface map = new MyHashMap();
        map.put(1,23);
        map.put(10,22);
        map.put(90,21);
        map.put(7,2);
        map.put(2,2);
        map.put(4,2);

        map.put(170,2);
        map.put(970,2);
        map.put(77,2);
        map.put(27,2);
        map.put(47,2);

        map.put(104,2);
        map.put(904,2);
        map.put(74,2);
        map.put(24,2);
        map.put(44,2);

        map.put(456,67);

        System.out.println(map.toString());

        map.getValue(24);

        map.put(453,67);

        System.out.println(map.size());

        map.getValue(453);

        System.out.println("Size -> "+map.size());
        System.out.println(map.toString());

    }

    // Complete!!! Добавить ключи не могут повторятся
    // Complete!!! Сортировка знач
    // Complete!!! Поиск знач

    @Test
    void test22() {
        MapInterface map = new MyHashMap();

        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        map.put(8,2);
        map.put(100,9);

        map.put(9,21);
        map.put(97,31);
        map.put(93,41);
        map.put(98,21);
        map.put(99,61);

        Assertions.assertEquals(map.getValue(93),41);
    }

    @Test
    public void testGettingValueIfArrayHasOnlyOneValue() {
        MapInterface map = new MyHashMap();

        map.put(11,100);

        Assertions.assertEquals(map.getValue(11),100);
    }

    @Test
    public void testGettingValueIfHashMapIsNotExist() {
        MapInterface map = new MyHashMap();

        map.put(11,100);

        try{
            map.getValue(1);
        } catch (NullPointerException ex) {}
    }


    @Test
    public void testGettingValueIfHashMapIsEmpty() {
        MapInterface map = new MyHashMap();

        try{
            map.getValue(1);
        } catch (NegativeArraySizeException ex) {}
    }

    @Test
    public void test333(){
        MapInterface map = new MyHashMap();

        map.put(100,600);
        map.put(110,50);
        map.put(1,6);
        map.put(3,500);
        map.put(7,8);

        map.put(1,900);

        try{
            map.getValue(10);
        } catch (Exception ex) {}

        Assertions.assertEquals(map.getValue(3),500);
        Assertions.assertEquals(map.getValue(7),8);
        Assertions.assertEquals(map.getValue(1),900);
    }

    @Test
    public void globalTest() {
        MapInterface map = new MyHashMap();

        map.put(1,5);
        map.put(2,4);
        map.put(90,3);
        map.put(4,2);
        map.put(5,1);

        map.put(5,10);
        map.put(10,100);
        map.put(20,20);

        Assertions.assertEquals(map.getValue(4),2);
        Assertions.assertEquals(map.getValue(5),10);
        Assertions.assertEquals(map.getValue(20),20);

        Assertions.assertFalse(map.toString().equals("[1 = 5] [2 = 4] [4 = 2] [5 = 10] [10 = 100] [20 = 20] [90 = 3] [999 = 5]"));
    }

}