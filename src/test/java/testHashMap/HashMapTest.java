package testHashMap;

import com.kostin.algorithms.MapInterface;
import com.kostin.algorithms.MyHashMap;
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

        map.get(24);

        map.put(453,67);

        System.out.println(map.size());

        map.get(453);

        map.printMaxLenght();
        map.printAllArray();

    }

    // Добавить ключи не могут повторятся
    // Complete!!! Сортировка знач
    // Поиск знач

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

        map.printAllArray();

        System.out.println(map.get(93));

        System.out.println();

        map.printAllArray();
    }
}