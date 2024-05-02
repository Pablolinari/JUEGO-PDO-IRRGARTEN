package irrgarten;

public class Shield extends CombatElement {

    public Shield(float p , int u ){
        super(p, u);
    }
    public float protect(){
        return super.produceEffect();
    }
    
    @Override
    public String toString(){
        return "S" + super.toString();
    }

    public boolean discard(){
        return super.discard();
    }
    
}
