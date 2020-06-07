//https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=36
import java.util.Scanner;

public class Main{

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            String next = in.nextLine();
            String [] split = next.split(" ");
            
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int min = a > b ? b : a;
            int max = a > b ? a : b;
            
            int max_cycle_length = 0;
            for(int i = min; i <= max; i++){
                int cycle_length = calcCycleLength(i);
                if(cycle_length > max_cycle_length) max_cycle_length = cycle_length;
            }
            System.out.println(a + " " + b + " " + max_cycle_length);
        }
    }
    
    private static int calcCycleLength(int n){
        int count = 1;
        while (n != 1){
            if(n%2 == 1) n = 3*n + 1;    
            else n = n/2;
            count++;
        }
        return count;
    }
}
