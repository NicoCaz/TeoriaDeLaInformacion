import numpy as np
from numpy import ma


arch=open("graficadora/matriz.txt","r")

arch=arch.readlines()
mat=[]
fila=[]
for filas in arch:
    filas=filas.split()
    fila.append(float(filas[0]))
    fila.append(float(filas[1]))
    fila.append(float(filas[2]))
    fila.append(float(filas[3]))
    mat.append(fila)
    fila=[]

mat=np.matrix(mat)

dimension=len(mat)
mat=mat-np.identity(dimension)
b=np.zeros(dimension)
mat[-1]=np.ones(dimension)
b[-1]=1
vec=np.linalg.solve(mat,b)


print(vec)
