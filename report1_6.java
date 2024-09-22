package Report;

import java.util.Scanner;

public class report1_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다.****");
		
		int pay1 = scanner.nextInt();
		int pay2 = scanner.nextInt();
		int pay3 = scanner.nextInt();
		
		System.out.println("떡복이 몇 인분>>" + pay1);
		System.out.println("김말이 몇 인분>>" + pay2);
		System.out.println("쫄면 몇 인분>>" + pay3);
		int total = (pay1*2000)+(pay2*1000)+(pay3*3000);
		System.out.println("전체 금액은" + total +"입니다");
		scanner.close();
	}
}
