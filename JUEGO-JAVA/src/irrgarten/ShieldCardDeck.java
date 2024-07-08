package irrgarten;

public class ShieldCardDeck extends CardDeck<Shield>{
    @Override
    protected void addCards(){
        addCard(new Shield(2f, 7));
        addCard(new Shield(4f, 2));
        addCard(new Shield(3.75f, 3));
    }
}
