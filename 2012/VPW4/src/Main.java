
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {

    private static final HashMap<Character, Character> klgr = new HashMap<>();
    private static final HashMap<Character, Character> grkl = new HashMap<>();
    private static final char[] alfkl;
    private static final char[] alfgr;
    private static long begin;
    private static String[] words;
    private static String[] parts;
    private static String[] partsOrigineel;
    private static String tempComb = "";
    private static ArrayList<String> combination = new ArrayList<>();
    private static int combinationscounter;
    private static int aantalwoorden;
    private static int aantalparts;
    private static boolean state;

    static {
        alfkl = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        alfgr = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        for (int i = 0; i < alfkl.length; i++) {
            klgr.put(alfkl[i], alfgr[i]);
            klgr.put(alfgr[i], alfgr[i]);
        }
        for (int i = 0; i < alfgr.length; i++) {
            grkl.put(alfgr[i], alfkl[i]);
            grkl.put(alfkl[i], alfkl[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalopgaves = sc.nextInt();
        for (int i = 0; i < aantalopgaves; i++) {
            aantalwoorden = sc.nextInt();
            words = new String[aantalwoorden];
            for (int j = 0; j < aantalwoorden; j++) {
                words[j] = sc.next();
            }
            aantalparts = sc.nextInt();
            parts = new String[aantalparts];
            partsOrigineel = new String[aantalparts];
            for (int j = 0; j < aantalparts; j++) {
                parts[j] = sc.next();
                partsOrigineel[j] = parts[j];
            }
            for (String word : words) {
                checkComb(word);
                state = true;
            }
            aantalwoorden = 0;
            aantalparts = 0;
            combinationscounter = 0;
        }

    }

    private static void checkComb(String word) {
        for (int i = 0; i < parts.length; i++) {
            String temp = "";
            for (char c : parts[i].toCharArray()) {
                temp += grkl.get(c);
            }
            parts[i] = temp;
        }
        begin = System.currentTimeMillis();
        if (!backtracking(0, word)) {
            System.out.println("nee");
        } else {
            String result = "";
            for (String str : combination) {
                int index = -1;
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals(str)) {
                        index = i;
                    }
                }
                if (index != -1) {
                    if (combination.indexOf(str) != (combination.size() - 1)) {
                        result += (partsOrigineel[index] + "-");
                    } else {
                        result += (partsOrigineel[index]);
                    }
                }
            }
            if (result.charAt(result.length() - 1) == '-') {
                System.out.println(result.substring(0, result.length() - 1));
            } else {
                System.out.println(result);
            }
        }
        combination.clear();
        tempComb = "";
    }

    private static boolean backtracking(int n, String word) {
        if (tempComb.equals(word)) {
            return true;
        }
        if (tempComb.length() >= word.length()) {
            return false;
        }
        if (combinationscounter >= Math.pow(parts.length, word.length())) {
            return false;
        }
        if (System.currentTimeMillis() - begin > 2500) {
            state = false;
        }
        if (state) {
            for (int k = 0; k < parts.length; k++) {
                combinationscounter++;
                combination.add(parts[k]);
                tempComb = "";
                for (int i = 0; i < combination.size(); i++) {
                    tempComb += combination.get(i);
                }
                if (backtracking(n + 1, word)) {
                    return true;
                }
                combination.remove(parts[k]);
            }
        }
        return false;
    }
}
