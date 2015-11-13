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
/*Problem Statement

Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line, and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

1 <= N <= 105 
1 <= ratingi <= 105

Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input

3  
1  
2  
2
Sample Output

4*/
public class Candy {
     public static int candy(int[] ratings){
        if(ratings.length==0){
            return 0;
        }
        
        int[] candies = new int[ratings.length];
        candies[0]=1;
        
        //from left end to right
        for(int i=1; i< ratings.length; i++){
            //more rating more choci
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
            else{
                candies[i]=1;
            }
        }
        
        int result=candies[ratings.length-1];
        for(int i=ratings.length-2; i>=0; i--){
            int cur=1;
            if(ratings[i]>ratings[i+1]){
                cur=candies[i+1]+1;
            }
            
            result+=Math.max(cur,candies[i]);
            candies[i]=cur;
        }
        return result;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for(int i=0; i<count;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(candy(nums));
    }
}
