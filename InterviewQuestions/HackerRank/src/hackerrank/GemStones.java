/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

/**
 *
 * @author Lavanya
 */
import java.util.*;

public class GemStones {
    private static List<String> rocks = new ArrayList<String>();
    private static Set<String> elements = new HashSet<String>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);                
        int noOfRocks = sc.nextInt();
        
        //Populate all the rocks which are strings
        for(int i=0; i < noOfRocks; i++) {
            if(sc.hasNext()){
                populateRocks(sc.next());
            }
        }        
        //Populate Elements
        populateElements(rocks);
        //get gem-element count
        int gemCount = getGemCount(noOfRocks);
        System.out.println(gemCount);
        sc.close();
    }
    
    private static void populateRocks(String rock){
        rocks.add(rock);
    }
    
    private static void populateElements(List<String> rocks){
        for(String rock : rocks){
            for(int i=0;i<rock.length();i++){
                elements.add(""+rock.charAt(i));
            }
        }
    }
    
    private static int getGemCount(int noOfRocks){
        int gemCount = 0;
        Map<String, Integer> map = new HashMap<>();
        
        //First loop should be of unique elements (alphabets) is imp 
        //else we get stuck in rock loop we use our hash set as first loop
        //as a rock can have multiple times same element
        for(String element : elements){ 
            //check if the element is present in the rock
            for(String rock : rocks){
                CharSequence s = ""+element;
                
                //If the rock contains the element in set create a map entryif not present
                //or increase the count
                if(rock.contains(s)){
                    if(map.containsKey(element)){
                        int count = map.get(element);
                        count++;
                        map.put(element,count);
                    }else{
                        map.put(element,1);
                    }                    
                }
            }
        }
        
        System.out.println("Map - "+map);
        //check the elements which are present in all rocks
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == noOfRocks){
                gemCount++;
            }
        }       
        
        return gemCount;
    }  
}
