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
        LeeArch lectura=new LeeArch();

        lectura.lee("Argentina.txt");
        Rlc codificacionRlc =new Rlc();
        ShannonFano codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        Huffman codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("Argentina.txt");
        codificacionHuffman.comprimir("Argentina.txt");
        codificaShannonFano.comprimir("Argentina.txt");
     /*   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        lectura.lee("Aleman.txt");
        codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("Aleman.txt");
        codificacionHuffman.comprimir("Aleman.txt");
        codificaShannonFano.comprimir("Aleman.txt");
      */  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        lectura.lee("imagen.raw");
        codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionRlc.comprimir("imagen.raw");
       // codificacionHuffman.comprimir("imagen.raw");
        //codificaShannonFano.comprimir("imagen.raw");

    }
}
