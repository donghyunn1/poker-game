enum HandRankType {
    STRAIGHT_FLUSH("스트레이트 플러시",9), FOUR_CARD("포 카드", 8), FULL_HOUSE("풀 하우스", 7),
    FLUSH("플러시", 6), STRAIGHT("스트레이트", 5), TRIPPLE("트리플", 4),
    TWO_PAIRS("투 페어", 3), ONE_PAIR("원 페어", 2), HIGH_CARD("하이 카드", 1);

    private final String rankName;
    private final int score;

    HandRankType(String rankName, int score) {
        this.rankName = rankName;
        this.score = score;
    }

    public String getRankName() {
        return rankName;
    }

    public int getScore() {
        return score;
    }
}
