class Park {
    private Attraction[] attractions;

    class Attraction {
        private String name;
        private String workingHours;
        private int cost;

        public Attraction(String name, String workingHours, int cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("Название аттракциона: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
        }
    }

    public Park(int numAttractions, String[] names, String[] workingHours, int[] costs) {
        attractions = new Attraction[numAttractions];
        for (int i = 0; i < numAttractions; i++) {
            attractions[i] = new Attraction(names[i], workingHours[i], costs[i]);
        }
    }

    public void printAllAttractions() {
        for (Attraction attraction : attractions) {
            attraction.printAttractionInfo();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] names = {"Колесо обозрения", "Американские горки", "Комната смеха"};
        String[] workingHours = {"10:00-18:00", "10:00-20:00", "11:00-22:00"};
        int[] costs = {500, 300, 400};

        Park park = new Park(3, names, workingHours, costs);

        park.printAllAttractions();
    }
}
