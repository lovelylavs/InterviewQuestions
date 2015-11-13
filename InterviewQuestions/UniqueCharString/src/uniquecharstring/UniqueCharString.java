/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uniquecharstring;

/**
 *
 * @author Lavanya
 */
public class UniqueCharString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UniqueCharString uniq = new UniqueCharString();
        System.out.println(uniq.isStrCharUnique("lavanya"));
    }
    
    //ASCII code has 128 specified characters
    public boolean isStrCharUnique(String str)
    {
        if(str.length()> 256)
            return false;
        boolean[] charSet = new boolean[256];
        for(int i=0; i< str.length();i++) //complexity is o(n)
        {
            int val = str.charAt(i);
            if(charSet[val]) //this implies already value is present
                return false;
            charSet[val]=true;
        }
        return true;
    }
    
    //if we assume that the characters are all in lower case
    public boolean isUniqueChars(String str)
    {
        int checker=0;
         for(int i=0; i< str.length();i++) //complexity is o(n)
        {
            int val = str.charAt(i)-'a';
            if((checker & ( 1<<val)) > 0)
               return false;
            checker |= (1 << val);
        }
        return true;
    }
    
}
