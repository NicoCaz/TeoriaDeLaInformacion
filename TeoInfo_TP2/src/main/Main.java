package main;

import modelo.algoritmos.Huffman;
import modelo.LeeArch;
import modelo.algoritmos.Rlc;
import modelo.algoritmos.ShannonFano;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        LeeArch lectura=new LeeArch();
        String ruta = System.getProperty("user.dir");
        PrintStream archivoSalida= new PrintStream(new FileOutputStream(ruta+"/informes/informe_Argentina.txt"));

        lectura.lee("Argentina.txt");
        Rlc codificacionRlc =new Rlc();
        ShannonFano codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        Huffman codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras(),"TEXT");
        codificacionRlc.comprimir("Argentina.txt");
        codificacionHuffman.comprimir("Argentina.txt");
        codificaShannonFano.comprimir("Argentina.txt");
        System.setOut(archivoSalida);
        codificacionHuffman.informe();


        lectura.lee("Aleman.txt");
        codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras(),"TEXT");
        codificacionRlc.comprimir("Aleman.txt");
        codificacionHuffman.comprimir("Aleman.txt");
        codificaShannonFano.comprimir("Aleman.txt");



        lectura.lee("imagen.raw");
        codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras(),"NUM");
        codificacionRlc.comprimir("imagen.raw");
       // codificacionHuffman.comprimir("imagen.raw");
        //codificaShannonFano.comprimir("imagen.raw");

    }
}
