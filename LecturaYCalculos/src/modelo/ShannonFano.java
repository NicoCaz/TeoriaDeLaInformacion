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

    }

    private void creoTabla(HashMap<String,String> tabla, List<Simbolo> simbolos){

            if (simbolos.size()>1) {
                int suma = 0;
                for (Simbolo s : simbolos) {
                    suma += s.getFrecuencia();
                }
                int mitad = 0;
                int sumaAux = 0;
                double aux;
                String simbolo;
                String acumula;
                for (Simbolo s : simbolos) {
                    aux=s.getFrecuencia();
                    simbolo=s.getSimbolo();
                    if(simbolo==null)
                        simbolo="";
                    acumula=tabla.get(simbolo);
                    if(sumaAux +aux <=suma/2) {//Todavia no me paso
                        tabla.put(simbolo,  acumula+"0");
                        mitad++;
                        sumaAux += aux;
                    }else{
                        if(Math.abs((suma / 2) - sumaAux) > Math.abs((suma / 2) - (sumaAux + aux))){//me fijo si me paso por mucho o por poco
                            tabla.put(simbolo, acumula+"0");
                            mitad++;
                            sumaAux += aux;
                        }else{
                            tabla.put(simbolo, acumula+"1");
                        }
                    }
                }
                List<Simbolo> superior;
                List<Simbolo> inferior;
                superior=simbolos.subList(0, mitad);
                creoTabla(tabla, superior);
                inferior=simbolos.subList(mitad,simbolos.size());
                creoTabla(tabla, inferior);



            }
    }










}


/*
*  if (Math.abs((suma / 2) - sumaAux) < Math.abs((suma / 2) - (sumaAux - aux))) {
                            tabla.put(s.getSimbolo(), "1" + tabla.get(s.getSimbolo()));
                        }else {
*
* */