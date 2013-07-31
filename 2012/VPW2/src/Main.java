
import java.util.Scanner;


/**
 * 
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {
    
   
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int last = 1;
        String rij = "1";
        int aantal = sc.nextInt();
        int[] results = new int[aantal];
        int[] data = new int[aantal];
        for(int i=0; i<aantal; i++){
            data[i]=sc.nextInt();
        }
        for(int i=0; i<aantal; i++){
            while(data[i] > rij.length()){
                rij+=(last+1);
                last++;
            }
            results[i]=rij.charAt(data[i]-1);
        }
        for(int i=0; i<results.length-1; i++){
            System.out.println(i+"");
        }
        System.out.print(results[results.length-1]+"");
    }
}
