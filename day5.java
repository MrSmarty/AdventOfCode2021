import java.util.*;
import java.io.*;

public class day5 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day5.txt"));

        int size = 1000;
        int[][] grid = new int[size][size];

        int numInputs = 500;


        for (int i = 0; i < numInputs; i++) {
            String[] nums = scan.nextLine().split(",| -> ");
            int[] coord1 = { Integer.parseInt(nums[0]), Integer.parseInt(nums[1]) };
            int[] coord2 = { Integer.parseInt(nums[2]), Integer.parseInt(nums[3]) };

            if (coord1[0] == coord2[0]) {
                int start = Math.min(coord1[1], coord2[1]);
                int end = Math.max(coord1[1], coord2[1]);
                int current = start;

                while (current <= end) {
                    grid[coord1[0]][current] += 1;
                    current++;
                }
            } else if (coord1[1] == coord2[1]) {
                int start = Math.min(coord1[0], coord2[0]);
                int end = Math.max(coord1[0], coord2[0]);
                int current = start;

                while (current <= end) {
                    grid[current][coord1[1]] += 1;
                    current++;
                }
            } else {
                if ((coord1[0] < coord2[0] && coord1[1] < coord2[1]) || (coord1[0] > coord2[0] && coord1[1] > coord2[1])) {
                    int startX = Math.min(coord1[0], coord2[0]);
                    int startY = Math.min(coord1[1], coord2[1]);
                    int endX = Math.max(coord1[0], coord2[0]);
                    int endY = Math.max(coord1[1], coord2[1]);
                    int currentX = startX;
                    int currentY = startY;

                    while (currentX <= endX && currentY <= endY) {
                        grid[currentX][currentY] += 1;
                        currentX++;
                        currentY++;
                    }
                } else if (coord1[0] > coord2[0] && coord1[1] > coord2[1]) {
                    // int startX = Math.min(coord1[0], coord2[0]);
                    // int startY = Math.min(coord1[1], coord2[1]);
                    // int endX = Math.max(coord1[0], coord2[0]);
                    // int endY = Math.max(coord1[1], coord2[1]);
                    // int currentX = startX;
                    // int currentY = startY;

                    // while (currentX <= endX && currentY <= endY) {
                    //     grid[currentX][currentY] += 1;
                    //     currentX++;
                    //     currentY++;
                    // }
                } else if (coord1[0] < coord2[0] && coord1[1] > coord2[1]) {
                    int startX = Math.max(coord1[0], coord2[0]);
                    int startY = Math.min(coord1[1], coord2[1]);
                    int endX = Math.min(coord1[0], coord2[0]);
                    int endY = Math.max(coord1[1], coord2[1]);
                    int currentX = startX;
                    int currentY = startY;

                    while (currentX >= endX && currentY <= endY) {
                        grid[currentX][currentY] += 1;
                        currentX--;
                        currentY++;
                    }
                } else {
                    int startX = Math.min(coord1[0], coord2[0]);
                    int startY = Math.max(coord1[1], coord2[1]);
                    int endX = Math.max(coord1[0], coord2[0]);
                    int endY = Math.min(coord1[1], coord2[1]);
                    int currentX = startX;
                    int currentY = startY;

                    while (currentX <= endX && currentY >= endY) {
                        grid[currentX][currentY] += 1;
                        currentX++;
                        currentY--;
                    }
                }
            }

        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //System.out.print(grid[j][i] + " ");
                if (grid[j][i] >= 2) {
                    count++;
                }
            }
            //System.out.println();
        }
        System.out.println(count);

    }
}
