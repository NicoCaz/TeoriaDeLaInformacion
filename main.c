#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct nodo
{
    int palabra,catidad;
    struct nodo * sig;
}nodo;
typedef nodo*TLista;

void leeArchivo(char archFuente[],int tamanioPalabra,TLista *L);
int anytoint(char *s, char **out);
void cargalista(TLista *L, int dato);
void muestraLista(TLista L);
int main(int cantArgc, char *arg[]){
    TLista L=NULL;
    leeArchivo("anexo1.txt",5,&L);
    muestraLista(L);
    return 0;
}


void leeArchivo(char archFuente[],int tamanioPalabra,TLista *L){
    char palabra[tamanioPalabra+1];
    FILE* arch = fopen(archFuente,"rt");
    while(fgets(palabra,tamanioPalabra+1,arch)!=NULL){
        cargalista(L,anytoint(palabra,NULL));
       // printf("%s \n",palabra);
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
int total=0;

nuevo=(TLista)malloc(sizeof(nodo));
nuevo->catidad=1;
nuevo->palabra=dato;
nuevo->sig=NULL;
if((*L)==NULL || (*L)->palabra>dato){
    if(*L==NULL){
        *L=nuevo;
        (*L)->sig=NULL;
    }
    else{
        nuevo->sig=*L;
        *L=nuevo;
    }
}
else{
    ant=(*L);
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


void muestraLista(TLista L){
    while(L!=NULL){
        printf("palabra: %d cant: %d  \n",L->palabra,L->catidad);
        L=L->sig;
    }
}