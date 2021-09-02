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

typedef struct datos{
    char palabra[20];
    int repeticiones;
}datos;

void leeArchivo(char archFuente[],int tamanioPalabra,datos vec[],int *cant);
int anytoint(char *s, char **out);
void cargalista(TLista *L, char dato[50]);
void muestraLista(TLista L);
void calculoCantInformacion(TLista L,int cant);
void calculoCantEntropia(TLista L,int cant);
void muestravec(datos vec[],int x);
void inicializavec(datos vec[]);

float logbase(double a, double base);
void clear();


int main(int cantArgc, char *arg[]){

    TLista L=NULL;
    int cant=0;
   datos vec[1000];
   inicializavec(vec);
    leeArchivo("anexo1.txt",9,vec,&cant);
   // muestravec(vec,pow(2,5));
   // calculoCantInformacion(L,cant);
   // calculoCantEntropia(L,cant);
    return 0;
}


void leeArchivo(char archFuente[],int tamanioPalabra,datos vec[],int *cant){
    char palabra[tamanioPalabra+1];
    char aux[tamanioPalabra+1];
    FILE* arch = fopen(archFuente,"rt");
    int x;
    while(fgets(palabra,tamanioPalabra+1,arch)!=NULL){
        strcpy(aux,palabra);
        x=strtoul(aux,NULL ,2);
        strcpy(vec[x].palabra,palabra);
        vec[x].repeticiones++; //inicializar esto
        (*cant)++;
       // printf("%s \n",palabra);
    }
}


void calculoCantInformacion(TLista L,int cant){
    float cantidadInfo;
    float prob;
    int i=0;
    while(L!=NULL){
        printf("palabra: %s cant: %d  palabra nro: %d \n",L->palabra,L->catidad,i);
        prob=(L->catidad/(float)cant);
        i++;
        printf("la cantidad de informacion es de:%f \n",-logbase(prob,2));
        L=L->sig;
    }
}

void calculoCantEntropia(TLista L,int cant){
    float prob;
    float entropia=0;
    while(L!=NULL){
        prob=(L->catidad/(float)cant);
        entropia+=(prob*(-logbase(prob,2)));
        L=L->sig;
    }
    printf("\n\nEl logaritmo de %d es: %f  ",cant,logbase(cant,2));
    printf("\n\nLa cantidad de entropia de la fuente es de: %f",entropia);

}
float logbase(double a, double base){
   return log(a) /log(base);
}

void muestravec(datos vec[],int n){
    for(int i=0;i<n;i++){
        printf("%d %s %d \n",i,vec->palabra,vec->repeticiones);
    }
}
void inicializavec(datos vec[]){
for(int i=0;i<600;i++){
    vec[i].repeticiones=0;
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




void contarChar(char arch1[]){
    char c;
    int cant=0;
    FILE* arch = fopen(arch1,"rt");
    fscanf(arch,"%c",&c);
    while(!feof(arch)){
        cant++;
        fscanf(arch,"%c",&c);
    }
    printf("%d",cant);
}



