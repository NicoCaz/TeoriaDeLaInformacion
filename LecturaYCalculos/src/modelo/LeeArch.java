package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import util.Calculos;


public class LeeArch {

    private Palabra[] palabra;
    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private int largopalabra;
    public static Double entropia;

    public LeeArch(int largopalabra) {
        super();
        this.largopalabra = largopalabra;
        this.palabra = new Palabra[(int) Math.pow(2, largopalabra)];
    }

    private void crearvec() {
        for (int i = 0; i < (int) Math.pow(2, largopalabra); i++)
            this.palabra[i] = new Palabra();
    }

    public void leerarch() {
        entropia = 0.0;
        crearvec();
        int cantidadPalabras = 0;
        try {
            String ruta;
            ruta = System.getProperty("user.dir");
            archivo = new File(ruta + "/anexo1.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr, this.largopalabra);
            String ant = null;
            String lineaStr, lineaBinaria;
            char[] linea = new char[this.largopalabra];
            while ((br.read(linea, 0, this.largopalabra)) != -1) { //mientras leo convierto y actualizo
                lineaBinaria = String.valueOf(linea);
                lineaStr = String.valueOf(linea);
                int indice = Integer.parseInt(lineaStr, 2);
                this.palabra[indice].palabra = lineaBinaria;
                this.palabra[indice].repeticiones++;
                cantidadPalabras++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr)
                    fr.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Calculos.calculoCantInfoYEntropia(this.palabra, cantidadPalabras, this.largopalabra);
        System.out.println("La entropia de la fuente es: " + LeeArch.entropia);
    }

    public void muestravec() {
        for (int i = 0; i < (int) Math.pow(2, largopalabra); i++)
            System.out.println(this.palabra[i]);
    }

}

