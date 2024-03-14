/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Irrigarten;

/**
 *
 * 
 */
public class Monster {
    private static final int INITIAL_HEALTH=5;
    private String name;
    private float intelligence;
    private float health;
    private float strength;
    private int row;
    private int col;
    
    public Monster(String nombre, float inteligencia, float fuerza){
        name = nombre;
        intelligence = inteligencia;
        strength = fuerza;
        health = INITIAL_HEALTH;
        row = 0;
        col = 0;
    }
    public boolean dead(){
        if (this.health==0){
            return true;
        }
        else{
            return false;
        }
    }

    public float attack(){
        return Dice.intensity(this.strength);
    }

    // public boolean defend(float receivedAttack){
        
    // }

    public void setPos(int row, int col){
        this.row =row;
        this.col =col;
    }

    public String toString(){
        return String.format("M[%d, %s, %f, %f, %d, %d]", this.INITIAL_HEALTH, this.name, this.intelligence, this.health, this.strength, this.row, this.col);
    }

    public void gotWounded(){
        this.health--;
    }













}





