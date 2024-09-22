
package Report;

import java.util.Scanner;

public class Report1_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("$1=1200원입니다. 달러를 입력하세요>> ");
		int score = scanner.nextInt();
		System.out.println("$253는" + score*1200 +"입니다");
		
		scanner.close();
	}
}
