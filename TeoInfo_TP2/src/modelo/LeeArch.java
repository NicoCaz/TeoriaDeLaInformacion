package modelo;

import java.io.*;
import java.util.*;


public class LeeArch {

    private HashMap<Character,Integer> palabras= new HashMap<Character, Integer>();
    private HashMap<String,Integer> numeros= new HashMap<String, Integer>();
    private Palabra[] vectorPalabras;
    private File archivo = null;
    private Boolean esImagen;
    private FileReader fr = null;
    private BufferedReader br = null;

    private int cantidadUnicaDePalabras =0,cantidadTotalDeSimbolos=0;


    public void lee(String nombreArch) throws IOException {
        this.esImagen=nombreArch.contains(".raw");
        String ruta;
        ruta = System.getProperty("user.dir");
        archivo = new File(ruta+"/archivosEntrada" + "/"+nombreArch);
        fr = new FileReader(archivo);
        br=new BufferedReader(fr);
        String linea;
        if(!this.esImagen) {

            while ((linea=br.readLine() )!= null){
                for(int i=0;i<linea.length();i++){
                    cantidadTotalDeSimbolos++;
                    if(palabras.get(linea.charAt(i))==null){
                        palabras.put(linea.charAt(i),1);
                        cantidadUnicaDePalabras++;
                    }else{
                        int contaux;
                        contaux=palabras.get(linea.charAt(i));
                        palabras.remove(linea.charAt(i));
                        palabras.put(linea.charAt(i),contaux+1);
                    }
                }
                cantidadTotalDeSimbolos++;
                if(palabras.get('\n')==null){
                    palabras.put('\n',1);
                    cantidadUnicaDePalabras++;
                }else{
                    int contaux;
                    contaux=palabras.get('\n');
                    palabras.remove('\n');
                    palabras.put('\n',contaux+1);
                }
            }
            this.crearvec();
        }else{
            while ((linea=br.readLine() )!= null) {
                    cantidadTotalDeSimbolos++;
                    if (numeros.get(linea) == null) {
                        numeros.put(linea, 1);
                        cantidadUnicaDePalabras++;
                    } else {
                        int contaux;
                        contaux = numeros.get(linea);
                        numeros.remove(linea);
                        numeros.put(linea, contaux + 1);
                    }
            }
        }
    }

    public HashMap<String, Integer> getTablaNumeros() {
        return numeros;
    }

    private void crearvec(){
        this.vectorPalabras=new Palabra[cantidadUnicaDePalabras];
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
        System.out.println("cantidad de palabras: "+ cantidadUnicaDePalabras +"\n");
        for(int i = 0; i< cantidadUnicaDePalabras; i++){
            System.out.println(vectorPalabras[i]+"\n");
        }
    }



}
