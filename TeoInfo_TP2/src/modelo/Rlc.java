package modelo;

import java.io.*;
import java.util.Scanner;

public class Rlc {
    private Double entropia=0.0;
    private Double longMedia=0.0;
    private  Scanner lector;
    private File archivo = null;
    private FileWriter archivoSalida;
    private PrintWriter pw = null;
    public void comprimir(String nombreArch,int cantPal) throws IOException {
        int cont = 0;
        String act,ant=null;
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        archivoSalida= new FileWriter(ruta+"/"+nombreArch+"."+"RLC");
        archivo = new File(ruta + "/"+nombreArch);
        pw= new PrintWriter(archivoSalida);
        String linea;
        lector= new Scanner(archivo);
        while(lector.hasNext()){
            act= lector.next();
            act= act.replaceAll("[^\\w\\s]","");
            if(ant==null){
                cont++;
                ant=act;
            }else{
                if(ant.equals(act)){
                    cont++;
                }else{
                    pw.println(ant+cont);
                    cont=1;
                    ant=act;
                }
            }
        }

        pw.println(cont+" "+ant);

        if(pw!=null)
            pw.close();

    }
}
