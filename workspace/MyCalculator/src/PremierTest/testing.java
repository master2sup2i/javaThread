package PremierTest;

public class testing 
{ 
	public static int fact (int i)
	{ 
		int j, f=1 ; 
		for (j=1; j <=i; j++)
		{ f = f*j; }
		return (f);
	}
	
	public static boolean parite (int i)
	{
		if (i%2==0)
		{
			return true;
		}
		else {return false;}
			
		
	}
	
	public static boolean divisible (int i)
	{
		if (i%5==0 && i%7==0)
		{
			return true;
		}
		else {return false;}
			
		
	}
	
	public static String notation (int i)
	{
		String n = null;
		if (i >=0 && i<=20){
			if (i<=7&&i>=0)
			{
				n="echec !!";}
			else if (i<=12&&i>=7)
			{
				n="moyen";
			}
			else if (i<=17&&i>=12)
			{
				n="tres bien";
			}
			else if (i<=20&&i>=17)
			{
				n="excellent";
			}
		}
		else n= "Faux";
		return n;
	}
	
	public static int somme (int i)
	{
		int somme = 0;
		while (i!=0){
			somme=i%10;
			i=i/10;				
			
		}
		return somme;
	}
}
