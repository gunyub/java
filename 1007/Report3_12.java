//252쪽 12번
package Report;

import java.util.Scanner;

public class Report3_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어? ");
            String koreanWord = scanner.next();

            if (koreanWord.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String englishEquivalent = Dictionary.translateToEnglish(koreanWord);
            if (englishEquivalent != null) {
                System.out.println(koreanWord + "는 " + englishEquivalent);
            } else {
                System.out.println(koreanWord + "는 저의 사전에 없습니다.");
            }
        }

        scanner.close();
    }
}

class Dictionary {
    private static String[] koreanWords = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] englishWords = {"love", "baby", "money", "future", "hope"};

    public static String translateToEnglish(String koreanWord) {
        for (int i = 0; i < koreanWords.length; i++) {
            if (koreanWords[i].equals(koreanWord)) {
                return englishWords[i];
            }
        }
        return null;
    }
}
