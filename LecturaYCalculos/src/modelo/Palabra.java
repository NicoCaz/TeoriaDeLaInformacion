package modelo;

public class Palabra implements Comparable<Palabra>{
public String palabra;
public int repeticiones;
public Double cantInfo;

public Palabra() {
	super();
	this.palabra = null;
	this.repeticiones = 0;
	this.cantInfo =  0.0;

}

@Override
public String toString() {
	return "Palabra [palabra=" + palabra + ", repeticiones=" + repeticiones + ", cantInfo=" + cantInfo + " ]";
}


	@Override
	public int compareTo(Palabra o) {
		if(this.palabra.equals(o.palabra))
			return 0;
		if(this.repeticiones < o.repeticiones)
			return 1;
		return -1;

	}
}

