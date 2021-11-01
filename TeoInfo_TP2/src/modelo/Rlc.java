package modelo;

import java.io.*;
import java.util.Scanner;

public class Rlc {
    private  Scanner lector;
    private File archivo = null;
    private FileWriter archivoSalida;
    private PrintWriter pw = null;
    public void comprimir(String nombreArch) throws IOException {
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
            linea= act.replaceAll("[^\\w\\s]","");
            if(ant==null){
                cont++;
                ant=act;
            }else{
                if(ant.equals(act)){
                    cont++;
                }else{
                    pw.println(cont+""+ant);
                    // guardar cont y ant en el archivo
                    cont=1;
                    ant=act;
                }
            }
        }
        /*
         *aca hay que guardar el anterior y el cont
         * */
        pw.println(cont+""+ant);

        if(pw!=null)
            pw.close();
        System.out.println("archivo creado");
    }
}
