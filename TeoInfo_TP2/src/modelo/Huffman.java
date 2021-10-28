package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Huffman {
    private HashMap<String, String>tabla=new HashMap<>();
    private NodoHuffman arbolDeHuffman=null;
    private ArrayList<NodoHuffman> nodosDeHuffman=new ArrayList<>();
    private Palabra[] vecPalabras;
    public Huffman(Palabra[] vecPalabra){
        this.vecPalabras=vecPalabra;
        for(Palabra palabra: vecPalabra){
            nodosDeHuffman.add(new NodoHuffman(palabra.palabra,palabra.repeticiones));
        }
        this.creoHuffman();

        generaTabla(arbolDeHuffman,"");


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


    public void muestroTabla(){
        for(Palabra palabra : vecPalabras){
            System.out.println(tabla.get(palabra.palabra));
        }

}




    class NodoHuffman implements Comparable<NodoHuffman>{
        int cant;
        String valor;
        NodoHuffman der;
        NodoHuffman izq;

        public NodoHuffman(String valor,int cant){
            this.cant=cant;
            this.valor=valor;
            this.der=null;
            this.izq=null;
        }
        public NodoHuffman(int cant,NodoHuffman izq,NodoHuffman der){
            this.cant=cant;
            this.valor="Nodo interno";
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
}
