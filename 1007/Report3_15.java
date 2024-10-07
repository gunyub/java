//239쪽 오픈 챌린지
package Report;

import java.util.Scanner;

public class Report3_15 {
    // Player 클래스 정의
    static class Player {
        private String name;
        private String word;

        // 생성자
        public Player(String name) {
            this.name = name;
        }

        // 이름을 반환하는 메소드
        public String getName() {
            return name;
        }

        // 단어를 입력받는 메소드
        public void getWordFromUser(Scanner scanner) {
            System.out.print(name + ">> ");
            word = scanner.next();
        }

        // 입력받은 단어 반환 메소드
        public String getWord() {
            return word;
        }
    }

    // WordGameApp 클래스 정의
    static class WordGameApp {
        private Player[] players;
        private String startWord = "아버지";

        // 게임을 시작하는 메소드
        public void run() {
            Scanner scanner = new Scanner(System.in);

            // 참가자 수 입력받기
            System.out.print("게임에 참가하는 인원은 몇명입니까>> ");
            int numPlayers = scanner.nextInt();
            players = new Player[numPlayers];

            // 각 참가자의 이름 입력받기
            for (int i = 0; i < numPlayers; i++) {
                System.out.print("참가자의 이름을 입력하세요>> ");
                String name = scanner.next();
                players[i] = new Player(name);
            }

            System.out.println("시작하는 단어는 " + startWord + "입니다.");

            // 끝말잇기 진행
            String lastWord = startWord;
            int currentPlayerIndex = 0;

            while (true) {
                Player currentPlayer = players[currentPlayerIndex];
                currentPlayer.getWordFromUser(scanner);
                String currentWord = currentPlayer.getWord();

                // 끝말잇기 성공 여부 판단
                if (!checkSuccess(lastWord, currentWord)) {
                    System.out.println(currentPlayer.getName() + "이(가) 졌습니다.");
                    break;
                }

                // 끝말잇기 성공 시 다음 단어로 갱신
                lastWord = currentWord;
                currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
            }

            scanner.close();
        }

        // 끝말잇기 성공 여부를 판단하는 메소드
        private boolean checkSuccess(String lastWord, String currentWord) {
            int lastIndex = lastWord.length() - 1;
            char lastChar = lastWord.charAt(lastIndex);
            char firstChar = currentWord.charAt(0);

            return lastChar == firstChar;
        }
    }

    // main 메소드
    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.run();
    }
}
