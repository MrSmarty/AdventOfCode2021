package day3;
import java.io.*;
import java.util.*;

public class day3part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day3.txt"));

        // String oxygen = "";
        // String co2 = "";

        String[] oxygenNums = new String[1000];
        String[] co2Nums = new String[1000];

        for (int i = 0; i < 1000; i++) {
            String temp = scan.nextLine();
            oxygenNums[i] = temp;
            co2Nums[i] = temp;
        }

        for (int i = 0; i < 12; i++) {
            if (oxygenNums.length == 1) {
                break;
            }
            int numOnes = 0;
            int numZeros = 0;
            for (int k = 0; k < oxygenNums.length; k++) {
                if (oxygenNums[k].charAt(i) == '1') {
                    numOnes++;
                } else {
                    numZeros++;
                }
            }
            if (numOnes >= numZeros) {
                String tempArr[] = new String[numOnes];
                int index = 0;
                for (int k = 0; k < oxygenNums.length; k++) {
                    if (oxygenNums[k].charAt(i) == '1') {
                        tempArr[index] = oxygenNums[k];
                        index++;
                    }
                }
                oxygenNums = new String[numOnes];
                oxygenNums = tempArr;
            } else {
                String tempArr[] = new String[numZeros];
                int index = 0;
                for (int k = 0; k < oxygenNums.length; k++) {
                    if (oxygenNums[k].charAt(i) == '0') {
                        tempArr[index] = oxygenNums[k];
                        index++;
                    }
                }
                oxygenNums = new String[numZeros];
                oxygenNums = tempArr;
            }
        }
        System.out.println(oxygenNums.length);

        for (int i = 0; i < 12; i++) {
            if (co2Nums.length == 1) {
                break;
            }
            int numOnes = 0;
            int numZeros = 0;
            for (int k = 0; k < co2Nums.length; k++) {
                if (co2Nums[k].charAt(i) == '1') {
                    numOnes++;
                } else {
                    numZeros++;
                }
            }
            if (numOnes >= numZeros) {
                String tempArr[] = new String[numZeros];
                int index = 0;
                for (int k = 0; k < co2Nums.length; k++) {
                    if (co2Nums[k].charAt(i) == '0') {
                        tempArr[index] = co2Nums[k];
                        index++;
                    }
                }
                co2Nums = new String[numOnes];
                co2Nums = tempArr;
            } else {
                String tempArr[] = new String[numOnes];
                int index = 0;
                for (int k = 0; k < co2Nums.length; k++) {
                    if (co2Nums[k].charAt(i) == '1') {
                        tempArr[index] = co2Nums[k];
                        index++;
                    }
                }
                co2Nums = new String[numZeros];
                co2Nums = tempArr;
            }
        }
        System.out.println(co2Nums.length);
        System.out.println(Integer.parseInt(oxygenNums[0], 2) * Integer.parseInt(co2Nums[0], 2));
    }
}
