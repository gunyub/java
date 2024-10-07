//251쪽 11번
package Report;

public class Report3_11 {
    public static void main(String[] args) {
        int[] firstArray = {1, 5, 7, 9};
        int[] secondArray = {3, 6, -1, 100, 77};
        int[] combinedArray = ArrayUtil.concat(firstArray, secondArray);
        ArrayUtil.print(combinedArray);
    }
}

class ArrayUtil {
    public static int[] concat(int[] first, int[] second) {
        int[] combined = new int[first.length + second.length];
        System.arraycopy(first, 0, combined, 0, first.length);
        System.arraycopy(second, 0, combined, first.length, second.length);
        return combined;
    }

    public static void print(int[] array) {
        System.out.print("[ ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }
}
