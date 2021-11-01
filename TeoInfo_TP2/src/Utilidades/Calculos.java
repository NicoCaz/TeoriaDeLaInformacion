package Utilidades;


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

}
