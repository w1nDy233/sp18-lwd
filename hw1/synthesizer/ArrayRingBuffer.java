package synthesizer;
import java.util.Iterator;
public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    private int first;
    private int last;
    private int size;
    public T[] rb;
    public ArrayRingBuffer(int capacity){
        rb=(T[]) new Object[capacity];
        first=0;
        last=0;
        size=0;
    }
    private int addOne(int pos){
        return (pos+1)%capacity();
    }
    @Override
    public int capacity(){
        return rb.length;
    }
    @Override
    public int fillCount(){
        return size;
    }
    @Override
    public void enqueue(T x){
        if(isFull()){
            throw new RuntimeException("String Buffer overrflow");
        }
        rb[last]=x;
        last=addOne(last);
        size++;
    }
    @Override
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Ring Buffer underflow");
        }
        T tmp=rb[first];
        rb[first]=null;
        first=addOne(first);
        size--;
        return tmp;
    }
    @Override
    public T peek(){
        return rb[first];
    }

    private class ARBIterator implements Iterator<T>{
        private int pos;
        private int cap;
        public ARBIterator(){
            pos=first;
            cap=size;
        }
        @Override
        public boolean hasNext(){
            return cap>0;
        }
        @Override
        public T next(){
            T returnItem=rb[pos];
            pos=addOne(pos);
            cap--;
            return returnItem;
        }
    }
    public Iterator<T> iterator(){
        return new ARBIterator();
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ArrayRingBuffer<T> obj=(ArrayRingBuffer<T>) o;
        if(this.capacity()!=obj.capacity()){
            return false;
        }
        for(T item:this){
            if(!item.equals(obj.dequeue())){
                return false;
            }
        }
        return true;
    }

}
