package SoftUniAdvanceExam;

import java.util.Scanner;

public class StickyFingers02 {
    private static int ROW = 0;
    
    private static int COL = 0;
    
    private static int GOLD_STOLEN = 0;
    
    private static boolean IS_CAUGHT = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int size = Integer.parseInt(sc.nextLine());
        int rowCount = 0;

        String[] enterCommand = sc.nextLine().split(",");

        char[][] dimMatrix = new char[size][];

            while (size-- > 0) {
            dimMatrix[rowCount] = sc.nextLine().replaceAll(" ", "").toCharArray();

            for (int j = 0; j < dimMatrix[rowCount].length; j++) {
                char currChar = dimMatrix[rowCount][j];

                if (currChar == 'D') {
                    ROW = rowCount;
                    COL = j;
                }

            }
            rowCount++;
        }


        int length = enterCommand.length;
        int i = 0;

        while (length-- > 0) {
            String s = enterCommand[i++];
            if ("up".equals(s)) {
                mover(dimMatrix, -1, 0);

            } else if ("down".equals(s)) {
                mover(dimMatrix, 1, 0);

            } else if ("right".equals(s)) {
                mover(dimMatrix, 0, 1);

            } else if ("left".equals(s)) {
                mover(dimMatrix, 0, -1);

            }
            if (IS_CAUGHT) {
                break;
            }

        }

        if (!IS_CAUGHT) {

            System.out.println("Your last theft has finished successfully with " + GOLD_STOLEN + "$ in your pocket.");
        }
        printTheMatrix(dimMatrix);
    }

      private static void printTheMatrix(char[][] theMatrix) {

        for (char[] matrix : theMatrix) {

            for (int col = 0; col < theMatrix.length; col++) {
                   System.out.print(matrix[col] + " ");
            }
            System.out.println();
        }
    }

    private static void mover(char[][] matrix, int mutatorForRow, int mutatorForColl) {

        int rowNext = ROW + mutatorForRow;
        int colNext = COL + mutatorForColl;
        if (!isInTheBound(matrix, rowNext, colNext)) {

               System.out.println("You cannot leave the town, there is police outside!");
               
            return;
        }
             char currChar = matrix[rowNext][colNext];


        if (currChar == 'P') {

            System.out.println("You got caught with " + GOLD_STOLEN + "$, and you are going to jail.");

            matrix[ROW][COL] = '+';

             matrix[rowNext][colNext] = '#';

            IS_CAUGHT = true;

            return;
        } else if (currChar == '$') {

            matrix[rowNext][colNext] = 'D';

            matrix[ROW][COL] = '+';

            GOLD_STOLEN += (colNext * rowNext);

              System.out.println("You successfully stole " + (colNext * rowNext) + "$.");

        } else {

            matrix[ROW][COL] = '+';

            matrix[rowNext][colNext] = 'D';
        }
        ROW = rowNext;
          COL = colNext;
    }

    private static boolean isInTheBound(char[][] matrix, int rowNext, int colNext) {

         return rowNext >= 0 && rowNext < matrix.length && colNext >= 0 && colNext < matrix.length;
    }
}
