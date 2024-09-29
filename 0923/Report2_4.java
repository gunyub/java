package Report;

public class Report2_4 {
// for 문 작성
//	public static void main(String[] args) {
//		
//		int sum=0; 
//		for(int i=1; i<50; i+=3) {
//			sum += i;
//		}
//		System.out.println(sum);
//	}
// do-while 작성
	public static void main(String[] args) {
		int i=1, sum=0;
		do {sum += i;
		 	i += 3;}while(i<50);
		System.out.println(sum);
		
		}
	}
