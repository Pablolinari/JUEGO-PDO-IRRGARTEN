package Irrigarten;

import java.util.ArrayList;

public class Player {
    private static final int MAX_WEAPONS=2;
    private static final int MAX_SHIELD=2;
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
    private ArrayList<Shield> ShieldArray = new ArrayList<Shield>(MAX_SHIELD);
    
    
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
        this.row 0 row;
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

    public Directions move(Directions direction, Directions[] validMoves){

    }
    

}
