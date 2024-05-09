package irrgarten;

import java.util.ArrayList;

public class FuzzyPlayer extends Player {
    FuzzyPlayer(Player ohter){
        super(ohter);
    }
    @Override
    public Directions move(Directions direction, ArrayList<Directions> validMoves) {

        Directions preferred = super.move(direction, validMoves);
        return Dice.nextStep(preferred, validMoves, this.getIntellignece());
    }
    @Override
    public float attack(){
        return this.sumWeapons() + Dice.intensity(this.getStrength());
    }
    @Override
    protected float defensiveEnergy(){
        return this.sumShields() + Dice.intensity(this.getIntellignece());

    }
    @Override
    public String toString() {
        return "Fuzzy"+super.toString();
    }
}
