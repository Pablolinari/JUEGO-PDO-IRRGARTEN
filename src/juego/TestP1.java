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
    public static void main(String[] args) {
        Dice dado = new Dice();
        Weapon arma = new Weapon(5.23f, 5);
        Shield escudo = new Shield(3.21f, 3);
        GameState juego = new GameState("laberinto", "pablo,pedro,pepe,jose", "monstruo1,monstruo2", 3, false,
                "122321");

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
        System.out.printf("PRUEBA shieldpower %.f", dado.shieldPower());
        System.out.printf("PRUEBA usesleft %d", dado.usesLeft());
        System.out.printf("PRUEBA intensity %.f", dado.intensity(3.45f));
        System.out.printf("PRUEBA discardelement %b", dado.discardElement(6));

        System.out.printf("PRUEBA getlabrint %s", juego.getLabyrinthv());
        System.out.printf("PRUEBA getplayers %s", juego.getPlayers());
        System.out.printf("PRUEBA getmonsters %s", juego.getMonsters());
        System.out.printf("PRUEBA getcurrentplayer %d", juego.getCurrentPlayer());
        System.out.printf("PRUEBA  getwinner %b", juego.getWinner());
        System.out.printf("PRUEBA getlog %s", juego.getLog());

        Directions direccion = Directions.DOWN;
        System.out.println(direccion);
    }

}
