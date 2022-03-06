package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentBrecket = input.charAt(i);

            if (currentBrecket == '(' || currentBrecket == '[' || currentBrecket == '{') {
                openBrackets.push(currentBrecket);
            } else if (currentBrecket == ')' || currentBrecket == ']' || currentBrecket == '}') {
                if (!openBrackets.isEmpty()) {
                    char lastOpenBrecket = openBrackets.pop();

                    if (lastOpenBrecket == '(' && currentBrecket == ')') {
                        areBalanced = true;
                    } else if (lastOpenBrecket == '[' && currentBrecket == ']') {
                        areBalanced = true;
                    } else if (lastOpenBrecket == '{' && currentBrecket == '}') {
                        areBalanced = true;
                    } else {
                        areBalanced = false;
                        break;
                    }
                }
                else {
                    areBalanced  = false;
                    break;
                }
            }

        }
        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }
}
