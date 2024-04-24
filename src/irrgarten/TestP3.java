package irrgarten;
import java.util.ArrayList;
public class TestP3 { 
    public static void main(String[] args){

        Labyrinth laberinto = new Labyrinth(4, 4, 2, 1);
        Weapon arma = new Weapon(2.65f,3);
        Weapon arma1 = new Weapon(2.65f,3);
        
        Shield escudo = new Shield(3f, 2);
        Shield escudo1 = new Shield(3f, 3);
        Player jugador = new Player('B', 5.75f, 4);
        
        
        System.out.println(arma.toString());
        System.out.println(escudo.toString());

        System.out.println(jugador.toString());

        jugador.receivedWeapon(arma);
        jugador.receivedWeapon(arma1);
        jugador.receivedShield(escudo);
        jugador.receivedShield(escudo1);
        
        System.out.println(jugador.sumWeapons());
        System.out.println(jugador.sumShields());
        
        System.out.println(jugador.attack());
        System.out.println(jugador.defend(2.65f));

        System.out.println(jugador.newWeapon().toString());
        System.out.println(jugador.newShield().toString());

        System.out.println(jugador.defensiveEnergy());

        jugador.gotWounded();

        System.out.println(jugador.toString()); // Debe salir 1 menos de vida

        jugador.incConsecutiveHits(); 

        System.out.println(jugador.toString());// debe quedarse igual que antes

        jugador.dead();


        jugador.resurrect();
        System.out.println(jugador.toString());
        
        System.out.println("["+jugador.getRow()+","+jugador.getCol()+"]");
        
        ArrayList<Directions> dirc = new ArrayList<>();
        dirc = laberinto.validMoves(jugador.getRow(), jugador.getCol());
        
        jugador.move(Directions.DOWN, laberinto.validMoves(jugador.getRow(), jugador.getCol()));
        
        jugador.move(Directions.UP, laberinto.validMoves(jugador.getRow(), jugador.getCol()));
        
        jugador.receiveReward();
                
        System.out.println("["+jugador.getRow()+","+jugador.getCol()+"]");

        ArrayList<Player> jugadores= new ArrayList<>();
        jugadores.add(jugador);
        
        /***********************Laberinto****************************/

        Player a = new Player('a', 1, 5);
        jugadores.add(a);
        Player z = new Player('z', 0.5f, 4);
        jugadores.add(z);

            
        laberinto.spreadPlayers(jugadores);
        if(laberinto.haveAWinner()){
            System.out.println(laberinto.toString());
            System.out.println("ganador ");
        }
        int []pos =new int [2];
        for (int i = 0; i < 13; i++){
        pos = laberinto.randomEmptyPos();
       
        laberinto.addMonster(pos[0], pos[1], new Monster("cerbero",2,7));
        }
        System.out.println(laberinto.toString());
        laberinto.putPlayer(Directions.LEFT, a);
        
        
        System.out.println(laberinto.toString());
        
        /*************GAME***************/
        
        Game juego = new Game(3);
        
        
        
    }

}