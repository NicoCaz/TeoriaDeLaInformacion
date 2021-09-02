#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct datos{
    char palabra[20];
    int repeticiones;
}datos;

void leeArchivo(char archFuente[],int tamanioPalabra,datos vec[],int *cant);
int anytoint(char *s, char **out);
void calculoCantInformacion(datos vec[],int cant,int tamanio);
void calculoCantEntropia(datos vec[],int cant,int tamanio);
void muestravec(datos vec[],int x);
void inicializavec(datos vec[]);

float logbase(double a, double base);
void clear();


int main(int cantArgc, char *arg[]){
    int cant=0;
    datos vec[1000];
    int tamanio=9;
    inicializavec(vec);
    leeArchivo("anexo1.txt",tamanio,vec,&cant);
    //muestravec(vec,pow(2,tamanio));
    calculoCantInformacion(vec,cant,tamanio);
     calculoCantEntropia(vec,cant,tamanio);
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
    }
}


void calculoCantInformacion(datos vec[],int cant,int tamanio){
    float cantidadInfo;
    float prob;
    int i=0;
    for(int i=0;i<pow(2,tamanio);i++){
        if(vec[i].repeticiones!=0){
            printf("palabra: %s cant: %d  palabra nro: %d \n",vec[i].palabra,vec[i].repeticiones,i);
            prob=(vec[i].repeticiones/(float)cant);
            printf("la cantidad de informacion es de:%f \n",-logbase(prob,2));
        }else{
            printf("La palabra numero %d nunca aparece!! \n ",i);
            printf("la cantidad de informacion es de: 0\n");
        }
    }   
}

void calculoCantEntropia(datos vec[],int cant,int tamanio){
    float prob;
    float entropia=0;
    for(int i=0;i<pow(2,tamanio);i++){
        if(vec[i].repeticiones!=0){ 
            prob=(vec[i].repeticiones/(float)cant);
            entropia+=(prob*(-logbase(prob,2)));
            }
    }
    
    printf("\n\nEl logaritmo de %d es: %f  ",cant,logbase(cant,2));
    printf("\n\nLa cantidad de entropia de la fuente es de: %f",entropia);

}
float logbase(double a, double base){
   return log(a) /log(base);
}

void muestravec(datos vec[],int n){
    for(int i=0;i<n;i++){
        if(vec[i].repeticiones!=0)
            printf("%d %s %d \n",i,vec[i].palabra,vec[i].repeticiones);
        else{
            printf("EL caracter numero %d no ha aparecido nunca \n",i);
        }
    }
}
void inicializavec(datos vec[]){
    for(int i=0;i<600;i++){
        vec[i].repeticiones=0;
    }
}

