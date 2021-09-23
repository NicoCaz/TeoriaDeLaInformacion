package modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VectorEstacionario {



    public List<Double> calculaVector(Double[][] mat) {
        Matriz matrizAux= new Matriz(mat);
        double denominator = matrizAux.determinante();
        List<Double> b = Arrays.asList(0d, 0d, 0d, 1d);
        List<Double> result = new ArrayList<>();
        for ( int i = 0 ; i < b.size() ; i++ ) {
            result.add(matrizAux.cambiaColumna(b, i).determinante() / denominator);
        }
        return result;
    }

    static class Matriz {

        private List<List<Double>> matriz;

        public Matriz(List<List<Double>> mat) {
            matriz = mat;
        }

        public Matriz(Double [][] mat){
            List<Double> aux;
            matriz=new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                mat[i][i]+=-1.0;
            }
            for(int i=0;i<mat.length-1;i++){
                aux=new ArrayList<>();
                for (Double[] doubles : mat) {
                    aux.add(doubles[i]);
                }
                matriz.add(aux);
            }
            aux=new ArrayList<>();
            for(int j=0;j<mat.length;j++){
                aux.add(1.0);
            }
            matriz.add(aux);
        }
        public double determinante() {
            double suma = 0;
            double signo = 1;
            if ( matriz.size() == 1 ) {
                return get(0, 0);
            }
            if ( matriz.size() == 2 ) {
                return get(0, 0) * get(1, 1) - get(0, 1) * get(1, 0);
            }
            for ( int i = 0 ; i < matriz.size() ; i++ ) {
                suma += signo * get(0, i) * coFactor(0, i).determinante();
                signo *= -1;
            }
            return suma;
        }

        private Matriz coFactor(int fila, int columna) {
            List<List<Double>> mat = new ArrayList<>();
            for ( int i = 0 ; i < matriz.size() ; i++ ) {
                if ( i != fila ) {
                    List<Double> list = new ArrayList<>();
                    for ( int j = 0 ; j < matriz.size() ; j++ ) {
                        if ( j != columna ) {
                        list.add(get(i, j));
                        }
                    }
                    mat.add(list);
                }
            }
            return new Matriz(mat);
        }

        protected Matriz cambiaColumna(List<Double> b, int columna) {
            List<List<Double>> mat = new ArrayList<>();
            for ( int fila = 0 ; fila < matriz.size() ; fila++ ) {
                List<Double> lista = new ArrayList<>();
                for ( int col = 0 ; col < matriz.size() ; col++ ) {
                    double value = get(fila, col);
                    if ( col == columna ) {
                        value = b.get(fila);
                    }
                    lista.add(value);
                }
                mat.add(lista);
            }
            return new Matriz(mat);
        }
        private double get(int fil, int col) {
            return matriz.get(fil).get(col);
        }
    }
}