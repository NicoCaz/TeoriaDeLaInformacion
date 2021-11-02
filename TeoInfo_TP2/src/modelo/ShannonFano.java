package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static Utilidades.Calculos.logbase;

public class ShannonFano {
    public Double getEntropia() {
        return entropia;
    }


    public Double getLongMedia() {
        return longMedia;
    }



    HashMap<Character, String> tabla = new HashMap<Character, String>();
    private Double entropia=0.0;
    private Double longMedia=0.0;
    
    public ShannonFano(Palabra[] palabra,int cantPal) {

        Arrays.sort(palabra);
        ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
        int indice = 0;
        for (Palabra o : palabra) {

            simbolos.add(new Simbolo(o.palabra, o.repeticiones));
            this.tabla.put(o.palabra, "");
            indice++;
        }
        creoTabla(this.tabla, simbolos);
        double prob;
        
        for(int i=0;i<tabla.size();i++) {
            if(palabra[i].repeticiones!=0) {
                prob= palabra[i].repeticiones / (cantPal+0.0);
                longMedia+=prob*tabla.get(palabra[i].palabra).length();
                this.entropia+= prob*(logbase(1/prob,2));
            }
        }
        System.out.println("Tabla de Shannon");
        muestroTabla(palabra);
        
    }

    public HashMap<Character, String> getTablaCodificada() {
        return this.tabla;
    }

    private void creoTabla(HashMap<Character, String> tabla, List<Simbolo> simbolos) {

        if (simbolos.size() > 1) {
            int suma = 0;
            for (Simbolo s : simbolos) {
                suma += s.getFrecuencia();
            }
            int mitad = 0;
            int sumaAux = 0;
            double aux;
            Character simbolo;
            String acumula;
            for (Simbolo s : simbolos) {
                aux = s.getFrecuencia();
                simbolo = s.getSimbolo();
                if (simbolo == null)
                    simbolo=null;
                acumula = tabla.get(simbolo);
                if (sumaAux + aux < suma / 2) {//Todavia no me paso
                    tabla.put(simbolo, acumula + "0");
                    mitad++;
                    sumaAux += aux;
                } else {
                    if (Math.abs((suma / 2) - sumaAux) >= Math.abs((suma / 2) - (sumaAux + aux)) && aux != 0) {//me fijo si me paso por mucho o por poco
                        tabla.put(simbolo, acumula + "0");
                        mitad++;
                        sumaAux += aux;
                    } else {
                        tabla.put(simbolo, acumula + "1");
                    }
                }
            }
            if (mitad != 0) {
                List<Simbolo> superior;
                List<Simbolo> inferior;
                superior = simbolos.subList(0, mitad);
                creoTabla(tabla, superior);
                inferior = simbolos.subList(mitad, simbolos.size());
                creoTabla(tabla, inferior);
            }


        }
    }
    private void muestroTabla(Palabra palabra[]){
        for(int i=0;i<this.tabla.size();i++)
        	System.out.println(this.tabla.get(palabra[i].palabra));

}
}