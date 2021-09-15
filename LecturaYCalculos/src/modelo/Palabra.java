package modelo;

public class Palabra {
public String palabra;
public int repeticiones;
public float cantInfo,entropia;

public Palabra() {
	super();
	this.palabra = null;
	this.repeticiones = 0;
	this.cantInfo = 0;
	this.entropia = 0;
}

@Override
public String toString() {
	return "Palabra [palabra=" + palabra + ", repeticiones=" + repeticiones + ", cantInfo=" + cantInfo + ", entropia="
			+ entropia + "]";
}


}

