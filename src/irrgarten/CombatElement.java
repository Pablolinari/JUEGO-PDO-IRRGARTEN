package irrgarten;

abstract class CombatElement {
    private float effect;
    private Integer uses;

    CombatElement(float effect ,Integer uses){
        this.effect = effect;
        this.uses=uses;
    }
    protected  float produceEffect(){
        if (uses > 0) {
            uses = uses -1;
            return effect;
        }
        else{
            return 0;
        }
    }
    public boolean discard(){
        return Dice.discardElement(this.uses);
    }
    public  String toString(){
        return String.format("[%f,%d]",effect,uses);
    }

}
