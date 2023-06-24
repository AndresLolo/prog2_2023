# Obligatorio 2023
##Andres Lolo e Iñaki Dávila
###Correr el programa en ProgMain
###Precauciones:
####Asegurarse de tener Junit instalado o pedira que se lo añada al classpath en el momento de la ejecucion
###Descripcion proceso de carga:
####La carga se hace mediante apache common csv, al cual le pasamos la ruta relativa del archivo el cual se debe analizar, este separa los campos por columnas y los vamos guardando en los distintos TADS
####Por ejemplo: Los tweets son guardados en Hashs cuya clave es un numero autogenerado el cual se incrementa automaticamente con cada tweet cargado
####Los usuarios son guardados en un hash por medio de la fecha de creacion de su cuenta, no usamos el nombre debido a que hay mas posibilidades de que un usuario se cambie de nombre o que hayan dos usuarios con el mismo nombre a que dos usuarios se creen al mismo tiempo
####Para los hashtags dividimos la columna y separamos los valores mediante comas, una vez separados los valores guardamos los hashtag en un hash cuya key es el hashtag en si mismo para asi evitar guardar hashtags duplicados debido a que si dos hashtags se repiten, tendran la misma clave y se sobrescribiran
###Consultas:
###En la consulta 5 tomamos como que los favoritos es la cantidad de favoritos que tiene el tweet
###Info:
###Las screenshots de los distintos consumos de memoria estan en el ZIP al igual que el diagrama uml

