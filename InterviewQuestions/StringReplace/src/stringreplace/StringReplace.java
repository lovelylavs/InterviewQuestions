/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringreplace;

/**
 *
 * @author Lavanya
 */
public class StringReplace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringReplace strRep = new StringReplace();
        System.out.println(strRep.replaceString("This is so lovely"));
    }
    
    public String replaceString(String str)
    {
        String n = "";
        for(int i=0; i <str.length(); i++)
        {
            if(str.charAt(i)==' ')
            {
                n=n+"%20";
            }
            else
                n= n+str.charAt(i);
        }
        
       
        return n;
    }
    
}
