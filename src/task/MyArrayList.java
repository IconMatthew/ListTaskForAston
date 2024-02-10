package task;

import java.util.*;

public class MyArrayList<T> {

    private static final int INIT_CAP = 10;
    private static final int EMPTY_CAP = 0;
    Object[] arr;
    private int size;

    List<T> list = new ArrayList<>();

    public MyArrayList(Collection<? extends T> c) {
        if (!c.isEmpty()) {
            this.arr = c.toArray();
            size = c.size();
        }
    }

    public MyArrayList(T[] t) {
        this.arr = t;
        size = t.length;
    }

    public MyArrayList() {
        arr = new Object[EMPTY_CAP];
    }

    public void add(T t) {
        try {
            increaseCap();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        arr[size] = t;
        size++;
    }

    public void add(int index, T t) {

        checkIfOutOfBounds(index);

        try {
            increaseCap();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = t;
        size++;
    }

    private void increaseCap() {

        if (size == Integer.MAX_VALUE) throw new RuntimeException("Max length achieved!");

        if (arr.length == EMPTY_CAP) arr = new Object[INIT_CAP];
        else if (size >= (arr.length * 0.75)) {
            try {
                arr = Arrays.copyOfRange(arr, 0, (int) (size * 2));
            } catch (Exception e) {
                arr = Arrays.copyOfRange(arr, 0, Integer.MAX_VALUE);
            }
        }
    }

    private void checkIfOutOfBounds(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    public T get(int index) {
        checkIfOutOfBounds(index);
        return (T) arr[index];
    }

    public T remove(int index) {
        checkIfOutOfBounds(index);
        Object val = arr[index];
        if (size - 1 > index) {
            System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
        }

        size--;
        return (T) val;
    }

    public boolean addAll(Collection<? extends T> c) {
        Object[] t = c.toArray();
        return addAll((T[]) t);
    }

    public boolean addAll(T[] t) {

        if (t.length == 0) return false;

        while (t.length > arr.length - size) {
            increaseCap();
        }

        System.arraycopy(t, 0, arr, size, t.length);
        size += t.length;
        return true;
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        return Arrays.copyOf(arr, size, Object[].class);
    }

    public static List<Object> sort(Collection<? extends Object> list) {

        boolean sorted = false;
        Object[] objectList = list.toArray();

        for (int i = 0; i < objectList.length - 1; ++i) {
            if (((Comparable) objectList[i]).compareTo(objectList[i + 1]) > 0) {
                sorted = true;
            } else {
                sorted = false;
                break;
            }
        }

        if (sorted) return null;

        if (objectList.length > 1) {
            for (int i = 0; i < objectList.length - 1; i++) {
                for (int j = 0; j < objectList.length - 1; j++) {
                    if (((Comparable) objectList[j]).compareTo(objectList[j + 1]) > 0) {
                        Object temp = objectList[j + 1];
                        objectList[j + 1] = objectList[j];
                        objectList[j] = temp;
                    }
                }
            }
        }

        return List.of(objectList);
    }

    public T set(int index, T elem) {
        checkIfOutOfBounds(index);
        T oldValue = (T) arr[index];
        arr[index] = elem;
        return oldValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange((T[]) arr, 0, size));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyArrayList<?> that)) return false;
        return size == that.size && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, list);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
