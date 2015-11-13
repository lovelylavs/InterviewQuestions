/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spiralmatrix;

/**
 *
 * @author Lavanya
 */
public class SpiralMatrix {
    
    public void printSpiral(int[][] a, int rowSize, int columnSize) {

        int increment = 1;
        int row = 0;
        int column = 0;

        while (columnSize > 1 || rowSize > 1) {

            for (int i = 0; i < columnSize; i++) {
                System.out.print(a[row][column] + " ");
                column = column + increment;
            }

            column = column - increment;

            row = row + increment;
            columnSize--;

            for (int i = 0; i < rowSize - 1; i++) {
                System.out.print(a[row][column] + " ");
                row = row + increment;
            }

            row = row - increment;

            column = column - increment;
            rowSize--;

            increment = -increment;
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[][] = new int[4][4];
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                arr[i][j]=i+j;
            }
        }
        
         for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(arr[i][j]);
                
            }
            System.out.println("");
        }
         
        SpiralMatrix sp = new SpiralMatrix();
        
        sp.printSpiral(arr, 4, 4);
    }
    
}
