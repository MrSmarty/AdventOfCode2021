import java.io.*;
import java.util.*;

public class day8part2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("day8single.txt"));
        
        int numInputs = 1;
        
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
                    for (int j = 0; j < 3; j++) {
                        if (patterns[7].contains(patterns[4].substring(j, j + 1)) == false) {
                            lcds[0] = patterns[4].substring(j, j + 1);
                        }
                    }
                    System.out.println(lcds[0]);
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
                        if (chars[j].equals((char)(97+j)) == false) {
                            char c = (char)(97+j);
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
                        if (solutions[4].contains(solutions[9].substring(j, j+1)) == false) {
                            chars[n] = solutions[9].substring(j, j+1);
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
                    System.out.println(solutions[3]);
                }

                solved = true;
            }
        }
        // System.out.println(total);
    }
}
