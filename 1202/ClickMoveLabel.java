//10장 5번
package Report10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ClickMoveLabel extends JFrame {
    public ClickMoveLabel() {
        setTitle("클릭 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null); // 배치관리자 없음

        // JLabel 생성 및 초기 위치 설정
        JLabel label = new JLabel("C");
        label.setBounds(100, 100, 30, 30); // (x, y, width, height)
        label.setFont(new Font("Arial", Font.BOLD, 20)); // 글꼴 설정
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        // JLabel에 MouseListener 추가
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random random = new Random();
                int x = random.nextInt(370); // X 좌표: 0 ~ (400 - JLabel 너비)
                int y = random.nextInt(270); // Y 좌표: 0 ~ (300 - JLabel 높이)
                label.setLocation(x, y); // 새로운 위치로 이동
            }
        });

        // JFrame에 JLabel 추가
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClickMoveLabel();
    }
}
