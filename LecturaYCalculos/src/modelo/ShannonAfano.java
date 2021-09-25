package modelo;

import java.util.*;

public class ShannonAfano {
    private static class Simbolo implements Comparable<Simbolo> {
        private final String ch;
        private final double freq;

        private String getCh() {
            return ch;
        }

        private double getFreq() {
            return freq;
        }

        Simbolo(String ch, double freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Simbolo that) {
            if (this.equals(that))
                return 0;
            else
                return (this.freq - that.freq > 0) ? 1 : -1;
        }

        @Override
        public String toString() {
            return this.ch + " p(" + this.getCh() + ")= " + this.getFreq();
        }

    } //guarda chufi


    private HashMap<String, String> encodeTable = new HashMap<String, String>();
    private HashMap<String, Character> decodeTable = new HashMap<String, Character>();

    public ShannonAfano(Palabra[] palabra) {
        super();
        Arrays.sort(palabra);
        List<Simbolo> lista = new ArrayList<Simbolo>();

        for (Palabra o:palabra) {
            lista.add(new Simbolo(o.palabra, o.repeticiones));
        }
        generaCodigo(this.encodeTable, lista, true);

        for(Palabra o:palabra){
            System.out.println(encodeTable.get(o.palabra));
        }


        //for (Map.Entry<String, String> e : encodeTable.entrySet()) {
        //    this.decodeTable.put(e.getValue(),e.getKey());
        //}

    }


    private void generaCodigo(HashMap<String, String> result, List<Simbolo> simboloList, boolean up) {
        String bit = "";
        if (!result.isEmpty()) {
            bit = (up) ? "0" : "1";
        }

        for (Simbolo s : simboloList) {
            String hastaAhora = result.get(s.getCh());
            if (hastaAhora == null)
                hastaAhora = "";
            //String string = (result.get(s.getCh()) == null) ? "" : result.get(s.getCh());
            result.put(s.getCh(), hastaAhora + bit);
        }

        if (simboloList.size() >= 2) {
            double total = 0;
            for (Simbolo s : simboloList) {
                total += s.getFreq();
            }
            double sumaHastaAhora = 0;

            int i = -1;

            while (sumaHastaAhora < total / 2) {
                i++;
                sumaHastaAhora += simboloList.get(i).getFreq();
            }


            int separador;
            if (Math.abs(sumaHastaAhora - total / 2) >
                    Math.abs((sumaHastaAhora - simboloList.get(i).getFreq()) - total / 2))
                separador = i - 1;
            else
                separador = i;
            //todo //cuidaod con los bordes..


            List<Simbolo> upList = simboloList.subList(0, separador + 1);
            generaCodigo(result, upList, true);
            List<Simbolo> downList = simboloList.subList(separador + 1, simboloList.size());
            generaCodigo(result, downList, false);
        }
    }
}
