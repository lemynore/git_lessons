public class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected static int animalCount = 0; // Переменная для подсчета всех животных

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++; // Увеличиваем счетчик при создании животного
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }
}