#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void leeArchivo(char archFuente[],int tamanioPalabra){
    char palabra[tamanioPalabra];
    FILE* arch = fopen(archFuente,"rt");
    while(!feof(arch)){
        //fgets(auxline,200,arch)!=NULL
        fgets(palabra,5,arch);
        printf("%s \n",palabra);
    }
}

int main(int cantArgc, char *arg[]){
    leeArchivo("anexo1.txt",5);
    return 0;
}


