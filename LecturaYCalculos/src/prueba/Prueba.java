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
		VectorEstacionario.Matriz mat2=new VectorEstacionario.Matriz(m.devuelveMat());

		System.out.println(VectorEstacionario.reglaDeCramer(mat2, Arrays.asList(0d, 0d, 0d, 1d)));

		}

}
