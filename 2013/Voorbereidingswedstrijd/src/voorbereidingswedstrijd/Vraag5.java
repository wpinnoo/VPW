package voorbereidingswedstrijd;

import java.util.Scanner;

/**
 *
 * @author Wouter Pinnoo <Wouter.Pinnoo@UGent.be>
 */
public class Vraag5 {
    
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int numberOfLines = Integer.parseInt(sc.nextLine());
       String[] lines = new String[numberOfLines];
       for(int i=0; i < numberOfLines; i++){
           lines[i] = sc.nextLine();
       }
       
       
    }
}
