// 실습 6번
package reportPackage;

import java.util.Scanner;

public class Report6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
		
		String word = sc.nextLine();
		
		for(int i=0; i<word.length(); i++) {
			char backString = word.charAt(0);
			String backString1 = word.substring(1) + backString;
			System.out.println(backString1);
			word = backString1;
			}
		sc.close();
	}
}
