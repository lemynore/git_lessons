public class LeapYearChecker {
    public void checkLeapYear() {
        int year = 2020;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeapYear ? "true" : "false");
    }
}
