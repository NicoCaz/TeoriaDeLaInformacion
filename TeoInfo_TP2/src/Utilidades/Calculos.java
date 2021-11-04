package Utilidades;


import java.util.HashMap;

public class Calculos {

    public static double rendimiento( double entropia, double longMedia) {

        return entropia/longMedia;
    }
    public static double redundancia( double entropia, double longMedia) {
        return 1-entropia/longMedia;
    }
    public static Double logbase(double num, int base) {
        return (Math.log10(num) / Math.log10(base));
    }

    public static double entropia(HashMap<String,Integer> numeros,int cantidadTotal){
            return 0.0;
    }

}
