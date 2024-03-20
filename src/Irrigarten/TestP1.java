/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Irrigarten ;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Weapon arma = new Weapon(5.23f, 5);
        Shield escudo = new Shield(3.21f, 3);
        GameState juego = new GameState("laberinto", "pablo,pedro,pepe,jose", "monstruo1,monstruo2", 3, false,
                "122321");

        System.out.printf("PRUEBA ATTACK : %f\n", arma.attack());
        System.out.printf("PRUEBA TOSTRING : %s\n", arma.toString());
        System.out.printf("PRUEBA DISCARD : %b\n", arma.discard());

        System.out.printf("PRUEBA PROTECTION : %f\n", escudo.protect());
        System.out.printf("PRUEBA TOSTRING : %s\n", escudo.toString());
        System.out.printf("PRUEBA DISCARD : %b\n", escudo.discard());

        System.out.printf("PRUEBA weaponsreward %d\n", Dice.weaponsReward());
        System.out.printf("PRUEBA shieldsreward %d\n", Dice.shieldsReward());
        System.out.printf("PRUEBA healthreward %d\n", Dice.healthReward());
        System.out.printf("PRUEBA weaponpower %f\n", Dice.weaponPower());
        System.out.printf("PRUEBA shieldpower %f\n", Dice.shieldPower());
        System.out.printf("PRUEBA usesleft %d\n", Dice.usesLeft());
        System.out.printf("PRUEBA intensity %f\n", Dice.intensity(3.45f));
        System.out.printf("PRUEBA discardelement %b\n", Dice.discardElement(6));

        System.out.printf("PRUEBA getlabrint %s\n", juego.getLabyrinthv());
        System.out.printf("PRUEBA getplayers %s\n", juego.getPlayers());
        System.out.printf("PRUEBA getmonsters %s\n", juego.getMonsters());
        System.out.printf("PRUEBA getcurrentplayer %d\n", juego.getCurrentPlayer());
        System.out.printf("PRUEBA  getwinner %b\n", juego.getWinner());
        System.out.printf("PRUEBA getlog %s\n", juego.getLog());

        Directions direccion = Directions.DOWN;
        System.out.println(direccion);
    }

}
