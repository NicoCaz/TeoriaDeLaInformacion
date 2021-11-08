package modelo.algoritmos;

import Utilidades.Calculos;
import modelo.Palabra;

import java.io.*;
import java.util.HashMap;

import static Utilidades.Calculos.redundancia;
import static Utilidades.Calculos.rendimiento;


public class Rlc implements ICodificadores, IInforme{
    private File archivo = null;
    private Boolean esImagen;
    private String tipoArch;
    private int cantPal=0;
    private int tamanioEnBits =0;
    private FileReader fr = null;
    private BufferedReader br = null;
    PrintStream archivoSalida = null;
    private Palabra[] simbolos;
    private double entropia;
    HashMap<String,Integer> numeros;

    public Rlc(String nombreArch, HashMap<String,Integer> numeros,double entropia){
        this.entropia=entropia;
        this.numeros=numeros;
        if(nombreArch.contains(".txt"))
            this.tipoArch="TEXT";
        else {
            this.tipoArch="NUM";
        }
        try {
            this.comprimir(nombreArch);
        } catch (IOException e) {
            System.out.println("imposible comprimir archivo!!!! ("+nombreArch+")");
        }

    }


    public void comprimir(String nombreArch) throws IOException {
        int p = nombreArch.lastIndexOf('.');
        int cont=0,color = -1;
        Character ant = null;
        String ruta;
        this.esImagen=nombreArch.contains(".raw");
        ruta = System.getProperty("user.dir");
        try {
            archivoSalida = new PrintStream(new FileOutputStream(ruta + "/archivosSalida/" + nombreArch.substring(0, p) + ".RLC"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(archivoSalida);
        archivo = new File(ruta + "/archivosEntrada/" + nombreArch);
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(fr);
        String linea = null;
        if(!this.esImagen) {
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    this.cantPal++;
                    if (ant == null) {
                        cont = 1;
                        ant = linea.charAt(i);
                    } else {
                        if (ant.equals(linea.charAt(i))) {
                            cont++;
                        } else {
                            System.out.print(cont + "" + ant);
                            cont = 1;
                            ant = linea.charAt(i);
                        }
                    }
                }
                this.cantPal++;
                System.out.print(cont + "" + ant);
                System.out.print(1 + "" + '\n');
                ant = null;
                tamanioEnBits +=(linea.length()+1)*8;//+1 salto de linea y *8 por el tamanio de un char
            }
        }else{
        	linea = br.readLine();
        	linea = br.readLine();//salteo las dos lineas de resolucion
            while ((linea = br.readLine()) != null) {
                this.cantPal++;
                if (color ==-1){
                    cont=1;
                    color=Integer.parseInt(linea);
                }else{
                    if(color==Integer.parseInt(linea)){
                        cont++;
                    }else {
                        System.out.print(cont+""+color);
                        cont=1;
                        color=Integer.parseInt(linea);
                        tamanioEnBits+=(12+8);// 12 por la cantidad y 8 por el tamanio del numero (se eligio 12 por la cantidad de repeticiones del numero 6 es alta
                    }
                }
            }
            System.out.print(cont+""+color);
        }
        try {
          archivoSalida.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Double getEntropia() {
        return this.entropia;
    }

    @Override
    public double getLongMedia() {
        if(!this.esImagen)
            return 16.0;
        return 20;
    }

    @Override
    public int tamanioEnByts() {
        return this.tamanioEnBits;
    }

    @Override
    public void informe() {
            System.out.println("\n----------------R.L.C----------------");
            System.out.println("Rendimiento -> "+rendimiento(getEntropia(),getLongMedia()));
            System.out.println("Redundancia -> "+redundancia(getEntropia(),getLongMedia()));
            System.out.println("Longitud media expresada en Bits-> "+ getLongMedia());
            System.out.println("Entropia -> "+getEntropia());
            System.out.println("La tasa de comprecion es de -> "+(this.cantPal*8)/(double)this.tamanioEnByts());
        }

}
