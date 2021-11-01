package main;

import modelo.Huffman;
import modelo.LeeArch;
import modelo.Rlc;
import modelo.ShannonFano;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;

import static Utilidades.Calculos.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LeeArch lectura=new LeeArch();
        Rlc codificacionRlc =new Rlc();

        lectura.lee("Argentina.txt");
        System.out.println();
        ShannonFano codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        Huffman codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("Argentina.txt");
        lectura.muestra();
        System.out.println("longitud media de 'Argentina.txt'");
        System.out.println(calculoLongitudMedia(lectura.vectorPalabras(), lectura.cantPalabras()));
        System.out.println("Entropia del archivo: "+codificaShannonFano.getEntropia());
        System.out.println("rendimiento:"+rendimiento(codificaShannonFano.getEntropia(),calculoLongitudMedia(lectura.vectorPalabras(), lectura.cantPalabras())));
        System.out.println("redundancia:"+redundancia(codificaShannonFano.getEntropia(),calculoLongitudMedia(lectura.vectorPalabras(), lectura.cantPalabras())));

        lectura.lee("Aleman.txt");
        codificaShannonFano=new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("Aleman.txt");
       // System.out.println("longitud media de 'Aleman.txt'");

        lectura.lee("imagen.raw");
        codificaShannonFano=new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("imagen.raw");
       // System.out.println("longitud media de 'imagen.raw'");

    }
}
