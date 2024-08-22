public class Dog extends Animal {
    private static int dogCount = 0; // Переменная для подсчета всех собак

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++; // Увеличиваем счетчик при создании собаки
    }

    public static int getDogCount() {
        return dogCount;
    }
}