package day7;

import java.util.*;
import java.io.*;

public class day7 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day7.txt"));
        String[] input = scan.nextLine().split(",");

        int lowest = -1;

        for (int k = 0; k < 2000; k++) {
            int sum = 0;
            int cost = 0;
            for (int i = 0; i < input.length; i++) {
                sum += Integer.parseInt(input[i]);
            }
            for (int i = 0; i < input.length; i++) {
                cost += Math.abs(Integer.parseInt(input[i]) - k);
            }
            if (lowest == -1 || cost < lowest) {
                lowest = cost;
                System.out.println("New Lowest: " + lowest);
            }
            System.out.println("Cost: " + cost);
        }
        System.out.println("Lowest: " + lowest);
    }
}
// Too High : 365349
