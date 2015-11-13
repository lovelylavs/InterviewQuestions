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
public class TwoStrings {
    public static String twoStrings(String word1, String word2){
        int count=0;
        int len1 = word1.length()-1;
        int len2 = word2.length()-1;
        String rt="NO";
        int val=0,val2=0;
        while(val<len1 && val2<len2){
            if(word1.charAt(val)==word2.charAt(val2)){
                val++;
                val2++;
                count++;
                rt="YES";
            }
            if(count==0){
                if(val>val2)
                val++;
                
            else
                val2++;
            
            }
            else{
                return "NO";
            }
        }
        
        return rt;

    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        
        for(int i=0; i< noOfTests; i++){
            String word1 = sc.next();
             String word2 = sc.next();
            System.out.println(twoStrings(word1,word2));
        }
    }
}
