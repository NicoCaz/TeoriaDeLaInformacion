package prueba;

import modelo.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Prueba {

	public static void main(String[] args) {
		//primer txt
		PrintStream archivoSalida = null;
		try {
			archivoSalida = new PrintStream(new FileOutputStream("resultados_primera_parte_1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assert archivoSalida != null;
		System.setOut(archivoSalida);
		System.out.println(	"Parte 1 Ejercicio a):");
		System.out.println("Escenario 1: Palabras c�digo de 5 d�gitos.");
		LeeArch lee=new LeeArch(5);
		lee.leerarch();
		lee.muestravec();
		System.out.println("Escenario 1: Palabras c�digo de 7 d�gitos.");
		LeeArch lee2=new LeeArch(7);
		lee2.leerarch();
		lee2.muestravec();
		System.out.println("Escenario 1: Palabras c�digo de 9 d�gitos.");
		LeeArch lee3=new LeeArch(9);
		lee3.leerarch();
		lee3.muestravec();
		try {
			archivoSalida.close();
		}catch(Exception e){
			e.printStackTrace();
		}//hasta aca primer txt


		//segundo txt
		try {
			archivoSalida = new PrintStream(new FileOutputStream("resultados_primera_parte_2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(archivoSalida);
		System.out.println(	"Parte 1 Ejercicio b):");
		MatrizDePasaje m =new MatrizDePasaje();
		m.crearMatriz();
		LeeArch leeB=new LeeArch(2);
		leeB.leerarch();
		try {
			archivoSalida.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//tercer txt
		try {
			archivoSalida = new PrintStream(new FileOutputStream("resultados_primera_parte_3.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(archivoSalida);
		System.out.println(	"Parte 1 Ejercicio c):");
		VectorEstacionario vec=new VectorEstacionario();
		System.out.println("Vector estacionario:"+vec.calculaVector(m.devuelveMat()));
		try {
			archivoSalida.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {//cuarto txt
			archivoSalida = new PrintStream(new FileOutputStream("resultados_segunda_parte_1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(archivoSalida);

		System.out.println(	"Parte 2 Ejercicio b):");
		System.out.println("Escenario 1");
		System.out.println(	"Kraft");
		lee.kraft();
		System.out.println(	"Longitud media:");
		lee.longmMedia();
		System.out.println("Escenario 2");
		lee2.kraft();
		System.out.println(	"Longitud media:");
		lee2.longmMedia();
		System.out.println("Escenario 3");
		lee3.kraft();
		System.out.println(	"Longitud media:");
		lee3.longmMedia();
		
		
		try {
			archivoSalida.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//quinto txt
		try {//cuarto txt
			archivoSalida = new PrintStream(new FileOutputStream("resultados_segunda_parte_2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(archivoSalida);
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
		try {
			archivoSalida.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		// los ultimos 3 txt
		//cuarto txt

		System.setOut(archivoSalida);
		Arrays.sort(lee.getPalabra());
		Arrays.sort(lee2.getPalabra());
		Arrays.sort(lee3.getPalabra());


		ShannonFano shannonFano=new ShannonFano(lee.getPalabra());
		CodificaArch codificador=new CodificaArch();
		codificador.creaArch(shannonFano.getTablaCodificada(),5);
		shannonFano=new ShannonFano(lee2.getPalabra());
		codificador.creaArch(shannonFano.getTablaCodificada(),7);
		shannonFano=new ShannonFano(lee3.getPalabra());
		codificador.creaArch(shannonFano.getTablaCodificada(),9);

		}


}
