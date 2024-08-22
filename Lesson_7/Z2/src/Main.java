public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Чёрный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Жёлтый");
        Shape triangle = new Triangle(3, 4, 5, "Зелёный", "Голубой");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("\nПрямоугольник:");
        rectangle.printInfo();

        System.out.println("\nТреугольник:");
        triangle.printInfo();
    }
}
