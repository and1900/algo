package concurrency;

import java.util.HashMap;

public class ArrayBlockingQueue {
    private final Object[] items;

    public ArrayBlockingQueue(int capacity) {
        items = new Object[capacity];
    }
}
