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
public class HeapSort {
    private static int N;
    
    
    public static void main(String[] args)
    {
        int[] A = new int[] {4,1,3,2,16,9,10,14,8,7};
                        heapSort(A);

                        System.out.println("Sorted array");
                        for (int i : A)
                        {
                                System.out.print(String.format("%5d", i));
                        }
                        System.out.println();
    }
    public static void build_max_heap(int[] arr)
    {
        for(int i=arr.length/2;i>=0; i--)
        {
            max_heapify(arr,arr.length,i);
        }
    }
    
    public static void max_heapify(int[] arr,int heap_size,int i)
            
    {
        int l=left(i);
        
        int r = right(i);
        
        int largest;
        
        if(l < heap_size && arr[l]>arr[i])
            largest=l;
        else
            largest=i;
        if(r<heap_size && arr[r]>arr[largest])
            largest=r;
        
        if(largest != i)
        {
            int exchange = arr[i];
            arr[i]=arr[largest];
            arr[largest]=exchange;
            
            max_heapify(arr,heap_size,largest);
        }
    }
    public static void heapSort(int arr[])
    {
        build_max_heap(arr);
        
        int heap_size = arr.length;
        int exchange;
        
        for(int i=arr.length/2;i>=1; i--)
        {
            exchange=arr[i];
            arr[i]=arr[0];
            arr[0]=exchange;
            
            heap_size--;
            max_heapify(arr,heap_size,0);
        }
    }
    public static int parent(int i)
    {
        return i/2;
    }
    
    public static int left(int i)
    {
        return 2*i;
    }
    
    public static int right(int i)
    {
        return 2*i+1;
    }
}
