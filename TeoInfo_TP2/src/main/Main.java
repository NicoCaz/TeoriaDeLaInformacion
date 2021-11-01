package main;

import modelo.Huffman;
import modelo.LeeArch;
import modelo.Rlc;
import modelo.ShannonFano;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LeeArch lectura=new LeeArch();
        Rlc codificacionRlc =new Rlc();

        lectura.lee("Argentina.txt");
        ShannonFano codificaShannonFano =new ShannonFano(lectura.vectorPalabras());
        Huffman codificacionHuffman=new Huffman(lectura.vectorPalabras());
        codificacionRlc.comprimir("Argentina.txt");

        lectura.lee("Aleman.txt");
        codificaShannonFano=new ShannonFano(lectura.vectorPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras());
        codificacionRlc.comprimir("Aleman.txt");

        lectura.lee("imagen.raw");
        codificaShannonFano=new ShannonFano(lectura.vectorPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras());
        codificacionRlc.comprimir("imagen.raw");

    }
}
