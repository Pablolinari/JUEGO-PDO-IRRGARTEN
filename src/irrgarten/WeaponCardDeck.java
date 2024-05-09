package irrgarten;

public class WeaponCardDeck extends CardDeck<Weapon> {
    @Override
    protected void addCards(){
        addCard(new Weapon(2.5f, 6));
        addCard(new Weapon(3.5f, 8));
        addCard(new Weapon(4.5f, 3));
    }
}
