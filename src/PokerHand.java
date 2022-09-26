import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class PokerHand {

    public PokerHand(Deck baraja) {
        baraja.shuffle();
        ArrayList<Card> hand1 = new ArrayList<Card>();
        for(int i = 0; i < 5; i++){
            Card c = baraja.draw();
            hand1.add(c);
        }

        baraja.shuffle();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        for(int i = 0; i < 5; i++) {
            Card c = baraja.draw();
            hand2.add(c);
        }

        mejor(hand1, hand2);
    }

    public static void mejor(ArrayList<Card> hand1, ArrayList<Card> hand2){
        boolean alta = false, pareja = false, doble = false, trio = false, escalera = false,
                color = false, full = false, poker = false, escaleracolor = false, real = false;
        boolean rojo, negro;
        int contar1 = 0, contar2 = 0, mejor = 0;



        for(Object i: hand1) {
            System.out.print(());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deck baraja = new Deck();
        PokerHand mano = new PokerHand(baraja);
    }
}