package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import util.Calculos;


public class LeeArch {

private Palabra[] palabra;
private File archivo = null;
private FileReader fr = null;
private BufferedReader br = null;
private int largopalabra;


	public LeeArch(int largopalabra) {
	super();
	this.largopalabra=largopalabra;
	this.palabra = new Palabra[(int) Math.pow(2,largopalabra)];
	//this.archivo = archivo;
	}

	private void crearvec() {
		for(int i=0;i<(int) Math.pow(2,largopalabra);i++)
		this.palabra[i]=new Palabra();
	}
	
	public void leerarch() {
	crearvec();
	int cantidadPalabras=0;
	try {
	   // Apertura del fichero y creacion de BufferedReader para poder
	   // hacer una lectura comoda (disponer del metodo readLine()).
	   String ruta;
	   ruta=System.getProperty("user.dir");
	   archivo = new File (ruta+"/anexo1.txt");
	   fr = new FileReader (archivo);
	   br = new BufferedReader(fr,this.largopalabra);
	   String ant=null;
	   // Lectura del fichero
	   String lineaStr,lineaBinaria;
	   char[] linea=new char[this.largopalabra];
	   
	   while((br.read(linea,0,this.largopalabra))!=-1) { //mientras leo convierto y actualizo
		lineaBinaria=String.valueOf(linea);
		lineaStr=String.valueOf(linea);
		int indice =Integer.parseInt(lineaStr,2);
		this.palabra[indice].palabra=lineaBinaria;
		this.palabra[indice].repeticiones++;
		
		cantidadPalabras++;
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
	Calculos.calculoCantInfoYEntropia(this.palabra,cantidadPalabras,this.largopalabra);
	}
	public void muestravec() {
		for(int i=0;i<(int) Math.pow(2,largopalabra);i++)
			System.out.println(this.palabra[i]);
	}
}

