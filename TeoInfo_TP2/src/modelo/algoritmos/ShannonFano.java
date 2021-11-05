package modelo.algoritmos;

import modelo.Palabra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static Utilidades.Calculos.*;

public class ShannonFano implements ICodificadores, IInforme {
    private int cantPal;
    HashMap<Character, String> tabla = new HashMap<Character, String>();
    private Double entropia=0.0;
    private Double longMedia=0.0;
    private int cantidadDeByts=0;
    private Palabra[] palabra;
    
    public ShannonFano(Palabra[] palabra, int cantPal,double entropia) {
        this.entropia=entropia;
        this.cantPal=cantPal;
        this.palabra=palabra;
        Arrays.sort(palabra);
        ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
        for (Palabra o : palabra) {
            simbolos.add(new Simbolo(o.palabra, o.repeticiones));
            this.tabla.put(o.palabra, "");
        }
        creoTabla(this.tabla, simbolos);
        double prob;
        for(int i=0;i<tabla.size();i++) {
            if(palabra[i].repeticiones!=0) {
                prob= palabra[i].repeticiones / (cantPal+0.0);
                this.longMedia+=prob*tabla.get(palabra[i].palabra).length();
            }
        }
    }

    private void creoTabla(HashMap<Character, String> tabla, List<Simbolo> simbolos) {
        if (simbolos.size() > 1) {
            int suma = 0;
            for (Simbolo s : simbolos) {
                suma += s.getFrecuencia();
            }
            int mitad = 0;
            int sumaAux = 0;
            double aux;
            Character simbolo;
            String acumula;
            for (Simbolo s : simbolos) {
                aux = s.getFrecuencia();
                simbolo = s.getSimbolo();
                if (simbolo == null)
                    simbolo=null;
                acumula = tabla.get(simbolo);
                if (sumaAux + aux < suma / 2) {//Todavia no me paso
                    tabla.put(simbolo, acumula + "0");
                    mitad++;
                    sumaAux += aux;
                } else {
                    if (Math.abs((suma / 2) - sumaAux) >= Math.abs((suma / 2) - (sumaAux + aux)) && aux != 0) {//me fijo si me paso por mucho o por poco
                        tabla.put(simbolo, acumula + "0");
                        mitad++;
                        sumaAux += aux;
                    } else {
                        tabla.put(simbolo, acumula + "1");
                    }
                }
            }
            if (mitad != 0) {
                List<Simbolo> superior;
                List<Simbolo> inferior;
                superior = simbolos.subList(0, mitad);
                creoTabla(tabla, superior);
                inferior = simbolos.subList(mitad, simbolos.size());
                creoTabla(tabla, inferior);
            }


        }
    }


    public void comprimir(String nombreArch) throws IOException {
        int p=nombreArch.lastIndexOf('.');
        String ruta = System.getProperty("user.dir");
        PrintStream archivoSalida = null;
        archivoSalida= new PrintStream(new FileOutputStream(ruta+"/archivosSalida/"+nombreArch.substring(0,p)+".Fan"));
        System.setOut(archivoSalida);
        File archivo = new File(ruta + "/archivosEntrada/" + nombreArch);
        FileReader fr=new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine() )!= null){
            for(int i=0;i<linea.length();i++){
                System.out.print(tabla.get(linea.charAt(i)));
                this.cantidadDeByts+=tabla.get(linea.charAt(i)).length();
            }
            System.out.print(tabla.get('\n'));
            this.cantidadDeByts+=tabla.get('\n').length();

        }
        archivoSalida.close();
    }
    private void muestroTabla(Palabra palabra[]){
        for(int i=0;i<this.tabla.size();i++)
            System.out.println("Palabra: "+palabra[i].palabra+ " simbolo  "+this.tabla.get(palabra[i].palabra));

    }

    public int tamanioEnByts(){
        return this.cantidadDeByts;
    }

    public Double getEntropia() {
        return entropia;
    }

    public double getLongMedia() {
        return longMedia;
    }

    @Override
    public void informe() {
        System.out.println("\n----------------Shannon Fano----------------");
        System.out.println("Rendimiento -> "+rendimiento(getEntropia(),getLongMedia()));
        System.out.println("Redundancia -> "+redundancia(getEntropia(),getLongMedia()));
        System.out.println("Longitud media expresada en Bits-> "+ getLongMedia());
        System.out.println("Entropia -> "+getEntropia());
        System.out.println("La tasa de comprecion es de -> "+(this.cantPal*8)/(double)this.tamanioEnByts() );
        System.out.println("Tabla de shannon");


    }
}