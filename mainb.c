#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void leeArchivo(char archFuente[],float mat[][4]);
void iniciaMat(float mat[][4]);
void muestraMat(float mat[][4]);

int main(){
    float mat[4][4];
    iniciaMat(mat);
    leeArchivo("anexo1.txt",mat);
    muestraMat(mat);
    return 0;    
}

void iniciaMat(float mat[][4]){
    for(int i=0;i<4;i++)
        for(int j=0;j<4;j++)
            mat[i][j]=1;
}
void muestraMat(float mat[][4]){
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++)
            printf("%f\t",mat[i][j]);
        printf("\n");
    }
}
void leeArchivo(char archFuente[],float mat[][4]){
    char ant[3];
    char act[3];
    int fila,columna;
    FILE* arch = fopen(archFuente,"rt"); 
    strcpy(ant,"\0");
    while(fgets(act,3,arch)!=NULL){
        if(strcmp(ant,"\0")==0){
            strcpy(ant,act);
        }else{
            fila=strtoul(ant,NULL ,2);
            columna=strtoul(act,NULL ,2);
            mat[fila][columna]+=1;
            strcpy(ant,act);
        }
    }

}

