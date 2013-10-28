package PremierTest;

public class testing2 {



	private static int i;

	public static String listinverse(String S)
	{
	  return new StringBuffer(S).reverse().toString();
	}
	
	
	
	public static boolean appartientoupas (String S, char c)
	{
		if(S.indexOf(c) !=-1)
		{
			return true;
		}
		
		else
			{return false;}
	}
	
	public static int comptechar (String S, char c)
	{
		int i=0;
		for (int j=0;j<S.length();j++)
		{
			if (S.charAt(j)==c)
			{
				i++;
			}
			
		}
		return i;
	}
	
	//public static int somme (String S)
	//{
		
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
