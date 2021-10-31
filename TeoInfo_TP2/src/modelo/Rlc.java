package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rlc {
    private  Scanner lector;
    private File archivo = null;
    public void comprimir(String nombreArch) throws FileNotFoundException {
        int cont = 0;
        String act,ant=null;
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        archivo = new File(ruta + "/"+nombreArch);
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
                    // guardar cont y ant en el archivo
                    cont=1;
                    ant=act;
                }
            }
        }
        /*
         *aca hay que guardar el anterior y el cont
         * */
    }
}
