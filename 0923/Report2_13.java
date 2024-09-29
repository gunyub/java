// 4 x 4 크기의 2차원 정수 배열에 0~255 범위의 정수 16개 랜덤  화면에 출력 후
//  임계값을 받고 배열에 저장된수가 임계값보다 크면 255 작거나 같으면 0으로 배열 수정후 배열 출력
package Report;

import java.util.Scanner;
import java.util.Arrays;
public class Report2_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intArray[][] = new int[4][4];
		
		
		System.out.println("4 x 4 배열에 랜덤한 값을 저장한 후 출력합니다.");
		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray.length; j++) {
				int number = (int) (Math.random()*256);
				intArray[i][j] = number;
			}
		}
		System.out.println(Arrays.deepToString(intArray));
		System.out.print("임계값 입력 ");
		int scoreThreshold = scanner.nextInt();
		
		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray.length; j++) {
				if(intArray[i][j]>scoreThreshold) {
					intArray[i][j] = 255;
				}else {
					intArray[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<intArray.length; i++) {
			System.out.println(Arrays.toString(intArray[i]));
			}
		scanner.close();
		}
}
