package irrgarten;
import irrgarten.controller.*;
import irrgarten.UI.*;

public class Juego {
    public static void main(String args[]){
        Game game = new Game(2);
        JFrame vista = new JFrame();
        Controller control = new Controller(game, vista);
        control.play();
    }
    
}