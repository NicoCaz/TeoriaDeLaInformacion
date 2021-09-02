#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct nodo
{
    int palabra,catidad;
    struct nodo * sig;
}nodo;
typedef nodo*TLista;


void leeArchivo(char archFuente[],int tamanioPalabra){
    char palabra[tamanioPalabra+1];
    FILE* arch = fopen(archFuente,"rt");
    while(fgets(palabra,tamanioPalabra+1,arch)!=NULL){
        
        printf("%c  ",palabra);
    }
}

int anytoint(char *s, char **out) {
    char *BASES = {"********@*#*****%"};
    int base = 2;
    char *bp = strchr(BASES, *s);
    if (bp != NULL) {
        base = bp - BASES;
        ++s;
    }
    return strtol(s, out, base);
}

void cargalista(TLista *L, int dato){
TLista nuevo,act,ant;

nuevo=(TLista)malloc(sizeof(nodo));
nuevo->catidad=1;
nuevo->palabra=dato;
nuevo->sig=NULL;
if(*L==NULL || (*L)->palabra>dato){
    if(*L==NULL){
        *L=nuevo;
        (*L)->sig=NULL;
    }
}
else{
    act=(*L)->sig;
    while (act!=NULL && act->palabra<dato){
        ant=act;
        act=act->sig;
    }
    if(act==NULL || act->palabra!=dato){ //inserto
        ant->sig=nuevo;
        nuevo->sig=act;
    }
    else{//actualizo
        free(nuevo);
        act->catidad++;
    }
}

}

int main(int cantArgc, char *arg[]){
    leeArchivo("anexo1.txt",5);
  //  leeArchivo("anexo1.txt",8);
    return 0;
}


