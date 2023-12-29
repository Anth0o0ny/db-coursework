INSERT INTO pool (name, pool_size) VALUES
  ('ПОЛЕТ', '_25'::POOL_SIZE),
  ('Океан', '_50'::POOL_SIZE),
  ('AquaSwim', '_50'::POOL_SIZE),
  ('SwimCity', '_25'::POOL_SIZE),
  ('Дом плавания', '_25'::POOL_SIZE),
  ('Атлантика', '_50'::POOL_SIZE);


INSERT INTO sports_school (name, pool_id) VALUES
  ('Школа7 города Новосибирск', 1),
  ('Школа Спортивных Чемпионов', 2),
  ('СДЮСШОР "Радуга"', 3),
  ('Спортивный клуб "Динамо"', 4),
  ('Школа плавания Эдуарда Гурьянова', 5),
  ('Школа олимпийского резерва по плаванию', 6);


INSERT INTO sportsman (full_name, yob, rank, sportschool_id) VALUES
  ('Коромысло Иван Филиппович', '2003-03-22', 'MS'::RANK, 6),
  ('Фэлпс Федор Джонсович', '2000-12-02', 'III_Y'::RANK, 1),
  ('Петров Баттерфляй Иванович', '2006-06-03', 'I_A'::RANK, 2),
  ('Аллаяров Игорь Олегович', '2003-10-02', 'MS'::RANK, 4),
  ('Брасов Алексей Кроллович', '2002-1-01', 'II_A'::RANK, 3),
  ('Бревно Максим Невсплываевич', '2003-11-21', 'CMS'::RANK, 5);


INSERT INTO coach (full_name, yob, sportschool_id) VALUES
  ('Победилов Василий Напенсиивич', '1788-03-08', 1),
  ('Рекодров Олег Побитович', '1988-09-01', 3),
  ('Старов Михаил Фелпсович', '1968-08-15', 4),
  ('Кроль Геннадий Баттерфляевич', '1980-08-19', 5),
  ('Бесов Никита Кукушкинович', '1986-06-06', 6);


INSERT INTO medical_checkup (date, sportsman_id, doping_check) VALUES
  ('2017-05-27', 1, 'False'),
  ('2023-09-01', 2, 'True'),
  ('2014-06-03', 3, 'False'),
  ('2023-11-03', 4, 'False'),
  ('2021-12-31', 5, 'False'),
  ('2014-01-1', 6, 'False');


INSERT INTO competition (name, pool_id, start_date, end_date, distance) VALUES
  ('Кубок золотого поршня', 1, '2023-09-09', '2023-09-15', '_50_BUTTERFLY'::DISTANCE),
  ('Плаваем вместе', 5, '2021-01-02', '2021-01-10', '_100_BREASTSTROKE'::DISTANCE),
  ('Чемпионат и первенство ДВФО', 1, '2023-10-01', '2023-10-03', '_1500_FREESTYLE'::DISTANCE),
  ('Чемпионат России по плаванию', 2, '2023-05-20', '2023-10-17','_200_BREASTSTROKE'::DISTANCE),
  ('Золотой граммофон', 3, '2017-03-17', '2020-02-12', '_400_MEDLEY'::DISTANCE),
  ('Российский чемпионат "Мне не холодно"', 4, '2022-06-03', '2022-07-03', '_50_BACKSTROKE'::DISTANCE);


INSERT INTO entry (competition_id, sportsman_id) VALUES
  (1, 1),
  (1, 2),
  (1, 3);
INSERT INTO entry (competition_id, sportsman_id) VALUES
  (2, 1),
  (2, 2),
  (2, 4);


INSERT INTO result (sportsman_id, distance, time, competition_id, rank) VALUES
  (1, '_50_BUTTERFLY'::DISTANCE, '00:22:30', 1, 'I_A'::RANK),
  (2, '_50_BUTTERFLY'::DISTANCE, '00:23:15', 1, 'II_A'::RANK),
  (3, '_50_BUTTERFLY'::DISTANCE, '00:24:00', 1, 'III_A'::RANK);


INSERT INTO result (sportsman_id, distance, time, competition_id, rank) VALUES
  (1, '_100_BACKSTROKE'::DISTANCE, '00:11:45', 2, 'I_A'::RANK),
  (2, '_100_BACKSTROKE'::DISTANCE, '00:12:30', 2, 'II_A'::RANK),
  (4, '_100_BACKSTROKE'::DISTANCE, '00:13:15', 2, 'III_Y'::RANK);


INSERT INTO training (coach_id, sportsman_id) VALUES
  (1, 1),
  (2, 2),
  (3, 3);


INSERT INTO training_event (sportsman_id, coach_id, training_id) VALUES
  (1, 1, 1),
  (2, 2, 2),
  (3, 3, 3);


INSERT INTO exercise (description, count, training_id) VALUES
  ('Подтягивания', 10,1),
  ('Приседания', 20,1),
  ('Отжимания', 15,1),
  ('Плавание вольным стилем', 400,2),
  ('Бег 100 метров', 1,2);