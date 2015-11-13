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
public class Item 
{
    private String key;//hash key
    private Object element;//elements to be mapped
    
    public Item(String key,Object element)//constructor
    {
        this.key = key;
        this.element = element;
    }
    
    public String getKey() //Getter / Setter
    {
        return key;
    }
    public void setKey(String key)
    {
        this.key=key;
    }
    public Object getElement() //Getter / Setter
    {
        return element;
    }
    public void setElement(Object element)
    {
        this.element=element;
    }
    
    public String toString()
    {
        String s = "<Item(";
        s+=this.key+","+this.element+")>";
        return s;
    }
}
