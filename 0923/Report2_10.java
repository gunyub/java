// 정수 10개 배열 생성, 11~19 범위 정수 랜덤 생성, 배열의 평균 생성
package Report;


import java.util.Arrays;

public class Report2_10 {
	public static void main(String[] args) {
		int intArray[] = new int[10];
		double sum=0;
		// 랜덤 숫자 생성
		for(int i=0; i<intArray.length; i++) {
			int num = (int)(Math.random()*9)+11;
			intArray[i] = num;
			sum += intArray[i];
		}
		System.out.println(Arrays.toString(intArray));
		System.out.println(sum/intArray.length);
	}
}