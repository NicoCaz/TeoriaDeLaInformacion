package modelo.algoritmos;

import modelo.Palabra;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static Utilidades.Calculos.logbase;


public class Huffman implements ICodificadores{
    private Double entropia=0.0;
    private Double longMedia=0.0;
    private HashMap<Character, String>tabla=new HashMap<>();
    private NodoHuffman arbolDeHuffman=null;
    private ArrayList<NodoHuffman> nodosDeHuffman=new ArrayList<>();
    private Palabra[] vecPalabras;
    private int cantidadDeByts=0;
    public Huffman(Palabra[] vecPalabra,int cantPal){
        this.vecPalabras=vecPalabra;
        for(Palabra palabra: vecPalabra){
            nodosDeHuffman.add(new NodoHuffman(palabra.palabra,palabra.repeticiones));
        }
        this.creoHuffman();

        generaTabla(arbolDeHuffman,"");
        double prob;
        for(int i=0;i<tabla.size();i++) {
            if(vecPalabra[i].repeticiones!=0) {
                prob= vecPalabra[i].repeticiones / (cantPal+0.0);
                longMedia+=prob*tabla.get(vecPalabra[i].palabra).length();
                this.entropia+= prob*(logbase(1/prob,2));
            }
        }

    }
    private void creoHuffman(){
        NodoHuffman aux1;
        NodoHuffman aux2;
        NodoHuffman nuevoNodo;

        int cant;
        if(nodosDeHuffman.size()==1){
            arbolDeHuffman=this.nodosDeHuffman.get(0);
        }else{
            aux1=this.nodosDeHuffman.get(0);
            aux2=this.nodosDeHuffman.get(1);
            cant= aux1.cant+aux2.cant;
            nuevoNodo=new NodoHuffman(cant,aux1,aux2);
            this.nodosDeHuffman.remove(0);
            this.nodosDeHuffman.remove(0);
            this.nodosDeHuffman.add(nuevoNodo);
            Collections.sort(nodosDeHuffman);
            creoHuffman();
        }


    }

    private void generaTabla(NodoHuffman nodo,String codigo){
        if(nodo.esHoja())
            this.tabla.put(nodo.valor,codigo);
        else
            if(nodo.izq!=null)
                generaTabla(nodo.izq,codigo+"0");
            if(nodo.der!=null)
                generaTabla(nodo.der,codigo+"1");
    }


    public void comprimir(String nombreArch) throws IOException {
        int p=nombreArch.lastIndexOf('.');
        String ruta = System.getProperty("user.dir");
        PrintStream archivoSalida = null;
        archivoSalida= new PrintStream(new FileOutputStream(ruta+"/archivosSalida/"+nombreArch.substring(0,p)+".Huf"));
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

        }
        archivoSalida.close();
    }





    class NodoHuffman implements Comparable<NodoHuffman>{
        int cant;
        Character valor;
        NodoHuffman der;
        NodoHuffman izq;

        public NodoHuffman(Character valor,int cant){
            this.cant=cant;
            this.valor=valor;
            this.der=null;
            this.izq=null;
        }
        public NodoHuffman(int cant,NodoHuffman izq,NodoHuffman der){
            this.cant=cant;
            this.valor=null;
            this.der=der;
            this.izq=izq;
        }
        public Boolean esHoja(){
            return (this.izq==null)&& (this.der==null);
        }

        @Override
        public int compareTo(NodoHuffman o) {
            if(this.cant<o.cant)
                return -1;
            if(this.cant==o.cant)
                return 0;
            return 1;
        }

        @Override
        public String toString() {
            return this.valor+" ";
        }
    }

    public Double getEntropia() {
        return entropia;
    }


    public Double getLongMedia() {
        return longMedia;
    }

    public int tamanioEnByts(){
        return this.cantidadDeByts;
    }

    public void muestroTabla(){
        for(Palabra palabra : vecPalabras){
            System.out.println(tabla.get(palabra.palabra));
        }

    }
}
