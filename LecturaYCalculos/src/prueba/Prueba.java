package prueba;

import modelo.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Prueba {

	public static void main(String[] args) {
		//primer txt
		System.out.println(	"Parte 1 Ejercicio a):");
		System.out.println("Escenario 1: Palabras código de 5 dígitos.");
		LeeArch lee=new LeeArch(5);
		lee.leerarch();
		lee.muestravec();
		System.out.println("Escenario 1: Palabras código de 7 dígitos.");
		LeeArch lee2=new LeeArch(7);
		lee2.leerarch();
		lee2.muestravec();
		System.out.println("Escenario 1: Palabras código de 9 dígitos.");
		LeeArch lee3=new LeeArch(9);
		lee3.leerarch();
		lee3.muestravec();
		//hasta aca primer txt
		
		
		//segundo txt
		
		System.out.println(	"Parte 1 Ejercicio b):");
		MatrizDePasaje m =new MatrizDePasaje();
		m.crearMatriz();
		LeeArch leeB=new LeeArch(2);
		leeB.leerarch();
		//leeB.muestraEntropia();
		//tercer txt
		System.out.println(	"Parte 1 Ejercicio c):");
		VectorEstacionario vec=new VectorEstacionario();
		System.out.println("Vector estacionario:"+vec.calculaVector(m.devuelveMat()));
		//cuarto txt
		System.out.println(	"Parte 2 Ejercicio b):");
		System.out.println(	"Kraft");
		lee.kraft();
		System.out.println(	"Longitud media:");
		lee.longmMedia();
		//quinto txt
		System.out.println("Escenario 1: ");
		lee.rendimiento();
		lee.redundancia();
		System.out.println("Escenario 2: ");
		lee2.rendimiento();
		lee2.redundancia();
		System.out.println("Escenario 3: ");
		lee3.rendimiento();
		lee3.redundancia();
		System.out.println("\n\n\n");
		// los ultimos 3 txt
		Arrays.sort(lee.getPalabra());
		Arrays.sort(lee2.getPalabra());
		Arrays.sort(lee3.getPalabra());
		
/*
		System.out.println("\n\n\n\n\n");
		ShannonFano shannonFano=new ShannonFano(lee.getPalabra());
		CodificaArch codificador=new CodificaArch();
		codificador.creaArch(shannonFano.getTablaCodificada(),9);*/

		}


}
