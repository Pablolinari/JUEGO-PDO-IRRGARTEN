package juego;

public class Shield {
    private float protection; 
    private int uses;

    public shield(float p , int u ){
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
        return discardElement(uses);
    }
    
}
