
import java.util.Scanner;

/*
 * 1: 1 2: 1 3: 4 4: 7 5: 9
 */
/**
 *
 * @author stefaanvermassen
 */
public class Polynominos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int invoer = sc.nextInt();

        int aantal = 1;

        for (int i = 1; i < invoer / 2; i++) {
            int l = invoer - i;
            int uitsteken = i - 1;
            aantal += l+(2*uitsteken);
        }
        System.out.println(aantal);

    }
}
