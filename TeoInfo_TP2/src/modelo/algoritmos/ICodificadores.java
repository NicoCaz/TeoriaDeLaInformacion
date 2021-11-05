package modelo.algoritmos;

import java.io.IOException;

public interface ICodificadores {
    Double getEntropia();
    double getLongMedia();
    int tamanioEnByts();
    void comprimir(String a) throws IOException;
}
