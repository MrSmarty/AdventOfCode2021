import java.util.*;
import java.io.*;

public class day9part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day9sample.txt"));
        int down = 5;
        int across = 10;
        int[][] map = new int[across][down];

        ArrayList<Integer> sizes = new ArrayList<Integer>();

        for (int i = 0; i < down; i++) {
            String line = scan.nextLine();
            String[] nums = line.split("");
            for (int j = 0; j < across; j++) {
                map[j][i] = Integer.parseInt(nums[j]);
            }
        }

        for (int i = 0; i < across; i++) {
            for (int j = 0; j < down; j++) {
                if (i == 0) {
                    if (j == 0) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1]) {
                            System.out.println("Low Point");
                        }
                    } else if (j == down-1) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                        }
                    } else {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                        }
                    }
                } else if (i == across-1) {
                    if (j == 0) {
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j+1]) {
                            System.out.println("Low Point");
                        }
                    } else if (j == down-1) {
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                        }
                    } else {
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                        }
                    }
                } else {
                    if (j == 0) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i-1][j]) {
                            System.out.println("Low Point");
                        }
                    } else if (j == down-1) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j-1] && map[i][j] < map[i-1][j]) {
                            System.out.println("Low Point");
                        }
                    } else {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i][j-1] && map[i][j] < map[i-1][j]) {
                            System.out.println("Low Point");
                        }
                    }
                }
            }
        }

        for (int i = 0; i < down; i++) {
            for (int j = 0; j < across; j++) {
                // System.out.print(map[j][i] + " (" + i + "," + j + ") ");
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
