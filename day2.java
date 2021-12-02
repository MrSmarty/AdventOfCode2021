import java.io.*;
import java.util.*;

public class day2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day2.txt"));
        int forward = 0;
        int up = 0;
        int down = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] data = line.split(" ");
            if (data[0].equals("up")) {
                up += Integer.parseInt(data[1]);
            } else if (data[0].equals("down")) {
                down += Integer.parseInt(data[1]);
            } else {
                forward += Integer.parseInt(data[1]);
            }
        }
        if (up > down) {
            System.out.println((up - down) * forward);
        } else {
            System.out.println((down - up) * forward);
        }
    }
}
