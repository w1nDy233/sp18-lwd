import java.sql.Array;

public class ArrayDequeTest {
    public static void main(String[] args){
           ArrayDeque<Integer> ad=new ArrayDeque<>();
           for(int i=0;i<15;i++){
               ad.addLast(i);
           }
           ad.printDeque();
           ad.addFirst(-1);
           ad.printDeque();
           ad.addFirst(-2);
           ad.printDeque();
           ad.addLast(-15);
           ad.printDeque();
           ad.removeFirst();
           ad.printDeque();
           ad.removeLast();
           ad.printDeque();
           Integer tmp=ad.get(15);
           System.out.println(tmp);
           ArrayDeque<Integer> add=new ArrayDeque<>(ad);
           add.removeFirst();
           add.printDeque();
    }
}
