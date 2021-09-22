package modelo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VectorEstacionario {

    public static void main(String[] args) {
        Matriz mat = new Matriz(
                Arrays.asList(-0.743243d, 0.249498d, 0.251405d,  0.257328d),
                Arrays.asList(0.254254d, -0.741717d,  0.247062d, 0.25214d),
                Arrays.asList(0.254254d,  0.247239d, -0.752683d,  0.245136d),
                Arrays.asList(1d, 1d, 1d, 1d));


       /* LeeArch lee=new LeeArch(7);

        lee.leerarch();
        lee.muestravec();

        MatrizDePasaje m =new MatrizDePasaje();
        m.crearMatriz();

        Matriz mat =new Matriz(m.devuelveMat());
        */
        List<Double> b = Arrays.asList(0d, 0d, 0d, 1d);

        System.out.println("Solucion = " + reglaDeCramer(mat, b));
    }

    public static List<Double> reglaDeCramer(Matriz matriz, List<Double> b) {
        double denominator = matriz.determinante();
        List<Double> result = new ArrayList<>();
        for ( int i = 0 ; i < b.size() ; i++ ) {
            result.add(matriz.replaceColumn(b, i).determinante() / denominator);
        }
        return result;
    }

    public static class Matriz {

        public Matriz(Double [][] mat){
            List<Double> aux;
            matriz=new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                mat[i][i]+=-1.0;
            }

            for(int i=0;i<mat.length-1;i++){
                aux=new ArrayList<>();
                for(int j=0;j<mat.length;j++) {
                    aux.add( mat[i][j]);
                }
                matriz.add(aux);
            }
            aux=new ArrayList<>();
            for(int j=0;j<mat.length;j++){
                aux.add(1.0);
            }
            matriz.add(aux);
        }


        private List<List<Double>> matriz;

        @Override
        public String toString() {
            return matriz.toString();
        }


        @SafeVarargs
        public Matriz(List<Double> ... lists) {
            matriz = new ArrayList<>();
            matriz.addAll(Arrays.asList(lists));
        }

        public Matriz(List<List<Double>> mat) {
            matriz = mat;
        }

        public double determinante() {
            double sum = 0;
            double sign = 1;
            if ( matriz.size() == 1 ) {
                return get(0, 0);
            }
            if ( matriz.size() == 2 ) {
                return get(0, 0) * get(1, 1) - get(0, 1) * get(1, 0);
            }
            for ( int i = 0 ; i < matriz.size() ; i++ ) {
                sum += sign * get(0, i) * coFactor(0, i).determinante();
                sign *= -1;
            }
            return sum;
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

        private Matriz replaceColumn(List<Double> b, int column) {
            List<List<Double>> mat = new ArrayList<>();
            for ( int row = 0 ; row < matriz.size() ; row++ ) {
                List<Double> list = new ArrayList<>();
                for ( int col = 0 ; col < matriz.size() ; col++ ) {
                    double value = get(row, col);
                    if ( col == column ) {
                        value = b.get(row);
                    }
                    list.add(value);
                }
                mat.add(list);
            }
            return new Matriz(mat);
        }
        private double get(int row, int col) {
            return matriz.get(row).get(col);
        }

    }

}