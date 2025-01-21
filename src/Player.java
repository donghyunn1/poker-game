import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;
    private HandRank handRank;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public void setHand(HandRank hand) {
        this.handRank = hand;
    }
}
