package se.frusunnanbo.servicec;

public class Animals {

    static final Animal.FoodSchedule CAT_FOODSCHEDULE
            = new Animal.FoodSchedule("One mouse", "One bird", "Nothing");
    static final Animal.FoodSchedule HEDGEHOG_FOODSCHEDULE
            = new Animal.FoodSchedule("Some worms", "A snail", "10 dragonflies");
    static final Animal.FoodSchedule DRAGON_FOODSCHEDULE
            = new Animal.FoodSchedule("A princess", "A brave knight", "Regrets");
    static final Animal.FoodSchedule TIGER_FOODSCHEDULE
            = new Animal.FoodSchedule("Nothing", "Lots of meat", "Nothing");


    static final Animal HUFFLEPUFF = new Animal("Hufflepuff", "cat", 9, CAT_FOODSCHEDULE);
    static final Animal SPIKY = new Animal("Spiky", "hedgehog", 7, HEDGEHOG_FOODSCHEDULE);
    static final Animal JOY = new Animal("Joy", "hedgehog", 4, HEDGEHOG_FOODSCHEDULE);
    static final Animal SMAUG = new Animal("Smaug", "dragon", 93, DRAGON_FOODSCHEDULE);
    static final Animal STRIPEY = new Animal("Stripey", "tiger", 17, TIGER_FOODSCHEDULE);
    static final Animal TIGGER = new Animal("Tigger", "tiger", 10, TIGER_FOODSCHEDULE);
}
