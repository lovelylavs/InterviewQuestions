/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.util.Scanner;

/**
 *
 * @author Lavanya
 */
public class MatrixDiag {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] myMatrix = new int[3][3];
        int row=3,col=3;
        for(int i=0; i< row;i++)
        {
            for(int j=0; j< col; j++)
            {
                myMatrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("************");
         for(int i=0; i< myMatrix.length;i++)
        {

            for(int k=0; k< row;k++)
            {
                System.out.println(myMatrix[i][k]);
            }
        }
         
         for( int k = 0 ; k < row * 2 ; k++ ) {
        for( int j = 0 ; j <= k ; j++ ) {
            int i = k - j;
            if( i < row && j < row ) {
                System.out.print( myMatrix[i][j] + " " );
            }
        }
        System.out.println();
    }
    }
}
