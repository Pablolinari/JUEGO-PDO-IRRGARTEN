/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Labyrinth {
    private static final char BLOCK_CHAR ='X';
    private static final char EMPTY_CHAR ='-';
    private static final char MONSTER_CHAR ='M';
    private static final char COMBAT_CHAR ='C';
    private static final char EXIT_CHAR ='E';
    private static final int ROW=0;
    private static final int COL=1;
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    private char [][] labyrinth;
    private Monster [][] monsters;
    private Player [][] players;
    
    Labyrinth (int nCols, int nRows, int exitRow, int exitCol){
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;

        labyrinth = new char[nRows][nCols];
        monsters = new Monster[nRows][nCols];
        players = new Player[nRows][nCols];
        
        for (int i=0; i< nCols;i++){
            for (int j = 0; j < nRows; j++){
                this.labyrinth[i][j]=EMPTY_CHAR;
                this.monsters[i][j] = null;
                this.players[i][j] = null;
            }
        }
        this.labyrinth[exitRow][exitCol]=EXIT_CHAR;
    } 
      

    void spreadPlayers(ArrayList<Player> jugadores){
        for (Player player:  jugadores) {
            int [] pos = new int [2];
            pos = randomEmptyPos();
            putPlayer2D(-1, -1, pos[ROW], pos[COL], player);
        }

    }

    public boolean haveAWinner(){
        return !(players[exitRow][exitCol]== null);
    }
    
    @Override
    public String toString() {
        String cadena="", marco="";

        for (int i=0; i<nCols+2;i++){
            marco +=" * ";
        }
        marco += "\n";
        cadena += marco;

        for (int i=0; i < nRows; i++){
            cadena += " * ";
            for (int j=0; j < nCols; j++){
                cadena += " " + this.labyrinth[i][j] + " ";
            }
            cadena += " *\n";
        }
        cadena += marco;

        return cadena;
    }
    
    public void addMonster (int row, int col, Monster monster){
        if (this.posOK(row, col) && labyrinth[row][col]==EMPTY_CHAR){
            this.labyrinth[row][col]= MONSTER_CHAR;
            this.monsters[row][col]= monster;
        }
    }
    
    public Monster putPlayer(Directions direction, Player player){
        int[] newPos = new int[2];
        Integer oldRow = player.getRow();
        Integer oldCol = player.getCol();

        newPos = this.dir2Pos(oldRow,oldCol, direction);
        return this.putPlayer2D(oldRow,oldCol , newPos[ROW], newPos[COL], player);  
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        int incRow, incCol;
        if (orientation == Orientation.VERTICAL){
            incRow = 1;
            incCol = 0;
        }
        else {
            incRow = 0;
            incCol = 1;
        }

        int row = startRow;
        int col = startCol;

        while (posOK(row, col) && emptyPos(row, col) && length > 0){
            labyrinth[row][col] = BLOCK_CHAR;
            length -= 1;
            row += incRow;
            col += incCol;
        }
    }   
    
    //Devuelve array de direcciones validas 

    public ArrayList<Directions> validMoves(Integer row,Integer col){
        ArrayList<Directions>output = new ArrayList<>();

        if (this.canStepOn(row +1, col)){
            output.add(Directions.DOWN);
        }
        if (this.canStepOn(row-1,col)) {
            output.add(Directions.UP);
        }
        if (this.canStepOn(row,col+1)) {
            output.add(Directions.RIGHT);
        }
        if (this.canStepOn(row,col-1)) {
            output.add(Directions.LEFT);
        }
        return output;
    }
    
    private boolean posOK(int row, int col){
         return (0 <= row && row < nRows && 0 <= col && col < nCols);
    }
    
    private boolean emptyPos(int row, int col){
        return (this.labyrinth[row][col] == EMPTY_CHAR);
          
    }

    private boolean monsterPos(int row, int col){
        return (this.labyrinth[row][col]==MONSTER_CHAR);

    }

    private boolean exitPos(int row, int col){
        return (this.labyrinth[row][col]==EXIT_CHAR);
    }   

    private boolean combatPos(int row, int col){
        return (this.labyrinth[row][col]==COMBAT_CHAR);

    }

    private boolean canStepOn(int row, int col){
        if (posOK(row, col)){
            if(this.emptyPos(row, col) || this.monsterPos(row, col) || this.exitPos(row, col)){
                return true;
            }
            else return false;
        }     
        else 
            return false;
    }

    private void updateOldPos(int row, int col){
        if (posOK(row, col)){
            if (this.combatPos(row, col)){
                this.labyrinth[row][col]= MONSTER_CHAR;
            }
            else this.labyrinth[row][col]= EMPTY_CHAR;
        }
    }

    private int[] dir2Pos(int row, int col, Directions direction){
        int [] newPos = new int[2];
        if (direction == Directions.UP){
            newPos[0]=row-1;
            newPos[1]=col;
        }
        if (direction == Directions.DOWN){
            newPos[0]=row+1;
            newPos[1]=col;
        }
        if (direction == Directions.LEFT){
            newPos[0]=row;
            newPos[1]= col-1;
        }
        if (direction == Directions.RIGHT){
            newPos[0]=row;
            newPos[1]= col+1;
        }

        return newPos;
    }

    private int[] randomEmptyPos(){
        int[] posicion = new int[2];
        int row = Dice.randomPos(nRows);
        int col = Dice.randomPos(nCols);
        while (!posOK(row, col) || !emptyPos(row, col)){
            row = Dice.randomPos(nRows);
            col = Dice.randomPos(nCols);

        }
        posicion[0]= row;
        posicion[1]= col;
        return posicion;
    }

    private Monster putPlayer2D(Integer oldRow ,Integer oldCol , Integer row , Integer col , Player player){
        Monster output = null;
        if(this.canStepOn(row, col)){
            if(this.posOK(oldRow, oldCol)){
                Player p = this.players[oldRow][oldCol];
                
                if(p == player){
                    this.updateOldPos(oldRow, oldCol);
                    this.players[oldRow][oldCol] =null;
                }

            }
            boolean monsterPos = this.monsterPos(row, col);
            if(monsterPos){
                this.labyrinth[row][col] = COMBAT_CHAR;
                output = this.monsters[row][col] ;  
            }
            else{
                this.labyrinth[row][col] = player.getNumber();
            }
            this.players[row][col]=player;
            player.setPos(row, col);
        }
        return output;
    }


}
