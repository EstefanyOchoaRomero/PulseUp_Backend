-- Cargar Estados de Ánimo
INSERT INTO mood (name, description) VALUES
    ('Ansioso', 'Estado de ánimo caracterizado por sentimientos de inquietud o preocupación.'),
    ('Estresado', 'Sentimiento de sobrecarga debido a una demanda excesiva de energía o tiempo.'),
    ('Triste', 'Sentimiento de melancolía o desánimo.'),
    ('Solo', 'Sentimiento de aislamiento o soledad.'),
    ('Enfermo', 'Estado de salud deficiente que puede afectar el bienestar emocional.'),
    ('De Mal Humor', 'Estado de ánimo caracterizado por irritabilidad o frustración.'),
    ('Feliz', 'Estado de ánimo positivo y alegre.'),
    ('Tranquilo', 'Estado de calma y paz interior.'),
    ('Aburrido', 'Falta de interés o entusiasmo debido a la falta de estimulación.');

-- Cargar Recomendaciones para cada Estado de Ánimo
-- Estado de Ánimo: Ansioso
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Ansioso'), 'Playlist Relajante', 'Música suave y relajante que ayuda a reducir la ansiedad.'),
    ((SELECT id FROM mood WHERE name = 'Ansioso'), 'Ejercicios de Mindfulness', 'Sesiones de mindfulness y respiración guiadas.'),
    ((SELECT id FROM mood WHERE name = 'Ansioso'), 'Evento de Moda para Relajarse', 'Actividades de moda que exploran estilos minimalistas o cómodos.'),
    ((SELECT id FROM mood WHERE name = 'Ansioso'), 'Evento de Música Suave', 'Conciertos de música tranquila o instrumental en vivo.');

-- Estado de Ánimo: Estresado
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Estresado'), 'Playlist para Aliviar el Estrés', 'Música instrumental y sonidos de la naturaleza.'),
    ((SELECT id FROM mood WHERE name = 'Estresado'), 'Recomendación de Outfit Relajado', 'Ropa cómoda, como looks en tonos suaves y tejidos de alta comodidad.'),
    ((SELECT id FROM mood WHERE name = 'Estresado'), 'Evento de Moda Estilo "Self-Care"', 'Talleres de moda de autocuidado, como sesiones de personalización de ropa cómoda.'),
    ((SELECT id FROM mood WHERE name = 'Estresado'), 'Evento de Música Ambiental', 'Conciertos de música ambiente para ayudar a desconectar y reducir el estrés.');

-- Estado de Ánimo: Triste
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Triste'), 'Playlist para Levantar el Ánimo', 'Música alegre y optimista.'),
    ((SELECT id FROM mood WHERE name = 'Triste'), 'Outfit de Colores Vivos', 'Looks coloridos y vibrantes para mejorar el ánimo.'),
    ((SELECT id FROM mood WHERE name = 'Triste'), 'Evento de Moda Divertido', 'Desfiles de moda coloridos o talleres de estilo que incluyan accesorios vibrantes.'),
    ((SELECT id FROM mood WHERE name = 'Triste'), 'Evento de Música Energética', 'Música pop o conciertos de música alegre para revitalizar el ánimo.');

-- Estado de Ánimo: Solo
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Solo'), 'Playlist de Compañía', 'Música de acompañamiento para momentos de soledad.'),
    ((SELECT id FROM mood WHERE name = 'Solo'), 'Llamadas de Bienestar y Conexión', 'Llamadas de chequeo programadas con voluntarios o vecinos.'),
    ((SELECT id FROM mood WHERE name = 'Solo'), 'Red de Conexiones para Bienestar', 'Conexión con voluntarios y vecinos locales dispuestos a brindar compañía.'),
    ((SELECT id FROM mood WHERE name = 'Solo'), 'Notificaciones Push para Interacciones Sociales', 'Recordatorios para mantener el contacto con amigos o familiares.');

-- Estado de Ánimo: Enfermo
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Enfermo'), 'Playlist de Relajación', 'Música tranquila y sanadora.'),
    ((SELECT id FROM mood WHERE name = 'Enfermo'), 'Guía de Primeros Auxilios y Salud', 'Información sobre el cuidado de la salud y primeros auxilios.'),
    ((SELECT id FROM mood WHERE name = 'Enfermo'), 'Evento de Moda en Línea', 'Charlas virtuales sobre moda cómoda o eventos que puedan participar desde casa.'),
    ((SELECT id FROM mood WHERE name = 'Enfermo'), 'Evento de Música en Streaming', 'Conciertos virtuales a los que el usuario pueda asistir sin salir de casa.');

-- Estado de Ánimo: De Mal Humor
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'De Mal Humor'), 'Playlist Energética', 'Música animada que eleve el ánimo.'),
    ((SELECT id FROM mood WHERE name = 'De Mal Humor'), 'Look en Colores Fuertes', 'Outfits en colores vibrantes y estilos atrevidos para mejorar el humor.'),
    ((SELECT id FROM mood WHERE name = 'De Mal Humor'), 'Evento de Moda Energético', 'Actividades de moda urbana o talleres de streetwear.'),
    ((SELECT id FROM mood WHERE name = 'De Mal Humor'), 'Evento de Música para Activarse', 'Conciertos de música con ritmos enérgicos, como rock o hip-hop.');

-- Estado de Ánimo: Feliz
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Feliz'), 'Playlist para Mantener el Buen Ánimo', 'Música optimista y de celebración.'),
    ((SELECT id FROM mood WHERE name = 'Feliz'), 'Outfit Celebratorio', 'Estilos festivos o looks de colores vivos para mantener la energía positiva.'),
    ((SELECT id FROM mood WHERE name = 'Feliz'), 'Evento de Moda para Celebrar', 'Desfiles de moda festivos o fiestas temáticas donde puedan compartir su felicidad.'),
    ((SELECT id FROM mood WHERE name = 'Feliz'), 'Festival de Música', 'Recomendación de eventos grandes como festivales de música para celebrar.');

-- Estado de Ánimo: Tranquilo
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Tranquilo'), 'Playlist Relajada', 'Música instrumental o acústica suave para mantener la calma.'),
    ((SELECT id FROM mood WHERE name = 'Tranquilo'), 'Outfit de Comodidad', 'Looks cómodos y relajados que refuercen la calma.'),
    ((SELECT id FROM mood WHERE name = 'Tranquilo'), 'Evento de Moda Diseñadores Estilo Minimalista', 'Actividades de moda con énfasis en el minimalismo y diseño consciente.'),
    ((SELECT id FROM mood WHERE name = 'Tranquilo'), 'Concierto de Música Suave', 'Conciertos acústicos o de jazz para un ambiente relajado.');

-- Estado de Ánimo: Aburrido
INSERT INTO recommendation (mood_id, recommendation_type, description) VALUES
    ((SELECT id FROM mood WHERE name = 'Aburrido'), 'Playlist de Descubrimiento', 'Música nueva o estilos diferentes para salir de la rutina.'),
    ((SELECT id FROM mood WHERE name = 'Aburrido'), 'Outfit Creativo', 'Recomendaciones de moda que incluyan colores y estilos que rompan la monotonía.'),
    ((SELECT id FROM mood WHERE name = 'Aburrido'), 'Evento de Moda para Descubrir', 'Actividades de moda que permitan explorar nuevos estilos y tendencias.'),
    ((SELECT id FROM mood WHERE name = 'Aburrido'), 'Concierto de Música Alternativa', 'Conciertos de música alternativa para explorar nuevos ritmos y artistas.');
