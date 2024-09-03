import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        phoneBook.putIfAbsent(lastName, new ArrayList<>());
        phoneBook.get(lastName).add(phoneNumber);
    }

    // Метод для получения телефонов по фамилии
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        // Добавляем записи
        myPhoneBook.add("Ivanov", "123-4567");
        myPhoneBook.add("Ivanov", "234-5678");
        myPhoneBook.add("Petrov", "345-6789");
        myPhoneBook.add("Sidorov", "456-7890");

        // Получаем и выводим номера телефонов по фамилии
        System.out.println("Номера телефонов Иванова: " + myPhoneBook.get("Ivanov"));
        System.out.println("Номера телефонов Петрова: " + myPhoneBook.get("Petrov"));
        System.out.println("Номера телефонов Сидорова: " + myPhoneBook.get("Sidorov"));
    }
}
