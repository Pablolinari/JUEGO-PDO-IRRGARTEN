package irrgarten;

public class CombatElement {
    private float effect;
    private Integer uses;

    CombatElement(float effect ,Integer uses){
        this.effect = effect;
        this.uses=uses;
    }
    protected float produceEffect(){
        return 0.1f;
    }
    public boolean discard(){

    }

    @Override
    public String toString(){

    }

}
