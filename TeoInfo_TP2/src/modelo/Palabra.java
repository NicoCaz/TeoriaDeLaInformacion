package modelo;

public class Palabra implements Comparable<Palabra>{
    public String palabra;
    public int repeticiones;

    public Palabra(String palabra) {
        super();
        this.palabra = palabra;
        this.repeticiones =0;
    }
    public Palabra(String palabra,int repeticiones) {
        super();
        this.palabra = palabra;
        this.repeticiones =repeticiones;
    }
    @Override
    public String toString() {
        return "palabra=" + palabra + ", repeticiones=" + repeticiones ;
    }


    @Override
    public int compareTo(Palabra o) {
        if(this.palabra==null)
            return 1;
        if(this.palabra.equals(o.palabra))
            return 0;
        if(this.repeticiones < o.repeticiones)
            return 1;
        return -1;

    }
}
