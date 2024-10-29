//실습 문제 1번
package ReortClass;
class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int color;

    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }
    public int colorchange() {
    	return color;
    }
    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }
}

public class ReportClass_1 {
    public static void main(String[] args) {
        ColorTV myTv = new ColorTV(65, 65536);
        myTv.printProperty(); // 출력: 65인치 65536컬러
    }
}
