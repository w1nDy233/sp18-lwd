package synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
    public int capacity();
    public int fillCount();
    public void enqueue(T x);
    public T dequeue();
    public T peek();
    public default boolean isEmpty(){
        return fillCount()==0;
    }
    public default  boolean isFull(){
        return fillCount()==capacity();
    }
    public Iterator<T> iterator();
}
