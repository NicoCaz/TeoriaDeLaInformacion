from distutils.core import setup 
import py2exe 
 
setup(name="graficadora", 
    version="1.0", 
    description="Graficadora", 
    author="grupo1", 
    author_email="", 
    url="https://github.com/NicoCaz/TeoriaDeLaInformacion", 
    license="MIT", 
    scripts=["main.py"], 
    console=["main.py"], 
    options={"py2exe": {"bundle_files": 1}}, 
    zipfile=None,
)
