
import java.util.Scanner;


/**
 * 
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {
    
    private static String[] data;
   
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        data = new String[sc.nextInt()];
        String line;
        for(int i=0; i<data.length; i++){
            line = sc.next();
            data[i]=line;
        }
    }
}
