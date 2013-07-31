/*
 * Team: De Fijnes: Eveline Hoogstoel, Wouter Pinnoo & Stefaan Vermassen
 */

import java.util.Scanner;

public class Main {
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iteratie = Integer.parseInt(sc.nextLine());
        for(int j=0; j<iteratie; j++){
            int aantalPersonen = Integer.parseInt(sc.nextLine());
            int size = Integer.parseInt(sc.nextLine());
            int lengteVrijePeriode = Integer.parseInt(sc.nextLine());
            char[][] dagen = new char[aantalPersonen][];
            for (int i = 0; i < aantalPersonen; i++) {
                dagen[i]=sc.nextLine().toCharArray(); 
            }
            int oplossing = search(dagen,size, aantalPersonen, lengteVrijePeriode);
            if(oplossing == 0){
                System.out.println("X");
            }
            else{
                System.out.println(oplossing);
            }
        }
    }

    public static int search(char[][] dagen, int size, int aantalPersonen, int lengteVrijePeriode) {
        boolean error = false;
        for(int i=0; i<size; i++){
            for(int j=0; j<aantalPersonen;j++){
                for(int k=0; k<lengteVrijePeriode; k++){
                    if(k+i>=size){
                        return 0;
                    }
                    if(dagen[j][i+k]!='V'){
                        error = true;
                        break;
                    }
                }
                if(error){
                    error=false;
                    break;
                }
                if(j==aantalPersonen-1){
                    return i+1;
                }
            }
        }
        return 0;
    }
}
