package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int enterQueue = scanner.nextInt();
            queue.offer(enterQueue);
        }
            for (int j = 0; j < s; j++) {
                queue.poll();
            }

            if (!queue.isEmpty()){
                if (queue.contains(x)){
                    System.out.println("true");
                }else {
                    System.out.println(Collections.min(queue));
                }
            }else {
                System.out.println("0");
            }




    }
}
