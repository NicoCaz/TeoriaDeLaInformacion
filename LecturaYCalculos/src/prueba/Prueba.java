package prueba;

import modelo.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Prueba {

	public static void main(String[] args) {
		System.out.println(	"Parte 1 Ejercicio a):");
		LeeArch lee=new LeeArch(9);
 
		lee.leerarch();
		lee.muestravec();
		System.out.println(	"Parte 1 Ejercicio b):");
		MatrizDePasaje m =new MatrizDePasaje();
		m.crearMatriz();
		System.out.println(	"Parte 1 Ejercicio c):");
		VectorEstacionario vec=new VectorEstacionario();
		System.out.println("Vector estacionario:"+vec.calculaVector(m.devuelveMat()));
		System.out.println(	"Parte 2 Ejercicio b):");
		System.out.println(	"Kraft");
		lee.kraft();
		System.out.println(	"Longitud media:");
		lee.longmMedia();

		System.out.println("\n\n\n");


		ShannonAfano afanado=new ShannonAfano(lee.getPalabra());
		System.out.println("\n\n\n\n\n");
		ShannonFano codificador=new ShannonFano(lee.getPalabra());

		Arrays.sort(lee.getPalabra());


		}


}
