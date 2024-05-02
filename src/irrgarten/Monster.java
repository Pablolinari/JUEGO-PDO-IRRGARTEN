/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * 
 */
public class Monster extends LabyrinthCharacter {
    private static final int INITIAL_HEALTH=5;

    
    public Monster(String nombre, float inteligencia, float fuerza){
        super(nombre, fuerza, inteligencia, INITIAL_HEALTH);
    }
    @Override
    public float attack(){
        return Dice.intensity(this.getStrength());
    }
    @Override
    public boolean defend(float receivedAttack){
        boolean isDead = this.dead();
        if(!isDead){
            if(Dice.intensity(this.getIntellignece()) < receivedAttack){
                this.gotWounded();
                isDead = this.dead();
            }
        }
        return isDead;
    }
}





