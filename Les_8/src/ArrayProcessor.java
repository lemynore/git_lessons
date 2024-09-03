import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем, что массив состоит из 4 строк
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4.");
        }

        // Проверяем, что каждая строка массива имеет длину 4
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер каждой строки массива должен быть 4. Ошибка на строке " + i);
            }
        }

        int sum = 0;
        List<String> errors = new ArrayList<>(); // Список для хранения всех ошибок

        // Проходим по каждому элементу массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Преобразуем строку в целое число и добавляем к сумме
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Сохраняем информацию об ошибке
                    errors.add("Неверные данные на (" + i + "," + j + "): " + array[i][j]);
                }
            }
        }

        // Если есть ошибки, бросаем исключение с информацией обо всех ошибках
        if (!errors.isEmpty()) {
            throw new MyArrayDataException(String.join("\n", errors));
        }

        return sum;
    }
}