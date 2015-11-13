/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author Lavanya
 */
public class SubArray {
    
    public static int maxSubarrayNonContiguous(int[] nums){
        int sumMax = nums[0];
		int max = nums[0];
		boolean negArray = true;
		int res = nums[0];
		for (int i = 0; i < nums.length; i++) {
			//add all positive numbers
			if (nums[i] > 0) {
				sumMax += nums[i];
				negArray = false;
			}
			//find the smallest negative number
			if (nums[i] >= max && nums[i] != 0) { max = nums[i];}
		}
	
		if (negArray == false)
			res = sumMax;
		//if the array consists of all negative numbers
		//return the smallest number
		if (negArray)
			res = max;
		
		return res;
    }
    
    public static int maxSubarrayContiguous(int[] nums){
        if(nums.length==0)
            return 0;
        
        int maxSum=nums[0];
        int minSum=nums[0];
        int max=nums[0];
        
        for(int i=1; i< nums.length;i++){
            if(nums[i] != 0){
            int temp = maxSum;
            maxSum=Math.max(Math.max(maxSum+nums[i],nums[i]),minSum+nums[i]);
            minSum=Math.min(Math.min(temp+nums[i],nums[i]),minSum+nums[i]);
            max=Math.max(max,maxSum);
            }
        }
        return max;
    }
    
     public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        //array to store continous solutions
    	int[] cont = new int[10];
    	//array to store non-continuous
    	int[] nonCont = new int[10];
        int resCont;
        int resNonCont;
        int inputs;
        inputs = Integer.parseInt(sc.nextLine());
        
        //go through the amount of solutions
        for (int i = 0; i < inputs; i++) {
        	String inputString;
        	int[] arr = new int[10];
        	int indexMax = Integer.parseInt(sc.nextLine());
        	
        	//tokenize input values;
        	//all entries are separated by a space
        	inputString = sc.nextLine();
        	int arrIndex=0;
    		StringTokenizer st = new StringTokenizer(inputString);
    		while(st.hasMoreTokens()) {
    			arr[arrIndex] = Integer.parseInt(st.nextToken());
    			arrIndex++;
    		}
    		
    		//continuous solution
        	resCont = maxSubarrayContiguous(arr);
        	//non-continuous solution
        	resNonCont = maxSubarrayNonContiguous(arr);
        	
        	//add continuous solutions to array
        	cont[i] = resCont;
        	//add non-continuous solutions to array
        	nonCont[i] = resNonCont;
        	
        }
        
        //print out entries
    	for(int i = 0; i < inputs; i++) {
    		System.out.print(cont[i] + " ");
    		System.out.print(nonCont[i]);
    		System.out.println();
    	}
    	
    }
}
