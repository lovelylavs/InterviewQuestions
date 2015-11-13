/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Lavanya
 */
public class rearrangeChar {
    
    public static void main(String[] args)
    {
        System.out.println(rearrangeAdjacDuplicates("aaabc"));
    }
    
    public static String rearrangeAdjacDuplicates(String str)
    {
        final class CharFreq implements Comparable<CharFreq>
        {
            char c;
            int freq;
            
            //Constructor
            public CharFreq(char ch, int count)
            {
                c = ch;
                freq=count;
            }
            
            //Compare the objects
            @Override
            public int compareTo(CharFreq o)
            {
                int comp = Double.compare(freq,o.freq);
                if(comp ==0)
                {
                    comp=Character.compare(o.c,c);
                    
                }
                    
                return comp;
            }
            
        }
        
        int n = str.length();
        StringBuilder rearranged = new StringBuilder();
        
        //Priority queue
        PriorityQueue<CharFreq> maxHeap = new 
            PriorityQueue<>(256,Collections.reverseOrder());
        int[] freqHistogram = new int[256];
        
        //build the character frequency histogram
        for(char c: str.toCharArray())
        {
            freqHistogram[c]++;
            
            //If a character repeats more than n/2 times 
            if(freqHistogram[c]> (n+1)/2)
               return "Not valid input";            
        }
        
        //build the max heap of histogram
        for(char i=0; i< 256; i++)
        {
            if(freqHistogram[i] >0)
                maxHeap.add(new CharFreq(i, freqHistogram[i]));
        }
        
        while(!maxHeap.isEmpty())
        {
            //extract top one and decrease histogram by one
            CharFreq first = maxHeap.poll();
            rearranged.append(first.c);
            first.freq--;
            
            CharFreq second = null;
            
            //second top one and decrease histogram by one
            if(!maxHeap.isEmpty())
            {
                second = maxHeap.poll();
                rearranged.append(second.c);
                second.freq--;
            }
            
            //add back to updates histogram
            if(first.freq > 0)
                maxHeap.add(first);
            if(second != null && second.freq> 0)
                maxHeap.add(second);
        }
        
        return rearranged.toString();
    }
}
