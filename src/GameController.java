import java.util.Scanner;

class GameController {

    public void start() {
        PokerGame pokerGame = new PokerGame();
        Scanner scanner = new Scanner(System.in);

        System.out.print("게임 참여자 수를 입력해주세요. : ");
        int numOfPlayer = scanner.nextInt();

        System.out.print("사용자의 이름을 입력해주세요. : ");
        String nameOfPlayer = scanner.next();
        pokerGame.addPlayer(nameOfPlayer);

        String[] aiPlayers = {"짱구", "짱아", "흰둥이", "홍길동"};
        for (int i = 1; i < numOfPlayer; i++) {
            pokerGame.addPlayer(aiPlayers[i - 1]);
        }

        pokerGame.dealCards();
        pokerGame.evaluateHand();

        System.out.println("================");
        System.out.println("전체 카드패 공개");
        System.out.println("================");

        for (Player player: pokerGame.player) {
            System.out.println(player);
        }

        System.out.println("================");
        System.out.println("전체 순위 공개");
        System.out.println("================");

        int index = 1;
        for (Player player: pokerGame.sortPlayer()) {
            System.out.println(index +"등: " + player.getName() +
                    "(" + player.getHandRank().getType().getRankName() + ")");
            index++;
        }

        Player winner = pokerGame.findWinner();
        System.out.println("우승자는: " + winner.getName());
    }
}