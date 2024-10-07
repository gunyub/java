//cube 는 직육면체를 표현하는 클래스이다 다음 main() 메소드와 실행 결과를 참고하여 cube 클래스 작성하라
package Report;
class Cube{
	int width;
	int depth;
	int height;
	// 생성자
	public Cube(int width, int depth, int height){
		this.width = width;
		this.depth = depth;
		this.height = height;
	}
	// 부피 메소드 
	public int getVolume() {
		return width*depth*height;
	}
	// 증가 메소드
	public void increase(int widthPlus, int depthPlus, int heightPlus) {
		this.width += widthPlus;
		this.depth += depthPlus;
		this.height += heightPlus;
	}
	// 부피가 0인지 확인 메소드
	public boolean isZero() {
		return getVolume() == 0;
	}
}

public class Report3_2 {
	public static void main(String[] args) {
		Cube cube = new Cube(1,2,3);
		System.out.println("큐브의 부피는" + cube.getVolume());
		cube.increase(1, 2, 3);
		System.out.println("큐브의 부피는"+ cube.getVolume());
		if(cube.isZero()) {
			System.out.println("큐브의 부피는 0");
		}else {
			System.out.println("큐브의 부피는 0이 아님");
		}
	}
}
