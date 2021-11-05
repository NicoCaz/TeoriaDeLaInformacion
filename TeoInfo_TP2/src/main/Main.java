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
        Rlc codificacionRlc =new Rlc("Argentina.txt", lectura.getTablaNumeros(), lectura.getEntropia());
        ShannonFano codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras(), lectura.getEntropia());
        Huffman codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras(), lectura.getEntropia());

        codificacionRlc.comprimir("Argentina.txt");
        codificacionHuffman.comprimir("Argentina.txt");
        codificaShannonFano.comprimir("Argentina.txt");
        System.setOut(archivoSalida);
        codificacionHuffman.informe();
        codificaShannonFano.informe();
        codificacionRlc.informe();

        lectura=new LeeArch();
        lectura.lee("Aleman.txt");
        codificacionRlc =new Rlc("Aleman.txt", lectura.getTablaNumeros(), lectura.getEntropia());
        archivoSalida= new PrintStream(new FileOutputStream(ruta+"/informes/informe_Aleman.txt"));
        codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras(), lectura.getEntropia());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras(), lectura.getEntropia());
        codificacionRlc.comprimir("Aleman.txt");
        codificacionHuffman.comprimir("Aleman.txt");
        codificaShannonFano.comprimir("Aleman.txt");
        System.setOut(archivoSalida);
        codificacionHuffman.informe();
        codificaShannonFano.informe();
        codificacionRlc.informe();

        lectura=new LeeArch();
        lectura.lee("imagen.raw");
        codificacionRlc =new Rlc("imagen.raw", lectura.getTablaNumeros(), lectura.getEntropia());
        archivoSalida= new PrintStream(new FileOutputStream(ruta+"/informes/informe_imagen.txt"));
        codificaShannonFano =new ShannonFano(lectura.vectorPalabras(),lectura.cantPalabras(), lectura.getEntropia());
        codificacionHuffman=new Huffman(lectura.vectorPalabras(),lectura.cantPalabras(), lectura.getEntropia());

        codificacionRlc.comprimir("imagen.raw");
        codificacionHuffman.comprimir("imagen.raw");
        codificaShannonFano.comprimir("imagen.raw");
        System.setOut(archivoSalida);
        codificacionHuffman.informe();
        codificaShannonFano.informe();

        codificacionRlc.informe();


    }
}
