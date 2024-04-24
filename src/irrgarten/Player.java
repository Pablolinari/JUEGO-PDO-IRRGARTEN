package irrgarten;

import java.util.ArrayList;

public class Player {
    private static final int MAX_WEAPONS=2;
    private static final int MAX_SHIELDS=2;
    private static final int INITIAL_HEALTH=2;
    private static final int HITS2LOSE=2;
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits;

    private ArrayList<Weapon> WeaponArray = new ArrayList<Weapon>();
    private ArrayList<Shield> ShieldArray = new ArrayList<Shield>();
    
    
    public Player(char number, float intelligence, float strength){
        this.name = String.format("Player %c", number);
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.resurrect();
        this.row = 0;
        this.col = 0;
    }

    public void resurrect(){
        this.WeaponArray.clear();
        this.ShieldArray.clear();
        this.health = INITIAL_HEALTH;
        this.consecutiveHits = 0;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    public char getNumber(){
        return this.number;
    }
    
    public boolean dead(){
        if (this.health==0){
            return true;
        }
        else{
            return false;
        }
    }
    //Mover el jugador hacia una de las posiciones validas
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        if (validMoves.size() > 0 && !validMoves.contains(direction)){
            return validMoves.get(0);
        } 
        else 
        return direction;
        
    }
    
    public float attack(){
        return this.strength + this.sumWeapons();
    }
    
    public boolean defend(float receivedAttack){
      return this.manageHit(receivedAttack);  
    }
    /**
     * Jugador recive una recompensa (supongo que por ganar un combate)
     * Funcion void que añade nuevas armas y escudos además de poder aumentar la vida del jugador
     */ 
    public void receiveReward(){
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();

        for (int i = 0; i < wReward; i++ ){
            Weapon wNew = newWeapon();
            this.receivedWeapon(wNew);
        }
        for (int i = 0; i < sReward; i++){
            Shield sNew = newShield();
            this.receivedShield(sNew);
        }

        int extraHealth = Dice.healthReward();
        this.health += extraHealth;
        
    }

   @Override
    public String toString(){
        return String.format("P[%s,%f,%f,%f]",this.name,this.intelligence, this.strength, this.health);

    }    

    public void receivedWeapon(Weapon w){
        WeaponArray.removeIf(Weapon::discard);
        int size = WeaponArray.size();
        if (size < MAX_WEAPONS){
            WeaponArray.add(w);
        }
    }

    public void receivedShield(Shield s){
        ShieldArray.removeIf(Shield::discard);
        int size = ShieldArray.size();
        if (size < MAX_SHIELDS){
            ShieldArray.add(s);
        }

    }

    public Weapon newWeapon(){
        float power = Dice.weaponPower();
        int uses = Dice.usesLeft();
        return new Weapon(power, uses);
    }

    public Shield newShield(){
        float protection = Dice.shieldPower();
        int uses = Dice.usesLeft();
        return new Shield(protection, uses);
    }

    public float sumWeapons(){
        float result = 0;
        for (int i=0; i< WeaponArray.size(); i++){
            result += WeaponArray.get(i).attack();
        }
        return result;
    }

    public float sumShields(){
        float result = 0;
        for (int i=0; i< ShieldArray.size(); i++){
            result += ShieldArray.get(i).protect();
        }
        return result;
    }

    public float defensiveEnergy(){
        return this.intelligence + this.sumShields();
    }

    private boolean manageHit(float receivedAttack){
        if(this.defensiveEnergy() < receivedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
        }
        else{
            resetHits();
        }
        if((this.consecutiveHits == HITS2LOSE) || this.dead()){
            this.resetHits();
            return true;
        }
        else{
            return false;
        }
    }
    public void resetHits(){
        this.consecutiveHits = 0;
    }

    public void gotWounded(){
        this.health --;
    }

    public void incConsecutiveHits(){
        this.health++;
    }
}
