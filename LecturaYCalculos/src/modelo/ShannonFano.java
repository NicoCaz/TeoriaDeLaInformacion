package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class ShannonFano {

    public ShannonFano(Palabra[] palabra){
        Arrays.sort(palabra);
        ArrayList<Simbolo> simbolos=new ArrayList<Simbolo>();
        HashMap<String,String> tabla=new HashMap<String,String>();
        for(Palabra o:palabra){
            simbolos.add(new Simbolo(o.palabra,o.repeticiones));
            tabla.put(o.palabra,"");
        }
        creoTabla(tabla,simbolos);
        for(Palabra o:palabra){
            System.out.println(tabla.get(o.palabra));
        }
       // tabla.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
    }
    private void creoTabla(HashMap<String,String> tabla, List<Simbolo> simbolos){

            if (simbolos.size() > 0) {
                int suma = 0;
                for (Simbolo s : simbolos) {
                    suma += s.getFrecuencia();
                }
                int mitad = 0;
                int sumaAux = 0;
                double aux = 0;
                for (Simbolo s : simbolos) {
                    if (sumaAux < suma / 2) {
                        tabla.put(s.getSimbolo(),  tabla.get(s.getSimbolo() )+"0");
                        aux = s.getFrecuencia();
                        mitad++;
                        sumaAux += s.getFrecuencia();
                    } else {
                            tabla.put(s.getSimbolo(),  tabla.get(s.getSimbolo())+"1");
                    }
                }if(mitad!=1) {
                    creoTabla(tabla, simbolos.subList(0, mitad));
                    creoTabla(tabla, simbolos.subList(mitad , simbolos.size()));
                }
            }
        }




}


/*
*  if (Math.abs((suma / 2) - sumaAux) < Math.abs((suma / 2) - (sumaAux - aux))) {
                            tabla.put(s.getSimbolo(), "1" + tabla.get(s.getSimbolo()));
                        }else {
*
* */