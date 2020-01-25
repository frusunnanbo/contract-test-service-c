package se.frusunnanbo.servicec;

import java.util.Objects;

class Animal {
    public final String name;
    public final String kind;
    public final int age;
    public final Image image;
    public final FoodSchedule foodSchedule;

    Animal(String name, String kind, int age, FoodSchedule foodSchedule) {
        this.name = name;
        this.kind = kind;
        this.age = age;
        this.image = imageFor(name);
        this.foodSchedule = foodSchedule;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Animal) {
            Animal other = (Animal) o;
            return Objects.equals(this.age, other.age)
                    && Objects.equals(this.foodSchedule, other.foodSchedule)
                    && Objects.equals(this.image, other.image)
                    && Objects.equals(this.kind, other.kind)
                    && Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, age, image, foodSchedule);
    }

    private Image imageFor(String name) {
        return new Image("/images/" + name.toLowerCase() + ".jpg", "/images/" + name.toLowerCase() + "-attribution.txt");
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
