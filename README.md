# cresiapp

## Objetivo del proyecto
Concientizar sobre la educación sexual entre jovenes de 12 y 18 años

## Tecnología
### Backend
Java 8 + springBoot

*Endpoints*
* /preguntas
  * categoria <LONG>
 
* /respuestas
  * pregunta_id <LONG>
  * respuesta_id <LONG>
 

### Frontend
vue.js


## Ambiente produccion
 * Frontend: cresi.developersforgood.com
 * Backend: cresi.herokuapp.com

## Hosting
* Backend: heroku // Integrado contra master - autodeploy
* Frontend: devsforgood // ftp del index.html

*IMPORTANTE:* Heroku es gratuito y como condición tiene cuotas de uso, en particular si no están usando la app entonces está apagada y se prende cuando la queremos consultar.
Por lo que puede pasar que si en 1 minuto nadie la usó va a tardar en mostrar las preguntas (podemos tener una demora de 2 minutos)

## Actualizacion de preguntas

Cuando la aplicación levanta toma las preguntas de: src/main/resources/preguntas.csv


