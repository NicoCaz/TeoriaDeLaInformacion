package modelo.algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RLC2 {

private File archivo = null;
private FileReader fr = null;
private BufferedReader br = null;



	    public RLC2() {
	    	super();
	    }

		public void leearch(String nombreArch) {
	    	
	    	 try {
	             String ruta;
	             ruta = System.getProperty("user.dir");
	             archivo = new File(ruta + "/"+nombreArch);
	             fr = new FileReader(archivo);
	             br = new BufferedReader(fr, 1);
	             int caracterLeido = fr.read();
	             char caracterAnterior='+'; //CAMBIAR ESTA BANDERA RUPESTRE
	             int cont=1;
	             while ((caracterLeido!= -1)) { 
	            	 char caracter = (char) caracterLeido;
	            	 if (caracterAnterior!='+') {
	            		 if(caracterAnterior!=caracter) {
	            			 System.out.println(caracterAnterior+""+cont);
	            			 caracterAnterior=caracter;
	            			 cont=1;
	            		 }
	            		 else
	            			 cont++;
	            	 }
	            	 else {
	            		 caracterAnterior=caracter;
	            	 }
	            	// System.out.println(caracter+" "+caracterAnterior);
	                 caracterLeido = fr.read();
	             }
	             System.out.println(caracterAnterior+" "+cont);// cuando corta el while le queda pendiente la ultima
	         } catch (Exception e) {
	             e.printStackTrace();
	         } finally {
	             try {
	                 if (null != fr)
	                     fr.close();
	             } catch (Exception e2) {
	                 e2.printStackTrace();
	             }
	         }
	    	 
	    }
}
