package irrgarten;

import java.util.ArrayList;

public class Game {
    static private final Integer MAX_ROUNDS = 10;
    private Integer currentPlayerIndex;
    private String log;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private Labyrinth labyrinth;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Player currentPlayer;

    Game(Integer nplayers){
        this.currentPlayerIndex = Dice.whoStarts(nplayers);
        this.log = "";
        this.labyrinth = new Labyrinth(5,5,0,0);
        for(Integer i =0; i< nplayers;i++){
            this.players.add(new Player(Character.forDigit(i, 10),Dice.randomIntelligence(),Dice.randomStrength()));
        }
        this.currentPlayer = players.get(this.currentPlayerIndex);
        this.ConfigureLabyrinth();
        this.labyrinth.spreadPlayers(this.players);
        
    }
    public boolean finished(){
        return this.labyrinth.haveAWinner();
    }
    public boolean nextStep(Directions preferredDirection){
        this.log = "";
        boolean isdead = this.currentPlayer.dead();
        if(!isdead){
            Directions direction =this.actualDirection(preferredDirection);
            if(direction != preferredDirection){
                this.logPlayerNoOrders();
            }
            Monster monster = this.labyrinth.putPlayer(direction,currentPlayer);

            if(monster == null){
                this.logNoMonster();
            }
            else{
                this.manageReward(this.combat(monster));
            }
        }
        else{
            manageResurrection();
        }
        boolean endGame = this.finished();
        if(!endGame){
            this.nextPlayer();
        }
        return endGame;
    }
    public GameState getGameState(){
        String cadplayers ="";
        String cadmonsters = "";
        for(Integer i = 0; i< this.players.size(); i++){
            cadplayers+=players.get(i).toString() + "\n";
        }
        for(Integer i = 0; i< this.monsters.size(); i++){
            cadmonsters+=monsters.get(i).toString();
        }
        return new GameState(this.labyrinth.toString(), cadplayers,cadmonsters,this.currentPlayerIndex,finished(),log);
    }
    private void ConfigureLabyrinth(){
        this.labyrinth.addBlock(Orientation.VERTICAL, 2, 1,2);
        Monster cerbero = new Monster("cerbero", 10, 20);
        this.labyrinth.addMonster(1, 0, cerbero);
        this.monsters.add(cerbero);

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
    private Directions actualDirection(Directions preferredDirections){
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        ArrayList<Directions> validMoves = this.labyrinth.validMoves(currentRow, currentCol);
        return this.currentPlayer.move(preferredDirections,validMoves);
        //return this.currentPlayer.move(preferredDirections,this.labyrinth.validMoves(this.currentPlayer.getRow(), this.currentPlayer.getRow()));
    }

    private GameCharacter combat(Monster monster){
        float monsterAttack, playerAttack;
        int rounds =0;
        GameCharacter winner = GameCharacter.PLAYER;
        playerAttack = this.currentPlayer.attack();
        boolean lose = monster.defend(playerAttack);

        while ((!lose)&&(rounds < MAX_ROUNDS)){
            winner = GameCharacter.MONSTER;
            rounds+=1;
            monsterAttack = monster.attack();
            lose = this.currentPlayer.defend(monsterAttack);

            if(!lose){
                playerAttack = this.currentPlayer.attack();
                winner = GameCharacter.PLAYER;
                lose = monster.defend(playerAttack);

            }

        }
        
        this.logRounds(rounds, MAX_ROUNDS);
        return  winner;
    }
    private void manageResurrection(){
        boolean resurrect = Dice.resurrectPlayer();
        if(resurrect){
           // this.currentPlayer.resurrect();
            this.resurrectFuzzy();
            this.logResurrected();
        }
        else{
            this.logPlayerSkipTurn();
        }
    }
    private void manageReward(GameCharacter winner){
        if(winner == GameCharacter.PLAYER){
            this.currentPlayer.receiveReward();
            this.logPlayerWon();
        }
        else{
            this.logMonsterWon();
        }
    }
    private void resurrectFuzzy(){
        this.currentPlayer.resurrect();
        this.currentPlayer = new FuzzyPlayer(this.currentPlayer);
        this.players.set(this.currentPlayerIndex, this.currentPlayer);
    }
    private void logPlayerWon(){
        this.log+="Has ganado el combate! \n";
    }
    private void logMonsterWon(){
        this.log+="El monstruo ha ganadpo el combate! \n";
    }
    private void logResurrected(){
        this.log+="Acabas de resucitar\n";
    }
    private void logPlayerSkipTurn(){
        this.log+="Has perdido el turno por estar muerto \n";
    }
    private void logPlayerNoOrders(){
        this.log+="No ha sido posible seguir la instrucción\n";
    }
    private void logNoMonster(){
        this.log+="Te has movido a una celda vacia\n";
    }
    private void logRounds(Integer rounds , Integer max){

        this.log+=String.format("Se han jugado %d rondas de %d \n", rounds,max);    
    }

}