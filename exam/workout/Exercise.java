package workout;

public class Exercise {


    private final int burnedCalories;
    private final String name;
    private final String muscle;
    public Exercise(String name, String muscle, int burnedCalories) {

        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;

    }

    public String getName() {
        return name;
    }
    public String getMuscle() {
        return muscle;
    }
    public int getBurnedCalories() {
        return burnedCalories;
    }

    @Override
    public String toString() {

        return String.format("Exercise: %s, %s, %d", getName(), getMuscle(), getBurnedCalories());
    }
}
