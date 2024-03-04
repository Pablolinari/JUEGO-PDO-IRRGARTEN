package juego;
 import java.util.Random;

public class Dice {
    private int MAX_USES = 5;
    private double MAX_INTELLIGENCE = 10.0;
    private double MAX_STRENGTH = 10.0;
    private double RESURRECT_PROB = 0.3;
    private int WEAPONS_REWARD = 2;
    private int SHIELDS_REWARD = 3;
    private int HEALTH_REWARD = 5;
    private double MAX_ATTACK = 3;
    private double MAX_SHIELD = 2;
    Random random  = new Random();
    
    public int randomPos(int max){
        return random.nextInt(max);
    }

    public int whoStarts(int nplayers){
        return random.nextInt(nplaers);
    }
    public float randomIntelligence(){
        return random.nextFloat(MAX_INTELLIGENCE);
    }
    public float randomStreangth(){
        return random.nextFloat(MAX_STRENGTH);
    }

    public boolean resurrectPlayer(){
        return random.nextBoolean();
    }

    public int weaponsReward(){
        return random.nextInt(WEAPONS_REWARD) +1 ;
    }
    public int healthReward(){
        return random.nextInt(HEALTH_REWARD);
    }

    public float weaponPower(){
        return random.nextFloat(MAX_ATTACK);
    }

    public float shieldPower(){
        return random.nextFloat(MAX_SHIELD);
    }
    public int usesLeft(){
        return random.nextInt(MAX_USES);
    }
    public float intensity(float competence){
        return random.nextFloat(competence);
    }
    public boolean discardElement(int usesLeft){
        int prob = usesLeft / MAX_USES;

        

    }
}





