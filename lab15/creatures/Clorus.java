package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;
public class Clorus extends Creature {
    private final int r=34;
    private final int g=0;
    private final int b=231;
    public Clorus(double e){
        super("clorus");
        energy=e;
    }
    public Clorus(){
        this(1);
    }
    public Color color(){
        return color(r,g,b);
    }
    public void stay(){
        energy+=0.01;
    }
    public void move(){
        energy-=0.03;
        if(energy<0){
            energy=0;
        }
    }
    public void attack(Creature c){
        energy+=c.energy();
    }
    public Clorus replicate() {
        double tmp=0.5*this.energy;
        energy-=tmp;
        return new Clorus(tmp);
    }
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        //return new Action(Action.ActionType.STAY);
        List<Direction> empties =getNeighborsOfType(neighbors,"empty");
        List<Direction> plips=getNeighborsOfType(neighbors,"plip");
        if(empties.size()==0){
            return new Action(Action.ActionType.STAY);
        }else if(plips.size()>=1){
            Direction moveDir = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK,moveDir);
        }else if(energy>=1){
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE,moveDir);
        }else{
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.MOVE,moveDir);
        }
    }
}
