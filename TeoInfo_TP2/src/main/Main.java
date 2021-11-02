package main;

import modelo.Huffman;
import modelo.LeeArch;
import modelo.RLC2;
import modelo.Rlc;
import modelo.ShannonFano;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;

import static Utilidades.Calculos.*;

public class Main {
    public static void main(String[] args) throws IOException {
      /*  LeeArch lectura=new LeeArch();
        Rlc codificacionRlc =new Rlc();

        lectura.lee("Argentina.txt");
        System.out.println();
        ShannonFano codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        Huffman codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("Argentina.txt",lectura.cantPalabras());
        lectura.muestra();
        System.out.println("'Argentina.txt' con shannon");

              System.out.println("Entropia del archivo: "+codificaShannonFano.getEntropia());
       System.out.println("rendimiento:"+rendimiento(codificaShannonFano.getLongMedia(), lectura.cantPalabras()));
       System.out.println("redundancia:"+redundancia(codificaShannonFano.getLongMedia(), lectura.cantPalabras()));

        System.out.println("'Argentina.txt' con huffman");
        System.out.println("Entropia del archivo: "+codificacionHuffman.getEntropia());
        System.out.println("rendimiento:"+rendimiento(codificacionHuffman.getLongMedia(), lectura.cantPalabras()));
        System.out.println("redundancia:"+redundancia(codificacionHuffman.getLongMedia(), lectura.cantPalabras()));



        lectura.lee("Aleman.txt");
        codificaShannonFano=new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("Aleman.txt",lectura.cantPalabras());
       // System.out.println("longitud media de 'Aleman.txt'");

        lectura.lee("imagen.raw");
        codificaShannonFano=new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("imagen.raw",lectura.cantPalabras());
       // System.out.println("longitud media de 'imagen.raw'");
        
        System.out.println("tabla de huffman: ");
        codificacionHuffman.muestroTabla();
       */
    	RLC2 rlc =new RLC2();
    	rlc.leearch("Argentina.txt");

    }
}
