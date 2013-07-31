/*
 * Team: De Fijnes: Eveline Hoogstoel, Wouter Pinnoo & Stefaan Vermassen
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());



        for (int i = 0; i < t; i++) {
            ArrayList<Punt> punten = new ArrayList<Punt>();
            
            int aantalPunten = Integer.parseInt(sc.nextLine());

            for (int k = 0; k < aantalPunten; k++) {
                String line = sc.nextLine();

                punten.add(new Punt(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1])));
            }
            int min = Integer.MAX_VALUE;

            for (int k = 0; k < punten.size(); k++) {

                if (punten.get(k).een > min) {
                    continue;
                }

                for (int j = 0; j < punten.size(); j++) {
                    if (j == k) {
                        continue;
                    }

                    int tmptotal = Math.max(punten.get(j).een, punten.get(k).een) + Math.max(punten.get(j).twee, punten.get(k).twee);

                    if (tmptotal < min) {
                        min = tmptotal;
                    }
                }
            }
            System.out.println(min);
        }
    }

    public static class Punt {

        public int een;
        public int twee;

        public Punt(int een, int twee) {
            this.een = een;
            this.twee = twee;
        }
    }
}
