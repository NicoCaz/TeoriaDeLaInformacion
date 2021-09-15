package util;

import modelo.Palabra;

public abstract class Calculos {

	
	public static void calculoCantInfoYEntropia(Palabra[] palabra,int cantPal,int tamanioPal){
		
		float prob,entropia=0;
		int i;
		for(i=0;i<Math.pow(2,tamanioPal);i++) {
			if(palabra[i].repeticiones!=0) {
				prob=(float)palabra[i].repeticiones/cantPal;
				palabra[i].cantInfo=(float) -logbase(prob,2);
				palabra[i].entropia=(float) (prob*(-logbase(prob,2)));
				//entropia+=(float) (prob*(-logbase(prob,2)));
				
			}
		}
		
	}
	
	
	
	 private static Double logbase(double num, int base) {
	      return (Math.log10(num) / Math.log10(base));
	   }
}
