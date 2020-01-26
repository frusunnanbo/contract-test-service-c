package se.frusunnanbo.servicec;

import java.util.Objects;

class Animal {

    public final String name;
    public final String kind;
    public final String description;
    public final int age;
    public final String imageUrl;
    public final FoodSchedule foodSchedule;

    Animal(String name, String kind, String description, int age, FoodSchedule foodSchedule) {
        this.name = name;
        this.kind = kind;
        this.description = description;
        this.age = age;
        this.imageUrl = imageFor(name);
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
                    && Objects.equals(this.imageUrl, other.imageUrl)
                    && Objects.equals(this.kind, other.kind)
                    && Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, age, imageUrl, foodSchedule);
    }

    private String imageFor(String name) {
        return "/images/" + name.toLowerCase() + ".jpg";
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
