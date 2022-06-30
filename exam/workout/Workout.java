package workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Workout {
    //The class for workout data

    private final int exerciseCount;
    private final String type;
    private final List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {

        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();

    }

    public void addExercise(Exercise exercise) {

        if (this.exercises.size() < this.exerciseCount) {

            this.exercises.add(exercise);
        }

    }

    public String getStatistics() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Workout type: %s%n", this.type));

        for (Iterator<Exercise> iterator = this.exercises.iterator(); iterator.hasNext(); ) {
            Exercise exercise = iterator.next();

            stringBuilder.append(String.format("%s%n", exercise.toString()));
        }

        return stringBuilder.toString().trim();
    }


    public Exercise getExercise(String name, String muscleName) {

        for (Exercise e : this.exercises) {
            if (e.getName().equals(name) && e.getMuscle().equals(muscleName)) {
                return e;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {

        Exercise burnCal = exercises.get(0);

        for (int i = 0; i < exercises.size(); i++) {
            Exercise exercise = exercises.get(i);

            if (exercise.getBurnedCalories() > burnCal.getBurnedCalories()) {

                burnCal = exercise;
            }
        }

        return burnCal;
    }

    public int getExerciseCount() {

        return this.exercises.size();
    }


    public boolean removeExercise(String name, String muscleName) {

        if (this.exercises.
            removeIf(e ->
                e.getName().equals(name) && e.getMuscle().equals(muscleName)
            ))
            return true;
        else
            return false;
    }
}
