package irrgarten;

public class Weapon {
    private float power;
    private int uses;

    public Weapon(float p , int u ){
        power = p;
        uses = u;
    }
    public float attack(){
        if (uses > 0) {
            uses = uses -1;
            return power;
        }
        else{
            return 0;
        }
    } 

    @Override
    public String toString(){
        return String.format("W[%f,%d]", power,uses);
    }
    public boolean discard(){
        return Dice.discardElement(this.uses);
    }
}
