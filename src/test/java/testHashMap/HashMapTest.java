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
        map.put(1,2);
        map.put(10,2);
        map.put(90,2);
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
    // Сортировка знач
    // Поиск знач

    @Test
    void test22() {
        long i = System.nanoTime();
        MapInterface map = new MyHashMap();
        map.put(7, 8);
        System.out.println("Size = " + map.size());
        long ii = System.nanoTime();
        System.out.println((ii - i) * 1000000000);
    }
}