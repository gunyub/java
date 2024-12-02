//10장 10번
package Report10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BlockDraggingApp extends JFrame {
    private JPanel panel;

    public BlockDraggingApp() {
        setTitle("블록 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);

        panel = new JPanel(null); // 배치관리자 없음
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 600, 400);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') { // 'M' 키 입력 시
                    createRandomBlock();
                }
            }
        });

        add(panel);
        setFocusable(true);
        setVisible(true);
    }

    private void createRandomBlock() {
        JLabel block = new JLabel();
        block.setOpaque(true);
        block.setBackground(getRandomColor());
        block.setBounds(100, 100, 80, 80); // 초기 위치와 크기 설정

        // 드래깅 이벤트 처리
        block.addMouseListener(new MouseAdapter() {
            Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        block.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 드래깅 시 컴포넌트 이동
                Point blockLocation = block.getLocation();
                block.setLocation(
                        blockLocation.x + e.getX() - block.getWidth() / 2,
                        blockLocation.y + e.getY() - block.getHeight() / 2
                );
            }
        });

        panel.add(block); // 블록 추가
        panel.repaint(); // 화면 갱신
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static void main(String[] args) {
        new BlockDraggingApp();
    }
}
