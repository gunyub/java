package ReortClass;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint() {
        this(0, 0, "BLACK"); // 기본 위치와 색상
    }

    public void setXY(int x, int y) {
        move(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }
}

public class ReportClass_3 {
    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "RED");

        cp.setXY(10, 20);
        cp.setColor("BLUE");
        System.out.println(cp.toString() + "입니다."); // 출력: BLUE색의 (10,20)의 점입니다.
    }
}
