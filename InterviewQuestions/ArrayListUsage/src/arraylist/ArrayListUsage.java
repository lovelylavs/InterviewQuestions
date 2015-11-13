/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arraylist;

/**
 *
 * @author Lavanya
 */
import java.util.ArrayList;
public class ArrayListUsage 
{
    
    public ArrayList<String> merge(String[] words,String[] more)
    {
        ArrayList<String> sentence = new ArrayList<String>();
        for(String w: words) sentence.add(w);
        for(String w:more ) sentence.add(w);
        return sentence;
    }
    public static void main(String[] args)
    {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Java");
        al.add("C++");
        al.add("PHP");
        al.add("Python");
        System.out.println(al);
        System.out.println("Element at index 1"+al.get(1));
        String[] first={"love", "live","laav"};
        String[] second={"white", "red","black"};
        ArrayListUsage x = new ArrayListUsage();
        al = x.merge(first,second);
        System.out.println(al);
    }
}
