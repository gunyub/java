package Report;

public class Report2_5 {
	public static void main(String[] args) {
		int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
		//for 문작성
//		for(int i=0; i<n.length; i++) {
//			if(n[i]>0 && n[i]%4==0) {
//				System.out.print(n[i]+" ");
//			}
//		}
		//while 문작성
//		int i=0;	
//		while(true) {
//			if(n[i]>0 && n[i]%4==0) {
//				System.out.println(n[i]);
//			}
//			i++;
//			if(i+1>n.length) {
//				break;
//			}
//		}
		// do-while 문작성
		int i=0;
		do {if(n[i]>0 && n[i]%4==0) {
			System.out.println(n[i]);
			}
			i++;
			}while(i<n.length);
	}
}
