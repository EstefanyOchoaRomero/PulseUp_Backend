#   PulseUP <img src="https://github.com/user-attachments/assets/48923c00-cdc5-4938-b23a-ffeab062cbd8" alt="Corazon Pulse Up" width="100" />

## Gestiona tus emociones de forma diferente
## Nombre: 
La idea del nombre encierra la esencia de la plataforma: elevar el estado de ánimo, conectar personas y ofrecer experiencias enriquecedoras. 
## Resumen del Proyecto 
Pulse up es una plataforma Integrada, que combina música, moda, salud y bienestar, ofreciendo una experiencia interactiva y personalizada
por medio de conexión entre APIS que ofrecen algunos de estos servicios, es un plataforma en la que los usuarios pueden conectar con otros en función de su estado de ánimo. 
El usuario recibe 4 experiencias a lo largo del día según su estado de ánimo, entre estas recibirá playlists de música diarias, 
diseñadas y estudiadas acorde a su gusto musical para ayudar a elevar y mejorar el estado de ánimo con el que empieza el día. 
## Fucionalidades principales 
## “EmotionSound”: Música que Conecta con tu Estado de Ánimo
EmotionSound es la funcionalidad de Pulse Up que adapta la experiencia musical según cómo te sientes. A través del análisis de tu estado de ánimo y preferencias musicales, 
la app genera playlists personalizadas que reflejan y mejoran tus emociones. 
Ya sea que necesites relajarte, motivarte, o mantener la felicidad, EmotionSound utiliza servicios como Spotify para ofrecerte la banda sonora perfecta para cada momento,
creando una experiencia única e inmersiva.
## "Mood Matching" : Música y Outfit Basados en el Estado de Ánimo.
El usuario recibirá recomendaciones de looks y accesorios en función del tipo de playlist que la app le ha recomendado 
según el estado de ánimo que le ha manifestado a la app (por ejemplo, looks relajados para el jazz, outfits urbanos para el hip hop, etc.). 
Todos estos outfits son diseñados y basados en los looks de los artistas de las playlists que la app le ha recomendado y que dicho usuario ha manifestado,
también los looks estarán basados en la psicología de la moda como herramienta clave para ayudar a los usuarios a entender, gestionar y mejorar el estado de ánimo,
ayudándolo a expresar su identidad y a mejorar su autoestima a través de la ropa que le recomendamos. 
## "Music and Fashion Sessions"
La plataforma ofrecerá eventos de música, moda y bienestar presenciales adaptados al estado de ánimo del usuario. Por ejemplo, si el usuario selecciona “triste”, 
la app le va a sugerir “¿Qué tal un paseo con amigos?” y ofrecerle dos opciones de eventos locales de música o moda (gratuitos o de pago) para asistir con otras personas..
El usuario podrá elegir el evento, confirmar su asistencia y una vez se hayan unido al menos tres personas, se desbloquearán los detalles del evento, entradas, descuentos y premios exclusivos.
Además, la app conectará a los asistentes por medio de un chat donde podrán hablar para encontrarse con las personas que han confirmado la asistencia al evento, 
así la plataforma fomentará una experiencia grupal y para elevar el estado de ánimo del usuario. 

## Ejemplo de uno de los estados de animo y sus servicios

## Estado de Ánimo: Triste 
### Servicios: 
● Playlist para Levantar el Ánimo: Música alegre y optimista. 
○ API : Spotify API. 
● Outfit de Colores Vivos: Looks coloridos y vibrantes para mejorar el ánimo. 
○ API : Pinterest API o Asos API. 
● Evento de Moda Divertido: Desfiles de moda coloridos o talleres de estilo que incluyan accesorios vibrantes. 
○ API : Eventbrite API. 
● Evento de Música Energética: Música pop o conciertos de música alegre para revitalizar el ánimo. 
○ API: Ticketmaster API o Songkick API. 


## Tecnologías y Herramientas
### Backend 
● Java + Spring Boot: Para la estructura de microservicios y REST APIs. 
● Spring Security + JWT: Para autenticación y autorización. 
● Spring Data JPA + Postgres: Para persistencia de datos. 
● Spotify API o similar: Para obtener playlists basadas en el estado de ánimo. 

### Base de Datos 
● PostgresSQL: Almacena perfiles de usuario, historial de estados de ánimo, eventos, outfits recomendados y otros datos relevantes. 

Frontend (posibles Herramientas) 
● VUE(con hooks y contexto API para la gestión de estado)
Hice un formulario un login para la idea de como seria visualmente estos elementos de Pulse Up.

## Muestra Visual de login en fronted eN Vue
![Login Pulse up](https://github.com/user-attachments/assets/0bebb36f-4aad-4c45-bda4-6fbb0fd56838)

### Módulos de la Aplicación 
Módulo 1: Autenticación y Gestión de Usuarios 
● Backend (Java/Spring Boot): 
○ Controlador para autenticación y registro Spring Security y JWT.
llegue a este punto pero falla en el token del login, el registro de un usuario funciona.

## Diagrama de flujo 
![Diagramas de flujo Proyecto personal (1)](https://github.com/user-attachments/assets/b926d989-ccff-4b11-afa6-b17b2d70076b)

## Diagrama UML Relacional 

![Diagrama de clases proyecto personal (1)](https://github.com/user-attachments/assets/563d8a7a-089f-4a33-b690-61d51e420492)
















