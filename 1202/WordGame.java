//실습 11장 10번
package Report11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class WordGame extends JFrame {
    private JLabel timerLabel; // 타이머 레이블
    private JPanel gamePanel; // 게임 단어가 표시되는 패널
    private JTextField resultField; // 하단에 완성된 문장 출력
    private JButton newTextButton; // "New Text" 버튼
    private String[] sentences = { 
        "I love programming", 
        "Java is fun", 
        "Swing makes GUIs",
        "Hello world"
    }; // 준비된 문장들
    private String[] words; // 선택된 문장의 단어들
    private String targetSentence; // 현재 목표 문장
    private StringBuilder userSentence; // 사용자가 완성 중인 문장
    private int timeElapsed; // 경과 시간
    private Timer timer; // Swing Timer 사용

    public WordGame() {
        setTitle("Word Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // 상단 타이머 및 버튼
        JPanel topPanel = new JPanel(new BorderLayout());
        timerLabel = new JLabel("Time: 0 sec");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setHorizontalAlignment(SwingConstants.LEFT);

        newTextButton = new JButton("New Text");
        newTextButton.addActionListener(e -> startNewGame());

        topPanel.add(timerLabel, BorderLayout.WEST);
        topPanel.add(newTextButton, BorderLayout.EAST);

        // 중앙 게임 패널
        gamePanel = new JPanel();
        gamePanel.setLayout(null); // 배치 관리자 제거
        gamePanel.setBackground(Color.WHITE);

        // 하단 결과 필드
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultField = new JTextField();
        resultField.setFont(new Font("Arial", Font.PLAIN, 16));
        resultField.setEditable(false);

        bottomPanel.add(resultLabel, BorderLayout.WEST);
        bottomPanel.add(resultField, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startNewGame() {
        gamePanel.removeAll();
        userSentence = new StringBuilder();
        resultField.setText("");

        // 문장 랜덤 선택
        Random random = new Random();
        targetSentence = sentences[random.nextInt(sentences.length)];
        words = targetSentence.split(" ");

        // 단어 셔플
        ArrayList<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        Collections.shuffle(wordList);

        // 단어 버튼 생성
        for (String word : wordList) {
            JButton wordButton = new JButton(word);
            wordButton.setBounds(random.nextInt(400), random.nextInt(200), 100, 30);
            wordButton.addActionListener(e -> handleWordClick(wordButton, word));
            gamePanel.add(wordButton);
        }

        // 타이머 시작
        startTimer();

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    private void handleWordClick(JButton wordButton, String word) {
        if (userSentence.length() > 0) userSentence.append(" ");
        userSentence.append(word);
        resultField.setText(userSentence.toString());

        wordButton.setEnabled(false); // 클릭한 버튼 비활성화

        // 정답 체크
        if (userSentence.toString().equals(targetSentence)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Correct! You finished in " + timeElapsed + " seconds.");
        }
    }

    private void startTimer() {
        timeElapsed = 0;
        if (timer != null) timer.stop();
        timer = new Timer(1000, e -> {
            timeElapsed++;
            timerLabel.setText("Time: " + timeElapsed + " sec");
        });
        timer.start();
    }

    public static void main(String[] args) {
        new WordGame();
    }
}
