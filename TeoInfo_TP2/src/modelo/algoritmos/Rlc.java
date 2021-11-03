package modelo.algoritmos;

import java.io.*;


public class Rlc implements ICodificadores{
    private File archivo = null;
    private Boolean esImagen;
    private int tamanioEnBits =0;
    private FileReader fr = null;
    private BufferedReader br = null;
    PrintStream archivoSalida = null;

    @Override
    public Double getEntropia() {
        return null;
    }

    @Override
    public Double getLongMedia() {
        if(this.esImagen)
            return 16.0;
        return 64.0;
    }

    @Override
    public int tamanioEnByts() {
        return this.tamanioEnBits;
    }

    public void comprimir(String nombreArch) throws IOException {
        int p = nombreArch.lastIndexOf('.');
        int cont=0,color = -1;
        Character ant = null;
        String ruta;
        this.esImagen=nombreArch.contains(".raw");
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
        if(!this.esImagen) {
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
                tamanioEnBits +=(linea.length()+1)*8;//+1 salto de linea y *8 por el tamanio de un char
            }
        }else{
            while ((linea = br.readLine()) != null) {
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
                tamanioEnBits+=(2*32);// 2 por la cantidad y 32 por el tamanio del unsigned int
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