package modelo;

import java.util.*;


public class ShannonFano {

    public ShannonFano(Palabra[] palabra){
        Arrays.sort(palabra);
        ArrayList<Simbolo> simbolos=new ArrayList<Simbolo>();
        HashMap<String,String> tabla=new HashMap<String,String>();
        int indice=0;
        for(Palabra o:palabra){
            if(Objects.equals(o.palabra, "")){
                simbolos.add(new Simbolo( String.valueOf(indice),o.repeticiones));
            }
            simbolos.add(new Simbolo(o.palabra,o.repeticiones));
            tabla.put(o.palabra,"");
            indice++;
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
                    if(sumaAux +aux <suma/2) {//Todavia no me paso
                        tabla.put(simbolo,  acumula+"0");
                        mitad++;
                        sumaAux += aux;
                    }else{
                        if(Math.abs((suma / 2) - sumaAux) >= Math.abs((suma / 2) - (sumaAux + aux)) && aux!=0    ){//me fijo si me paso por mucho o por poco
                            tabla.put(simbolo, acumula+"0");
                            mitad++;
                            sumaAux += aux;
                        }else{
                            tabla.put(simbolo, acumula+"1");
                        }
                    }
                }if(mitad!=0) {
                    List<Simbolo> superior;
                    List<Simbolo> inferior;
                    superior = simbolos.subList(0, mitad);
                    creoTabla(tabla, superior);
                    inferior = simbolos.subList(mitad, simbolos.size());
                    creoTabla(tabla, inferior);
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