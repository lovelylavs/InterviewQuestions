/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

import java.util.Scanner;

/**
 *
 * @author Lavanya
 */
public class Panagram {
     private static char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private static boolean isPangram(String sentence){
        for(char alphabet : alphabets){
            if(!sentence.contains(""+alphabet)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println("Entered sentence = "+sentence);
        
        if(sentence != null && isPangram(sentence.toLowerCase())){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        } 
        
        scanner.close();
    }
}
