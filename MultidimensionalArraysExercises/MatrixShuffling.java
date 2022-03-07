package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //валидация: 1. команда swap   2. брой на координати   3. коордианти
        //разменям елементите
        int [] dimensions =  Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        String[][] matrix = new String[rows][cols];
        fillMatrix(scanner, matrix, rows, cols);

        String command = scanner.nextLine();
        while(!command.equals("END")) {
            //ако е невалидна -> Invalid input! -> нова команда
            //ако е валидна -> разменяме
            if(!validateCommand(command, rows, cols)) {
                //невалидна
                System.out.println("Invalid input!");
            } else {
                //валидна
                String [] tokens = command.split(" ");
                int rowFirst = Integer.parseInt(tokens[1]);
                int colFirst = Integer.parseInt(tokens[2]);
                int rowSecond = Integer.parseInt(tokens[3]);
                int colSecond =Integer.parseInt(tokens[4]);

                String element1 = matrix[rowFirst][colFirst];
                String element2 = matrix[rowSecond][colSecond];

                matrix[rowFirst][colFirst] = element2;
                matrix[rowSecond][colSecond] = element1;

                printMatrix(matrix, rows, cols);
            }
            command = scanner.nextLine();
        }

    }

    private static boolean validateCommand(String command, int rows, int cols) {
        //swap 0 0 1 1
        String [] tokens = command.split(" "); //["swap", "0", "0", "1", "1"]
        // 1. команда swap
        String commandName = tokens[0];
        if (!commandName.equals("swap")) {
            return false;
        }
        //2. брой на координати
        if(tokens.length != 5) {
            return false;
        }
        // 3. коордианти
        int rowFirst = Integer.parseInt(tokens[1]);
        int colFirst = Integer.parseInt(tokens[2]);
        int rowSecond = Integer.parseInt(tokens[3]);
        int colSecond =Integer.parseInt(tokens[4]);

        if(rowFirst < 0 || rowFirst >= rows || colFirst < 0 ||
            colFirst >= cols || rowSecond < 0 || rowSecond >= rows || colSecond < 0 || colSecond >= cols) {
            return false;
        }

        return true;


    }

    //fill matrix
    private static void fillMatrix(Scanner scanner, String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    //print matrix
    public static void printMatrix (String [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}