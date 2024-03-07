package Irrigarten;
import java.util.Random;

public class Dice {
    static private int MAX_USES = 5;
    static private float MAX_INTELLIGENCE = 10.0f;
   static private float MAX_STRENGTH = 10.0f;
    static private float RESURRECT_PROB = 0.3f;
    static private int WEAPONS_REWARD = 2;
    static private int SHIELDS_REWARD = 3;
    static private int HEALTH_REWARD = 5;
    static private int MAX_ATTACK = 3;
    static private int MAX_SHIELD = 2;
    private Random generator ;
    public Dice(){
        generator = new Random();
    }
    public int randomPos(int max){
        return generator.nextInt(max);
    }

    public int whoStarts(int nplayers){
        return generator.nextInt(nplayers);
    }
    public float randomIntelligence(){
        return generator.nextInt((int)MAX_INTELLIGENCE) + generator.nextFloat();

    }
    public float randomStreangth(){
        return generator.nextInt((int)MAX_STRENGTH) + generator.nextFloat();
    }

    public boolean resurrectPlayer(){
        if (generator.nextDouble() > RESURRECT_PROB){
            return false;
        }
        else{
            return true;
        }
    }

    public int weaponsReward(){
        return generator.nextInt(WEAPONS_REWARD+1);
    }
    public int shieldsReward(){
        return generator.nextInt(SHIELDS_REWARD);
    }
    public int healthReward(){
        return generator.nextInt(HEALTH_REWARD);
    }

    public float weaponPower(){
        return generator.nextInt(MAX_ATTACK) + generator.nextFloat();
    }

    public float shieldPower(){
        return generator.nextInt(MAX_SHIELD) + generator.nextFloat();
    }
    public int usesLeft(){
        return generator.nextInt(MAX_USES);
    }
    public float intensity(float competence){
        return competence * generator.nextFloat();
    }
    public boolean discardElement(int usesLeft){
        float prob = usesLeft/MAX_USES;

        return generator.nextFloat() <= prob;

    }
}





