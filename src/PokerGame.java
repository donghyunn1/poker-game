import java.util.*;

public class PokerGame {

    List<Player> player;
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

    public void addPlayer(String name) {
        player.add(new Player(name));
    }

    public void dealCards() {
        for (int i = 0; i < 5; i++) {
            for (Player gamePlayer : player) {
                gamePlayer.addCard(deck.getFirst());
            }
        }
    }

    private boolean isStraight(List<Card> cards) {
        List<Card> sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards);

        for (int i = 1; i < sortedCards.size(); i++) {
            if (sortedCards.get(i).getRank().getValue() != sortedCards.get(i - 1).getRank().getValue() + 1) {
                return false;
            }
        }
        return false;
    }

    private boolean isFlush(List<Card> cards) {
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getSuit().getSymbol() != cards.get(i-1).getSuit().getSymbol()) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Integer> getCardCount(List<Card> cards) {
        Map<Integer, Integer> matchedNum = new HashMap<>();
        for (Card card : cards) {
            int value = card.getRank().getValue();
            matchedNum.put(value, matchedNum.getOrDefault(value, 0) + 1);
        }
        return matchedNum;
    }

    public void evaluateHand() {

        for (Player gamePlayer : player) {
            List<Card> hand = gamePlayer.getCards();
            boolean isStraight = isStraight(hand);
            boolean isFlush = isFlush(hand);
            Map<Integer, Integer> count = getCardCount(hand);

            if (isStraight && isFlush) {
                gamePlayer.setHand(new HandRank(HandRankType.STRAIGHT_FLUSH, hand));
            } else if (count.containsValue(4)) {
                gamePlayer.setHand(new HandRank(HandRankType.FOUR_CARD, hand));
            } else if (count.containsValue(3) && count.containsValue(2)) {
                gamePlayer.setHand(new HandRank(HandRankType.FULL_HOUSE, hand));
            } else if (isFlush) {
                gamePlayer.setHand(new HandRank(HandRankType.FLUSH, hand));
            } else if (isStraight) {
                gamePlayer.setHand(new HandRank(HandRankType.STRAIGHT, hand));
            } else if (count.containsValue(3)) {
                gamePlayer.setHand(new HandRank(HandRankType.TRIPPLE, hand));
            } else if (count.containsValue(2)) {
                gamePlayer.setHand(new HandRank(HandRankType.TWO_PAIRS, hand));
            } else {
                gamePlayer.setHand(new HandRank(HandRankType.HIGH_CARD, hand));
            }
        }
    }

    public Player findWinner() {
        return Collections.max(player, Comparator.comparing(Player::getHandRank));
    }
}
