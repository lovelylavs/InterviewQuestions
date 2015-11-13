/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stacksorting;
import java.util.Stack;
/**
 *
 * @author Lavanya
 */
public class StackSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Integer> s = new Stack<Integer>();
        
        s.push(12);
        s.push(1);
        s.push(4);
        s.push(9);
        sort(s);
        
    }
    
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty())
        {
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp)
            {
                s.push(r.pop());
        }
        r.push(tmp);
        }
        return r;
    }
    
}
