// 2차원 배열 n 을 실행 사례와 같이 출력하는 프로그램 작성

package Report;

public class Report2_7 {
	public static void main(String[] args) {
		
		int intArray[][] = {{1,2,3},{1,2},{1},{1,2,3},{1,2,3,4}};

		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray[i].length; j++) {
				System.out.print(intArray[i][j]);
			}
			System.out.println();
		}
	}
}
