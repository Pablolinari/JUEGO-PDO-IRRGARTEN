package irrgarten;

public class testP2 {
    public static void main(){
        Monster monstruo1 = new Monster("monstruo1", 1.52f, 3.5f);
        Monster monstruo2 = new Monster("monstruo2", 2.6f, 1.2f);
        Monster monstruo3 = new Monster("monstruo3", 2f, 6f);
        Player playerA = new Player('A', 2.5f, 5);
        Player playerB = new Player('B', 1f, 3);
        Player playerC = new Player('C', 4f, 10);
        Game juego1 = new Game(3);

    }
}
