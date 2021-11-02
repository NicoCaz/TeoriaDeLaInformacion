package modelo;

import java.io.*;
import java.util.Scanner;

public class Rlc {
    private final Double entropia=0.0;
    private final Double longMedia=0.0;
    private File archivo = null;

    private FileReader fr = null;
    private BufferedReader br = null;
    PrintStream archivoSalida = null;
    public void comprimir(String nombreArch,int cantPal) throws IOException {
        int cont = 0;
        Character act,ant=null;
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        try {
            archivoSalida= new PrintStream(new FileOutputStream(ruta+"/"+nombreArch+"rlc"+".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(archivoSalida);
        archivo = new File(ruta + "/"+nombreArch);
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br=new BufferedReader(fr);
        String linea;

        while((linea=br.readLine() )!= null){
            for(int i=0;i<linea.length();i++){
            if(ant==null){
                cont++;
                ant=linea.charAt(i);
            }else{
                if(ant.equals(linea.charAt(i))){
                    cont++;
                }else{
                    System.out.print(cont+""+ant);
                    cont=1;
                    ant=linea.charAt(i);
                }
                }
            }
        }

        System.out.print(cont+""+ant);
        /*try {
            archivoSalida.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
}
