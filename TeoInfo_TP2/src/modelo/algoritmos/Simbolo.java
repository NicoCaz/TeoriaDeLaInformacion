package modelo.algoritmos;

public class Simbolo implements Comparable<Simbolo> {
    private Character c;
    private double frecuencia;

    Simbolo(Character c, double freq) {
        this.c = c;
        this.frecuencia = freq;
    }

    public double getFrecuencia(){
        return this.frecuencia;
    }
    public Character getSimbolo(){
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
