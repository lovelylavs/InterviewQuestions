/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

/**
 *
 * @author Lavanya
 */
public class StringReorderDApart {
    
    public static void main(String[] args)
    {
        System.out.println(reorderString("hallooween",4));

    }
    
    	public static int NUM_ASCII_CHARS = 128 ;  
	
	
	/**
	 * Reorder the string such that duplicated characters are at least "dist" 
	 * apart from each other. Note that There could be more than one solution 
	 * for the same given string 
	 * 
	 * This problem can be solved using a greedy algorithm. The idea is to insert
	 * a character to the reordered string each time. The character to insert 
	 * depends on the following factors:
	 *    (1) the same character should be inserted "dist" apart 
	 *    (2) insert the characters with maximum frequency first 
	 *  
	 *  Time complexity: O(MN), where M is the set size, and N is the string size 
	 * 
	 * @param source
	 * @return
	 */
	public static String reorderString(String source, int dist){
		
		int[] occurs = new int[NUM_ASCII_CHARS] ; 
		int[] dists  = new int[NUM_ASCII_CHARS] ; // a char is available only if dist[i] is <= 0 
		boolean[] avail = new boolean[NUM_ASCII_CHARS]; // by default evey char is available 
		
		// collect the character frequency  
		int sourceLength = source.length(); 
		for(int i=0; i<sourceLength; i++) 
			occurs[source.charAt(i)] ++ ; 
		
		// now start to insert 
		StringBuilder stringBuilder = new StringBuilder(); 
		for(int i=0; i<sourceLength; i++){
			
			for(int j=0; j<NUM_ASCII_CHARS; j++) 
				avail[j] = true ; 
			
			int index = findMaxOccurChar(occurs, dists, avail); 
			if( index == -1)
					return null ; 
		
			stringBuilder.append((char) index); 
			avail[index] = false; 
			dists[index] = dist ; 
			occurs[index] -- ; 
			
			//decay the distances for all chars in the set 
			for(int k=0; k<NUM_ASCII_CHARS; k++)
				dists[k] --; 
		}
		

				
		return stringBuilder.toString(); 
	} 
	
	
	
	
	protected static int findMaxOccurChar(int[] occurs, int[] dists, boolean[] avail){
		
		int maxIndex = -1; 
		int maxOccur = 0 ; 
		
		for(char c='a';  c<='z';  c++){
			if(occurs[c]>maxOccur && dists[c]<=0 && avail[c] ){
				maxOccur = occurs[c]; 
				maxIndex = c ; 
			}
		}
		
		return maxIndex ; 
	}
		

}
