public class Card implements Comparable<Card> {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return this.rank + " " + this.suit;
    }

    @Override
    public int compareTo(Card other) {
        if (this.rank.getValue() != other.rank.getValue()) {
            return this.rank.getValue() - other.rank.getValue();
        }
        return this.suit.getValue() - other.suit.getValue();
    }
}
