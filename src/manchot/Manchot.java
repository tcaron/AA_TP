package manchot;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import algo.Algo;
public class Manchot {

   int esperance;
   int variance;
   
   public Manchot (int esperance, int variance){
	   
	   this.esperance = esperance;
	   this.variance = variance;
   }
   
   public int getEsperance(){
	   
	   return this.esperance;
   }
   
   public int getVariance(){
	   
	   return this.variance;
   }

   public void setEsperance(int newEsp){
	
	   this.esperance = newEsp;
	   
   }
   
   public void setVariance(int newVariance){
	   
	   this.variance = newVariance;
   }
   
    public Double tirerBras(){

  
        Double rand1 = Math.random();
        Double rand2 = Math.random();
        Double sqrt = ( -2.0 * Math.log(rand1)) ;
        Double cos = ( 2 * Math.PI * rand2 );		
        
        return this.variance * Math.sqrt(sqrt) * Math.cos(cos)+ this.esperance;
    }


    public static void main(String[] args) throws Exception { 
    	
    	Algo algo = new Algo();
    	Random rand = new Random();
    	
    	// équivalent à srand(time(0))
    	rand.setSeed(System.nanoTime());
    	
    	List<Manchot> manchots = new ArrayList<Manchot>();
    	manchots = algo.creerManchots(15, -10, 10, 0, 10);
    	
    	double result1 = algo.rechercheAleatoire(1000, manchots);
    	double result2 = algo.rechercheGloutonne(1000, manchots);
    	double result3 = algo.rechercheUCB(1000, manchots);
    	
    	System.out.println(result1);
    	System.out.println(result2);
    	System.out.println(result3);

    }
}
