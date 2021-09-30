package prueba;

import modelo.*;
import vista.Ventana;

import java.util.ArrayList;
import java.util.Arrays;

public class Prueba {

	public static void main(String[] args) {
		Ventana ventana =new Ventana();
		System.out.println(	"Parte 1 Ejercicio a):");
		LeeArch lee=new LeeArch(5);
 
		lee.leerarch();
		//lee.muestravec();
		Arrays.sort(lee.getPalabra());
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

		System.out.println("\n\n\n\n\n");
		ShannonFano shannonFano=new ShannonFano(lee.getPalabra());
		CodificaArch codificador=new CodificaArch();
		codificador.creaArch(shannonFano.getTablaCodificada(),5);

		}


}
