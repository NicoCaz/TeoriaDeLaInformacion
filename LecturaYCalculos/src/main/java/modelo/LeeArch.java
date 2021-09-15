package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class LeeArch {

private Palabra[] palabra;
private File archivo = null;
private FileReader fr = null;
private BufferedReader br = null;
private int largopalabra=5;


	public LeeArch() {
	super();
	this.palabra = new Palabra[512];
	//this.archivo = archivo;
	}

	private void crearvec() {
		for(int i=0;i<512;i++)
		this.palabra[i]=new Palabra();
	}
	
	public void leerarch() {
	crearvec();
	try {
	   // Apertura del fichero y creacion de BufferedReader para poder
	   // hacer una lectura comoda (disponer del metodo readLine()).
		String ruta;
	   ruta=System.getProperty("user.dir");
	   archivo = new File (ruta+"/anexo1.txt");
	   fr = new FileReader (archivo);
	   br = new BufferedReader(fr,this.largopalabra);
	
	   // Lectura del fichero
	   String lineaStr,lineaBinaria;
	   char[] linea=new char[5];
	   while((br.read(linea,0,this.largopalabra))!=-1) {
		lineaBinaria=String.valueOf(linea);
		lineaStr=String.valueOf(linea);
		
		
		int indice =Integer.parseInt(lineaStr,2);
		
		this.palabra[indice].palabra=lineaBinaria;
		this.palabra[indice].repeticiones++;
		this.palabra[indice].cantInfo=123456;
		
		//System.out.println(indice+"  \n");
		//System.out.println(lineaBinaria+"\n");
	   }
	  
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
	public void muestravec() {
		for(int i=0;i<512;i++)
			System.out.println(this.palabra[i]);
	}
}