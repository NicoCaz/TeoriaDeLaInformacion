#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void leeArchivo(char archFuente[100],int tamanioPalabra){
    char palabra[tamanioPalabra];
    FILE* arch = fopen(archFuente,"rt");
    while(!feof(arch)){
        freadf(arch,"%c",palabra);
    }
}

int main(int cantArgc, char *arg[]){

    return 0;
}


