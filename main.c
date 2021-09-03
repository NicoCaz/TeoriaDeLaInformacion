#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <math.h>

typedef struct datos{
    char palabra[20];
    int repeticiones;
    float cantInformacion;
    float entropia;
}datos;

void leeArchivo(char archFuente[],int tamanioPalabra,datos vec[],int *cant);
void calculoCantInformacion(datos vec[],int cant,int tamanio);
void calculoCantEntropia(datos vec[],int cant,int tamanio);
void muestravec(datos vec[],int x);
void inicializavec(datos vec[],int cant);
float logbase(double a, double base);
char *intABin(int numero);
char *concatena(char *palabra,char c);

int main(int cantArgc, char *arg[]){
    int cant=0;
    datos vec[512]; //el caso maximo
    int tamanio=9;
    inicializavec(vec,tamanio);
    leeArchivo("anexo1.txt",tamanio,vec,&cant);
    calculoCantInformacion(vec,cant,tamanio);
    calculoCantEntropia(vec,cant,tamanio);
    muestravec(vec,pow(2,tamanio));
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
            //printf("palabra: %s cant: %d  palabra nro: %d \n",vec[i].palabra,vec[i].repeticiones,i);
            prob=(vec[i].repeticiones/(float)cant);
            vec[i].cantInformacion=(float)-logbase(prob,2);
        }else{
            //printf("La palabra numero %d nunca aparece!! \n ",i);
            //printf("la cantidad de informacion es de: 0 bits\n");
            i=i;
        }
    }   
}

void calculoCantEntropia(datos vec[],int cant,int tamanio){
    float prob;
    float entropia=0;
    for(int i=0;i<pow(2,tamanio);i++){
        if(vec[i].repeticiones!=0){ 
            prob=(vec[i].repeticiones/(float)cant);
            vec[i].entropia=(prob*(-logbase(prob,2)));
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
    FILE * arch=fopen("graficadora/salida.txt","wt");
    for(int i=0;i<n;i++){
        if(vec[i].repeticiones!=0)
            fprintf(arch,"%s %d %f %f\n",vec[i].palabra,vec[i].repeticiones,vec[i].cantInformacion,vec[i].entropia);
        else
            fprintf(arch,"%s %d %f %f\n",intABin(i),vec[i].repeticiones,vec[i].cantInformacion,vec[i].entropia);
       /* if(vec[i].repeticiones!=0){
            printf("palabra: %s cantidad de veces: %d \n",vec[i].palabra,vec[i].repeticiones);
            printf("cantidad info: %f cantidad de entropia: %f \n",vec[i].cantInformacion,vec[i].entropia);
        }else{
            printf("EL caracter numero %d no ha aparecido nunca \n",i);
        }*/
    }
    fclose(arch);
}
void inicializavec(datos vec[],int tamanio){
    int cant=pow(2,tamanio);
    for(int i=0;i<cant;i++){
        vec[i].repeticiones=0;
        vec[i].cantInformacion=(float)0;
        vec[i].entropia=(float)0;
    }
}


char *intABin(int numero){
    char *binario="";
    char c;
    if(numero>0){
        while(numero>0){
            if(numero%2==0){
                binario=concatena(binario,'0');
            }else{
                binario=concatena(binario,'1');
            }
            numero=(int)numero/2;
        }
    }
    return binario;
}

char *concatena(char *palabra,char c){
    char *binario;
    int i;
    binario= (char*)malloc(strlen(palabra)+2);
    binario[0]=c;
    for(i=1;palabra[i-1]!='\0';i++){
        binario[i]=palabra[i-1];
    }
    binario[i++]='\0';
    return binario;
}