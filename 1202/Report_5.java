//9장 5번
package Report9;
import javax.swing.*;
import java.awt.*;   

public class Report_5 {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("4x4 Color Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // 컨텐트팬의 배치관리자를 GridLayout으로 설정
        frame.setLayout(new GridLayout(4, 4));

        // JLabel 배열 생성
        JLabel[] labels = new JLabel[16];

        // 색상 배열 생성
        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.BLUE, Color.MAGENTA, Color.CYAN, Color.PINK,
            Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE,
            Color.BLACK, new Color(128, 0, 128), new Color(255, 20, 147), new Color(0, 255, 127)
        };

        // JLabel 생성 및 배경색 설정 후 추가
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();  // JLabel 생성
            labels[i].setOpaque(true); // 배경색을 설정하려면 Opaque를 true로 설정해야 함
            labels[i].setBackground(colors[i]); // 배경색 설정
            frame.add(labels[i]); // JLabel을 JFrame에 추가
        }

        // 프레임을 보이도록 설정
        frame.setVisible(true);
    }
}
