// 랜덤 구구단 생성 사용자가 3번 틀리면 종료
package Report;

import java.util.Scanner;

public class Report2_14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 3;
		int wrongCount=1;
		
		while(count>=wrongCount) {
			int num1 = (int) (Math.random()*9+1);
			int num2 = (int) (Math.random()*9+1);
			int answer = num1*num2;
			
			System.out.print(num1+" x "+num2+" = ");
			int chek = scanner.nextInt();
			
			if(chek != answer) {
				if(wrongCount==count) {
					break;
				}
				System.out.println(wrongCount+" 번 틀렸습니다 분발하세요");
				wrongCount ++;
				
			}else {
				System.out.println("정답입니다. 잘했습니다.");
			}
			
		}
			System.out.println(wrongCount+" 번 틀렸습니다. 퀴즈 종료합니다.");
			scanner.close();
		
		}
	}