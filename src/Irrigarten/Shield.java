package Irrigarten;

public class Shield {
    private float protection; 
    private int uses;

    public Shield(float p , int u ){
        protection = p;
        uses = u;
    }
    public float protect(){
        if (uses > 0) {
            uses = uses -1;
            return protection;
        }
        else{
            return 0;
        }
    }
    public String toString(){
        return String.format("S[%f,%d]", protection, uses);
    }

    public boolean discard(){
        return Dice.discardElement(this.uses);
    }
    
}
