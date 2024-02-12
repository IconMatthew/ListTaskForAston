package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTests {
    @Test
    void testSortForIntegerList() {
        List<Integer> initList = new ArrayList<>() {{
            add(546);
            add(23);
            add(-123);
            add(0);
            add(43);
            add(2);
            add(8);
        }};
        List<Integer> expectedSortedList = new ArrayList<>() {{
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
    void testSortForIntegerSortedList() {
        List<Integer> initList = new ArrayList<>() {{
            add(-123);
            add(0);
            add(2);
            add(8);
            add(23);
            add(43);
            add(546);
        }};
        List<Integer> expectedSortedList = new ArrayList<>() {{
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
    void testSortForStringList() {
        List<String> initList = new ArrayList<>() {{
            add("546");
            add("23");
            add("-123");
            add("0");
            add("43");
            add("2");
            add("8");
        }};
        List<String> expectedSortedList = new ArrayList<>() {{
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
    void testAdd() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 123});

        integerMyArrayList.add(123);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAdd2Values() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 123, -444});

        integerMyArrayList.add(123);
        integerMyArrayList.add(-444);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAddToIndex() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 123, 2, 4});

        integerMyArrayList.add(1, 123);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAddToIndex2Values() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{-444, 12, 2, 123, 4});

        integerMyArrayList.add(2, 123);
        integerMyArrayList.add(0, -444);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAddAll() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 2, 123, 0, -444});

        integerMyArrayList.addAll(new Integer[]{2, 123});
        integerMyArrayList.addAll(new Integer[]{0, -444});

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testAddAllUsingList() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 2, 123, 0, -444});

        ArrayList<Integer> numsToAdd1 = new ArrayList<>();
        numsToAdd1.add(2);
        numsToAdd1.add(123);

        ArrayList<Integer> numsToAdd2 = new ArrayList<>();
        numsToAdd2.add(0);
        numsToAdd2.add(-444);

        integerMyArrayList.addAll(numsToAdd1);
        integerMyArrayList.addAll(numsToAdd2);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testRemoveIndex() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 2, 123, 0, -444});
        MyArrayList<Integer> expectedIntegerMyArrayList = new MyArrayList<>(new Integer[]{12, 4, 2, 0, -444});

        integerMyArrayList.remove(4);
        integerMyArrayList.remove(1);

        Assertions.assertEquals(expectedIntegerMyArrayList, integerMyArrayList);
    }

    @Test
    void testGet() {
        List<Integer> initList = new ArrayList<>() {{
            add(2);
            add(4);
            add(2);
            add(123);
            add(0);
            add(-444);
        }};

        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(initList);
        int exp4 = 0;
        int exp5 = -444;
        int exp0 = 2;
        System.out.println(integerMyArrayList);
        Assertions.assertEquals(exp4, integerMyArrayList.get(4));
        Assertions.assertEquals(exp5, integerMyArrayList.get(5));
        Assertions.assertEquals(exp0, integerMyArrayList.get(0));
    }

    @Test
    void testSize() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 2, 123, 0, -444});
        int expSize = 7;

        Assertions.assertEquals(expSize, integerMyArrayList.size());
    }

    @Test
    void testToArray() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(new Integer[]{12, 2, 4, 2, 123, 0, -444});
        Object[] integerMyArrayArray = integerMyArrayList.toArray();
        Object[] expArray = new Integer[]{12, 2, 4, 2, 123, 0, -444};

        for (int i = 0; i < integerMyArrayList.size(); i++) {
            Assertions.assertEquals(integerMyArrayArray[i], expArray[i]);
        }
    }

}