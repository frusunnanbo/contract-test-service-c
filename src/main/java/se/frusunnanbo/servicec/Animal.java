package se.frusunnanbo.servicec;

class Animal {
    public final String name;
    public final String kind;
    public final int age;
    public final Image image;
    public final String funFact;
    public final FoodSchedule foodSchedule;

    Animal(String name, String kind, int age, String funFact, FoodSchedule foodSchedule) {
        this.name = name;
        this.kind = kind;
        this.age = age;
        this.image = imageFor(name);
        this.funFact = funFact;
        this.foodSchedule = foodSchedule;
    }

    private Image imageFor(String name) {
        return new Image("/images/" + name.toLowerCase() + ".jpg", "/images/" + name.toLowerCase() + "-attribution.jpg");
    }

    private static class Image {
        public final String path;
        public final String attribution;

        private Image(String path, String attribution) {
            this.path = path;
            this.attribution = attribution;
        }
    }

    static class FoodSchedule {
        public final String morning;
        public final String lunch;
        public final String evening;

        FoodSchedule(String morning, String lunch, String evening) {
            this.morning = morning;
            this.lunch = lunch;
            this.evening = evening;
        }
    }
}
