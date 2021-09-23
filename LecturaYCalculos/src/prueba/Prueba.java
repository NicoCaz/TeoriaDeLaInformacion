package prueba;

import modelo.LeeArch;
import modelo.MatrizDePasaje;
import modelo.VectorEstacionario;

import java.util.Arrays;

public class Prueba {

	public static void main(String[] args) {
		LeeArch lee=new LeeArch(7);
 
		lee.leerarch();
		lee.muestravec();
		
		MatrizDePasaje m =new MatrizDePasaje();
		m.crearMatriz();
		VectorEstacionario vec=new VectorEstacionario();
		System.out.println("Vector estacionario:"+vec.calculaVector(m.devuelveMat()));
		}

}
