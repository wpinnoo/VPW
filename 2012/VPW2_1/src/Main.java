


/**
 * 
 * @author Team "Teamnaam": Stefaan Vermassen, Wouter Pinnoo en Hannes Mareen
 */
public class Main {
    public static void main(String[] args){
        String str ="1";
        int last = 1;
        while(Integer.MAX_VALUE > str.length()){
            last++;
            str+=last;
        }
        System.out.print(str);
    }
}
