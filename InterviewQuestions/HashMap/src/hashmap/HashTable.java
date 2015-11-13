/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hashmap;

/**
 *
 * @author Lavanya
 */
public class HashTable 
{
    private Item[] data;
    private int capacity;
    private int size;
    private static final Item AVAILABLE = new Item("Available",null);
    
    public HashTable(int capacity)
    {
        this.capacity = capacity;
        data = new Item[capacity];
        for(int i=0;i<data.length;i++)
        {
            data[i]=AVAILABLE;
        }
        size = 0;
    }
    public int size()
    {
        return size;
    }
    public int hashThis(String key)
    {
        return key.hashCode() % capacity;//hashCode returns a hash code for this string
    }
    public Object get(String key)
    {
        int hash = hashThis(key);
        while(data[hash] != AVAILABLE && (!data[hash].getKey().equals(key)))
        {
            hash = (hash +1) % capacity;
        }
        return data[hash].getElement();
    }
    
    public void put(String key,Object element)
    {
        if(key!= null)
        {
            size++;
            int hash = hashThis(key);
            while(data[hash] != AVAILABLE && (!data[hash].getKey().equals(key)))
            {
                hash = (hash +1) % capacity;
            }
            data[hash] = new Item(key,element);        
        }
    }
    
    public Object remove(String key)
    {
        throw new UnsupportedOperationException("Can't remove");
    }

    public String toString()
    {
        String s = "<HashTable[";
        for(int i =0;i<this.capacity ; i++)
        {
            if(data[i].getElement() != null)
            {
                s += data[i].toString();
                if(i<this.size -1)
                {
                    s+=",";
                }
            }
        }
        s += "]>";
        return s;
    }
    
    public static void main(String args[])
    {
        HashTable hm = new HashTable(5);
        hm.put("1", "a");
        String x = hm.toString();
        System.out.println(x);
        hm.put("2","b");
        String y = hm.toString();
        System.out.println(y);
        
    }
 
}   
