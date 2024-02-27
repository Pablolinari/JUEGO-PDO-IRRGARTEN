package juego;

public class weapon {
    private float power;
    private int uses;

    public weapon(float p , int u ){
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
    public String toString(){
        return String.format("W[%f,%d]", power,uses);
    }
}
