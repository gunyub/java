//248쪽 7번
package Report;

class Memo{
	String name, time, content;
	
	//생성자
	public Memo(String name, String time, String content) {
		this.name = name;
		this.time = time;
		this.content = content;
	}
	// 작성자가 같으면 true
	public boolean isSameName(Memo compare) {
		return this.name.equals(compare.name);
	}
	//메모 작성자 이름 리턴
	public String getName() {
		return name;
	}
	// 메모 출력
	public void show() {
		System.out.println(name+","+time+" "+content);
	}
	//메모 텍스트 길이 리턴
	public int length() {
		int length = 0;
		for(int i=0; i<content.length();i++) 
			length++;
		return length;
	}
}


public class Report3_6 {
	public static void main(String[] args) {
		Memo memo1 = new Memo("유송연","10:10","자바과제있음");
		Memo memo2 = new Memo("박채원","10:15","시카고로 어학 연수가요!");
		Memo memo3 = new Memo("김경미","11:30","사랑하는 사람이 생겼어요.");
		
		memo1.show();
		if(memo1.isSameName(memo2)) System.out.println("동일한 사람입니다");
		else System.out.println("다른 사람입니다.");
		System.out.println(memo3.getName()+"가 작성한 메모의 길이는 "+memo3.length());
	}
}
