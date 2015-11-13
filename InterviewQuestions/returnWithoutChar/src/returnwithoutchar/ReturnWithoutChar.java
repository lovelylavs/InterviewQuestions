/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package returnwithoutchar;

/**
 *
 * @author Lavanya
 */
public class ReturnWithoutChar {

    /**
     * @param args the command line arguments
     */
    public static String leaveCharInString(String str,String sub)
    {
        int strSubLen = sub.length();
        int strLen = str.length();
        int jValue=0;
      
        StringBuilder builder = new StringBuilder();
        if(strSubLen>=1)
        {
        for(int iCtr =0; iCtr<strLen; iCtr++)
        {
            if(str.charAt(iCtr)==sub.charAt(jValue))
            {                
                             
            }
            else
            {
                builder.append(str.charAt(iCtr));
                
            }
        }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(leaveCharInString("lavanya", "a"));
    }
    
}
