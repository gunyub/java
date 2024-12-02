//9장 10번
package Report9;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Report_10 extends JFrame {
    public Report_10() {
        setTitle("Custom GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // WEST 영역: GridLayout으로 8개의 색상 패널 추가
        JPanel westPanel = new JPanel(new GridLayout(8, 1)); // 8행 1열
        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.LIGHT_GRAY
        };
        for (Color color : colors) {
            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(color);
            westPanel.add(colorPanel);
        }

        // WEST 영역 크기 조정
        westPanel.setPreferredSize(new Dimension(100, 0)); // 가로 150px로 설정
        add(westPanel, BorderLayout.WEST);

        // CENTER 영역: 랜덤한 정수 출력
        JPanel centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Random random = new Random();
                g.setFont(new Font("Arial", Font.BOLD, 16));

                // 랜덤 좌표와 숫자 출력
                for (int i = 0; i < 10; i++) {
                    int x = 50 + random.nextInt(151); // 50 ~ 200 범위
                    int y = 50 + random.nextInt(151); // 50 ~ 200 범위
                    int randomNumber = random.nextInt(10); // 0 ~ 9
                    g.drawString(String.valueOf(randomNumber), x, y);
                }
            }
        };
        add(centerPanel, BorderLayout.CENTER);

        setSize(500, 400); // 창 크기 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        new Report_10();
    }
}
