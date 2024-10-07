package Report;

class DynamicArray {
    private int[] elements;
    private int elementCount;

    public DynamicArray(int initialCapacity) {
        elements = new int[initialCapacity];
        elementCount = 0;
    }

    public int getCapacity() {
        return elements.length;
    }

    public int getSize() {
        return elementCount;
    }

    public void addElement(int value) {
        if (elementCount >= elements.length) {
            doubleCapacity();
        }
        elements[elementCount++] = value;
    }

    public void insertElement(int position, int value) {
        if (position > elementCount) {
            System.out.println("Invalid index.");
            return;
        }
        if (elementCount >= elements.length) {
            doubleCapacity();
        }
        System.arraycopy(elements, position, elements, position + 1, elementCount - position);
        elements[position] = value;
        elementCount++;
    }

    public void removeElement(int position) {
        if (position >= elementCount) {
            System.out.println("Invalid index.");
            return;
        }
        System.arraycopy(elements, position + 1, elements, position, elementCount - position - 1);
        elementCount--;
    }

    public void displayElements() {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    private void doubleCapacity() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}

public class Report3_14 {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(5);
        System.out.println("Capacity: " + dynamicArray.getCapacity() + ", Stored Count: " + dynamicArray.getSize());

        for (int i = 0; i < 7; i++) {
            dynamicArray.addElement(i);
        }
        System.out.println("Capacity: " + dynamicArray.getCapacity() + ", Stored Count: " + dynamicArray.getSize());
        dynamicArray.displayElements();

        dynamicArray.insertElement(3, 100);
        dynamicArray.insertElement(5, 200);
        System.out.println("Capacity: " + dynamicArray.getCapacity() + ", Stored Count: " + dynamicArray.getSize());
        dynamicArray.displayElements();

        dynamicArray.removeElement(10);
        System.out.println("Capacity: " + dynamicArray.getCapacity() + ", Stored Count: " + dynamicArray.getSize());
        dynamicArray.displayElements();

        for (int i = 50; i < 55; i++) {
            dynamicArray.addElement(i);
        }
        System.out.println("Capacity: " + dynamicArray.getCapacity() + ", Stored Count: " + dynamicArray.getSize());
        dynamicArray.displayElements();
    }
}
