/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

import java.util.*;
/**
 *
 * @author Lavanya
 */
public class MakeAnagram {
    public static int makeAnagram(String word){
        int[] count = new int[26];
        int length = word.length();
        int sum = 0;
        int i = 0;

        for (i = 0; i < 26; i++)
            count[i] = 0;


        if (length % 2 == 1)
            return -1;

        else
        {
            for (i = 0; i < length / 2; i++)
                count[word.charAt(i) - 'a']++;

            for (i = length / 2; i < length; i++)
                count[word.charAt(i) - 'a']--;

            for (i = 0; i < 26; i++)
            {
                sum = sum + Math.abs(count[i]);
            }

            sum = sum / 2;
        }


        return sum;

    }
    
     public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        
        for(int i=0; i< noOfTests; i++){
            String word = sc.next();
            System.out.println(makeAnagram(word));
        }
    }
}
