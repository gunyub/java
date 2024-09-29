// 4 x 4 2차원 정수 배열을 생겅하고 0~255 범위의 정수 16개를 랜덤하게 생성하여 저장 배열 출력
package Report;

import java.util.Arrays;

public class Report2_12 {
	public static void main(String[] args) {
		
		int intArray[][] =new int[4][4];
		
		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray.length; j++) {				 
				int num = (int) (Math.random()*256);
				intArray[i][j] = num;
			}
		}
		for(int i=0; i<intArray.length; i++) {
			System.out.println(Arrays.toString(intArray[i]));
		}
	}
}
