package se.frusunnanbo.servicec;

public class Animals {

    private static final Animal.FoodSchedule CAT_FOODSCHEDULE
            = new Animal.FoodSchedule("One mouse", "One bird", "Nothing");
    private static final Animal.FoodSchedule HEDGEHOG_FOODSCHEDULE
            = new Animal.FoodSchedule("Some worms", "A snail", "10 dragonflies");
    private static final Animal.FoodSchedule DRAGON_FOODSCHEDULE
            = new Animal.FoodSchedule("A princess", "A brave knight", "Regrets");
    private static final Animal.FoodSchedule TIGER_FOODSCHEDULE
            = new Animal.FoodSchedule("Nothing", "Lots of meat", "Nothing");

    private static final String HUFFLEPUFF_DESCRIPTION = "Hufflepuff is our house cat. She's born at the zoo and loves to fall asleep on the zookeepers' lap";
    private static final String SPIKY_DESCRIPTION = "Spiky loves behind stones and under bushes. But if you take a close look you can probably find her.";
    private static final String JOY_DESCRIPTION = "Joy is Spiky's daughter. She's slightly smaller and lighter in colour than her mother.";
    private static final String SMAUG_DESCRIPTION = "Smaug is the world's only dragon born and bred in a zoo. We're extremely proud of him, but he has eaten a few visitors over the years. Be careful!";
    private static final String STRIPEY_DESCRIPTION = "Stripey is the cuddliest tiger you can ever imagine.";
    private static final String TIGGER_DESCRIPTION = "Tigger is our newest aquisition. He's about as beautiful and dangerous as a tiger can be.";

    static final Animal HUFFLEPUFF = new Animal("Hufflepuff", "cat", HUFFLEPUFF_DESCRIPTION, 9, CAT_FOODSCHEDULE);
    static final Animal SPIKY = new Animal("Spiky", "hedgehog", SPIKY_DESCRIPTION, 7, HEDGEHOG_FOODSCHEDULE);
    static final Animal JOY = new Animal("Joy", "hedgehog", JOY_DESCRIPTION, 4, HEDGEHOG_FOODSCHEDULE);
    static final Animal SMAUG = new Animal("Smaug", "dragon", SMAUG_DESCRIPTION, 93, DRAGON_FOODSCHEDULE);
    static final Animal STRIPEY = new Animal("Stripey", "tiger", STRIPEY_DESCRIPTION, 17, TIGER_FOODSCHEDULE);
    static final Animal TIGGER = new Animal("Tigger", "tiger", TIGGER_DESCRIPTION, 10, TIGER_FOODSCHEDULE);
}
