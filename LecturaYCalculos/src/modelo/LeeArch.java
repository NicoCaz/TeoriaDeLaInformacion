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
    private int largopalabra,cantPal;
    public static Double entropia;

    public LeeArch(int largopalabra) {
        super();
        this.largopalabra = largopalabra;
        this.palabra = new Palabra[(int) Math.pow(2, largopalabra)];
        this.cantPal=0;
    }

    private void crearvec() {
        for (int i = 0; i < (int) Math.pow(2, largopalabra); i++)
            this.palabra[i] = new Palabra();
    }

    public void leerarch() {
        entropia = 0.0;
        crearvec();

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
                this.cantPal++;
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
        Calculos.calculoCantInfoYEntropia(this.palabra, this.cantPal, this.largopalabra);
        System.out.println("La entropia de la fuente es: " + LeeArch.entropia);
    }
    public void longmMedia() {
        System.out.printf("long media:"+Calculos.calculoLongitudMedia(this.palabra,this.cantPal,this.largopalabra));
    }
    public void kraft(){
        System.out.println(Calculos.kraft(this.palabra,this.largopalabra));
    }
    public void muestravec() {
        for (int i = 0; i < (int) Math.pow(2, largopalabra); i++)
            System.out.println(this.palabra[i]);
    }

    public Palabra[] getPalabra() {
        return palabra;

    }


}

