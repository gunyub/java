package Report;

class Account {
    int money;

    // 생성자
    public Account(int money) {
        this.money = money;
    }

    // 단일 금액 예금
    public int deposit(int charge) {
        return this.money += charge;
    }

    // 여러 금액 예금
    public int deposit(int[] charges) {
        for (int charge : charges) {
            this.money += charge;
        }
        return this.money;
    }

    // 잔금 조회
    public int getBalance() {
        return this.money;
    }

    // 인출
    public int withdraw(int minus) {
        if (this.money >= minus) {  // 인출 가능한 경우
            this.money -= minus;
            return minus;  // 인출한 금액을 반환
        } else {  
            return this.money;
        }
    }
}

public class Report3_7 {
    public static void main(String[] args) {
        Account a = new Account(100);
        a.deposit(5000);
        System.out.println("잔금은 " + a.getBalance() + " 원입니다");

        int bulk[] = {100, 500, 200, 700};
        a.deposit(bulk);
        System.out.println("잔금은 " + a.getBalance() + " 원입니다");

        int money = 1000;
        int wMoney = a.withdraw(money);

        if (wMoney < money) {
            System.out.println(wMoney + "원만 인출되었습니다.");
        } else {
            System.out.println(money + "원 인출되었습니다.");
        }
        
        System.out.println("잔금은 " + a.getBalance() + " 원입니다");
    }
}
