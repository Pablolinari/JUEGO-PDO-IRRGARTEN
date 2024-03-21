package Irrigarten;
import java.util.Random;

 public class Dice {
    static private final int MAX_USES = 5;
    static private final float MAX_INTELLIGENCE = 10.0f;
    static private final float MAX_STRENGTH = 10.0f;
    static private final float RESURRECT_PROB = 0.3f;
    static private final int WEAPONS_REWARD = 2;
    static private final int SHIELDS_REWARD = 3;
    static private final int HEALTH_REWARD = 5;
    static private final int MAX_ATTACK = 3;
    static private final int MAX_SHIELD = 2;
    static private Random generator = new Random();
    
     public static int randomPos(int max){
        return generator.nextInt(max);
    }

    public static int whoStarts(int nplayers){
        return generator.nextInt(nplayers);
    }
     public static float randomIntelligence(){
        return generator.nextInt((int)MAX_INTELLIGENCE) + generator.nextFloat();

    }
     public static float randomStreangth(){
        return generator.nextInt((int)MAX_STRENGTH) + generator.nextFloat();
    }

     public static boolean resurrectPlayer(){
        if (generator.nextDouble() > RESURRECT_PROB){
            return false;
        }
        else{
            return true;
        }
    }

     public static int weaponsReward(){
        return generator.nextInt(WEAPONS_REWARD+1);
    }
     public static int shieldsReward(){
        return generator.nextInt(SHIELDS_REWARD);
    }
     public static int healthReward(){
        return generator.nextInt(HEALTH_REWARD);
    }

     public static float weaponPower(){
        return generator.nextInt(MAX_ATTACK) + generator.nextFloat();
    }

     public static float shieldPower(){
        return generator.nextInt(MAX_SHIELD) + generator.nextFloat();
    }
     public static int usesLeft(){
        return generator.nextInt(MAX_USES);
    }
     public static float intensity(float competence){
        return competence * generator.nextFloat();
    }
     public static boolean discardElement(int usesLeft){
        float prob = usesLeft/MAX_USES;

        return generator.nextFloat() <= prob;

    }
}





