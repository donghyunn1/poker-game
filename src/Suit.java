public enum Suit {
    SPADE("♠", 4), DIAMOND("♦", 3), HEART("♥", 2), CLUB("♣", 1);

    private final String symbol;
    private final int value;

    Suit(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
}
