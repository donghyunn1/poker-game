import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerGame {

    private List<Player> player;
    private List<Card> deck;

    public PokerGame() {
        player = new ArrayList<Player>();
        deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
    }

    private void addPlayer(String name) {
        player.add(new Player(name));
    }

    private void dealCards() {
        for (int i = 0; i < 5; i++) {
            for (Player gamePlayer : player) {
                gamePlayer.addCard(deck.getFirst());
            }
        }
    }
}
