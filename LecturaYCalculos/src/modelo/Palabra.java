package modelo;

public class Palabra {
public String palabra;
public int repeticiones;
public Double cantInfo,entropia;

public Palabra() {
	super();
	this.palabra = null;
	this.repeticiones = 0;
	this.cantInfo = (double) 0;
	this.entropia =(double) 0;
}

@Override
public String toString() {
	return "Palabra [palabra=" + palabra + ", repeticiones=" + repeticiones + ", cantInfo=" + cantInfo + ", entropia="
			+ entropia + "]";
}


}

