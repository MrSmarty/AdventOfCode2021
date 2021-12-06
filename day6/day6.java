package day6;
import java.util.*;
import java.io.*;

public class day6 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day6.txt"));

        String[] input = scan.nextLine().split(",");
        int days = 0;

        int[] fish = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            fish[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < days; i++) {
            int newFish = 0;
            //System.out.print("Day " + (i+1) + ": ");
            for (int j = 0; j < fish.length; j++) {
                if (fish[j] == 0) {
                    newFish++;
                    fish[j] = 6;
                } else {
                    fish[j]--;
                }
                //System.out.print(fish[j]+ ", ");
            }
            int[] temp = new int[fish.length + newFish];
            temp = Arrays.copyOf(fish, fish.length + newFish);
            for (int j = 0; j < newFish; j++) {
                temp[fish.length + j] = 8;
                //System.out.print(temp[fish.length + j] + ", ");
            }
            fish = temp;
            //System.out.println();
        }
        System.out.println(fish.length);
    }
}
