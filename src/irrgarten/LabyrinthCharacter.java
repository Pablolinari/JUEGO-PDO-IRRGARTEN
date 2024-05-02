package irrgarten;

public abstract class LabyrinthCharacter {
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private Integer row;
    private Integer col;

    LabyrinthCharacter(String name, float intelligence , float strength,float health){
        this.name = name;
        this.intelligence=intelligence;
        this.strength=strength;
        this.health=health;
        this.row=0;
        this.col=0;
    }
    LabyrinthCharacter(LabyrinthCharacter other){
        this(other.name,other.intelligence,other.strength,other.health);
        this.col=other.col;
        this.row=other.row;

        
    }
    public boolean dead(){
        if (this.health<=0){
            return true;
        }
        else{
            return false;
        }
    }
    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }
    protected float getIntellignece(){
        return this.intelligence;
    }
    protected float getStrength(){
        return this.strength;
    }
    protected float getHealth(){
        return this.health;
    }
    protected void setHealth(float health){
        this.health=health;
    }
    public void setPos(Integer row, Integer col){
        this.row=row;
        this.col=col;
    }
    @Override
    public String toString() {
        return String.format("[%s,%f,%f,%f]",this.name,this.intelligence, this.strength, this.health);
    }
    protected void gotWounded(){
        this.health --;
    }
    public abstract float attack();
    public abstract boolean defend(float attack);

}
