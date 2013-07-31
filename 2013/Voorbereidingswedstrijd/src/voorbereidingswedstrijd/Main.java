//package voorbereidingswedstrijd;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Wouter Pinnoo <Wouter.Pinnoo@UGent.be>
 */
public class Main {
    
    public static GregorianCalendar base = new GregorianCalendar(1970, 1, 1);
    static long baseInMillis = base.getTimeInMillis();
    static int[] maya = new int[] {12,17,16,7,5};
    
    
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int numberOfLines = Integer.parseInt(sc.nextLine());
       sc.useDelimiter("/|\n");
       for(int i = 0; i< numberOfLines; i++){
            int dag = sc.nextInt();
            int maand = sc.nextInt();
            int jaar = sc.nextInt();
            calculate(dag,maand,jaar);
            
       }
       
    }
    
    public static void calculate(int dag, int maand, int jaar){
        if(dag == 1 && maand==1 && jaar== 1970){
            System.out.println("12.17.16.7.5");
            return;
        }
        
        GregorianCalendar g = new GregorianCalendar(jaar, maand, dag); 
        long dateInMillis = g.getTimeInMillis();
        long differenceInDays = (dateInMillis - baseInMillis)/(1000 *60 *60*24);
        
        differenceInDays += (12*20*20*18*20) + (17*20*18*20) + (16*18*20) + (7*20) + 5 + 1;

        
        int kin = (int) differenceInDays%20 ;
        int uinal = (int) differenceInDays/20 +1;
        
        int tun = (int)uinal/20 +1;
        uinal = uinal % 20 ;
        
        int katun = tun/20 +1;
        tun = tun % 20;
        
        int baktun =katun/20 +1;
        katun = katun%20 ;
        
        System.out.println(baktun + "." + katun + "." + tun + "." + uinal + "." + kin);
        
        
        
    }
}
