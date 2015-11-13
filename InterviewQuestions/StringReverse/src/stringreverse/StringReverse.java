/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringreverse;

/**
 *
 * @author Lavanya
 */
public class StringReverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(strReverse("lavanya"));
    }
    
    public static String strReverse(String src)
    {
        int i, len = src.length();
        
        StringBuilder dest = new StringBuilder(len);
        
        for(i=(len-1) ; i>=0; i--)
        {
            dest.append(src.charAt(i));
        }
        
        return dest.toString();
        
    }
}
