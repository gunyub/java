package Project08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class openChallenge {
    public static void main(String[] args) {
        Vector<String> wordVector = new Vector<>();
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new File("C:\\\\oop\\\\workspace\\\\Report07_08\\\\word.txt"));
            while (fileScanner.hasNext()) {
                String word = fileScanner.nextLine();
                wordVector.add(word);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("C:\\\\oop\\\\workspace\\\\Report07_08\\\\word.txt 파일을 찾을 수 없습니다.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            String targetWord = wordVector.get(random.nextInt(wordVector.size()));
            char[] hiddenWord = new char[targetWord.length()];
            for (int i = 0; i < hiddenWord.length; i++) {
                hiddenWord[i] = '-';
            }

            int attempts = 0;
            boolean wordGuessed = false;

            while (attempts < 5 && !wordGuessed) {
                System.out.print(hiddenWord);
                System.out.print("\n>> ");
                char guess = scanner.nextLine().charAt(0);
                boolean correctGuess = false;

                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == guess && hiddenWord[i] == '-') {
                        hiddenWord[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    attempts++;
                }

                wordGuessed = true;
                for (char c : hiddenWord) {
                    if (c == '-') {
                        wordGuessed = false;
                        break;
                    }
                }
            }

            if (wordGuessed) {
                System.out.println(targetWord);
                System.out.println("정답입니다!");
            } else {
                System.out.println("5번 실패하였습니다.");
                System.out.println("정답은: " + targetWord);
            }

            System.out.print("Next(y/n)? ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")) {
                playAgain = false;
            }
        }

        scanner.close();
    }
}
