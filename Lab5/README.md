## Escuela colombiana de ingenieria Julio Garavito
#### Laboratorio 5 CVDS - MVC PRIMEFACES INTRODUCTION
#### Estudiante: _Nicolás Ariza Barbosa_

#### PARTE I. - JUGANDO A SER UN CLIENTE HTTP
1) Realice una conexión síncrona TCP/IP a través de Telnet alsiguiente servidor:
	- Host:www.escuelaing.edu.co
	- Puerto: 80
    - Teniendo en cuenta los parámetros delcomando telnet:
    ``` telnet HOST PORT ```
```
C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5>telnet www.escuelaing.edu.co 80
Conectandose a www.escuelaing.edu.co ...
```
2) Solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP. Asegúrese de presionar ENTER dos veces después de ingresar el comando.
```
GET /sssss/abc.html HTTP/1.0
Host: www.escuelaing.edu.co

HTTP/1.1 301 Moved Permanently
Connection: close
Server: gunicorn
Date: Wed, 08 Mar 2023 15:18:29 GMT
Content-Type: text/html; charset=utf-8
Location: https://www.escuelaing.edu.co/sssss/abc.html
X-Content-Type-Options: nosniff
Referrer-Policy: same-origin
Cross-Origin-Opener-Policy: same-origin
Via: 1.1 vegur



Se ha perdido la conexión con el host.

C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5>
```
- **¿Qué codigo de error sale?**
    301 Moved Permantly y significa que el servidor esta haciendo un redireccionamiento, en este caso lo hace moviendo la peticion hacia HTTPS.
- **¿Qué otros códigos de error existen?,¿En qué caso se manejarán?**
    - 1xx se usan para responder que la conexión fue recibida y entendida.
    - 2xx se usan para indicar que la conexion fue exitosa. 
    - 3xx se usan para indicar que se realizara una redirección hacia el recurso solicitado.
    - 4xx se usan para indicar que el usuario cometio un error solicitando el recurso.
    - 5xx se usan para indicar que el servidor ha fallado respondiendo a la solicitud.

3) Realice una nueva conexión con telnet, esta vez a:
    -   Host:www.httpbin.org
    -   Puerto: 80
    -   VersiónHTTP:1.1
```
C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5>telnet www.httpbin.org 80
Conectandose a www.httpbin.org ...
```
Ahora,solicite (GET) el recurso /html.¿Qué se obtiene como resultado?
```
GET /html HTTP/1.1
Host:www.httpbin.org

HTTP/1.1 200 OK
Date: Wed, 08 Mar 2023 15:42:08 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 3741
Connection: keep-alive
Server: gunicorn/19.9.0
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true

<!DOCTYPE html>
               <html>
                       <head>
                               </head>
                                        <body>
                                                    <h1>Herman Melville - Moby-Dick</h1>

                                                                                              <div>
                                                                                                           <p>
                                                                                                                        Availing himself of the mild, summer-cool weather that now reigned in these latitudes, and in preparation for the peculiarly active pursuits shortly to be anticipated, Perth, the begrimed, blistered old blacksmith, had not removed his portable forge to the hold again, after concluding his contributory work for Ahab's leg, but still retained it on deck, fast lashed to ringbolts by the foremast; being now almost incessantly invoked by the headsmen, and harpooneers, and bowsmen to do some little job for them; altering, or repairing, or new shaping their various weapons and boat furniture. Often he would be surrounded by an eager circle, all waiting to be served; holding boat-spades, pike-heads, harpoons, and lances, and jealously watching his every sooty movement, as he toiled. Nevertheless, this old man's was a patient hammer wielded by a patient arm. No murmur, no impatience, no petulance did come from him. Silent, slow, and solemn; bowing over still further his chronically broken back, he toiled away, as if toil were life itself, and the heavy beating of his hammer the heavy beating of his heart. And so it was. Ç Most miserable! A peculiar walk in this old man, a certain slight but painful appearing yawing in his gait, had at an early period of the voyage excited the curiosity of the mariners. And to the importunity of their persisted questionings he had finally given in; and so it came to pass that every one now knew the shameful story of his wretched fate. Belated, and not innocently, one bitter winter's midnight, on the road running between two country towns, the blacksmith half-stupidly felt the deadly numbness stealing over him, and sought refuge in a leaning, dilapidated barn. The issue was, the loss of the extremities of both feet. Out of this revelation, part by part, at last came out the four acts of the gladness, and the one long, and as yet uncatastrophied fifth act of the grief of his life's drama. He was an old man, who, at the age of nearly sixty, had postponedly encountered that thing in sorrow's technicals called ruin. He had been an artisan of famed excellence, and with plenty to do; owned a house and garden; embraced a youthful, daughter-like, loving wife, and three blithe, ruddy children; every Sunday went to a cheerful-looking church, planted in a grove. But one night, under cover of darkness, and further concealed in a most cunning disguisement, a desperate burglar slid into his happy home, and robbed them all of everything. And darker yet to tell, the blacksmith himself did ignorantly conduct this burglar into his family's heart. It was the Bottle Conjuror! Upon the opening of that fatal cork, forth flew the fiend, and shrivelled up his home. Now, for prudent, most wise, and economic reasons, the blacksmith's shop was in the basement of his dwelling, but with a separate entrance to it; so that always had the young and loving healthy wife listened with no unhappy nervousness, but with vigorous pleasure, to the stout ringing of her young-armed old husband's hammer; whose reverberations, muffled by passing through the floors and walls, came up to her, not unsweetly, in her nursery; and so, to stout Labor's iron lullaby, the blacksmith's infants were rocked to slumber. Oh, woe on woe! Oh, Death, why canst thou not sometimes be timely? Hadst thou taken this old blacksmith to thyself ere his full ruin came upon him, then had the young widow had a delicious grief, and her orphans a truly venerable, legendary sire to dream of in their after years; and all of them a care-killing competency.
                                              </p>
                                                        </div>
                                                                </body>
                                                                       </html>

Se ha perdido la conexión con el host.

C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5>
```
4) Claro está, las peticiones GET son insuficientes en muchoscasos. Investigue: 
**¿Cuál es la diferencia entre los verbos GET y POST?** 
    _El metodo GET solicitda al servidor web que le envie toda la informacion de hipertexto que posea en el recurso especificado, mientras que POST es usado para hacer peticiones pero a su vez también es capaz de enviar parametros que el servidor necesita para acceder al recurso solicitado._
