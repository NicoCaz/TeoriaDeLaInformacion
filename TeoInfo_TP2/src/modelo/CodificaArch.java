package modelo;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class CodificaArch {
    private File archivo = null;
    private  Scanner lector;
    PrintWriter pw = null;

    public CodificaArch(){

    }
    public void creaArch(HashMap<String,String> tabla, String nombreArch,String tipoCodificacion) throws IOException {
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        archivo=new File(ruta + "/"+nombreArch);
        FileWriter archivoSalida= new FileWriter(ruta+"/"+nombreArch+"."+tipoCodificacion);
        pw= new PrintWriter(archivoSalida);
        String linea;

        lector= new Scanner(archivo);
        while(lector.hasNext()){
            aux= lector.next();
            linea= aux.replaceAll("[^\\w\\s]","");
            pw.print(tabla.get(linea));
        }
        if(pw!=null)
            pw.close();
        System.out.println("archivo creado");
    }

}
