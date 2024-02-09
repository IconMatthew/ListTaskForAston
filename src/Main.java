import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();

        list1.add(546);
        list1.add(23);
        list1.add(-123);
        list1.add(0);
        list1.add(43);
        list1.add(2);
        list1.add(8);

        Object[] objects = MyArrayList.sort(list1);

        System.out.println(list1);
        System.out.println(Arrays.toString(objects));

    }
}