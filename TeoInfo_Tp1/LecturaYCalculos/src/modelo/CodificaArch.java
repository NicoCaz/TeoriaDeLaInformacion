package modelo;

import java.io.*;
import java.util.HashMap;

public class CodificaArch {




    public CodificaArch(){

    }
    public void creaArch(HashMap<String,String> tabla,int largoPalabra) {
        FileReader fr=null;
        PrintWriter pw = null;
        try {
            String ruta;
            ruta = System.getProperty("user.dir");
            /////////////////////////////
            File archivoLectura = new File(ruta + "/anexo1.txt");
            fr= new FileReader(archivoLectura);
            BufferedReader br = new BufferedReader(fr, largoPalabra);
            /////////////////////////////
            FileWriter archivoSalida= new FileWriter(ruta+"/archCodificado"+String.valueOf(largoPalabra)+".txt");
            pw= new PrintWriter(archivoSalida);
            ////////////////////////////////////////////////
            String lineaStr, lineaBinaria;
            char[] linea = new char[largoPalabra];
            while ((br.read(linea, 0,largoPalabra)) != -1){
                lineaBinaria=String.valueOf(linea);
                pw.print(tabla.get(lineaBinaria));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (null != fr)
                    fr.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }try{
                if(pw!=null)
                    pw.close();
            }catch (Exception e3) {
                e3.printStackTrace();
            }
            System.out.println("archivo creado");
        }
    }
}
