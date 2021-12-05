package day2;
import java.io.*;
import java.util.*;

public class day2part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day2.txt"));
        int forward = 0;
        int depth = 0;
        int aim = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] data = line.split(" ");
            if (data[0].equals("up")) {
                aim -= Integer.parseInt(data[1]);
            } else if (data[0].equals("down")) {
                aim += Integer.parseInt(data[1]);
            } else {
                forward += Integer.parseInt(data[1]);
                depth += (Integer.parseInt(data[1]) * aim);
            }
        }
        System.out.println(forward * depth);
    }
}

