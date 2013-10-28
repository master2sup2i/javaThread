package TP5;

public class TP5Thread extends Thread {

	int i,j,res,seuil;
	
	public TP5Thread(int i, int j, int seuil) {
		this.i=i;
		this.j=j;
		this.seuil=seuil;
		res=1;
		
	}
	
	public void run (){
		
		if(j-i<=seuil){
			res=1;
			for (int k=i;k<=j;k++){
				res=res*k;
			}
		}
		else{
			int mid=(i+j)/2;
			TP5Thread T1=new TP5Thread(i,mid,seuil);
			TP5Thread T2=new TP5Thread(mid+1,j,seuil);
			T1.start();	
			T2.start();
			try {
				T1.join();T2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			res = T1.res*T2.res;
		}
	}
}
