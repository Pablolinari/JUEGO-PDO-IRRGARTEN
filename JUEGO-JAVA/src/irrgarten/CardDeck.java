package irrgarten;
import java.util.ArrayList;
import java.util.Collections;

public abstract class CardDeck<T extends CombatElement>{
    private ArrayList<T> cardDeck;
    CardDeck(){
        this.cardDeck = new ArrayList<T>();
    }
    protected abstract void addCards();
    protected void addCard(T card){
        this.cardDeck.add(card);
    }
    public T nextCard(){
        if(this.cardDeck.size() == 0){
            this.addCards();
            Collections.shuffle(this.cardDeck);
        }
        T carta = this.cardDeck.get(0);
        this.cardDeck.remove(0);
        return carta;
    }
}
