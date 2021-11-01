package Utilidades;

import modelo.LeeArch;
import modelo.Palabra;

public class Calculos {
    public static double calculoLongitudMedia(Palabra[] palabra, int cantPal){
        double prob,lon=0;
        LeeArch.entropia=0.0;

        for(int i=0;i<palabra.length;i++) {
            if(palabra[i].repeticiones!=0) {
                prob= palabra[i].repeticiones / (cantPal+0.0);
                lon+=prob*palabra[i].palabra.length();
                LeeArch.entropia+= prob*(-logbase(prob,2));
            }

        }
        return lon;

    }
    public static double rendimiento(double entropia, double longMedia) {
        return entropia/longMedia;
    }
    public static double redundancia(double entropia, double longMedia) {
        return 1-entropia/longMedia;
    }
    public static Double logbase(double num, int base) {
        return (Math.log10(num) / Math.log10(base));
    }

}
