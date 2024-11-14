//실습 1번
package reportPackage;

public class Report1 {

	public static void main(String[] args) {
		Student a = new Student("황기태",23);
		Student b = new Student("황기태",77);
		System.out.println(a);
		if(a.equals(b)) {
			System.out.println("같은 학생입니다.");
		}else {
			System.out.println("다른학생입니다.");
		}
	}
}
class Student {
	String name;
	int id;
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "학번이 "+this.id+"인 "+ this.name;
	}
	
}
