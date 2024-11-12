USE bdtibias;

INSERT INTO profile(id_profile, user_name, profile_image, about_me)
VALUES
(1, 'liz32', 'image1', 'Apasionada por la tecnología y siempre lista para nuevos retos.'),
(2, 'ivanna21', 'image2', 'Amante de la música clásica y la escritura creativa.'),
(3, 'vanessa33', 'image3', 'Aficionada a la moda y el diseño contemporáneo.'),
(4, 'karen44', 'image4', 'Chef amateur y experta en repostería, con gusto por la enseñanza.'),
(5, 'elisa55', 'image5', 'Fotógrafa profesional que disfruta capturando emociones en imágenes.'),
(6, 'azul66', 'image6', 'Ingeniera en nanotecnología con pasión por la maquetación web.'),
(7, 'andrea77', 'image7', 'Voluntaria en organizaciones sin fines de lucro y deportista.'),
(8, 'tibio88', 'image8', 'Programador entusiasta y amante de los juegos de estrategia.');

SELECT COUNT(*) FROM profile;

INSERT INTO users(id_user, user_name, first_name, last_name, telephone, email, password, creation_date, profile_id_profile)
VALUES
(1, 'liz32', 'Lizette', 'Trejo', '5540515285', 'lizettetrejo@gmail.com', 'lizettetrejo', '2024-11-08', 1),
(2, 'ivanna21', 'Ivanna', 'Hernández', '5551234567', 'ivannahernandez21@gmail.com', 'ivanna2024', '2024-11-08', 2),
(3, 'vanessa33', 'Vanessa', 'Morales', '5552345678', 'vanessamorales33@gmail.com', 'vanessa2024', '2024-11-08', 3),
(4, 'karen44', 'Karen', 'Ramírez', '5553456789', 'karenramirez44@gmail.com', 'karen2024', '2024-11-08', 4),
(5, 'elisa55', 'Elisa', 'Gómez', '5554567890', 'elisagomez55@gmail.com', 'elisa2024', '2024-11-08', 5),
(6, 'azul66', 'Azul', 'López', '5555678901', 'azullopez66@gmail.com', 'azul2024', '2024-11-08', 6),
(7, 'andrea77', 'Andrea', 'Díaz', '5556789012', 'andreadiaz77@gmail.com', 'andrea2024', '2024-11-08', 7),
(8, 'tibio88', 'Tibio', 'Santos', '5557890123', 'tibiosantos88@gmail.com', 'tibio2024', '2024-11-08', 8);

INSERT INTO board(id_board, id_admin, description, image, creation_date)
VALUES
(1,1,'Publicacion de board de Lizette', 'imagen', '2024-11-08'),
(2,2,'Publicacion de board de Ivanna', 'imagen', '2024-11-08'),
(3,3,'Publicacion de board de Vanessa', 'imagen', '2024-11-08'),
(4,4,'Publicacion de board de Karen', 'imagen', '2024-11-08'),
(5,5,'Publicacion de board de Elisa', 'imagen', '2024-11-08'),
(6,6,'Publicacion de board de Azul', 'imagen', '2024-11-08'),
(7,7,'Publicacion de board de Andrea', 'imagen', '2024-11-08');

SELECT COUNT(*) FROM board;

INSERT INTO admins (id_admins, name, board_id_board, users_id_user)
VALUES 
(1, 'Lizette', 1, 1),
(2, 'Ivanna', 1, 2),
(3, 'Vanessa', 1, 3),
(4, 'Karen', 1, 4),
(5, 'Elisa', 1, 5),
(6, 'Azul', 1, 6),
(7, 'Andrea', 1, 7);

INSERT INTO label (id_label, Categories)
VALUES
(1, 'Cuidado persnal'),
(2, 'Salud'),
(3, 'Cultura'),
(4, 'Ocio');

INSERT INTO post (id_post, content, image, creation_date, label_id_label, users_id_user) VALUES
(1,'¡La mentoría ha sido clave para mi crecimiento!No olviden que no estamos solas.', 'mentoria.jpg', '2024-11-08', 1, 1),
(2,'Cada vez más mujeres están ocupando roles de liderazgo, ¡y es inspirador!', 'mentoria.jpg', '2024-11-08', 1, 1),
(3,'La salud mental es un tema tan importante, especialmente con el ritmo de vida actual. ¿Qué actividades o prácticas les ayudan a mantener el bienestar emocional? Es hora de actuar', 'mentoria.jpg', '2024-11-08', 1, 1),
(4,'A veces es complicado encontrar tiempo para nosotras mismas entre el trabajo y la familia.Pero lo importante es Valorarte', 'mentoria.jpg', '2024-11-08', 1, 1),
(5,'¡Hola, chicas! ¿Alguien ha comenzado su propio negocio recientemente?Si no es asi y tienes miedo recuerda que solo tu puedes impedirte un brillante futuro , decide hoy', 'mentoria.jpg', '2024-11-08', 1, 1);

INSERT INTO favorite(id_favorite,users_id_user, post_id_post)
VALUES
(1,1,1),
(2,2,2),
(3,3,3),
(4,4,4),
(5,5,5);


