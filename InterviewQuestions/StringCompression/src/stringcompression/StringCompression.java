/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringcompression;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Lavanya
 */
public class StringCompression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringCompression strCompress = new StringCompression();
        strCompress.toCompress("aaallllbb");
    }
    
    public String toCompress(String str)
    {
        
        HashMap<Character,Integer> myMap = new HashMap<Character, Integer>();
        for(int i=0; i< str.length(); i++)
        {
            if(myMap.containsKey(str.charAt(i)))
            {
                myMap.put(str.charAt(i),myMap.get(str.charAt(i))+1 );
            }
            else
            {
                myMap.put(str.charAt(i),1 );
            }
        }
        
        Iterator<Character> keySetIterator = myMap.keySet().iterator();
        
        String strNew="";
        while(keySetIterator.hasNext())
        {
            Character key = keySetIterator.next();
            strNew = strNew+key+myMap.get(key);
        }
        System.out.println(strNew);
        return strNew;
    }
    
     
    
}
