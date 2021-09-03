
from io import open
import matplotlib.pyplot as plt


arch=open("graficadora/salida.txt","r")
fig, ax = plt.subplots()
texto=arch.readlines()
simbolos=[]
cantidad=[]
informacion=[]
entropia=[]
numero=0
for linea in texto:
    linea=linea.split()
    simbolos.append(numero)
    cantidad.append(linea[1])
    informacion.append(linea[2])
    entropia.append(linea[3])
    numero=numero+1

ax.set_ylabel('Cantidad')
ax.set_xlabel('simbolo')
plt.bar(simbolos,cantidad)
plt.show()
