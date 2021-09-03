import numpy as numpy
from io import open
from matplotlib import pyplot as plt


arch=open("graficadora/salida.txt","r")
texto=arch.readlines()
print(texto[1])