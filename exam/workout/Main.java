package workout;

public class Main {
    public static void main(String[] args) {

        Workout workout = new Workout("strength", 3);
        Exercise exercise = new Exercise("Bench Press", "chest", 30);
        Exercise secondExercise = new Exercise("Deadlift", "back", 50);
        Exercise thirdExercise = new Exercise("Barbell Curl", "biceps", 25);
        Exercise fourthExercise = new Exercise("Squats", "legs", 60);
        Exercise fifthExercise = new Exercise("Deadlift", "legs", 55);

        System.out.println(exercise);

        workout.addExercise(exercise);


        System.out.println(workout.removeExercise("Bench Press", "arms")); // false
        System.out.println(workout.removeExercise("Bench Press", "chest")); // true
        System.out.println(workout.getExercise("Bench Press", "chest")); // null

        workout.addExercise(secondExercise);
        workout.addExercise(thirdExercise);
        workout.addExercise(fourthExercise);
        workout.addExercise(fifthExercise);




        Exercise mostBurnedCaloriesExercise = workout.getMostBurnedCaloriesExercise();
        System.out.println(mostBurnedCaloriesExercise);

        Exercise exerciseByNameAndMuscle = workout.getExercise("Deadlift", "back");
        System.out.println(exerciseByNameAndMuscle);

        System.out.println(workout.getExerciseCount());
        System.out.println(workout.removeExercise("Barbell Curl", "biceps"));

        System.out.println(workout.getStatistics());


    }
}
