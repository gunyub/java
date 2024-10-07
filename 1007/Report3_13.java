//252쪽 13번
package Report;

import java.util.Scanner;

class Seat {
    private String[] seatStatus;

    public Seat() {
        seatStatus = new String[10];
        for (int i = 0; i < seatStatus.length; i++) {
            seatStatus[i] = "---";
        }
    }

    public boolean reserve(String customerName, int seatIndex) {
        if (seatIndex < 1 || seatIndex > 10 || !seatStatus[seatIndex - 1].equals("---")) {
            return false;
        }
        seatStatus[seatIndex - 1] = customerName;
        return true;
    }

    public boolean cancel(String customerName) {
        for (int i = 0; i < seatStatus.length; i++) {
            if (seatStatus[i].equals(customerName)) {
                seatStatus[i] = "---";
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (String seat : seatStatus) {
            System.out.print(seat + " ");
        }
        System.out.println();
    }
}

public class Report3_13 {
    private Seat[] seats;
    private Scanner inputScanner;

    public Report3_13() {
        seats = new Seat[3];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat();
        }
        inputScanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int menuOption = inputScanner.nextInt();
            switch (menuOption) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    displaySeats();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 시도하세요.");
            }
        }
    }

    private void makeReservation() {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int seatType = inputScanner.nextInt();
        if (seatType < 1 || seatType > 3) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }
        System.out.print("이름>>");
        String name = inputScanner.next();
        System.out.print("번호>>");
        int seatNumber = inputScanner.nextInt();
        if (!seats[seatType - 1].reserve(name, seatNumber)) {
            System.out.println("예약에 실패했습니다. 다시 시도하세요.");
        }
    }

    private void displaySeats() {
        System.out.print("S>> ");
        seats[0].display();
        System.out.print("A>> ");
        seats[1].display();
        System.out.print("B>> ");
        seats[2].display();
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    private void cancelReservation() {
        System.out.print("좌석 S:1, A:2, B:3>>");
        int seatType = inputScanner.nextInt();
        if (seatType < 1 || seatType > 3) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }
        System.out.print("이름>>");
        String name = inputScanner.next();
        if (!seats[seatType - 1].cancel(name)) {
            System.out.println("취소에 실패했습니다. 다시 시도하세요.");
        }
    }

    public static void main(String[] args) {
        Report3_13 concertReservationSystem = new Report3_13();
        concertReservationSystem.run();
    }
}
