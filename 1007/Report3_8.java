//249쪽 9번
package Report;

import java.util.Scanner;

public class Report3_8 {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}

class Player {
    private String playerName; // 선수의 이름
    private int accumulatedScore; // 누적된 점수

    public Player(String playerName) {
        this.playerName = playerName;
        this.accumulatedScore = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAccumulatedScore() {
        return accumulatedScore;
    }

    public void incrementScore() {
        accumulatedScore++;
    }
}

class NumberGuessingGame {
    private Player[] gamePlayers;
    private Scanner inputScanner;

    public NumberGuessingGame() {
        inputScanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("*** 숫자 추측 게임을 시작합니다. ***");
        System.out.print("게임에 참여할 선수 수 >>");
        int numberOfPlayers = inputScanner.nextInt();
        gamePlayers = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("선수 이름>>");
            String playerName = inputScanner.next();
            gamePlayers[i] = new Player(playerName);
        }

        boolean keepPlaying = true;
        while (keepPlaying) {
            conductGameRound();
            System.out.print("계속하려면 yes 입력>>");
            String userResponse = inputScanner.next();
            keepPlaying = userResponse.equalsIgnoreCase("yes");
        }

        displayFinalScores();
    }

    private void conductGameRound() {
        int secretNumber = (int) (Math.random() * 100 + 1); // 1~100 사이의 숫자
        System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

        int smallestDifference = Integer.MAX_VALUE;
        Player roundWinner = null;

        for (Player player : gamePlayers) {
            System.out.print(player.getPlayerName() + ">>");
            int playerGuess = inputScanner.nextInt();
            int difference = Math.abs(secretNumber - playerGuess);

            if (difference < smallestDifference) {
                smallestDifference = difference;
                roundWinner = player;
            }
        }

        System.out.println("정답은 " + secretNumber + ". " + roundWinner.getPlayerName() + "이 이겼습니다. 승점 1점 확보!");
        roundWinner.incrementScore();
    }

    private void displayFinalScores() {
        System.out.println();
        for (Player player : gamePlayers) {
            System.out.println(player.getPlayerName() + ":" + player.getAccumulatedScore());
        }

        Player ultimateWinner = gamePlayers[0];
        for (Player player : gamePlayers) {
            if (player.getAccumulatedScore() > ultimateWinner.getAccumulatedScore()) {
                ultimateWinner = player;
            }
        }

        System.out.println(ultimateWinner.getPlayerName() + "이 최종 승리하였습니다.");
    }
}
