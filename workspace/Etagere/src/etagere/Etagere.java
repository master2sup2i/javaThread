//TP2

package etagere;

import java.util.Arrays;


public class Etagere {

		public int nblivres;
		public Livre meslivres[];
		public int maxlivres;
		
		
		public Etagere (int n)
		{
			this.nblivres = 0;
			this.meslivres = new Livre[n];
			this.maxlivres = n;
		}
		
		public int getNblivres() {
			return nblivres;
		}

		public void setNblivres(int nblivres) {
			this.nblivres = nblivres;
		}

		public Livre[] getMeslivres() {
			return meslivres;
		}

		public void setMeslivres(Livre[] meslivres) {
			this.meslivres = meslivres;
		}

		public int getMaxlivres() {
			return maxlivres;
		}

		public void setMaxlivres(int maxlivres) {
			this.maxlivres = maxlivres;
		}
//ajouter livre
		public void ajouterlivre (Livre L) throws EtagerePleine
		{
			if (nblivres < maxlivres)
			{
				meslivres[nblivres]= L;
				nblivres ++;
			}
			else
			{
				throw new EtagerePleine();
			}
			
		}

// recupérer livre
		public Livre recuplivre (int pos)
		{
			if (pos < nblivres)
			{
				
				return meslivres[pos-1];
			}
			else
			{
				return null;
			}
		}
// chercher livre
		public int cherchelivre (String Auteur,String Titre)
		{
			int pos = -1;
			for (int i=0;i<nblivres;i++)
			{
				if (meslivres[i].getAuteur().equals(Auteur) && 
						meslivres[i].getTitre().equals(Titre) )
				{
					return i;
				}
				
			}
			return pos;
		}
//chercher livre renvoi tableau
		public int [] chercher (String Auteur,String Titre)
		{
			int [] T = new int [nblivres];
			int pos=0;
			for (int i=0;i<nblivres;i++)
			{
				if (meslivres[i].getAuteur().equals(Auteur) && 
				meslivres[i].getTitre().equals(Titre) )
				{
					T[pos]=i+1;
					pos++;
				}
				
			}
			return T;
		}

//supprimer livre methode 1
		public boolean supprimerlivre (int n) 
		{
			if (n >=1 && n<=nblivres)
			{
				for (int i =n;i<nblivres-1;i++)
				{
					meslivres[i]=meslivres[i+1];
				}
			
				nblivres --;
				return true;
			}
			else
			{	
				return false;	
			}
		}
	
//methode suppr 2
		public boolean supprimerlivre (String Auteur, String Titre) 
		{
			int pos=cherchelivre(Auteur,Titre);
			return supprimerlivre(pos);
		}
		
		

//methode description "toString()"
		public String toString(){
			return("il y a "+ nblivres +" livres sur "+ maxlivres + " possibles... Les voicis: "+ Arrays.toString(meslivres)+ "/n");
		}
		
}
