package modelo;

import java.io.*;
import java.util.*;


public class LeeArch {

    private HashMap<Character,Integer> palabras= new HashMap<Character, Integer>();
    private Palabra[] vectorPalabras;
    private File archivo = null;

    private FileReader fr = null;
    private BufferedReader br = null;

    private int cantidadPalabras=0,cantidadTotalDeSimbolos=0;
    public static Double entropia;

    public void lee(String nombreArch) throws IOException {
        String ruta;
        String aux;
        ruta = System.getProperty("user.dir");
        archivo = new File(ruta + "/"+nombreArch);
        fr = new FileReader(archivo);
        br=new BufferedReader(fr);
        String linea;
        while ((linea=br.readLine() )!= null){

            for(int i=0;i<linea.length();i++){
                cantidadTotalDeSimbolos++;
                if(palabras.get(linea.charAt(i))==null){
                    palabras.put(linea.charAt(i),1);
                    cantidadPalabras++;
                }else{
                    int contaux;
                    contaux=palabras.get(linea.charAt(i));
                    palabras.remove(linea.charAt(i));
                    palabras.put(linea.charAt(i),contaux+1);
                }
            }

        }
        this.crearvec();
    }
    private void crearvec() {
        this.vectorPalabras=new Palabra[cantidadPalabras];
        int i=0;
        Iterator<Map.Entry<Character, Integer>> it = palabras.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair =(Map.Entry)it.next();
            this.vectorPalabras[i]=new Palabra((Character) pair.getKey(),(int)pair.getValue());
            i++;
        }
        Arrays.sort(this.vectorPalabras);
    }


        public Palabra[] vectorPalabras(){
                return this.vectorPalabras;
        }


    public int cantPalabras() {
        return cantidadTotalDeSimbolos;
    }

    public void muestra(){
        System.out.println("cantidad de palabras: "+cantidadPalabras+"\n");
        for(int i=0;i<cantidadPalabras;i++){
            System.out.println(vectorPalabras[i]+"\n");
        }
    }



}
