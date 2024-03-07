/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
       Dice dado = new Dice();
       Weapon arma = new Weapon(5.23f, 5);
       Shield escudo = new Shield(3.21f,3 );
       GameState juego = new GameState("laberinto", "pablo,pedro,pepe,jose","monstruo1,monstruo2", 3, false, "122321");

       System.out.printf("PRUEBA ATTACK : %f", arma.attack());
       System.out.printf("PRUEBA TOSTRING : %s", arma.toString());
       System.out.printf("PRUEBA DISCARD : %b", arma.discard());

       System.out.printf("PRUEBA PROTECTION : %f", escudo.protect());
       System.out.printf("PRUEBA TOSTRING : %s", escudo.toString());
       System.out.printf("PRUEBA DISCARD : %b", escudo.discard());

       System.out.printf("PRUEBA weaponsreward %d", dado.weaponsReward());
       System.out.printf("PRUEBA shieldsreward %d", dado.shieldsReward());
       System.out.printf("PRUEBA healthreward %d", dado.healthReward());
       System.out.printf("PRUEBA weaponpower %.f", dado.weaponPower());
        


    }
    
}
