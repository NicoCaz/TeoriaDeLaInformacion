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
    }
    private void creoTabla(HashMap<String,String> tabla, List<Simbolo> simbolos){
        if(simbolos.size()>1){
            int suma=0;
            for(Simbolo s :simbolos){
                suma+=s.getFrecuencia();
            }
            int mitad=0;
            int sumaAux=0;
            for(Simbolo s :simbolos){
                if(sumaAux<suma/2) {
                    tabla.put(s.getSimbolo(), "1" + tabla.get(s.getSimbolo()));
                    mitad++;
                    sumaAux+=s.getFrecuencia();
                }else {
                    tabla.put(s.getSimbolo(), "0" + tabla.get(s.getSimbolo()));
                }
            }
            creoTabla(tabla,simbolos.subList(0,mitad));
            creoTabla(tabla,simbolos.subList(mitad+1,simbolos.size()));
        }

    }


}
