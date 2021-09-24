package modelo;


public class Simbolo implements Comparable<Simbolo> {
    private char c;
    private double frecuencia;

    Simbolo(char c, double freq) {
        this.c = c;
        this.frecuencia = freq;
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
