package juego;

class GameState{
    private String labyrinthv;
    private String players;
    private String monsters ;
    private int currentPlayer ;
    private boolean winner;
    private String log;

    public GameState(String lab ,String plyrs,String mnstrs,int cplyr,boolean wnr,String lg){
        labyrinthv = lab;
        players = plyrs;
        monsters = mnstrs;
        currentPlayer = cplyr;
        winner = wnr;
        log = lg;
    }

    public String getLabyrinthv(){return labyrinthv;}
    public String getPlayers(){return players;}
    public String getMonsters(){return monsters;}
    public int getCurrentPlayer(){return currentPlayer;}
    public boolean getWinner(){return winner;}
    public String getLog(){return log;}



}