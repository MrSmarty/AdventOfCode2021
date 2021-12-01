import java.io.*;
import java.util.*;

public class day1part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day1.txt"));
        int increased = 0;
        int prevA = scan.nextInt();
        int prevB = scan.nextInt();
        int prevC = scan.nextInt();
        int newA = scan.nextInt();

        while(scan.hasNextInt()) {
            if(prevB + prevC + newA > prevA + prevB + prevC) {
                increased++;
            }
            System.out.println((prevB + prevC + newA) + " | " + (prevA + prevB + prevC));
            prevA = prevB;
            prevB = prevC;
            prevC = newA;
            newA = scan.nextInt();
        }

        if(prevB + prevC + newA > prevA + prevB + prevC) {
            increased++;
        }
        System.out.println((prevB + prevC + newA) + " | " + (prevA + prevB + prevC));
        prevA = prevB;
        prevB = prevC;
        prevC = newA;
        //newA = scan.nextInt();

        System.out.println(increased);
    }
}