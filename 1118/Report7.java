package Project08;

import java.io.*;

public class Report7 {
    public static void main(String[] args) {
        File sourceFile = new File("a.jpg");
        File destFile = new File("b.jpg");

        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            long totalBytes = sourceFile.length();
            long copiedBytes = 0;
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                copiedBytes += bytesRead;
                int progress = (int) ((copiedBytes * 100) / totalBytes);
                if (progress % 10 == 0) {
                    System.out.print("*");
                }
            }
            System.out.println("\n복사가 완료되었습니다.");

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다: " + e.getMessage());
        }
    }
}