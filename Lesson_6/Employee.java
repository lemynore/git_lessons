public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployeeInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван", "Инженер", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Петров Петр", "Менеджер", "petrovp@mailbox.com", "892312313", 40000, 35);
        employees[2] = new Employee("Сидоров Сидор", "Разработчик", "sidorov@mailbox.com", "892312314", 50000, 28);
        employees[3] = new Employee("Смирнов Алексей", "Тестировщик", "smirnov@mailbox.com", "892312315", 35000, 25);
        employees[4] = new Employee("Кузнецов Сергей", "Аналитик", "kuznetsov@mailbox.com", "892312316", 45000, 32);

        for (Employee employee : employees) {
            employee.printEmployeeInfo();
            System.out.println();
        }
    }
}
