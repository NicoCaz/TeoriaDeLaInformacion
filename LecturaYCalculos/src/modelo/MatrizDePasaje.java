package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import util.Calculos;

public class MatrizDePasaje {

	
	
	private int largopalabra;
	private Double[][] mat;

	public MatrizDePasaje() {
		super();
		this.largopalabra = 2;
		this.mat = new Double[4][4];
		Calculos.inicializaMat(this.mat);
	}

	public Double[][] devuelveMat(){
		return this.mat;
	}

	public void crearMatriz() {

		int cantidadPalabras=0;
		FileReader fr = null;
		String lineaStr,ant=null;
		char[] linea=new char[this.largopalabra];

		String ruta;
		try {
		   ruta=System.getProperty("user.dir");
		   File archivo = new File (ruta+"/anexo1.txt");
		   fr = new FileReader (archivo);
		   BufferedReader br = new BufferedReader(fr,this.largopalabra);


		   
		   while((br.read(linea,0,this.largopalabra))!=-1) { //mientras leo convierto y actualizo
			
			 lineaStr=String.valueOf(linea);

			if(ant==null) {
				ant=lineaStr;
			}
			else {
				Calculos.calculaMatriz(ant,lineaStr,this.mat);
				ant=lineaStr;
			}
			cantidadPalabras++;
		   }

		   Calculos.promMat(this.mat);
		   Calculos.muestraMat(this.mat);
		  
		}
		catch(Exception e){
		   e.printStackTrace();
		}finally{
		   try{                    
		      if( null != fr )  
		         fr.close();                       
		   }catch (Exception e2){
		      e2.printStackTrace();
		   }
		}
		}
	public void suma() {
		double acum;
		for(int i=0;i<4;i++) {
			acum=0;
			for(int j=0;j<4;j++) {
				acum+=this.mat[i][j];
			}
			System.out.println("la suma es: "+acum);
		}
	}
}
