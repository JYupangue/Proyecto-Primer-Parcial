# Proyecto-Primer-Parcial
En el cumplimiento del proyecto del primer parcial se expondra a continuacion los pasos para poder ejecutar las clases en las maquinas virtuales.

# Requerimiento
Instalar virtualbox, proceder a crear dos nodos y estos esten conectandos por un adaptador de red nat, y estos mismo esten conectados por una red interna
- Instar jdk en ambos terminales
- Instalar Git en ambos terminales
- Instalar json-simple.jar en eclipse

# Trabajando en las maquinas virtuales
- Como primer paso se procedio a clonar los respositorios en ambas maquinas virtuales con el comando " git clone"[url_del_repositorio].
- Se instalada por consola json en ambas terminales con el siguiente comando "sudo apt-get install -y libjson-simple-java"
- Para hacer uso de la libreria puesta en el respositorio se hace uso del comando "export CLASSPATH=json-simple-1.1.jar:$CLASSPATH" en ambas terminales.
- Se procede a ejecutar la clase reportero.java en el primer nodo con el comando java por delante es decir, java reportero.
- Despues de ejecutar dicha clase en el nodo1 se procede a ejecutar la clase verificador.java en el segundo nodo con el comando java por delante es decir, java reportero.

# Explicacion de la visualizacion

En el nodo1 donde se ejecuto la clase reportero se visualizará un texto diciendo prueba, este da por entendido que se ha ejecutado la clase satisfactoriamente, procedentemente en el nodo 2 se visualizará los json leidos de la carpeta verificador creada en el repositorio.
Una ves ejecutadas las dos clases en ambos nodos, se creará un archivo json, el cual se podra acceder a visualizarlo en la terminal con el comando "nano" [nombre del archivo json]

# Referencias
http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm
