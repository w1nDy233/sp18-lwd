public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int front;
    private int tail;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = 3;
        tail = 4;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
        front = other.front;
        tail = other.tail;
        size = other.size;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        int p = (front + 1) % items.length;
        int q = (capacity - 1) / 2;
        for (int i = 0; i < size; i++) {
            tmp[q] = items[p];
            p = (p + 1) % items.length;
            q = (q + 1) % capacity;
        }
        items = tmp;
        front = (capacity - 1) / 2 - 1;
        tail = q;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[front] = item;
        front = (front - 1 + items.length) % items.length;
        size++;
    }
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        size++;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        int p = (front + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[p] + " ");
            p = (p + 1) % items.length;
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        front = (front + 1) % items.length;
        T tmp = items[front];
        items[front] = null;
        size--;
        return tmp;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        tail = (tail - 1 + items.length) % items.length;
        T tmp = items[tail];
        items[tail] = null;
        size--;
        return tmp;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int p = (front + 1) % items.length;
        for (int i = 0; i < index; i++) {
            p = (p + 1) % items.length;
        }
        return items[p];
    }
}
