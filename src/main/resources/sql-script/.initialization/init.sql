CREATE TABLE subjects(subject_id serial primary key, name VARCHAR(60) NOT NULL);
CREATE TABLE rooms(room_id serial primary key, number INTEGER);
CREATE TABLE teachers(teacher_id serial primary key, first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL);
CREATE TABLE teachers_subjects(teacher_id integer DEFAULT '0', subject_id integer DEFAULT '0', FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id) on delete cascade on update cascade, FOREIGN KEY (subject_id) REFERENCES subjects(subject_id));
CREATE TABLE groups(group_id serial PRIMARY KEY, name VARCHAR(20) NOT NULL);
CREATE TABLE students(student_id serial primary key, first_name VARCHAR(30), last_name VARCHAR(30), group_id INTEGER NOT NULL REFERENCES groups(group_id) ON DELETE CASCADE ON UPDATE CASCADE);
CREATE TABLE lectures(lecture_id serial primary key,teacher_id INTEGER,group_id INTEGER, subject_id INTEGER, room_id INTEGER, date date,start_time time,end_time time,FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id) on delete cascade on update cascade,FOREIGN KEY (group_id) REFERENCES groups(group_id) on delete cascade on update cascade,FOREIGN KEY (subject_id) REFERENCES subjects(subject_id) on delete cascade on update cascade,FOREIGN KEY (room_id) REFERENCES rooms(room_id) on delete cascade on update cascade);
SET datestyle = "ISO, DMY";
INSERT INTO subjects (name) VALUES ('Math'), ('Biology'), ('English'), ('Chemistry'), ('Music'), ('Art'), ('Geography'), ('Physics'), ('Psychology'), ('Literature');
INSERT INTO rooms (number) VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10);
INSERT INTO teachers(first_name, last_name) VALUES ('Vasiliy','Popov'),('Volodymyr','Kozlov'),('Oleksandr','Pavlov'),('Roman','Makarov'),('Sergei','Orlov');
INSERT INTO teachers_subjects(teacher_id, subject_id) VALUES (1,1),(1,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,9),(5,10);
INSERT INTO groups (name) VALUES ('MB-1'),('MB-2'),('MB-3'),('MB-4'),('MB-5');
INSERT INTO students (first_name, last_name, group_id) VALUES ('Oleg','Voroncov',1),('Myhajlo','Baranov',1),('Slava','Lazarev',2),('Maksim','Danilov',2),('Olga','Osipova',3),('Yana','Bobrova',3),('Oleksandra','Zueva',4),('Kateryna','Voronova',4),('Nastya','Galkina',5),('Svitlana','Savina',5);
INSERT INTO lectures(teacher_id, group_id,subject_id,room_id,date,start_time,end_time) VALUES (5,2,7,1,'17-06-2020','08:00','09:20'),(4,1,6,1,'17-06-2020','08:00','09:20'),(4,1,4,1,'17-06-2020','08:00','09:20'),(1,1,1,1,'17-06-2020','08:00','09:20'),(2,1,5,2,'17-06-2020','08:00','09:20'),(3,2,2,1,'17-06-2020','08:00','09:20'),(1,2,3,1,'17-06-2020','08:00','09:20');

