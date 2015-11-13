/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnmatrixzero;

import java.util.Scanner;

/**
 *
 * @author Lavanya
 */
public class MNMatrixZero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        for(int i=0; i< 3;i++)
        {
            for(int j=0; j< 3; j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        
        
        MNMatrixZero mat = new MNMatrixZero();
        mat.setZeros(matrix);
        for(int i=0; i< 3;i++)
        {
            for(int j=0; j< 3; j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println(" ");
        }
   }
    
   
    public void setZeros(int[][] matrix)
    {
        //to keep track of rows with zeros and columns with zeros
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        
        //Now storing the indexes of values which are 0 
        for(int i=0; i< matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    column[j]=true;
                }
            }
        }
        
        
        for(int i=0;i< row.length;i++)
        {
            if(row[i])nullifyRow(matrix, i);
        }
        
        
        for(int j=0;j< column.length;j++)
        {
            if(column[j])nullifyColumn(matrix, j);
        }
        
    }
        public void nullifyRow(int[][] matrix,int row)
        {
            for(int j=0; j< matrix[0].length; j++)
            {
                matrix[row][j]=0;
            }
        }
        
        public void nullifyColumn(int[][] matrix,int col)
        {
            for(int i=0; i< matrix.length; i++)
            {
                matrix[col][i]=0;
            }
        }
        
        
    
}
