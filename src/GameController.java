import java.util.InputMismatchException;
import java.util.Scanner;

class GameController {

    public void start() {
        PokerGame pokerGame = new PokerGame();
        Scanner scanner = new Scanner(System.in);

        int numOfPlayer = getNumOfPlayer(scanner);
        getUserName(scanner, pokerGame);
        addAiPlayers(numOfPlayer, pokerGame);

        pokerGame.dealCards();
        pokerGame.evaluateHand();

        showAllCards(pokerGame);
        showPlayerRank(pokerGame);
        showWinner(pokerGame);
    }

    private static void showWinner(PokerGame pokerGame) {
        Player winner = pokerGame.findWinner();
        System.out.println("우승자는: " + winner.getName());
    }

    private static void showPlayerRank(PokerGame pokerGame) {
        System.out.println("================");
        System.out.println("전체 순위 공개");
        System.out.println("================");

        int index = 1;
        for (Player player: pokerGame.sortPlayer()) {
            System.out.println(index +"등: " + player.getName() +
                    "(" + player.getHandRank().getType().getRankName() + ")");
            index++;
        }
    }

    private static void showAllCards(PokerGame pokerGame) {
        System.out.println("================");
        System.out.println("전체 카드패 공개");
        System.out.println("================");

        for (Player player: pokerGame.player) {
            System.out.println(player);
        }
    }

    private static void addAiPlayers(int numOfPlayer, PokerGame pokerGame) {
        String[] aiPlayers = {"짱구", "짱아", "흰둥이", "홍길동"};
        for (int i = 1; i < numOfPlayer; i++) {
            pokerGame.addPlayer(aiPlayers[i - 1]);
        }
    }

    private static void getUserName(Scanner scanner, PokerGame pokerGame) {
        scanner.nextLine();
        while (true) {
            System.out.print("사용자의 이름을 입력해주세요. : ");
            String nameOfPlayer = scanner.nextLine().trim();

            if (nameOfPlayer.isEmpty()) {
                System.out.println("이름은 공백일 수 없습니다.");
                continue;
            }
            pokerGame.addPlayer(nameOfPlayer);
            break;
        }
    }

    private static int getNumOfPlayer(Scanner scanner) {
         while (true) {
             try {
                 System.out.print("게임 참여자 수를 입력해주세요. : ");
                 int numOfPlayer = scanner.nextInt();
                 if (numOfPlayer < 2 || numOfPlayer > 5) {
                     System.out.println("참여해야하는 인원은 2~5명 사이입니다.");
                     continue;
                 }
                 return numOfPlayer;
             } catch (InputMismatchException e) {
                 System.out.println("숫자만 입력해주세요.");
                 scanner.nextLine();
             }
         }

    }
}