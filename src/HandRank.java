import java.util.List;

public class HandRank implements Comparable<HandRank>{

    private final HandRankType type;
    private final List<Card> cards;

    public HandRank(HandRankType type, List<Card> cards) {
        this.type = type;
        this.cards = cards;
    }

    public HandRankType getType() {
        return type;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return getType().getRankName();
    }

    @Override
    public int compareTo(HandRank other) {
        if (this.getType().getScore() != other.getType().getScore()) {
            return this.getType().getScore() - other.getType().getScore();
        }
        //todo: RankType이 같을 경우 로직 ?
    }
}
