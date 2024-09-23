package Report;

import java.util.Scanner;

public class report1_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("생일을 입력하세요>>");
		int birth = scanner.nextInt();
		System.out.print(birth/10000+"년 ");
		int month = (birth%10000) / 100;
		System.out.print(month+"월 ");
		int day = (birth%10000) % 100;
		System.out.println(day+"일");
		scanner.close();
		
	}
}
