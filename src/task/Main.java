package task;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> initList = new ArrayList<>(){{
            add(222);
            add(23);
            add(-123);
            add(0);
            add(43);
            add(2);
            add(8);
        }};

        System.out.println(initList);
        System.out.println(MyArrayList.sort(initList));

    }
}