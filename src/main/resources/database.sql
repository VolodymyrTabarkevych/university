CREATE TABLE IF NOT EXISTS subjects(id serial primary key, name VARCHAR(60) NOT NULL);
CREATE TABLE IF NOT EXISTS teachers(id serial primary key, first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL);
CREATE TABLE IF NOT EXISTS teacherssubjects(teacher_id integer DEFAULT '0', subject_id integer DEFAULT '0', FOREIGN KEY (teacher_id) REFERENCES teachers(id) on delete cascade on update cascade, FOREIGN KEY (subject_id) REFERENCES subjects(id));
SELECT teachers.first_name, teachers.last_name, subjects.name FROM teacherssubjects INNER JOIN subjects ON subject_id = subjects.id INNER JOIN teachers ON teacher_id = teachers.id WHERE teacher_id = ?;
CREATE TABLE groups(id serial PRIMARY KEY, name VARCHAR(20) NOT NULL);
CREATE TABLE students(id serial primary key, first_name VARCHAR(30), last_name VARCHAR(30), group_id INTEGER NOT NULL REFERENCES groups(id) ON DELETE CASCADE ON UPDATE CASCADE);