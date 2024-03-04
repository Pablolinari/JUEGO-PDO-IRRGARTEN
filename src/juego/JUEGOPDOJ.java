/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class JUEGOPDOJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Weapon wep = new Weapon(2, 4);
        System.out.printf("prueba wep \n%f \n, %s \n, \n%b%n\n",wep.attack(),wep.toString(),wep.discard());
        
    }
    
}
