package Irrigarten;

import java.util.ArrayList;

public class Game {
    static private final int MAX_ROUNDS = 10;
    private int currentPlayerIndex;
    private String log;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private Labyrinth labyrinth;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Player currentPlayer;

    Game(int nplayers){
        this.currentPlayerIndex = Dice.whoStarts(nplayers);
        this.log = "";
        this.labyrinth = new Labyrinth();
        for(int i =0; i< nplayers;i++){
            this.players.set(i,new Player(Character.forDigit(i, 10),Dice.randomIntelligence(),Dice.randomStreangth()));
        }
        this.currentPlayer = players.get(this.currentPlayerIndex);
        
    }
    public boolean finished(){
        return this.labyrinth.haveAWinner();
    }
    public GameState getGameState(){
        String cadplayers ="";
        String cadmonsters = "";
        for(int i = 0; i< this.players.size(); i++){
            cadplayers.concat(players.get(i).toString());
        }
        for(int i = 0; i< this.monsters.size(); i++){
            cadmonsters.concat(monsters.get(i).toString());
        }
        return new GameState(this.labyrinth.toString(), cadplayers,cadmonsters,this.currentPlayerIndex,finished(),log);
    }
    public void ConfigureLabyrinth(){
    }

    private void nextPlayer(){
        if(this.currentPlayerIndex < players.size()-1){
            this.currentPlayerIndex+=1;
            this.currentPlayer = this.players.get(this.currentPlayerIndex);
        }
        else{
            this.currentPlayerIndex = 0;
            this.currentPlayer = this.players.get(0);
        }
    }

    private void logPlayerWon(){
        this.log.concat("Has ganado el combate! \n");
    }
    private void logMonsterWon(){
        this.log.concat("El monstruo ha ganadpo el combate! \n");
    }
    private void logResurrected(){
        this.log.concat("Acabas de resucitar\n");
    }
    private void logPlayerSkipTurn(){
        this.log.concat("Has perdido el turno por estar muerto \n");
    }
    private void logPlayerNoOrders(){
        this.log.concat("No ha sido posible seguir la instrucción\n");
    }
    private void logNoMonster(){
        this.log.concat("Te has movido a una celda vacia\n");
    }
    private void logRounds(int rounds , int max){

        this.log = String.format("Se han jugado %d rondas de %d \n", rounds,max);    
    }

}