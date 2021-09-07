import numpy as np


arch=open("graficadora/matriz.txt","r")

arch=arch.readlines()
mat=[]
for fila in arch:
    mat.append(fila)

mat=np.matrix(mat)
print(mat)