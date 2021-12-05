import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class day4part2external {
    List<String> boards = new LinkedList<>();
    String[] calls;
    Pattern rowBingo = Pattern.compile("(00\\s*){5}\\n");
    Pattern colBingo = Pattern.compile("(\\b00(\\s+\\d+){4}\\s+){4}00");

    public static void main(String[] args) throws Exception {
        System.out.println(new day4part2external().part1());
        System.out.println(new day4part2external().part2());
    }

    day4part2external() throws Exception {
        try (Stream<String> lines = Files.lines(Path.of(day4part2external.class.getResource("day4.txt").toURI()))) {
            Iterator<String> it = lines.iterator();
            calls = it.next().split(",");
            while (it.hasNext()) {
                it.next();
                boards.add(it.next() + "\n" + it.next() + "\n" + it.next() + "\n" + it.next() + "\n" + it.next() + "\n");
            }
        }
    }

    int part1() {
        for (String call : calls) {
            for (ListIterator<String> iterator = boards.listIterator(); iterator.hasNext(); ) {
                String board = iterator.next();
                String newBoard = board.replaceFirst("\\b" + call + "\\b", "00");
                iterator.set(newBoard);
                if (colBingo.matcher(newBoard).find() || rowBingo.matcher(newBoard).find()) {
                    return score(call, newBoard);
                }
            }
        }
        throw new RuntimeException();
    }

    int part2() {
        for (String call : calls) {
            for (ListIterator<String> iterator = boards.listIterator(); iterator.hasNext(); ) {
                String board = iterator.next();
                String newBoard = board.replaceFirst("\\b" + call + "\\b", "00");
                iterator.set(newBoard);
                if (colBingo.matcher(newBoard).find() || rowBingo.matcher(newBoard).find()) {
                    iterator.remove();
                    if (boards.isEmpty()) {
                        return score(call, newBoard);
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    int score(String call, String newBoard) {
        return Integer.parseInt(call) * Arrays.stream(newBoard.trim().split("\\s+")).mapToInt(Integer::parseInt).sum();
    }
}