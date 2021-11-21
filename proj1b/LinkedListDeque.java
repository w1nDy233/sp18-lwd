public class LinkedListDeque<T> implements Deque<T>{
    private class TNode{
        public T data;
        public TNode prev;
        public TNode next;
        public TNode(T d,TNode p,TNode n){
            data=d;
            prev=p;
            next=n;
        }
    }
    private TNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel =new TNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
    }
    public LinkedListDeque(LinkedListDeque other){
        sentinel=new TNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;

        TNode ptr=other.sentinel.next;
        TNode tmp=sentinel;
        while(ptr!=other.sentinel){
            addLast(ptr.data);
            ptr=ptr.next;
        }
    }
    @Override
    public void addFirst(T d){
        sentinel.next.prev=new TNode(d,sentinel,sentinel.next);
        sentinel.next=sentinel.next.prev;
        size++;
    }
    @Override
    public void addLast(T d){
        sentinel.prev.next=new TNode(d,sentinel.prev,sentinel);
        sentinel.prev=sentinel.prev.next;
        size++;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public T removeFirst(){
        if(size==0){
            return null;
        }
        T tmp=sentinel.next.data;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size--;
        return tmp;
    }
    @Override
    public T removeLast(){
        if(size==0){
            return null;
        }
        T tmp=sentinel.prev.data;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size--;
        return tmp;
    }
    @Override
    public void printDeque(){
        TNode ptr=sentinel.next;
        while(ptr!=sentinel){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }
    @Override
    public T get(int index){
        if(index<0||index>size-1){
            return null;
        }
        TNode ptr=sentinel.next;
        int i=0;
        while(i<index){
            ptr=ptr.next;
            i++;
        }
        return ptr.data;
    }
    /**实例方法中可以直接调用实例方法 */
    public T getRecursive(int index){
        if(index<0||index>size-1){
            return null;
        }
        return gett(sentinel.next,index);
    }
    private T gett(TNode ptr,int i){
        if(i==0){
            return ptr.data;
        }
        return gett(ptr.next,i-1);
    }
}
