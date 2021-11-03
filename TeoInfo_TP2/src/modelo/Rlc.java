package modelo;

import java.io.*;


public class Rlc {
    private final Double entropia = 0.0;
    private final Double longMedia = 0.0;
    private File archivo = null;
    private int cantidad=0;
    private FileReader fr = null;
    private BufferedReader br = null;
    PrintStream archivoSalida = null;

    public void comprimir(String nombreArch) throws IOException {
        int p = nombreArch.lastIndexOf('.');
        int cont=0,color = -1;
        Character ant = null;
        String ruta;
        Boolean esImagen=nombreArch.contains(".raw");
        ruta = System.getProperty("user.dir");
        try {
            archivoSalida = new PrintStream(new FileOutputStream(ruta + "/archivosSalida/" + nombreArch.substring(0, p) + ".RLC"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(archivoSalida);
        archivo = new File(ruta + "/archivosEntrada/" + nombreArch);
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(fr);
        String linea = null;
        if(!esImagen) {
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (ant == null) {
                        cont = 1;
                        ant = linea.charAt(i);
                    } else {
                        if (ant.equals(linea.charAt(i))) {
                            cont++;
                        } else {
                            System.out.print(cont + "" + ant);
                            cont = 1;
                            ant = linea.charAt(i);
                        }
                    }
                }
                System.out.print(cont + "" + ant);
                System.out.print(1 + "" + '\n');
                ant = null;
                cantidad+=linea.length();
            }
        }else{
            while ((linea = br.readLine()) != null) {
                cantidad++;
                if (color ==-1){
                    cont=1;
                    color=Integer.parseInt(linea);
                }else{
                    if(color==Integer.parseInt(linea)){
                        cont++;
                    }else {
                        System.out.print(cont+""+color);
                        cont=1;
                        color=Integer.parseInt(linea);
                    }
                }
            }
            System.out.print(cont+""+color);
        }

        try {
          archivoSalida.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

