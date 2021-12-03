package synthesizer;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        ArrayRingBuffer<Double> arr=new ArrayRingBuffer<>(10);
        StdOut.println(arr.peek());
    }
} 
