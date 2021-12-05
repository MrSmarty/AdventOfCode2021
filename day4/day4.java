package day4;
import java.io.*;
import java.util.*;

public class day4 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day4.txt"));
        
        String[] nums = scan.nextLine().split(",");
        int index = 0;
        boolean winner = false;

        int numBoards = 60;

        int[][] winningBoard = new int[5][5];
        int winningNumber = 0;

        int[][][] boards = new int[numBoards][5][5];
        for (int i = 0; i < numBoards; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    boards[i][j][k] = scan.nextInt();
                    //  System.out.println(boards[i][j][k]);
                }
            }
        }

        while (winner == false) {
            int num = Integer.parseInt(nums[index]);
            for (int i = 0; i < numBoards; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (boards[i][j][k] == num) {
                            boards[i][j][k] = -1;
                        }
                        if ((boards[i][0][k] == -1 && boards[i][1][k] == -1 && boards[i][2][k] == -1 && boards[i][3][k] == -1 && boards[i][4][k] == -1) || (boards[i][j][0] == -1 && boards[i][j][1] == -1 && boards[i][j][2] == -1 && boards[i][j][3] == -1 && boards[i][j][4] == -1)) {
                            winner = true;
                            System.out.println("Winner!");
                            winningBoard = boards[i];
                            winningNumber = num;
                        }
                    }
                }
            }
            System.out.println("Num: " + num);
            for (int i = 0; i < numBoards; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        System.out.print(boards[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            index++;
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (winningBoard[i][j] != -1) {
                    sum += winningBoard[i][j];
                }
            }
        }
        System.out.println(sum * winningNumber);
    }
}
