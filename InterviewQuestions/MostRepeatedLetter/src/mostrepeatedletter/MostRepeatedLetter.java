/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mostrepeatedletter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lavanya
 */
public class MostRepeatedLetter {

    public static char getMaxLetter(String word)
    {
        if(word==null || word.isEmpty())
            throw new IllegalArgumentException("input word must have non empty values");
        char maxChar = ' ';
        int intMaxCount=0;
        int[] charCnt = new int[Character.MAX_VALUE+1];
        for(int i= word.length()-1; i>=0; i--){
            char ch= word.charAt(i);
            
            //increment this character cnt and compare it to max
            if(++charCnt[ch]>=intMaxCount){
                intMaxCount=charCnt[ch];
                maxChar=ch;
            }
        }
        return maxChar;
    }
    
    public static void repeatedLetterMap(String LINE){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (Character c : LINE.toCharArray()) {

            Integer count = map.get(c);
            map.put(c, count != null ? count + 1 : 0);
        }
        System.out.println(Collections.max(map.values()));
        
    }
     


  public static void repeat()
  {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    String theString = "This is a test that find the most common character";
    String unique = new String();

    for (int i = 0; i < theString.length(); i++) {
      if ( map.containsKey(theString.charAt(i))) {
        map.put (theString.charAt(i), map.get(theString.charAt(i)) + 1 );
      } else {
        map.put (theString.charAt(i), 1);
        unique += theString.charAt (i);
      }
    }
    for(Map.Entry item:map.entrySet())
        System.out.println(item.getKey() + ": " + item.getValue());
  }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(getMaxLetter("asj kklllll nnmmsddd"));
        repeatedLetterMap("asj kklllll nnmmsddd");
        repeat();
    }
    
}
