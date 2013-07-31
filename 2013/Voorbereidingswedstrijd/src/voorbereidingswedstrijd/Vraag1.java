package voorbereidingswedstrijd;

import java.util.Scanner;

/**
 *
 * @author Wouter Pinnoo <Wouter.Pinnoo@UGent.be>
 */
public class Vraag1 {

    private static char[][] content;
    private static int rows;
    private static int columns;

    public static enum DIRECTION {

        EAST, WEST, SOUTH, NORTH;
    }

    public static boolean isLetter(char c) {
        return c != ' '
                && c != '|'
                && c != '-'
                && c != '+';
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int numberOfLines = Integer.parseInt(sc.nextLine());
//        rows = sc.nextInt();
//        columns = sc.nextInt();
//        String coded = sc.next();
//        content = new char[rows][];
//        sc.nextLine();
//        for (int r = 0; r < rows - 1; r++) {
//            String line = sc.nextLine();
//            content[r] = new char[columns];
//            for (int c = 0; c < columns; c++) {
//                content[r][c] = line.charAt(c);
//            }
//        }
//
//        for (int i = 0; i < coded.length(); i++) {
//            search(coded.charAt(i));
//        }
//
//    }

    public static char search(char input) {
        Location loc = searchLocation(input);
        
        if (content[loc.x - 1][loc.y] == '|'
                || (content[loc.x - 1][loc.y] == '+'
                && content[loc.x - 1][loc.y - 1] != '-'
                && content[loc.x - 1][loc.y + 1] != '-')) {
            return search(loc, DIRECTION.NORTH);
        } else if (content[loc.x + 1][loc.y] == '|'
                || (content[loc.x + 1][loc.y] == '+'
                && content[loc.x + 1][loc.y - 1] != '-'
                && content[loc.x + 1][loc.y + 1] != '-')) {
            return search(loc, DIRECTION.SOUTH);
        } else if (content[loc.x][loc.y - 1] == '-'
                || (content[loc.x][loc.y] == '+'
                && content[loc.x - 1][loc.y - 1] != '|'
                && content[loc.x + 1][loc.y - 1] != '|')) {
            return search(loc, DIRECTION.WEST);
        } else if (content[loc.x][loc.y + 1] == '-'
                || (content[loc.x][loc.y] == '+'
                && content[loc.x - 1][loc.y + 1] != '|'
                && content[loc.x + 1][loc.y + 1] != '|')) {
            return search(loc, DIRECTION.EAST);
        } else if (content[loc.x - 1][loc.y] == '+') {
            if (content[loc.x - 1][loc.y - 1] == '-') {
                return search(new Location(loc.x - 1, loc.y - 1), DIRECTION.WEST);
            } else if (content[loc.x - 1][loc.y + 1] == '-') {
                return search(new Location(loc.x - 1, loc.y + 1), DIRECTION.EAST);
            }
        } else if (content[loc.x + 1][loc.y] == '+') {
            if (content[loc.x + 1][loc.y - 1] == '-') {
                return search(new Location(loc.x + 1, loc.y - 1), DIRECTION.WEST);
            } else if (content[loc.x + 1][loc.y + 1] == '-') {
                return search(new Location(loc.x + 1, loc.y + 1), DIRECTION.EAST);
            }
        } else if (content[loc.x][loc.y - 1] == '+') {
            if (content[loc.x - 1][loc.y - 1] == '|') {
                return search(new Location(loc.x - 1, loc.y - 1), DIRECTION.NORTH);
            } else if (content[loc.x + 1][loc.y - 1] == '|') {
                return search(new Location(loc.x + 1, loc.y - 1), DIRECTION.SOUTH);
            }
        } else if (content[loc.x][loc.y + 1] == '+') {
            if (content[loc.x - 1][loc.y + 1] == '|') {
                return search(new Location(loc.x - 1, loc.y + 1), DIRECTION.NORTH);
            } else if (content[loc.x + 1][loc.y - 1] == '|') {
                return search(new Location(loc.x + 1, loc.y + 1), DIRECTION.SOUTH);
            }
        }
        return '0';
    }

    public static char search(Location loc, DIRECTION dir) {
        char output = 'a';
        if (isLetter(content[loc.x][loc.y])) {
            return content[loc.x][loc.y];
        } else if (content[loc.x - 1][loc.y] == '|'
                || (content[loc.x - 1][loc.y] == '+'
                && content[loc.x - 1][loc.y - 1] != '-'
                && content[loc.x - 1][loc.y + 1] != '-')) {
            return search(loc, DIRECTION.NORTH);
        } else if (content[loc.x + 1][loc.y] == '|'
                || (content[loc.x + 1][loc.y] == '+'
                && content[loc.x + 1][loc.y - 1] != '-'
                && content[loc.x + 1][loc.y + 1] != '-')) {
            return search(loc, DIRECTION.SOUTH);
        } else if (content[loc.x][loc.y - 1] == '-'
                || (content[loc.x][loc.y] == '+'
                && content[loc.x - 1][loc.y - 1] != '|'
                && content[loc.x + 1][loc.y - 1] != '|')) {
            return search(loc, DIRECTION.WEST);
        } else if (content[loc.x][loc.y + 1] == '-'
                || (content[loc.x][loc.y] == '+'
                && content[loc.x - 1][loc.y + 1] != '|'
                && content[loc.x + 1][loc.y + 1] != '|')) {
            return search(loc, DIRECTION.EAST);
        } else if (content[loc.x - 1][loc.y] == '+') {
            if (content[loc.x - 1][loc.y - 1] == '-') {
                return search(new Location(loc.x - 1, loc.y - 1), DIRECTION.WEST);
            } else if (content[loc.x - 1][loc.y + 1] == '-') {
                return search(new Location(loc.x - 1, loc.y + 1), DIRECTION.EAST);
            }
        } else if (content[loc.x + 1][loc.y] == '+') {
            if (content[loc.x + 1][loc.y - 1] == '-') {
                return search(new Location(loc.x + 1, loc.y - 1), DIRECTION.WEST);
            } else if (content[loc.x + 1][loc.y + 1] == '-') {
                return search(new Location(loc.x + 1, loc.y + 1), DIRECTION.EAST);
            }
        } else if (content[loc.x][loc.y - 1] == '+') {
            if (content[loc.x - 1][loc.y - 1] == '|') {
                return search(new Location(loc.x - 1, loc.y - 1), DIRECTION.NORTH);
            } else if (content[loc.x + 1][loc.y - 1] == '|') {
                return search(new Location(loc.x + 1, loc.y - 1), DIRECTION.SOUTH);
            }
        } else if (content[loc.x][loc.y + 1] == '+') {
            if (content[loc.x - 1][loc.y + 1] == '|') {
                return search(new Location(loc.x - 1, loc.y + 1), DIRECTION.NORTH);
            } else if (content[loc.x + 1][loc.y - 1] == '|') {
                return search(new Location(loc.x + 1, loc.y + 1), DIRECTION.SOUTH);
            }
        }
        return output;
    }

    public static Location searchLocation(char input) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input == content[i][j]) {
                    return new Location(i, j);
                }
            }
        }
        return null;
    }

    public static class Location {

        public int x;
        public int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
