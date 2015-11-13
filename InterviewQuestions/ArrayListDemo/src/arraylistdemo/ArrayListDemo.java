/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arraylistdemo;

import java.util.Arrays;

/**
 *
 * @author Lavanya
 */
public class ArrayListDemo
{
    private Object[] myStore;//object array
    private int actSize =0;
    
    public ArrayListDemo() //create new List
    {
        myStore = new Object[10];
    }
    
    public Object get(int index) //get an object at particular index
    {
        if(index<actSize)
        {
            return myStore[index];
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
     }
    
    public void add(Object obj)
    {
        if(myStore.length-actSize <= 5) //increase list size if halfh through
        {
            increaseListSize();
        }
        myStore[actSize++]=obj; //add object to arrayList
    }
    
    public Object remove(int index)
    {
        if(index<actSize)
        {
            Object obj = myStore[index];
            myStore[index]= null;
            int tmp = index;
            while(tmp < actSize)
            {
                myStore[tmp]=myStore[tmp+1];
                myStore[tmp+1]=null;
                tmp++;
            }
            actSize--;
            return obj;
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public int size()
    {
        return actSize;
    }
    private void increaseListSize()//Double ArrayList
    {
        myStore = Arrays.copyOf(myStore,myStore.length*2);
        System.out.println("\n New Length:"+myStore.length);
    }
    public static void main(String[] args)
    {
        ArrayListDemo arr = new ArrayListDemo();
        arr.add(new Integer(2));
        arr.add(new Integer(5));
        arr.add(new Integer(1));
        arr.add(new Integer(14));
        arr.add(new Integer(31));
        
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+"");
            
        }
        arr.add(new Integer(4));
        System.out.println("Element at index 5:"+arr.get(5));
        System.out.println("List Size:"+arr.size());
        System.out.println("Remove element at index 2:"+arr.remove(2));
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+"");
            
        }
    }
    
}
