public class CustomArrayCreator {
    public void createArray() {
        int len = 10;
        int initialValue = 5;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        printArray(array);
    }

    private void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
