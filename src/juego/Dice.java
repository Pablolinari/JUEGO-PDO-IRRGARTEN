package juego;
 import java.util.Random;

public class Dice {
    private int MAX_USES = 5;
    private float MAX_INTELLIGENCE = 10.0f;
    private float MAX_STRENGTH = 10.0f;
    private float RESURRECT_PROB = 0.3f;
    private int WEAPONS_REWARD = 2;
    private int SHIELDS_REWARD = 3;
    private int HEALTH_REWARD = 5;
    private int MAX_ATTACK = 3;
    private int MAX_SHIELD = 2;
    Random random  = new Random();
    
    public int randomPos(int max){
        return random.nextInt(max);
    }

    public int whoStarts(int nplayers){
        return random.nextInt(nplayers);
    }
    public float randomIntelligence(){
        return random.nextInt((int)MAX_INTELLIGENCE) + random.nextFloat();

    }
    public float randomStreangth(){
        return random.nextInt((int)MAX_STRENGTH) + random.nextFloat();
    }

    public boolean resurrectPlayer(){
        return random.nextBoolean();
    }

    public int weaponsReward(){
        return random.nextInt(WEAPONS_REWARD+1);
    }
    public int shieldsReward(){
        return random.nextInt(SHIELDS_REWARD);
    }
    public int healthReward(){
        return random.nextInt(HEALTH_REWARD);
    }

    public float weaponPower(){
        return random.nextInt(MAX_ATTACK) + random.nextFloat();
    }

    public float shieldPower(){
        return random.nextInt(MAX_SHIELD) + random.nextFloat();
    }
    public int usesLeft(){
        return random.nextInt(MAX_USES);
    }
    public float intensity(float competence){
        return competence * random.nextFloat();
    }
    public boolean discardElement(int usesLeft){
        float prob = usesLeft/MAX_USES;

        return random.nextFloat() <= prob;

    }
}





