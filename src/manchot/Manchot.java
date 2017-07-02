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
    	
    	List<Manchot> list = new ArrayList<Manchot>();
    	
    	Manchot m1 = new Manchot(1,5);
    	Manchot m2 = new Manchot(1,5);
    	Manchot m3 = new Manchot(1,5);
    	Manchot m4 = new Manchot(1,5);
    	Manchot m5 = new Manchot(1,5);

    	list.add(m1);
    	list.add(m2);
    	list.add(m3);
    	list.add(m4);
    	list.add(m5);
    	
    	Algo algo = new Algo();
    	algo.rechercheAleatoire(10, list);
    	System.out.println(algo.rechercheUCB(40, list));
    }
}
