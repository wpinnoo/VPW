
import java.util.Arrays;
import java.util.Scanner;


/**
 * 
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {
    
    private static int[] data;
   
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int aantal = sc.nextInt();
        int grootste = sc.nextInt();
        int kleinste = grootste;
        for(int i=0; i<aantal-1; i++){
            int getal = sc.nextInt();
            if(getal > grootste){
                grootste = getal;
            } else if(getal < kleinste){
                kleinste = getal;
            }
        }
        System.out.println(kleinste+" "+grootste);
    }
}
