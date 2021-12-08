import java.util.*;
import java.io.*;

public class day8 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day8sample.txt"));
        
        int numInputs = 200;
        
        int count = 0;
        for (int i = 0; i < numInputs; i++) {
            String[] input = scan.nextLine().split(" |\\ | ");
            for (int j = 0; j < 4; j++) {
                if (input[11+j].length() == 2 || input[11+j].length() == 3 || input[11+j].length() == 4 || input[11+j].length() == 7) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}