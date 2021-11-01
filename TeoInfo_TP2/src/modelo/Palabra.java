package modelo;

public class Palabra implements Comparable<Palabra>{
    public Character palabra;
    public int repeticiones;

    public Palabra(Character palabra) {
        super();
        this.palabra = palabra;
        this.repeticiones =0;
    }
    public Palabra(Character palabra,int repeticiones) {
        super();
        this.palabra = palabra;
        this.repeticiones =repeticiones;
    }
    @Override
    public String toString() {
        return "palabra=" + palabra + ",repeticiones=" + repeticiones ;
    }


    @Override
    public int compareTo(Palabra o) {
        if(this.repeticiones<o.repeticiones)
            return -1;
        if(this.repeticiones==o.repeticiones)
            return 0;
        return 1;

    }
}
