package reportPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Gambler {
    private String name;
    private int chosenNumber;
    private int matchCount;

    public Gambler(String name, int chosenNumber) {
        this.name = name;
        this.chosenNumber = chosenNumber;
        this.matchCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getChosenNumber() {
        return chosenNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void resetMatchCount() {
        this.matchCount = 0;
    }

    public void incrementMatchCount() {
        this.matchCount++;
    }
}

public class Report12_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 참가자 수 및 이름 입력
        System.out.print("게임에 참여할 선수들 이름>> ");
        String inputNames = scanner.nextLine();
        String[] names = inputNames.split(" ");
        
        ArrayList<Gambler> players = new ArrayList<>();
        
        // 각 참가자가 좋아하는 숫자 입력
        for (String name : names) {
            System.out.print(name + "의 정수 선택 (1~10) >> ");
            int chosenNumber = scanner.nextInt();
            scanner.nextLine(); // 남아있는 개행 문자 소비
            players.add(new Gambler(name, chosenNumber));
        }

        while (players.size() > 1) {
            System.out.print("Enter 키 입력>> ");
            scanner.nextLine(); // Enter 키 입력 대기

            // 1~10 사이의 랜덤 숫자 15개 생성 및 출력
            System.out.print("랜덤 숫자: ");
            int[] randomNumbers = new int[15];
            for (int i = 0; i < 15; i++) {
                randomNumbers[i] = random.nextInt(10) + 1;
                System.out.print(randomNumbers[i] + " ");
            }
            System.out.println();

            // 각 선수의 매치 카운트를 초기화하고 일치하는 숫자 세기
            for (Gambler player : players) {
                player.resetMatchCount();
                for (int number : randomNumbers) {
                    if (player.getChosenNumber() == number) {
                        player.incrementMatchCount();
                    }
                }
                System.out.println(player.getName() + "의 맞춘 개수: " + player.getMatchCount());
            }

            // 최소 매치 카운트 확인 및 탈락자 선정
            int minMatches = Integer.MAX_VALUE;
            for (Gambler player : players) {
                if (player.getMatchCount() < minMatches) {
                    minMatches = player.getMatchCount();
                }
            }

            ArrayList<Gambler> losers = new ArrayList<>();
            for (Gambler player : players) {
                if (player.getMatchCount() == minMatches) {
                    losers.add(player);
                }
            }

            // 탈락자 출력
            if (losers.size() == players.size()) {
                System.out.println("모든 참가자가 동일한 횟수를 맞췄습니다. 게임을 다시 시작합니다.");
            } else {
                for (Gambler loser : losers) {
                    System.out.println("현재 패자: " + loser.getName());
                    players.remove(loser);
                }
            }

            System.out.println();
        }

        // 최종 패자 출력
        if (players.size() == 1) {
            System.out.println("최종 패자는 " + players.get(0).getName() + "입니다.");
        }

        scanner.close();
    }
}
