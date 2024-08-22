public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.run(150); // Бобик пробежал 150 м.
        dogBobik.swim(5); // Бобик проплыл 5 м.
        catMurzik.run(150);
        catMurzik.swim(5);

        Bowl bowl = new Bowl(10);
        Cat[] cats = {catMurzik, catBarsik};

        for (Cat cat : cats) {
            cat.eat(bowl, 5);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.isFull());
        }

        bowl.addFood(10);
        catBarsik.eat(bowl, 5);
        System.out.println(catBarsik.name + " сытость: " + catBarsik.isFull());

        // Выводим количество созданных животных
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}