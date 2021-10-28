package main;

import modelo.LeeArch;
import modelo.ShannonFano;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LeeArch lectura=new LeeArch();
        lectura.lee("Argentina.txt");
        ShannonFano codifica =new ShannonFano(lectura.vectorPalabras());
    }
}
