import java.io.*;
import java.util.*;

public class day8part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day8sample.txt"));

        int numInputs = 10;

        int total = 0;
        for (int i = 0; i < numInputs; i++) {
            String[] patterns = new String[10];
            String[] outputs = new String[4];
            boolean solved = false;

            String[] solutions = new String[10];
            String[] lcds = new String[7];
            for (int j = 0; j < 10; j++) {
                patterns[j] = scan.next();
                if (patterns[j].length() == 2) {
                    solutions[1] = patterns[j];
                } else if (patterns[j].length() == 4) {
                    solutions[4] = patterns[j];
                } else if (patterns[j].length() == 3) {
                    solutions[7] = patterns[j];
                } else if (patterns[j].length() == 7) {
                    solutions[8] = patterns[j];
                }
            }
            scan.next();
            for (int j = 0; j < 4; j++) {
                outputs[j] = scan.next();
            }

            // Piece together the things
            while (solved == false) {

                // Solve for LCD 0
                if (lcds[0] == null) {
                    char[] seven = solutions[7].toCharArray();
                    for (int g = 0; g < 3; g++) {
                        if (solutions[1].indexOf(seven[g] + "") == -1) {
                            lcds[0] = seven[g] + "";
                        }
                    }
                    // System.out.println(lcds[0]);
                }

                // Solve for 9
                if (solutions[9] == null) {
                    String nine = solutions[4];
                    for (int j = 0; j < 3; j++) {
                        if (solutions[4].contains(solutions[7].substring(j, j + 1)) == false) {
                            nine += solutions[7].substring(j, j + 1);
                        }
                    }

                    for (int j = 0; j < 10; j++) {
                        if (patterns[j].length() == 6) {
                            int digits = 0;
                            for (int k = 0; k < 5; k++) {
                                if (patterns[j].contains(nine.substring(k, k + 1))) {
                                    digits++;
                                }
                            }
                            if (digits == 5) {
                                solutions[9] = patterns[j];
                            }
                        }
                    }
                }

                // Solve for 0
                if (solutions[0] == null) {
                    for (int j = 0; j < 10; j++) {
                        if (patterns[j].length() == 6) {
                            int digits = 0;
                            for (int k = 0; k < 3; k++) {
                                if (patterns[j].contains(solutions[7].substring(k, k + 1))) {
                                    digits++;
                                }
                            }
                            if (digits == 3) {
                                solutions[0] = patterns[j];
                            }
                        }
                    }
                    // System.out.println(solutions[0]);
                }

                // Solve for LCD 3
                if (lcds[3] == null) {
                    String[] chars = solutions[0].split("");
                    Arrays.sort(chars);
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j].equals((char) (97 + j)) == false) {
                            char c = (char) (97 + j);
                            lcds[3] = c + "";
                            // System.out.println("char: " + ((char)(97+j)) + " | chars: " + chars[j]);
                        }
                    }
                    // System.out.println(lcds[3]);
                }

                // Solve for LCD 6
                if (lcds[6] == null) {
                    String[] chars = new String[2];
                    int n = 0;
                    for (int j = 0; j < 6; j++) {
                        if (solutions[4].contains(solutions[9].substring(j, j + 1)) == false) {
                            chars[n] = solutions[9].substring(j, j + 1);
                            n++;
                        }
                    }
                    if (chars[0] == lcds[0]) {
                        lcds[6] = chars[1];
                    } else {
                        lcds[6] = chars[0];
                    }
                    // System.out.println(lcds[6]);
                }

                // Solve for 3
                if (solutions[3] == null) {
                    solutions[3] = solutions[1] + lcds[0] + lcds[3] + lcds[6];
                    // System.out.println(solutions[3]);
                }

                // Solve for 6
                if (solutions[6] == null) {
                    int[] index6 = new int[3];
                    int n = 0;
                    for (int k = 0; k < 10; k++) {
                        if (patterns[k].length() == 6) {
                            index6[n] = k;
                            n++;
                        }
                    }

                    for (int l = 0; l < 3; l++) {
                        char[] arr = patterns[index6[l]].toCharArray();
                        if (Arrays.equals(arr, solutions[0].toCharArray()) == false
                                && Arrays.equals(arr, solutions[9].toCharArray()) == false) {
                            solutions[6] = patterns[index6[l]];
                        }
                    }

                    // System.out.println(solutions[6]);
                }

                // Solve for 2 and 5
                if (solutions[2] == null && solutions[5] == null) {
                    char[] six = solutions[6].toCharArray();
                    int arr1Index = 0;
                    int arr2Index = 0;
                    int n = 0;
                    for (int g = 0; g < 10; g++) {
                        if (patterns[g].length() == 5) {
                            char[] temp1 = solutions[3].toCharArray();
                            char[] temp2 = patterns[g].toCharArray();
                            Arrays.sort(temp1);
                            Arrays.sort(temp2);
                            if (Arrays.equals(temp1, temp2)) {
                            } else if (n == 0) {
                                arr1Index = g;
                                n++;
                            } else {
                                arr2Index = g;
                                // System.out.println(arr2Index);
                            }
                        }
                    }
                    char[] arr1 = patterns[arr1Index].toCharArray();
                    char[] arr2 = patterns[arr2Index].toCharArray();
                    Arrays.sort(arr1);
                    Arrays.sort(arr2);
                    Arrays.sort(six);
                    int common = 0;
                    for (int t = 0; t < arr1.length; t++) {
                        if (Arrays.asList(six).contains(arr1[t])) {
                            common++;
                        }
                    }
                    if (common == 5) {
                        solutions[2] = patterns[arr1Index];
                        solutions[5] = patterns[arr2Index];
                    } else {
                        solutions[5] = patterns[arr1Index];
                        solutions[2] = patterns[arr2Index];
                    }
                }

                for (int h = 0; h < solutions.length; h++) {
                    System.out.println(h + ": " + solutions[h]);
                }

                solved = true;
            }
            String num = "";
            for (int t = 0; t < 4; t++) {
                for (int y = 0; y < 10; y++) {
                    char[] temp1 = outputs[t].toCharArray();
                    char[] temp2 = solutions[y].toCharArray();
                    Arrays.sort(temp1);
                    Arrays.sort(temp2);
                    if (Arrays.equals(temp1, temp2)) {
                        num += y;
                    }
                }
            }
            System.out.println(num);
            total += Integer.parseInt(num);
        }
        System.out.println(total);
    }
}
