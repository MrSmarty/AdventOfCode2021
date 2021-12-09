import java.util.*;
import java.io.*;

public class day9 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day9.txt"));
        int down = 100;
        int across = 100;
        int[][] map = new int[across][down];

        int score = 0;

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
                            score += map[i][j] + 1;
                        }
                    } else if (j == down-1) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    } else {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    }
                } else if (i == across-1) {
                    if (j == 0) {
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j+1]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    } else if (j == down-1) {
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    } else {
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i][j-1]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    }
                } else {
                    if (j == 0) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i-1][j]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    } else if (j == down-1) {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j-1] && map[i][j] < map[i-1][j]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
                        }
                    } else {
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1] && map[i][j] < map[i][j-1] && map[i][j] < map[i-1][j]) {
                            System.out.println("Low Point");
                            score += map[i][j] + 1;
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
        System.out.println(score);
    }
}
