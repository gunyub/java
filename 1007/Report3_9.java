//246쪽 4번
package Report;

public class Report3_9 {
    public static void main(String[] args) {
        Average averageCalculator = new Average();
        averageCalculator.put(10);
        averageCalculator.put(15);
        averageCalculator.put(100);
        averageCalculator.showAll();
        System.out.print("평균은 " + averageCalculator.calculateAverage());
    }
}

class Average {
    private int[] data;
    private int currentIndex;

    public Average() {
        data = new int[10];
        currentIndex = 0;
    }

    public void put(int value) {
        if (currentIndex < data.length) {
            data[currentIndex] = value;
            currentIndex++;
        } else {
            System.out.println("더 이상 저장할 수 없습니다.");
        }
    }

    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public double calculateAverage() {
        int total = 0;
        for (int i = 0; i < currentIndex; i++) {
            total += data[i];
        }
        return (double) total / currentIndex;
    }
}
