package JavaAdvanced.p12DefiningClassesExercises.p07Google;

import java.util.List;

public class Car {
    String model;
    int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return model + " " + speed + System.lineSeparator();
    }
}
