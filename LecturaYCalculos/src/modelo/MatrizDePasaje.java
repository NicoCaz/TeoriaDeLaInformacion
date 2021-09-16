package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import util.Calculos;

public class MatrizDePasaje {

	
	
	private int largopalabra;
	
	

	public MatrizDePasaje() {
		super();
		this.largopalabra = 2;
	}



	public void crearMatriz() {
		int cantidadPalabras=0;
		FileReader fr = null;
		try {
		   // Apertura del fichero y creacion de BufferedReader para poder
		   // hacer una lectura comoda (disponer del metodo readLine()).
		   String ruta;
		   ruta=System.getProperty("user.dir");
		   File archivo = new File (ruta+"/anexo1.txt");
		   fr = new FileReader (archivo);
		   BufferedReader br = new BufferedReader(fr,this.largopalabra);
		   // Lectura del fichero
		   String lineaStr,ant=null;
		   char[] linea=new char[this.largopalabra];
		   float mat[][]= new float[4][4];
		   
		   while((br.read(linea,0,this.largopalabra))!=-1) { //mientras leo convierto y actualizo
			
			 lineaStr=String.valueOf(linea);
			//CALCULO DE LA MATRIZ
			if(ant==null) {
				ant=lineaStr;
			}
			else {
				Calculos.calculaMatriz(ant,lineaStr,mat);
				ant=lineaStr;
			}
			
			
			cantidadPalabras++;
		   }
		   Calculos.promMat(mat);
		   Calculos.muestraMat(mat);
		  
		}
		catch(Exception e){
		   e.printStackTrace();
		}finally{
		   // En el finally cerramos el fichero, para asegurarnos
		   // que se cierra tanto si todo va bien como si salta 
		   // una excepcion.
		   try{                    
		      if( null != fr )  
		         fr.close();                       
		   }catch (Exception e2){
		      e2.printStackTrace();
		   }
		}
		}
}
