package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;
public class TestClorus {
    @Test
    public void testMove(){
        Clorus c=new Clorus(1);
        c.move();
        assertEquals(c.energy(),0.97,0.01);
    }
    @Test
    public void TestAttack(){
        Plip p=new Plip(2);
        Clorus c=new Clorus(1);
        c.attack(p);
        assertEquals(c.energy(),3,0.01);
    }
    @Test
    public void TestStay(){
        Clorus c=new Clorus(1);
        c.stay();
        assertEquals(c.energy(),1.01,0.001);
    }
    @Test
    public void TestReplicate(){
        Clorus c=new Clorus(1);
        Clorus cc=c.replicate();
        assertEquals(c.energy(),cc.energy(),0.01);
        assertFalse(c==cc);
    }
    @Test
    public void TestChoose(){
        Clorus c = new Clorus(1);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);
    }
}
