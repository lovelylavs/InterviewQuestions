/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codaility;

/**
 *
 * @author Lavanya
 */
public class InsDel {
    
public static void main(String[] args)
{
    System.out.println(solution("nice", "niece"));
}

 public static String solution(String s1, String s2) {
     
        //If both strings are equal its SAME
        if (s1.equals(s2)) {
          return "SAME";
        }
        
        //Check for insertion
        String result = checkInsStrEqual(s1, s2);
        if (result != null) { 
            return "INSERT " + result;
        }
        //check for deletion
        result = checkDelStrEqual(s1, s2);
        if (result != null) {
            return "DELETE " + result;
        }
        //check for swap
        result = checkSwapStrEqual(s1, s2);
        if (result != null) {
            return "SWAP " + result;
        }
        return "IMPOSSIBLE";
    }

    private static String checkInsStrEqual(final String s1, final String s2) {
        if (s1.length() + 1 != s2.length()) {
            return null;
        }
        final char[] s1ChArray = s1.toCharArray();
        final char[] s2ChArray = s2.toCharArray();

        for (int s2CIndex = 0; s2CIndex < s2ChArray.length; s2CIndex++) {
            //to check if the last character
            if (s2CIndex == s2ChArray.length-1) { 
            
                final String s1ChInserted = s1 + s2ChArray[s2CIndex];
                if (s1ChInserted.equals(s2)) {
                  return String.valueOf(s2ChArray[s2CIndex]);
                } else {
                  return null;
                }
            }
            
            //Checking of character of both the elements match until a point
            if (s1ChArray[s2CIndex] != s2ChArray[s2CIndex]) {
                
                //modify the string by inserting character that did not match from second string
                final String s1ChInserted = 
                    s1.substring(0, s2CIndex) + s2ChArray[s2CIndex] + s1.substring(s2CIndex, s1ChArray.length);
                
                //If this makes it equal
                if (s1ChInserted.equals(s2)) {
                  return String.valueOf(s2ChArray[s2CIndex]);
                } else {
                  return null;
                }
            } else {
              continue;
            }
        }

        return null;
    }

  private static String checkDelStrEqual(final String s1, final String s2) {
        if (s1.length() - 1 != s2.length()) {
            return null;
        }
        final char[] s1ChArray = s1.toCharArray();
          final char[] s2ChArray = s2.toCharArray();

        for (int s2ChIndex = 0; s2ChIndex < s1ChArray.length; s2ChIndex++) {
            if (s2ChIndex == s1ChArray.length-1) { 

            //check at last char in s1
                final String s1ChDeleted = s1.substring(0, s1ChArray.length-1);
                
                
                if (s1ChDeleted.equals(s2)) {
                  return String.valueOf(s1ChArray[s2ChIndex]);
                } else {
                  return null;
                }
            }
            
            //Checking of character of both the elements match until a point
            if (s1ChArray[s2ChIndex] != s2ChArray[s2ChIndex]) {
                final String s1ChDeleted = 
                    s1.substring(0, s2ChIndex) + s1.substring(s2ChIndex+1, s1ChArray.length);
                if (s1ChDeleted.equals(s2)) {
                  return String.valueOf(s1ChArray[s2ChIndex]);
                } else {
                  return null;
                }
            } else {
              continue;
            }
        }

        return null;
    }

    private static String checkSwapStrEqual(final String s1, final String s2) {
        if (s1.length() != s2.length()) {
            return null;
        }
        final char[] s1ChArray = s1.toCharArray();
        for (int s2ChIndex = 0; s2ChIndex < s1ChArray.length - 1; s2ChIndex++) {
            swapChArray(s1ChArray, s2ChIndex, s2ChIndex + 1);
            if (s2.equals(new String(s1ChArray))) {
                return s1ChArray[s2ChIndex + 1] + " " + s1ChArray[s2ChIndex];
            }
            swapChArray(s1ChArray, s2ChIndex, s2ChIndex + 1); 
        }
        return null;
    }

     private static void swapChArray(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}