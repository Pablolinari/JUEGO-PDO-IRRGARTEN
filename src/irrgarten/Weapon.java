package irrgarten;

public class Weapon extends CombatElement {

    public Weapon(float p , int u ){
        super(p, u);
    }
    public float attack(){
        return super.produceEffect();
    } 

    @Override
    public String toString(){
        return "W" + super.toString();
    }
    public boolean discard(){
        return super.discard();
    }
}
