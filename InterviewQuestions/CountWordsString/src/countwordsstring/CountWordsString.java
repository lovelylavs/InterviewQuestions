/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countwordsstring;

import java.util.StringTokenizer;

/**
 *
 * @author Lavanya
 */
public class CountWordsString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String msg = "This is something exciting!!";
        String[] x = msg.split(" ");
        System.out.println("Count: "+ x.length);
        String[] words = "Example test: one, two, three".split("[^A-Za-z]+");
        System.out.println("words count"+ words.length);
        System.out.println("Using function"+countWords(msg));
    }
    
    public static int countWords(String str) {
    char[] sentence = str.toCharArray();
    boolean inWord = false;
    int wordCt = 0;
    for (char c : sentence) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            if (!inWord) {
                wordCt++;
                inWord = true;
            }
        } else {
            inWord = false;
        }
    }
    return wordCt;
}
    
}
