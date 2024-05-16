package irrgarten;

import java.util.ArrayList;

public class Player extends LabyrinthCharacter {
    private static final int MAX_WEAPONS=2;
    private static final int MAX_SHIELDS=2;
    private static final int INITIAL_HEALTH=2;
    private static final int HITS2LOSE=2;
    private char number;
    private int consecutiveHits;
    private ArrayList<Weapon> WeaponArray = new ArrayList<Weapon>();
    private ArrayList<Shield> ShieldArray = new ArrayList<Shield>();
    private ShieldCardDeck shieldCardDeck = new ShieldCardDeck();
    private WeaponCardDeck weaponCardDeck = new WeaponCardDeck();
    
    
    
    Player(char number, float intelligence, float strength){
        super(String.format("Player %c", number),intelligence,strength,INITIAL_HEALTH);
        this.number = number;
        this.consecutiveHits=0;

    }
    Player(Player other){
        super(other);
        this.number = other.number;
        this.consecutiveHits=other.consecutiveHits;
        this.weaponCardDeck = other.weaponCardDeck;
        this.shieldCardDeck = other.shieldCardDeck;
        this.ShieldArray = other.ShieldArray;
        this.WeaponArray = other.WeaponArray;

    }

    public void resurrect(){
        this.WeaponArray.clear();
        this.ShieldArray.clear();
        this.setHealth(INITIAL_HEALTH); 
        this.consecutiveHits = 0;
    }
    public char getNumber(){
        return this.number;
    }
    //Mover el jugador hacia una de las posiciones validas
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        if (validMoves.size() > 0 && !validMoves.contains(direction)){
            return validMoves.get(0);
        } 
        else 
        return direction;
        
    }
    @Override
    public float attack(){
        return this.getStrength() + this.sumWeapons();
    }
    @Override
    public boolean defend(float receivedAttack){
      return this.manageHit(receivedAttack);  
    }
    /**
     * Jugador recive una recompensa (supongo que por ganar un combate)
     * Funcion void que añade nuevas armas y escudos además de poder aumentar la vida del jugador
     */ 
    public void receiveReward(){
        int wReward = Dice.weaponsReward();
        int sReward = Dice.shieldsReward();

        for (int i = 0; i < wReward; i++ ){
            Weapon wNew = newWeapon();
            this.receivedWeapon(wNew);
        }
        for (int i = 0; i < sReward; i++){
            Shield sNew = newShield();
            this.receivedShield(sNew);
        }

        int extraHealth = Dice.healthReward();
        this.setHealth(extraHealth+this.getHealth());
        
    }

   @Override
    public String toString(){
        return super.toString() + " "+ShieldArray.toString() + " " +WeaponArray.toString();
    }    

    private void receivedWeapon(Weapon w){
        WeaponArray.removeIf(Weapon::discard);
        int size = WeaponArray.size();
        if (size < MAX_WEAPONS){
            WeaponArray.add(w);
        }
    }

    private void receivedShield(Shield s){
        ShieldArray.removeIf(Shield::discard);
        int size = ShieldArray.size();
        if (size < MAX_SHIELDS){
            ShieldArray.add(s);
        }

    }

    private Weapon newWeapon(){
        return this.weaponCardDeck.nextCard();
    }

    private Shield newShield(){
        return this.shieldCardDeck.nextCard();
    }

    protected float sumWeapons(){
        float result = 0;
        for (int i=0; i< WeaponArray.size(); i++){
            result += WeaponArray.get(i).attack();
        }
        return result;
    }

    protected float sumShields(){
        float result = 0;
        for (int i=0; i< ShieldArray.size(); i++){
            result += ShieldArray.get(i).protect();
        }
        return result;
    }

    protected float defensiveEnergy(){
        return this.getIntellignece() + this.sumShields();
    }

    private boolean manageHit(float receivedAttack){
        if(this.defensiveEnergy() < receivedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
        }
        else{
            resetHits();
        }
        if((this.consecutiveHits == HITS2LOSE) || this.dead()){
            this.resetHits();
            return true;
        }
        else{
            return false;
        }
    }
    private void resetHits(){
        this.consecutiveHits = 0;
    }
    private void incConsecutiveHits(){
        this.consecutiveHits++;
    }
}
