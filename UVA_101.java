//https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=37
import java.util.*;

public class Main{
    
    private static void returnAbove(ArrayList[] _stacks, ArrayList<Integer> _stack, int _a){
        
        int index = _stack.indexOf(_a);
        //move
        for(int i = index+1; i < _stack.size(); i++){
            int v = _stack.get(i);
            _stacks[v].add(v);
        }
        //remove
        _stack.subList(index, _stack.size()).clear();
        
    }
    
    private static void moveBlocks(ArrayList<Integer> _stack_a, ArrayList<Integer> _stack_b, int _a){
        int index = _stack_a.indexOf(_a);
        //move
        for(int i = index; i < _stack_a.size(); i++) _stack_b.add(_stack_a.get(i));
        //remove
        _stack_a.subList(index, _stack_a.size()).clear();
    }

     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        
        ArrayList[] stacks = new ArrayList[count];
        
        for(int i = 0; i < count; i++){
            ArrayList<Integer> stack = new ArrayList<Integer>();
            stack.add(i);
            stacks[i] = stack;
        }
        
        while(in.hasNextLine()){
            String next = in.nextLine();
            
            if(next.equals("quit")) break;
            String [] split = next.split(" ");
            
            int a = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[3]);
            ArrayList<Integer> a_stack = new ArrayList<Integer>(); 
            ArrayList<Integer> b_stack = new ArrayList<Integer>();
            
            for(ArrayList<Integer> stack: stacks){
                if(stack.indexOf(a) != -1) a_stack = stack;
                if(stack.indexOf(b) != -1) b_stack = stack;
            }
            
            if(a == b || a_stack.equals(b_stack)){
                //ignored
            }else if(split[0].equals("move")){
                if(split[2].equals("onto")){
                    returnAbove(stacks, a_stack, a);
                    returnAbove(stacks, b_stack, b);
                    b_stack.add(b);
                    b_stack.add(a);
                }else{//over
                    returnAbove(stacks, a_stack, a);
                    b_stack.add(a);
                }
            }else{//pile
                if(split[2].equals("onto")){
                    returnAbove(stacks, b_stack, b);
                    b_stack.add(b);
                    moveBlocks(a_stack, b_stack, a);
                }else{//over
                    moveBlocks(a_stack, b_stack, a);
                }
            }
        }
        
        for(int i = 0; i < stacks.length; i++){
            ArrayList<Integer> stack = stacks[i];
            
            System.out.print(i + ":");
            for(Integer j : stack){
                System.out.print(" " + j);
            }
            System.out.println();
        }
     }
}