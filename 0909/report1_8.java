/*출석점수 총100점 지각3점감점 결석8점감점 이름 지각회수 결석회수 순으로 입력
 * 하면 두학생중 누구 점수가 높은지 비교3*/
package Report;

import java.util.Scanner;

public class report1_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//학생이름 지각획수 결석횟수 저장
		System.out.print("첫번째 학생이름 지각횟수 결석횟수");
		String student1 = scanner.next();
		int lately1 = scanner.nextInt();
		int absent1 = scanner.nextInt();
		
		System.out.print("두번째 학생이름 지각횟수 결석횟수");
		String student2 = scanner.next();
		int lately2 = scanner.nextInt();
		int absent2 = scanner.nextInt();
		
		//지각 결석 합한 점수
		int score1 = (lately1*3) + (absent1*8);
		int score2 = (lately2*3) + (absent2*8);
		
		//각 학생의 마이너스 점수
		System.out.println(student1+"의 마이너스 점수는 "+score1+","+student2+"의 마이너스 점수는"+score2);
		
		 if (score1 > score2) {
	            System.out.println(student1 + "의 점수가 더 높습니다.");
	        } else if (score1 < score2) {
	            System.out.println(student2 + "의 점수가 더 높습니다.");
	        } else {
	            System.out.println("두 학생의 점수가 같습니다.");
	        }
		
			
		scanner.close();
	}
}