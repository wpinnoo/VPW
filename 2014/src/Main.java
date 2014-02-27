import java.util.Scanner;

/**
 *
 * @author Wouter Pinnoo <Wouter.Pinnoo@UGent.be>
 */
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lijsten = sc.nextInt();
        
        for(int i=0; i < lijsten; i++){
            int grootte = sc.nextInt();
            
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            for(int j=0; j < grootte; j++){
                int getal = sc.nextInt();
                if(getal < min){
                    min = getal;
                }
                if(getal > max){
                    max = getal;
                }
            }
            
            System.out.println((i+1) + " " + min + " " + max);
        }
    }
}
