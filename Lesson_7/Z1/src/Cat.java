public class Cat extends Animal {
    private static int catCount = 0; // Переменная для подсчета всех котов
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++; // Увеличиваем счетчик при создании кота
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            isFull = true;
            System.out.println(name + " покушал.");
        } else {
            System.out.println(name + " не хватило еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}