package SoftUniAdvanceExam;

import java.util.*;

public class ItsChocolateTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> chocolateTypes = new TreeMap<>();
        chocolateTypes.put("Milk Chocolate", 0);
        chocolateTypes.put("Dark Chocolate", 0);
        chocolateTypes.put("Baking Chocolate", 0);

        double[] arrayOne = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToDouble(Double::parseDouble).toArray();
        double[] arrayTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToDouble(Double::parseDouble).toArray();

        ArrayDeque<Double> queueForMilk = new ArrayDeque<>();
        ArrayDeque<Double> stackForCacao = new ArrayDeque<>();
        Arrays.stream(arrayOne).forEach(queueForMilk::offer);
        Arrays.stream(arrayTwo).forEach(stackForCacao::push);


        while (!queueForMilk.isEmpty() && !stackForCacao.isEmpty()) {
            double milk = queueForMilk.poll();
            double cacao = stackForCacao.pop();

            double sum = (cacao / (milk + cacao)) * 100;

            if (sum == 30.0) {

                chocolateTypes.put("Milk Chocolate", chocolateTypes.get("Milk Chocolate") + 1);

            } else if (sum == 50.0) {

                chocolateTypes.put("Dark Chocolate", chocolateTypes.get("Dark Chocolate") + 1);

            } else if (sum == 100.0) {

                chocolateTypes.put("Baking Chocolate", chocolateTypes.get("Baking Chocolate") + 1);

            } else {

                double addTen = milk;
                addTen += 10;
                queueForMilk.addLast(addTen);
            }

        }
        boolean isPrepare = true;
        for (Map.Entry<String, Integer> entyrSet : chocolateTypes.entrySet()) {
            if (entyrSet.getValue() == 0) {
                isPrepare = false;
                break;
            }
        }

        if (isPrepare) {

            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");

        } else {

            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entrySet : chocolateTypes.entrySet()) {
            if (entrySet.getValue() != 0) {
                System.out.printf("# %s --> %d%n", entrySet.getKey(), entrySet.getValue());
            }
        }
    }
}
