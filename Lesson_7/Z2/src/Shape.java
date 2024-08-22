public interface Shape {
    double calculateArea();  // Метод для расчета площади
    double calculatePerimeter();  // Метод для расчета периметра

    // Методы для получения и установки цветов
    String getFillColor();
    void setFillColor(String color);

    String getBorderColor();
    void setBorderColor(String color);


    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
