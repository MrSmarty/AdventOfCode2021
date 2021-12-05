package day1;
import java.io.*;
import java.util.*;

public class day1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day1.txt"));
        int increased = 0;
        int previousNum = scan.nextInt();
        while(scan.hasNextInt()) {
            int num = scan.nextInt();
            if(num > previousNum) {
                increased++;
            }
            previousNum = num;
        }
        System.out.println(increased);
    }
}