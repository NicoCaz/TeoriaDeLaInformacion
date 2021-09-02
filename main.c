#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct nodo
{   
    char palabra[50];
    int catidad;
    struct nodo * sig;
}nodo;
typedef nodo*TLista;

void leeArchivo(char archFuente[],int tamanioPalabra,TLista *L,int *cant);
int anytoint(char *s, char **out);
void cargalista(TLista *L, char dato[50]);
void muestraLista(TLista L);
void calculoCantInformacion(TLista L,int cant);
void clear();


int main(int cantArgc, char *arg[]){
    system("cls");
    TLista L=NULL;
    int cant=0;
    leeArchivo("anexo1.txt",5,&L,&cant);
    calculoCantInformacion(L,cant);
    return 0;
}


void leeArchivo(char archFuente[],int tamanioPalabra,TLista *L,int *cant){
    char palabra[tamanioPalabra+1];
    FILE* arch = fopen(archFuente,"rt");
    while(fgets(palabra,tamanioPalabra,arch)!=NULL){
        cargalista(L,palabra);
        (*cant)++;
       // printf("%s \n",palabra);
    }
}

void cargalista(TLista *L, char dato[50]){
    TLista nuevo,act,ant;
    nuevo=(TLista)malloc(sizeof(nodo));
    nuevo->catidad=1;
    strcpy(nuevo->palabra,dato);
    nuevo->sig=NULL;
    if((*L)==NULL || strcmp((*L)->palabra,dato)>0){
        if(*L==NULL){
            *L=nuevo;
            (*L)->sig=NULL;
        }else{
            nuevo->sig=*L;
            *L=nuevo;
        }
    }else{
        ant=NULL;
        act=(*L);
        while (act!=NULL && strcmp(act->palabra,dato)<0){
            ant=act;
            act=act->sig;
        }
        if(act==NULL || strcmp(act->palabra,dato)!=0){ //inserto
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
        printf("palabra: %s cant: %d  \n",L->palabra,L->catidad);
        L=L->sig;
    }
}

float logbase(double a, double base)
{
   return log(a) / log(base);
}

void calculoCantInformacion(TLista L,int cant){
    float cantidadInfo;
    float prob;
    while(L!=NULL){
        printf("palabra: %s cant: %d  \n",L->palabra,L->catidad);
        prob=(L->catidad/(float)cant);
        printf("%f \n",prob);
        cantidadInfo=logbase(1/(float)prob,2);
        //printf("la cantidad de informacion es de:%f \n",calculoCantInformacion);
        L=L->sig;
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


void clear(){
    #if defined(__linux__) || defined(__unix__) || defined(__Apple__)
        system("clear");
    #endif

    #if defined(_WIN32) || defined(_WIN64)
        system("cls");
    #endif
}