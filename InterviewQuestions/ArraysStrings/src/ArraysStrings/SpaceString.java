package ArraysStrings;

public class SpaceString 
{

	
	void Rep_Str(char[] str)
	{
	    int j=0,count=0;
	    int stlen = str.length;
	    System.out.format("char length %d\n",stlen);
	    for (j = 0; j < stlen; j++)
	    {
	        if (str[j]==' ')
	        {
	            count++;
	        }
	    }

	    int newlength = stlen+(count*2);
	    System.out.format("String length %d",newlength);
	    
	    char[] newstr = new char[newlength] ;
	    try
	    {
	    	newstr[newlength]='\0';
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Have issue here");
	    }
	    System.out.println(str);
	    
	    for (j = stlen-1; j >=0 ; j--)
	    {
	    	System.out.println(j);
	    	System.out.println(str[j]);
	        if (str[j]==' ')
	        {
	        	
	        	newstr[newlength--]='0';
	        	newstr[newlength--]='2';
	        	newstr[newlength--]='%';
	        }

	        else
	        {

	        	newstr[newlength--]=str[j];
	        }

	    }
	    System.out.println(newstr);

	}
	
	public static void main(String[] args)
	{
		SpaceString myStr = new SpaceString();
		char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        myStr.Rep_Str(ch);   
	}
}
	


