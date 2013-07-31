
import java.util.Scanner;


/**
 * 
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {
    
   
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int o = 0; o < t; o++) {
            int invoer = sc.nextInt();
            int i = 0;
            int j = 0;
            while(i < invoer) {
                i+= 9*Math.pow(10,j)*(j+1);
                j++;
            }
            j-=1;
            i-=9*Math.pow(10,j)*(j+1);
            int k = invoer-i;
            String uitvoer = Integer.toString((int)Math.pow(10,j)+k/(j+1)-1);
            System.out.println(uitvoer.charAt(k%(k%(j+1))-1));
            //for(int l = (int)Math.pow(10, j); l < (int) (Math.pow(10,j) + k/(j+1)+1);l++) {
            //    s+=Integer.toString(l);
            //}
            //System.out.println(s.charAt(k-1));
        }
    }
}
