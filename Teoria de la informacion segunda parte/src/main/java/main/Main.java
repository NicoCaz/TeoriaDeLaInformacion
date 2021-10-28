package main;

import modelo.LeeArch;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LeeArch lectura=new LeeArch();
        lectura.lee("Argentina.txt");
        lectura.muestra();
    }
}
