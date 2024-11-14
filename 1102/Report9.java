//실습문제 9번
package reportPackage;

import java.util.Random;
import java.util.Scanner;

public class Report9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("단어>> ");
            String word = scanner.nextLine();

            // "그만" 입력 시 프로그램 종료
            if (word.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 5x5 문자 배열 생성
            char[][] board = new char[5][5];

            // 배열을 빈칸(' ')으로 초기화
            initializeBoard(board);

            // 단어를 랜덤한 위치와 방향으로 배치
            placeWordInBoard(board, word, random);

            // 배열에 남은 빈칸을 랜덤 문자로 채우기
            fillBoardWithRandomLetters(board, random);

            // 배열 출력
            printBoard(board);
        }

        scanner.close();
    }

    // 5x5 보드를 빈칸으로 초기화하는 메서드
    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = ' '; // 빈칸으로 초기화
            }
        }
    }

    // 5x5 보드에 단어 배치하는 메서드
    private static void placeWordInBoard(char[][] board, String word, Random random) {
        int direction = random.nextInt(3); // 0: 가로, 1: 세로, 2: 대각선
        int row, col;

        // 단어를 배치할 수 있는 위치와 방향을 찾을 때까지 반복
        while (true) {
            row = random.nextInt(5);
            col = random.nextInt(5);

            if (canPlaceWord(board, word, row, col, direction)) {
                placeWord(board, word, row, col, direction);
                break;
            }
        }
    }

    // 단어를 보드에 배치할 수 있는지 확인하는 메서드
    private static boolean canPlaceWord(char[][] board, String word, int row, int col, int direction) {
        int length = word.length();

        switch (direction) {
            case 0: // 가로 배치
                if (col + length > 5) return false;
                for (int i = 0; i < length; i++) {
                    if (board[row][col + i] != ' ') return false;
                }
                break;
            case 1: // 세로 배치
                if (row + length > 5) return false;
                for (int i = 0; i < length; i++) {
                    if (board[row + i][col] != ' ') return false;
                }
                break;
            case 2: // 대각선 배치
                if (row + length > 5 || col + length > 5) return false;
                for (int i = 0; i < length; i++) {
                    if (board[row + i][col + i] != ' ') return false;
                }
                break;
        }
        return true;
    }

    // 단어를 보드에 실제로 배치하는 메서드
    private static void placeWord(char[][] board, String word, int row, int col, int direction) {
        int length = word.length();

        for (int i = 0; i < length; i++) {
            switch (direction) {
                case 0: // 가로
                    board[row][col + i] = word.charAt(i);
                    break;
                case 1: // 세로
                    board[row + i][col] = word.charAt(i);
                    break;
                case 2: // 대각선
                    board[row + i][col + i] = word.charAt(i);
                    break;
            }
        }
    }

    // 보드의 빈칸을 랜덤 문자로 채우는 메서드
    private static void fillBoardWithRandomLetters(char[][] board, Random random) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == ' ') { // 빈칸만 랜덤 문자로 채움
                    board[i][j] = (char) ('a' + random.nextInt(26)); // a부터 z 사이의 랜덤 문자
                }
            }
        }
    }

    // 보드를 출력하는 메서드
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
