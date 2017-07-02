package algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import manchot.Manchot;

public class Algo {
	
	public Double rechercheAleatoire(int itr, List<Manchot> Manchot){
		
		Double gainTotal = 0.0;
		for ( int i = 0 ; i<itr; i++ )
		{
			Random r = new Random();
			gainTotal += Manchot.get(r.nextInt(Manchot.size())).tirerBras();
		}
		
		return gainTotal;
	}
	
	public Double rechercheGloutonne(int itr , List<Manchot> manchot){

		 Double bestScore = 0.0;
		 Double actual = 0.0;
		 Manchot bestManchot = new Manchot(0, 0) ;
		for (int i = 0; i< manchot.size();i++){
			
			actual = manchot.get(i).tirerBras();
			
			if ( actual > bestScore ){
				bestScore = actual;
				bestManchot = manchot.get(i);
			}
		}
		
		for (int j=0; j< itr; j++){
			
			bestScore += bestManchot.tirerBras();
		}
		 return bestScore;
	}
	
	public Double rechercheUCB (int itr, List<Manchot> manchot){
		
		Double[] arrayScore = new Double[manchot.size()];
		int[] arrayTirage = new int[manchot.size()];
		int first_itr = 0;
		Double resultat = 0.0;
		Double best_result = 0.0;
		Double score = 0.0;
		Double total = 0.0;
		int index_manchot = 0;
		
		for (int i = 0;i< manchot.size(); i++)
		{
			first_itr++;
			arrayScore[i] = manchot.get(i).tirerBras();
			arrayTirage[i]++;
		}
		
		
		for ( int j= first_itr ; j< itr;j++){
		
			
			for ( int k =0; k<manchot.size();k++)
			{
				resultat = (arrayScore[k]/arrayTirage[k]) +  Math.sqrt(2.0)*Math.sqrt(Math.log(j)/arrayTirage[k]) ;
				
				if (resultat > best_result){
					
					best_result = resultat;
					index_manchot = k;
				}
			}
			
			score = manchot.get(index_manchot).tirerBras();
			total += score;
			arrayTirage[index_manchot] += score;
			arrayScore[index_manchot]++ ;
			
		}
		return total;
	}
	
	public List<Manchot> creerManchots (int nb_manchots , int min_esp, int max_esp, int min_var, int max_var )
	{
		List<Manchot> manchots = new ArrayList<Manchot>();
		for (int i = 0; i< nb_manchots;i++){
			Random rand = new Random();
			int esperance = rand.nextInt(max_esp-min_esp+1)+min_esp ;
			int variance = rand.nextInt(max_var-min_var+1)+min_var ;
			
			Manchot manchot = new Manchot(esperance,variance);
			manchots.add(manchot);
		}	
		
		return manchots;
		
	}

}