**¿Qué otros tipos de peticiones existen?**
    - GET
    - HEAD
    - POST
    - PUT
    - DELETE
    - CONNECT
5) En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos: “curl www.httpbin.org”
    - Utilice ahora el parámetro -v y con el parámetro -i:
        - curl -v www.httpbin.org
        - curl -i www.httpbin.org
        
    **¿Cuáles son las diferencias con los diferentes parámetros?**
    _El parametro -v se denomina "verbose mode" y lo que hace es mostrar informacion sobre el proceso de conexion con el destino sobre la marcha. Por otro lado, el parametro -i se usa para hacer seguimiento a los headers de problemas que retorne el servidor al que se le hace la solicitud._
#### PARTE II. -HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.
Cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar **maven-archetype-webapp**.
```
C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5>mvn archetype:generate -DgroupId=edu.eci.cvds -DartifactId=Servlet -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeGroupId=org.apache.maven.archetypes
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] >>> archetype:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO]
[INFO] <<< archetype:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO]
[INFO]
[INFO] --- archetype:3.2.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[INFO] Archetype [org.apache.maven.archetypes:maven-archetype-webapp:1.4] found in catalog remote
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-webapp/1.4/maven-archetype-webapp-1.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-webapp/1.4/maven-archetype-webapp-1.4.pom (1.4 kB at 11 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-webapp/1.4/maven-archetype-webapp-1.4.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-webapp/1.4/maven-archetype-webapp-1.4.jar (6.8 kB at 253 kB/s)
[INFO] Using property: groupId = edu.eci.cvds
[INFO] Using property: artifactId = Servlet
Define value for property 'version' 1.0-SNAPSHOT: :
[INFO] Using property: package = edu.eci.cvds
Confirm properties configuration:
groupId: edu.eci.cvds
artifactId: Servlet
version: 1.0-SNAPSHOT
package: edu.eci.cvds
 Y: : Y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: maven-archetype-webapp:1.4
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: edu.eci.cvds
[INFO] Parameter: artifactId, Value: Servlet
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: edu.eci.cvds
[INFO] Parameter: packageInPathFormat, Value: edu/eci/cvds
[INFO] Parameter: package, Value: edu.eci.cvds
[INFO] Parameter: groupId, Value: edu.eci.cvds
[INFO] Parameter: artifactId, Value: Servlet
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Project created from Archetype in dir: C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5\Servlet
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  22.428 s
[INFO] Finished at: 2023-03-08T09:03:29-05:00
[INFO] ------------------------------------------------------------------------

C:\Users\Nicolas Ariza\Documents\CVDS\LabsCVDS\CVDS-LABORATORIOS-ARIZA-2023-1\Lab5>
```
