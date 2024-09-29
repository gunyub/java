//양의 정수 10개를 입력받아 배열에 저장, 배열에 저장된 정수 중 3의 배수만 출력하기.

package Report;

import java.util.Scanner;

public class Report2_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intArray[];
		intArray = new int[10];
		System.out.println("정수10개입력");
		// 배열 크기만큼 값 입력받기
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		// for-each 문
		System.out.println("3의 배수는");
		for(int num:intArray) {
			if(num%3==0) {
				System.out.print(num+" ");
			}
		}
		scanner.close();
	}
}
