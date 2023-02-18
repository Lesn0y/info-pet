CREATE SCHEMA IF NOT EXISTS infopet;

CREATE TABLE IF NOT EXISTS infopet.animals
(
    id          SERIAL PRIMARY KEY,
    animal_name VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS infopet.filters
(
    id          SERIAL PRIMARY KEY,
    filter_name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS infopet.breeds
(
    id          SERIAL PRIMARY KEY,
    animal_id INT REFERENCES infopet.animals (id)
        ON UPDATE CASCADE,
    breed_name  VARCHAR(30) UNIQUE NOT NULL,
    img_url     VARCHAR(150)       NOT NULL,
    subtitle    VARCHAR(250)       NOT NULL,
    character   text,
    training    text,
    diet        text,
    care        text,
    gallery_url varchar(255)
);

CREATE TABLE IF NOT EXISTS infopet.breeds_parameters
(
    id serial PRIMARY KEY,
    breed_id  INT REFERENCES infopet.breeds (id),
    parameter VARCHAR(50) NOT NULL,
    value     VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS infopet.breed_filters
(
    breed_id   INT REFERENCES infopet.breeds (id),
    filters_id INT REFERENCES infopet.filters (id),
    PRIMARY KEY (breed_id, filters_id)
);

CREATE TABLE IF NOT EXISTS infopet.animal_filters
(
    animal_id  INT REFERENCES infopet.animals (id),
    filters_id INT REFERENCES infopet.filters (id),
    PRIMARY KEY (animal_id, filters_id)
);

-- ANIMALS

INSERT INTO infopet.animals (animal_name)
VALUES ('Собаки');

INSERT INTO infopet.animals (animal_name)
VALUES ('Кошки');

INSERT INTO infopet.animals (animal_name)
VALUES ('Рыбы');

INSERT INTO infopet.animals (animal_name)
VALUES ('Птицы');

-- FILTERS

INSERT INTO infopet.filters (id, filter_name)
VALUES (DEFAULT, 'Умные');

INSERT INTO infopet.filters (id, filter_name)
VALUES (DEFAULT, 'Большие');

INSERT INTO infopet.filters (id, filter_name)
VALUES (DEFAULT, 'Маленькие');

INSERT INTO infopet.filters (id, filter_name)
VALUES (DEFAULT, 'Милые');

INSERT INTO infopet.filters (id, filter_name)
VALUES (DEFAULT, 'Ленивые');

-- BREED

INSERT INTO infopet.breeds (id, animal_id, breed_name, img_url, subtitle, character, training, diet, care,
                           gallery_url)
VALUES (DEFAULT, 1, 'Бульдог', '/img/buldog.jpg', 'Сабтайтл', 'Харктрер', 'Тренировка', 'Диета', 'Забота',
        '/img/buldogs');

INSERT INTO infopet.breeds (id, animal_id, breed_name, img_url, subtitle, character, training, diet, care,
                           gallery_url)
VALUES (DEFAULT, 2, 'Дворовая', '/img/cat.jpg', 'Кошка', 'Мягкий', 'Нет', 'Мыши', 'Ласковая', '/img/cats');

-- BREED - FILTERS

INSERT INTO infopet.breed_filters (breed_id, filters_id)
VALUES (1, 2);

INSERT INTO infopet.breed_filters (breed_id, filters_id)
VALUES (1, 3);

INSERT INTO infopet.breed_filters (breed_id, filters_id)
VALUES (1, 4);

INSERT INTO infopet.breed_filters (breed_id, filters_id)
VALUES (2, 4);

INSERT INTO infopet.breed_filters (breed_id, filters_id)
VALUES (2, 5);

-- ANIMAL - FILTERS

INSERT INTO infopet.animal_filters (animal_id, filters_id)
VALUES (1, 1);

INSERT INTO infopet.animal_filters (animal_id, filters_id)
VALUES (1, 3);

INSERT INTO infopet.animal_filters (animal_id, filters_id)
VALUES (1, 5);

INSERT INTO infopet.animal_filters (animal_id, filters_id)
VALUES (1, 4);

INSERT INTO infopet.animal_filters (animal_id, filters_id)
VALUES (2, 2);

INSERT INTO infopet.animal_filters (animal_id, filters_id)
VALUES (2, 3);

-- PARAMETERS

INSERT INTO infopet.breeds_parameters(breed_id, parameter, value)
VALUES (1, 'Происхождение', 'Германия');

INSERT INTO infopet.breeds_parameters(breed_id, parameter, value)
VALUES (1, 'Рост', '25 см');

INSERT INTO infopet.breeds_parameters(breed_id, parameter, value)
VALUES (1, 'Вес', '25 кг');

INSERT INTO infopet.breeds_parameters(breed_id, parameter, value)
VALUES (2, 'Вес', '5 кг');

-- DROP TABLE infopet.animals CASCADE;
-- DROP TABLE infopet.breed CASCADE;
-- DROP TABLE infopet.breed_filters CASCADE;
-- DROP TABLE infopet.filters CASCADE;
-- DROP TABLE infopet.breeds_description CASCADE;