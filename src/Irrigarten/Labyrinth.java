/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Irrigarten;
import java.util.ArrayList;
/**
 *
 * @author manuel
 */
public class Labyrinth {
    private static final char BLOCK_CHAR ='X';
    private static final char EMPTY_CHAR='-';
    private static final char MONSTER_CHAR='M';
    private static final char EXIT_CHAR='C';
    private static final int ROW=0;
    private static final int COL=1;
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    private ArrayList<ArrayList<Character>> labyrinth = new ArrayList<ArrayList<Character>>();
    private ArrayList<ArrayList<Character>> monsters = new ArrayList<ArrayList<Character>>();
    private ArrayList<ArrayList<Character>> players = new ArrayList<ArrayList<Character>>();
    
    Labyrinth (int nCols, int nRows, int exitCol, int exitRow){
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitCol = exitCol;
        this.exitRow = exitRow;
        
        ArrayList<Character> row = new ArrayList<>(nCols);
        for (int i=0; i< nCols;i++){
            row.set(i, EMPTY_CHAR);
        }
        for (int i = 0; i <nRows; i++){
            this.labyrinth.add(row);
            this.monsters.add(row);
            this.players.add(row);
        }
    }       

    // void spreadPlayers(ArrayList<Player> jugadores){

    // }
            
    public boolean haveAWinner(){
        if (players.get(exitRow).get(exitCol)==null)
            return false;
        
        else return true;

    }
    
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
                cadena += " " + this.labyrinth.get(i).get(j) + " ";
            }
            cadena += " *\n";
        }
        cadena += marco;

        return cadena;
    }
    
    public void addMonster (int row, int col, Monster monster){
        if (row < this.nRows && col < this.nCols && labyrinth.get(row).get(col)==EMPTY_CHAR){
            this.labyrinth.get(row).set(col, MONSTER_CHAR);
            this.monsters.get(row).set(col, MONSTER_CHAR);
        }
    }
    
    // public Monster putPlayer(Directions direction, Player player){}
    
    // public void addBlock(Orientation orientation, int startRow, int startCol, int length){}
    
    // public ArrayList<Directions> validMoves(int row, int col){}
    
    public boolean posOK(int row, int col){
        if (row < nRows && col < nCols){
            return true;
        }
        else return false;
    }
    
    public 

}
