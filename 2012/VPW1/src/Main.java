
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {

    private static String[] data;

    public static Map<Character,Character> map = new HashMap<Character,Character>();
    static {
        map.put('/','\\');
        map.put('\\','/');
        map.put('+','+');
        map.put('-','|');
        map.put('|','-');
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int p = sc.nextInt();
            String[][] patronen = new String[p][];
            for (int j = 0; j < p; j++) {
                patronen[j] = new String[2];
                patronen[j][0] = sc.next();
                patronen[j][1] = sc.next();
            }
            
            int b = sc.nextInt();
            
            Stack<String[]> stapel = new Stack<String[]>();
            
            for(int j = 0; j < b; j++) {
                String bevel = sc.next();
                
                if(bevel.equals("naai")) {
                    String[] lap1 = stapel.pop();
                    String[] lap2 = stapel.pop();
                    int lengte = lap1.length;
                    String[] lap = new String[lengte];
                    for(int k = 0; k < lap.length; k++) {
                        lap[k] = "";
                    }
                    for(int k = 0; k < lap.length; k++) {
                        lap[k] += lap1[k] + lap2[k];
                    }
                    stapel.push(lap);
                } 
                
                else if(bevel.equals("draai")) {
                    String[] lap = stapel.pop();
                    String[] nieuwlap = new String[lap[0].length()];
                    for(int k = 0; k < lap[0].length(); k++) {
                        String nieuw = "";
                        for(int l = 0; l < lap.length; l++) {
                            nieuw += map.get(lap[lap.length-1-l].charAt(k));
                        }
                        nieuwlap[k] = nieuw;
                    }
                    stapel.push(nieuwlap);
                }
                
                else if(bevel.equals("teken")) {
                    String[] lap = stapel.peek();
                    for(String s : lap) {
                        System.out.println(s);
                    }
                    System.out.println();
                }
                
                else if(bevel.equals("stop")) {
                    // Niets te doen
                }
                
                else {
                    stapel.push(patronen[Integer.parseInt(bevel)-1]);
                }
            }
            
        }

      
    }
}
