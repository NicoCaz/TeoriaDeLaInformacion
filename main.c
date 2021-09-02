#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct datos{
    char palabra[20];
    int repeticiones;
}datos;

void leeArchivo(char archFuente[],int tamanioPalabra,datos vec[],int *cant);
void calculoCantInformacion(datos vec[],int cant,int tamanio);
void calculoCantEntropia(datos vec[],int cant,int tamanio);
void muestravec(datos vec[],int x);
void inicializavec(datos vec[]);
float logbase(double a, double base);


int main(int cantArgc, char *arg[]){
    int cant=0;
    datos vec[512]; //el caso maximo
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
    FILE* arch = fopen(archFuente,"rt");
    int indice;
    while(fgets(palabra,tamanioPalabra+1,arch)!=NULL){
        indice=strtoul(palabra,NULL ,2); //strtoul converite el string a decimal con la base inicada(2)
        strcpy(vec[indice].palabra,palabra);
        vec[indice].repeticiones++;
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
            printf("la cantidad de informacion es de:%f bits\n",-logbase(prob,2));
        }else{
            printf("La palabra numero %d nunca aparece!! \n ",i);
            printf("la cantidad de informacion es de: 0 bits\n");
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

