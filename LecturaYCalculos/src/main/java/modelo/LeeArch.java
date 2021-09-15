package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class LeeArch {

private Palabra palabra[];
private File archivo = null;
private FileReader fr = null;
private BufferedReader br = null;
private int largopalabra=5;


	public LeeArch() {
	super();
	this.palabra = new Palabra[512];;
	//this.archivo = archivo;
	}


	public void leerarch() {
	
	try {
	   // Apertura del fichero y creacion de BufferedReader para poder
	   // hacer una lectura comoda (disponer del metodo readLine()).
		String ruta;
	   ruta=System.getProperty("user.dir");
	   archivo = new File (ruta+"/anexo1.txt");
	   fr = new FileReader (archivo);
	   br = new BufferedReader(fr,this.largopalabra);
	
	   // Lectura del fichero
	   String linea;
	   while((linea=br.readLine())!=null) {
		System.out.println("\n");
		System.out.println(linea+"  \n");
		int indice =Integer.parseInt(linea);
		this.palabra[indice].palabra=linea;
		this.palabra[indice].repeticiones++;
		this.palabra[indice].cantInfo=123456;
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
	/* public void leerarch()  {
		String ruta=System.getProperty("user.dir");
	        String fileName = ruta+"/anexo1.txt";
	        Scanner scan = null;
			try {
				scan = new Scanner(new File(fileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        while(scan.hasNextLine()){
	            String line = scan.nextLine();
	            System.out.println(line+"\n");
	        }
	    }*/
}