public class ArrayInverter {
    public void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
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
