package Irrigarten;

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

    private ArrayList<Weapon> WeaponArray = new ArrayList<Weapon>(MAX_WEAPONS);
    private ArrayList<Shield> ShieldArray = new ArrayList<Shield>(MAX_SHIELDS);
    
    
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
    
    public boolean dead(){
        if (this.health==0){
            return true;
        }
        else{
            return false;
        }
    }

    // public Directions move(Directions direction, Directions[] validMoves){
    //     return 
    // }
    
    public float attack(){
        return this.strength + this.sumWeapons();
    }
    
    // public boolean defend(float receivedAttack){
    //     boolean defended = true;

    //     return defended;
    // }

    public String toString(){
        return String.format("P[%d, %d, %d, %d, %s, %c, %f, %f, %f, %d, %d, %d]", MAX_WEAPONS, MAX_SHIELDS, INITIAL_HEALTH, HITS2LOSE,
         this.name, this.number, this.intelligence, this.strength, this.health, this.row, this.col, this.consecutiveHits);

    }    

    // public void receivedWeapon(){

    // }

    // public void receivedShield(){


    // }

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
        for (int i=0; i< MAX_WEAPONS; i++){
            result += WeaponArray.get(i).attack();
        }
        return result;
    }

    public float sumShields(){
        float result = 0;
        for (int i=0; i< MAX_SHIELDS; i++){
            result += ShieldArray.get(i).protect();
        }
        return result;
    }

    public float defensiveEnergy(){
        return this.intelligence + this.sumShields();
    }

    // public boolean manageHit(float receivedAttack){
        
    // }
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
