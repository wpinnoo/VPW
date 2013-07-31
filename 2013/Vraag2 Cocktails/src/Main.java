/*
 * Team: De Fijnes: Eveline Hoogstoel, Wouter Pinnoo & Stefaan Vermassen
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Integer, ArrayList<Character>> kunnen = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantal = Integer.parseInt(sc.nextLine());
        for (int z = 0; z < aantal; z++) {
            int aantalBarmannen = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < aantalBarmannen; i++) {
                String input = sc.nextLine();
                ArrayList<Character> temp = new ArrayList<>();
                for (int j = 0; j < input.length(); j++) {
                    temp.add(input.charAt(j));
                }
                kunnen.put(i, temp);
            }
            int aantalCocktails = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < aantalCocktails; i++) {
                String cocktails = sc.nextLine();
                HashMap<Character, Integer> nodig = new HashMap<>();
                for (int j = 0; j < cocktails.length(); j++) {
                    if (nodig.containsKey(cocktails.charAt(j))) {
                        nodig.put(cocktails.charAt(j), nodig.get(cocktails.charAt(j)) + 1);
                    } else {
                        nodig.put(cocktails.charAt(j), 1);
                    }

                }
                if (backTracking(0, nodig, aantalBarmannen)) {
                    System.out.println(cocktails + " mogelijk");
                } else {
                    System.out.println(cocktails + " onmogelijk");
                }


            }


        }
    }

    public static boolean backTracking(int barman, HashMap<Character, Integer> nodig, int aantalBarmannen) {
        if (barman >= aantalBarmannen) {
            return false;

        }
        for (int i = 0; i < kunnen.get(barman).size(); i++) {
            if (nodig.containsKey(kunnen.get(barman).get(i)) && nodig.get(kunnen.get(barman).get(i)) != 0) {
                nodig.put(kunnen.get(barman).get(i), nodig.get(kunnen.get(barman).get(i)) - 1);
                if (backTracking(barman + 1, nodig, aantalBarmannen)) {
                    return true;
                } else {
                    nodig.put(kunnen.get(barman).get(i), nodig.get(kunnen.get(barman).get(i)) + 1);
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
}
