package modelo;


public class Simbolo implements Comparable<Simbolo> {
    private String c;
    private double frecuencia;

    Simbolo(String c, double freq) {
        this.c = c;
        this.frecuencia = freq;
    }

    public double getFrecuencia(){
        return this.frecuencia;
    }
    public String getSimbolo(){
        return  this.c;
    }

    @Override
    public int compareTo(Simbolo s) {
        if(this.equals(s))
            return 0;
        if(this.frecuencia- s.frecuencia>0)
            return  1 ;
        return -1;
    }
}
