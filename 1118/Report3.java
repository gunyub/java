package project07;

import java.util.HashMap;
import java.util.Scanner;

public class Report3 {
    public static void main(String[] args) {
        HashMap<String, Integer> stockPrices = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("주식 종목과 주가를 입력하세요 (종료하려면 '그만' 입력):");
        while (true) {
            System.out.print("주식 이름과 주가 (예: 삼성전자 70000): ");
            input = scanner.nextLine();

            if (input.equals("그만")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 2) {
                String stockName = parts[0];
                try {
                    int stockPrice = Integer.parseInt(parts[1]);
                    stockPrices.put(stockName, stockPrice);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 주가 입력입니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("입력 형식이 잘못되었습니다. '주식이름 주가' 형식으로 입력해주세요.");
            }
        }

        if (stockPrices.isEmpty()) {
            System.out.println("입력된 주식 정보가 없습니다. 프로그램을 종료합니다.");
            scanner.close();
            return;
        }

        System.out.println("주식을 검색하세요 (종료하려면 '종료' 입력):");
        while (true) {
            System.out.print("주식 이름 (종료하려면 '종료' 입력): ");
            String stockName = scanner.nextLine();

            if (stockName.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (stockPrices.containsKey(stockName)) {
                System.out.println(stockName + "의 주가는 " + stockPrices.get(stockName) + "원 입니다.");
            } else {
                System.out.println("해당 주식 정보가 없습니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
