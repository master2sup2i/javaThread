package TP5E3;


/*
 * Somme Tableau
 */
public class TP5E3 extends Thread {

	int i,m;
	int []t;
	int res;
		
	public TP5E3 (int i,int m,int[] t){
		this.i=i;
		this.m=m;
		this.t=t;
		res=0;		
	}
	
	public void run (){
		
		if(i==m){
			res=t[i];
		}
		else{
			TP5E3 T1=new TP5E3(i,m,t);
			TP5E3 T2=new TP5E3(i,m,t);
			T1.start();	
			T2.start();
			try {
				T1.join();T2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			res = T1.res+T2.res;
		}
	}
	
}
