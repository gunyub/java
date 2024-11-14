package reportPackage;

import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean play() {
        Random random = new Random();
        int num1 = random.nextInt(3) + 1; // 1~3 사이의 랜덤 숫자
        int num2 = random.nextInt(3) + 1;
        int num3 = random.nextInt(3) + 1;

        // 랜덤 숫자 출력
        System.out.printf("\t%d\t%d\t%d\t", num1, num2, num3);

        // 3개의 숫자가 모두 같으면 true 반환
        return (num1 == num2 && num2 == num3);
    }
}

public class Report11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 게임에 참여할 선수 수 입력
        System.out.print("갬블링 게임에 참여할 선수 수>>");
        int playerCount = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        // 선수 배열 생성
        Player[] players = new Player[playerCount];

        // 선수 이름 입력
        for (int i = 0; i < playerCount; i++) {
            System.out.print((i + 1) + "번째 선수 이름>>");
            String name = scanner.nextLine();
            players[i] = new Player(name);
        }

        // 게임 시작
        boolean gameWon = false;
        while (!gameWon) {
            for (Player player : players) {
                System.out.print("[" + player.getName() + "]:<Enter> ");
                scanner.nextLine(); // Enter 키 대기

                // 플레이어가 랜덤 숫자를 돌리고 결과를 확인
                if (player.play()) {
                    System.out.println(player.getName() + "님이 이겼습니다!");
                    gameWon = true;
                    break;
                } else {
                    System.out.println("아쉽군요!");
                }
            }
        }

        scanner.close();
    }
}

