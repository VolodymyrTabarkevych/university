CREATE TABLE IF NOT EXISTS subjects(id serial primary key, name VARCHAR(60) NOT NULL);
CREATE TABLE IF NOT EXISTS teachers(id serial primary key, first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL);
CREATE TABLE IF NOT EXISTS teacherssubjects(teacher_id integer DEFAULT '0', subject_id integer DEFAULT '0', FOREIGN KEY (teacher_id) REFERENCES teachers(id) on delete cascade on update cascade, FOREIGN KEY (subject_id) REFERENCES subjects(id));
SELECT teachers.first_name, teachers.last_name, subjects.name FROM teacherssubjects INNER JOIN subjects ON subject_id = subjects.id INNER JOIN teachers ON teacher_id = teachers.id WHERE teacher_id = ?;
CREATE TABLE groups(id serial PRIMARY KEY, name VARCHAR(20) NOT NULL);
CREATE TABLE students(id serial primary key, first_name VARCHAR(30), last_name VARCHAR(30), group_id INTEGER NOT NULL REFERENCES groups(id) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE lectures(lecture_id serial primary key,
					  teacher_id INTEGER,
					  group_id INTEGER, 
					  subject_id INTEGER, 
					  room_id INTEGER, 
					  lecture_begin TIMESTAMP,
					  lecture_end TIMESTAMP,
					  FOREIGN KEY (teacher_id) REFERENCES teachers(id) on delete cascade on update cascade,
					  FOREIGN KEY (group_id) REFERENCES groups(id) on delete cascade on update cascade,
					  FOREIGN KEY (subject_id) REFERENCES subjects(id) on delete cascade on update cascade,
					  FOREIGN KEY (room_id) REFERENCES rooms(id) on delete cascade on update cascade);
SELECT teachers.first_name,
teachers.last_name,
groups.name as group_name,
subjects.name as subject_name,
rooms.number as room_number,
lecture_begin, 
lecture_end 
FROM lectures 
INNER JOIN teachers ON teacher_id = teachers.id 
INNER JOIN groups ON group_id = groups.id 
INNER JOIN subjects ON subject_id = subjects.id
INNER JOIN rooms ON room_id = rooms.id;