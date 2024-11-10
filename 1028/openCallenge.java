package ReortClass;

import java.util.Scanner;

abstract class Player1 {
    protected String bet[] = {"묵", "찌", "빠"};
    protected String name;
    protected String lastBet = null;

    protected Player1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBet() {
        return lastBet;
    }

    abstract public String next();
}

class Human1 extends Player1 {
    public Human1(String name) {
        super(name);
    }

    @Override
    public String next() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + "님, 묵/찌/빠 중 하나를 입력하세요: ");
        lastBet = scanner.nextLine();

        while (!lastBet.equals("묵") && !lastBet.equals("찌") && !lastBet.equals("빠")) {
            System.out.print("잘못된 입력입니다. 묵/찌/빠 중 하나를 다시 입력하세요: ");
            lastBet = scanner.nextLine();
        }
        return lastBet;
    }
}

class Computer1 extends Player1 {
    public Computer1(String name) {
        super(name);
    }

    @Override
    public String next() {
        int randomIndex = (int) (Math.random() * 3);
        lastBet = bet[randomIndex];
        System.out.println(name + "가 선택한 값: " + lastBet);
        return lastBet;
    }
}

class Game1 {
    private Player1[] players = new Player1[2];

    public Game1(String humanName, String computerName) {
        players[0] = new Human1(humanName);
        players[1] = new Computer1(computerName);
    }

    public void run() {
        Player1 owner = players[0]; // 사람이 먼저 오너
        Player1 opponent = players[1];
        boolean gameEnd = false;

        while (!gameEnd) {
            System.out.println(owner.getName() + "가 먼저 오너가 되어 시작합니다.");
            String ownerBet = owner.next();
            String opponentBet = opponent.next();

            if (ownerBet.equals(opponentBet)) {
                System.out.println(owner.getName() + "가 승리했습니다! 오너 유지.");
                gameEnd = true; // 오너가 승리하면 게임 종료
            } else if (
                (ownerBet.equals("묵") && opponentBet.equals("찌")) ||
                (ownerBet.equals("찌") && opponentBet.equals("빠")) ||
                (ownerBet.equals("빠") && opponentBet.equals("묵"))
            ) {
                System.out.println(owner.getName() + "가 이겼습니다. 오너 유지.");
            } else {
                System.out.println(opponent.getName() + "가 이겼습니다. 오너 변경.");
                Player1 temp = owner;
                owner = opponent;
                opponent = temp;
            }

            if (!ownerBet.equals(opponentBet) && !(
                (ownerBet.equals("묵") && opponentBet.equals("찌")) ||
                (ownerBet.equals("찌") && opponentBet.equals("빠")) ||
                (ownerBet.equals("빠") && opponentBet.equals("묵"))
            )) {
                System.out.println("묵찌빠가 아닙니다.");
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}

public class openCallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사람의 이름을 입력하세요: ");
        String humanName = scanner.nextLine();
        System.out.print("컴퓨터의 이름을 입력하세요: ");
        String computerName = scanner.nextLine();

        new Game1(humanName, computerName).run();
    }
}
