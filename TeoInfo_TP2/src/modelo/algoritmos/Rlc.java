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
    private int cantPal=0;
    private int cantFinal=0;
    private int tamanioEnBits =0;
    private FileReader fr = null;
    private BufferedReader br = null;
    PrintStream archivoSalida = null;
    private double entropia;
    HashMap<String,Integer> numeros;

    public Rlc(String nombreArch, HashMap<String,Integer> numeros,double entropia){
        this.entropia=entropia;
        this.numeros=numeros;
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
                            tamanioEnBits+=2*8;
                            cantFinal++;
                        }
                    }
                }
                this.cantPal++;
                System.out.print(cont + "" + ant);//codifico el ultimo elemento de la fila
                System.out.print(1 + "" + '\n');  //codifico el salto de linea
                ant = null;
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
                        tamanioEnBits+=(14+3);// 14 por la cantidad y 3 por el tamanio del numero (se eligio 12 por la cantidad de repeticiones del numero 6 es alta)
                        cantFinal++;
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

        return this.tamanioEnBits/(this.cantFinal+0.0);

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
            System.out.println("La tasa de compresion es de -> "+(this.cantPal*8)/(double)this.tamanioEnByts());
        }

}
