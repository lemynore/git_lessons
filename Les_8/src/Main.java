public class Main {
    public static void main(String[] args) {
        // Создаем корректный массив 4x4
        String[][] correctArray = {
                {"1", "2", "3", "4",},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16",}
        };

        // Создаем массив неправильного размера
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };

        // Создаем массив с неправильными данными
        String[][] wrongDataArray = {
                {"Й", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "Ц", "15", "16"}
        };

        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = ArrayProcessor.processArray(wrongSizeArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = ArrayProcessor.processArray(wrongDataArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}