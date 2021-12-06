package day6;
import java.util.*;
import java.io.*;

public class day6part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day6.txt"));

        String[] input = scan.nextLine().split(",");
        int days = 100;

        long[] population = new long[9];

        long temp;

        for(int i = 0; i < input.length; i++) {  
            population[Integer.valueOf(input[i])]++;
        }

        for(int i = 0; i < days; i++){
            temp = population[0];
            population[0] = population[1];
            population[1] = population[2];
            population[2] = population[3];
            population[3] = population[4];
            population[4] = population[5];
            population[5] = population[6];
            population[6] = temp + population[7];
            population[7] = population[8];
            population[8] = temp;
        }

        System.out.println(population[0]+population[1]+population[2]+population[3]+population[4]+population[5]+population[6]+population[7]+population[8]);
    }
}
// 172
// 179