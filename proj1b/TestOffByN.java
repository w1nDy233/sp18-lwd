import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    private static OffByN m0 =new OffByN(0);
    private static OffByN m3 =new OffByN(3);
    private static OffByN m6 =new OffByN(6);
    @Test
    public void testOffByN(){
        assertTrue(m0.equalChars('a','a'));
        assertFalse(m0.equalChars('a','b'));

        assertTrue(m3.equalChars('b','e'));
        assertFalse(m3.equalChars('b','c'));

        assertTrue(m6.equalChars('o','u'));
        assertFalse(m6.equalChars('o','v'));

    }
}
