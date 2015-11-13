/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringwordreverse;

/**
 *
 * @author Lavanya
 */
public class StringWordReverse 
{

    /**
     * @param args the command line arguments
     */
    public String strReverse(String str)
        {
            char charArray[] = str.toCharArray();
            for(int i=0;i<str.length();i++)
            {
                if(charArray[i]==' ')
                {
                    return strReverse(str.substring(i+1))+ str.substring(0,i)+" ";
                }
        
        
            }
            return str + " ";
        }
    
    public static void main(String[] args) 
    {
        StringWordReverse sword = new StringWordReverse();
        String b = sword.strReverse("This is a stupid world");
        System.out.println(b);
    }
        
}
