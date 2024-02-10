package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.MyArrayList;

import java.util.*;

public class MyArrayListTests {
    @Test
    void testSortForIntegerList(){
        List<Integer> initList = new ArrayList<>(){{
            add(546);
            add(23);
            add(-123);
            add(0);
            add(43);
            add(2);
            add(8);
        }};
        List<Integer> expectedSortedList = new ArrayList<>(){{
            add(-123);
            add(0);
            add(2);
            add(8);
            add(23);
            add(43);
            add(546);
        }};

        List<Object> sortedList = MyArrayList.sort(initList);
        
        Assertions.assertEquals(expectedSortedList, sortedList);
    }

    @Test
    void testSortForIntegerSortedList(){
        List<Integer> initList = new ArrayList<>(){{
            add(-123);
            add(0);
            add(2);
            add(8);
            add(23);
            add(43);
            add(546);
        }};
        List<Integer> expectedSortedList = new ArrayList<>(){{
            add(-123);
            add(0);
            add(2);
            add(8);
            add(23);
            add(43);
            add(546);
        }};

        List<Object> sortedList = MyArrayList.sort(initList);

        Assertions.assertEquals(expectedSortedList, sortedList);
    }

    @Test
    void testSortForStringList(){
        List<String> initList = new ArrayList<>(){{
            add("546");
            add("23");
            add("-123");
            add("0");
            add("43");
            add("2");
            add("8");
        }};
        List<String> expectedSortedList = new ArrayList<>(){{
            add("-123");
            add("0");
            add("2");
            add("23");
            add("43");
            add("546");
            add("8");
        }};

        List<Object> sortedList = MyArrayList.sort(initList);

        Assertions.assertEquals(expectedSortedList, sortedList);
    }

    @Test
    void testAdd(){
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 123});

        integerMyArrayList.add(123);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAdd2Values(){
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 123, -444});

        integerMyArrayList.add(123);
        integerMyArrayList.add(-444);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAddToIndex(){
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 124, 2, 4});

        integerMyArrayList.add(1, 123);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAddToIndex2Values(){
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{-444, 12, 2, 123, 4});

        integerMyArrayList.add(2, 123);
        integerMyArrayList.add(0, -444);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

}