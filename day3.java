import java.io.*;
import java.util.*;

public class day3 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day3.txt"));

        int[] onesAppear = new int[12];
        String gamma = "";
        String epsilon = "";
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] bits = line.split("");
            for (int i = 0; i < bits.length; i++) {
                if (bits[i].equals("1")) {
                    onesAppear[i]++;
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            if (onesAppear[i] > 500) {
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }
        System.out.println(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }
}
