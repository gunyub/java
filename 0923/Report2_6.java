// 입력받은 정수 별찍기 점점 내려감 음수 입력시
package Report;

import java.util.Scanner;

public class Report2_6{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("정수 입력");
			int num = scanner.nextInt();
			//음수 입력시 재입력
			if(num < 0) {System.out.println("양수를 입력하세요");continue;}
			
			//별 찍기
			for(int i=num; i>0; i--) { //행
				for(int j=0; j<i; j++) { //열
					System.out.print("*");
				}
				System.out.println(" ");
			}
			break;
		}
		scanner.close();
	}
}