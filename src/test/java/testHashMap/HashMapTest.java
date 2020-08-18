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

        Assertions.assertEquals(map.getValue(24),2);

        map.put(453,67);

        Assertions.assertEquals(map.getValue(453),67);
        System.out.println(map.toString());
    }

    @Test
    void SimpleTest() {
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

    @Test
    public void testWithBigValues() {
        MapInterface map = new MyHashMap();

        for(int i = 1000; i>0; i--) {
            map.put(i,i*i);
        }

        for(int i=1; i<1000; i++) {
            Assertions.assertEquals(map.getValue(i),i*i);
        }

        map.put(4,300);

        Assertions.assertEquals(map.getValue(4),300);
    }

}