public enum Rank {
    A("A", 14), K("K", 13), Q("Q", 12),
    J("J", 11), TEN("10", 10), NINE("9", 9),
    EIGHT("8", 8), SEVEN("7", 7), SIX("6", 6),
    FIVE("5", 5), FOUR("4", 4), THREE("3", 3),
    TWO("2", 2);

    private final String symbol;
    private final int value;

    Rank(String symbol, int value) {
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
