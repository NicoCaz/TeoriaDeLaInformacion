#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void leeArchivo(char archFuente[],float mat[][4]);
void iniciaMat(float mat[][4]);
void muestraMat(float mat[][4]);
void vectorEstacionario(float mat[][4]);

int main(){
    float mat[4][4];
    iniciaMat(mat);
    leeArchivo("anexo1.txt",mat);
    muestraMat(mat);
    vectorEstacionario(mat);
    return 0;    
}

void iniciaMat(float mat[][4]){
    for(int i=0;i<4;i++)
        for(int j=0;j<4;j++)
            mat[i][j]=0;
}
void muestraMat(float mat[][4]){
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            printf("|\t%f\t",mat[j][i]);
        }   
        printf("\n"); 
       // printf("|\n-------------------------------------------------------------\n");
    }
}
void leeArchivo(char archFuente[],float mat[][4]){
    char ant[3];
    char act[3];
    int fila,columna,suma;
    FILE* arch = fopen(archFuente,"rt"); 
    strcpy(ant,"\0");
    while(fgets(act,3,arch)!=NULL){
        if(strcmp(ant,"\0")==0){
            strcpy(ant,act);
        }else{
            fila=strtoul(ant,NULL ,2);
            columna=strtoul(act,NULL ,2);
            mat[columna][fila]+=1;
            strcpy(ant,act);
        }
    }
    for(int i=0;i<4;i++){
        suma=0;
        for(int j=0;j<4;j++){
            suma+=mat[i][j];
        }if(suma!=0)
            for(int j=0;j<4;j++){
                mat[i][j]/=suma;
        }
    }
}
void vectorEstacionario(float mat[][4]){
     FILE * arch=fopen("graficadora/matriz.txt","wt");
    for(int i=0;i<4;i++){
        fprintf(arch,"%f %f %f %f\n",mat[0][i],mat[1][i],mat[2][i],mat[3][i]);
       }
    fclose(arch);
}

