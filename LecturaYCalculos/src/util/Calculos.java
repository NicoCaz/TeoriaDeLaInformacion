package util;

import modelo.LeeArch;
import modelo.Palabra;

public abstract class Calculos {


	public static void calculoCantInfoYEntropia(Palabra[] palabra,int cantPal,int tamanioPal, Double entropia){

		Double prob;
		int i;
		for(i=0;i<Math.pow(2,tamanioPal);i++) {
			if(palabra[i].repeticiones!=0) {
				prob= (double) (palabra[i].repeticiones / cantPal);
				palabra[i].cantInfo=-logbase(prob,2);
				palabra[i].entropia= prob*(-logbase(prob,2));
				LeeArch.entropia+= prob*(-logbase(prob,2));
				
			}
		}
		
	}
	
	public static void calculaMatriz(String ant, String act, Double[][] mat){
		//int mat[][] = null;
		//inicializaMat(mat);
		
		int i=Integer.parseInt(act,2);
		int j=Integer.parseInt(ant,2);
		mat[i][j]+=1.0;
		
	}
	
	public static void promMat(Double[][] mat){
		int suma;
		for(int i=0;i<4;i++) {
			suma=0;
			for(int j=0;j<4;j++) {
				suma+=mat[i][j];
			}
			if(suma!=0) {
				for(int j=0;j<4;j++) {
					mat[i][j]/=suma;
				}
			}
			}
		}
	
	public static void inicializaMat(Double[][] mat) {
		for (int i=0; i < 4; i++) {
			  for (int j=0; j < 4; j++) {
			    mat[i][j]= (double) 0;
			  }
			}
	}
	
	 private static Double logbase(double num, int base) {
	      return (Math.log10(num) / Math.log10(base));
	   }


public static void muestraMat(Double[][] mat){
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            System.out.print(mat[i][j]+" ");
        }   
        System.out.println("\n"); 
       
    }
}

}
