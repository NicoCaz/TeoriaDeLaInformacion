
from io import open
import pylab as pl


arch=open("graficadora/salida.txt","r")
def trunca(num, n):
    trun=1
    for i in range(n):
        trun*=10
    aux=float(num)*trun
    aux=int(aux)
    return float(aux/trun)

texto=arch.readlines()
simbolos=[]
cantidad=[]
informacion=[]
entropia=[]
numero=0
for linea in texto:
    linea=linea.split()
    simbolos.append(numero)
    cantidad.append(int(linea[1]))
    informacion.append(trunca(linea[2],6))
    entropia.append(trunca(linea[3],6))
    numero=numero+1


pl.subplot(2, 2, 1)
pl.ylabel("n° Apareciones")
pl.bar(simbolos,cantidad)

pl.subplot(2, 2, 2)
pl.xlabel("Palabra")
pl.ylabel("Informacion")
pl.bar(simbolos,informacion)

pl.subplot(2, 2, 3)
pl.xlabel("Palabra")
pl.ylabel("Entropia")
pl.bar(simbolos,entropia)

pl.show()