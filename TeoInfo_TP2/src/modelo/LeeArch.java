package modelo;

import java.io.*;
import java.util.*;


public class LeeArch {
    private HashMap<String,Integer> palabras=new HashMap<String,Integer>();
    private Palabra[] vectorPalabras;
    private File archivo = null;
    private  Scanner lector;
    private int cont=0;
    public void lee(String nombreArch) throws IOException {
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        archivo = new File(ruta + "/"+nombreArch);
        String linea;
        lector= new Scanner(archivo);
        while(lector.hasNext()){

            aux= lector.next();
            linea= aux.replaceAll("[^\\w\\s]","");
            if(palabras.get(linea)==null){
                palabras.put(linea,1);
                cont++;
            }else{
                int cont;
                cont=palabras.get(linea);
                palabras.remove(linea);
                palabras.put(linea,cont+1);
            }
        }
        this.crearvec();
    }
    private void crearvec() {
        this.vectorPalabras=new Palabra[cont];
        int i=0;
        Iterator<Map.Entry<String, Integer>> it = palabras.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair =(Map.Entry)it.next();
            this.vectorPalabras[i]=new Palabra((String) pair.getKey(),(int)pair.getValue());
            i++;
        }
        Arrays.sort(this.vectorPalabras);
        System.out.println(this.vectorPalabras);
    }


public Palabra[] vectorPalabras(){
        return this.vectorPalabras;
}








    public void muestra(){
        System.out.println("cantidad de palabras: "+cont+"\n");
        for(int i=0;i<cont;i++){
            System.out.println(vectorPalabras[i]+"\n");
        }
    }



}
