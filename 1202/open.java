package Report9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class open extends JFrame {
    private JTextField inputField; // SOUTH 패널에 있는 텍스트 필드

    public open() {
        setTitle("단어 조합 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // NORTH 패널
        JPanel northPanel = new JPanel();
        JLabel titleLabel = new JLabel("단어 조합 게임");
        JButton newTextButton = new JButton("New Text");
        northPanel.add(titleLabel);
        northPanel.add(newTextButton);
        add(northPanel, BorderLayout.NORTH);

        // SOUTH 패널
        JPanel southPanel = new JPanel();
        JLabel inputLabel = new JLabel("정답:");
        inputField = new JTextField(20); // 20글자 길이
        southPanel.add(inputLabel);
        southPanel.add(inputField);
        add(southPanel, BorderLayout.SOUTH);

        // CENTER 패널
        JPanel centerPanel = new JPanel(null); // 자유 배치 (null layout)
        String text = "I can't help falling in love with you";
        String[] words = text.split(" ");
        Random random = new Random();

        for (String word : words) {
            JButton wordButton = new JButton(word); // 단어를 버튼으로 생성
            int x = random.nextInt(350); // X 범위: 0 ~ 350
            int y = random.nextInt(180); // Y 범위: 0 ~ 180
            wordButton.setBounds(x, y, 100, 30); // 버튼 크기와 위치 설정
            wordButton.addActionListener(new WordButtonListener()); // 버튼 클릭 리스너 추가
            centerPanel.add(wordButton);
        }
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // 버튼 클릭 이벤트 리스너 클래스
    private class WordButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            String currentText = inputField.getText();
            inputField.setText(currentText + clickedButton.getText() + " ");
            clickedButton.setEnabled(false); // 버튼 비활성화
        }
    }

    public static void main(String[] args) {
        new open();
    }
}
