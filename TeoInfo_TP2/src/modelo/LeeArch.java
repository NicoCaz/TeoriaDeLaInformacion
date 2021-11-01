package modelo;

import java.io.*;
import java.util.*;


public class LeeArch {

    private HashMap<String,Integer> palabras=new HashMap<String,Integer>();
    private Palabra[] vectorPalabras;
    private File archivo = null;
    private  Scanner lector;
    private int cont=0,cantidadPalabras=0;
    public static Double entropia;

    public void lee(String nombreArch) throws IOException {
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        archivo = new File(ruta + "/"+nombreArch);
        String linea;
        lector= new Scanner(archivo);
        while(lector.hasNext()){
            cont++;
            aux= lector.next();
            linea= aux.replaceAll("[^\\w\\s]","");
            if(palabras.get(linea.toLowerCase())==null){
                palabras.put(linea.toLowerCase(),1);
                cantidadPalabras++;
            }else{
                int contaux;
                contaux=palabras.get(linea.toLowerCase());
                palabras.remove(linea.toLowerCase());
                palabras.put(linea.toLowerCase(),contaux+1);
            }
        }
        this.crearvec();
    }
    private void crearvec() {
        this.vectorPalabras=new Palabra[cantidadPalabras];
        int i=0;
        Iterator<Map.Entry<String, Integer>> it = palabras.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair =(Map.Entry)it.next();
            this.vectorPalabras[i]=new Palabra((String) pair.getKey(),(int)pair.getValue());
            i++;
        }
        Arrays.sort(this.vectorPalabras);
    }


public Palabra[] vectorPalabras(){
        return this.vectorPalabras;
}



public int cantPalabras(){
        return this.cont;
}




    public void muestra(){
        System.out.println("cantidad de palabras: "+cantidadPalabras+"\n");
        for(int i=0;i<cantidadPalabras;i++){
            System.out.println(vectorPalabras[i]+"\n");
        }
    }



}
