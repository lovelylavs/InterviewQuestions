/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 *
 * @author Lavanya
 */
public class searchMatrix {
    
    public static void main(String[] args){
        int[][] matrix={{1}};
        System.out.println(searchMatrix(matrix,1));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
          return false;
        
        //Sizes of matrix  
        int m = matrix.length;
        int n= matrix[0].length;
        
        int start=0;
        int end = m*n-1;
        
        while(start <end){
            int middle=(start+end)/2;
            int middleX= middle/n;
            int middleY=middle%n;
            
            if(matrix[middleX][middleY]==target)
                return true;
            if(matrix[middleX][middleY]<target)
                start=middle+1;
            
            else
                end=middle-1;
            
            }
        
        return false;
    }
}
