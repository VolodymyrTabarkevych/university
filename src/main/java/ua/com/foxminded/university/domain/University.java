package ua.com.foxminded.university.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class University {
	private Set<Teacher> teachers = new LinkedHashSet<>();
	private Set<Student> students = new HashSet<>();
	private Set<Group> groups = new HashSet<>();
	private Set<Subject> subjects = new HashSet<>();
	private Set<Room> rooms = new HashSet<>();
	private Timetable timetable = new Timetable();

	public void addTeacher(int id, String firstName, String lastName) {
		for (Teacher teacher : teachers) {
			if (teacher.getId() == id) {
				System.out.println("Teacher with such id is already exists!");
				return;
			}
		}
		teachers.add(new Teacher(id, firstName, lastName));
		System.out.println("Teacher was added!");
	}

	public void removeTeacher(int id) {
		for (Teacher teacher : teachers) {
			if (teacher.getId() == id) {
				teachers.remove(teacher);
				System.out.println("Teacher was removed!");
				return;
			}
		}
		System.out.println("No teacher with such id!");
	}

	public void addStudentToUniversity(int id, String firstName, String lastName) {
		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println("Teacher with such id is already exists!");
				return;
			}
		}
		students.add(new Student(id, firstName, lastName));
		System.out.println("Student was added!");
	}

	public void removeStudentFromUniversity(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				students.remove(student);
				System.out.println("Student was removed!");
				return;
			}
		}
		System.out.println("No student with such id!");
	}

	public void changeStudentGroup(int studentId, String groupName) {
		for (Student student : students) {
			if (student.getId() == studentId) {
				for (Group group : groups) {
					if (group.getName().equals(groupName)) {
						group.addStudent(student);
						System.out.println("Student was added to the group!");
						return;
					}
				}
			}
		}
		System.out.println("Student wasnt added to the group!");
	}

	public void addGroup(String groupName) {
		for (Group group : groups) {
			if (group.getName().equals(groupName)) {
				System.out.println("Group with such name is already exists!");
				return;
			}
		}
		groups.add(new Group(groupName));
	}

	public void removeGroup(String groupName) {
		for (Group group : groups) {
			if (group.getName().equals(groupName)) {
				groups.remove(group);
				System.out.println("Group was removed!");
				return;
			}
		}
		System.out.println("No group with such id!");
	}

	public void addSubject(String name) {
		for (Subject subject : subjects) {
			if (subject.getName().equals(name)) {
				System.out.println("Such subject is already exists!");
				return;
			}
		}
		subjects.add(new Subject(name));
		System.out.println("Subject was added!");
	}

	public void removeSubject(String name) {
		for (Subject subject : subjects) {
			if (subject.getName().equals(name)) {
				subjects.remove(subject);
				System.out.println("Subject was removed!");
				return;
			}
		}
		System.out.println("No subject with such name!");
	}

	public void addRoom(int roomNumber) {
		for (Room room : rooms) {
			if (room.getNumber() == roomNumber) {
				System.out.println("Room with such number is already exists!");
				return;
			}
		}
		rooms.add(new Room(roomNumber));
		System.out.println("Room was added to university!");
	}

	public void removeRoom(int roomNumber) {
		for (Room room : rooms) {
			if (room.getNumber() == roomNumber) {
				rooms.remove(room);
				System.out.println("Room was removed from university!");
				return;
			}
		}
		System.out.println("No room with such number!");
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void viewAllTeachers() {
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getFirstName() + " " + teacher.getLastName());
		}
	}

	public void viewAllStudents() {
		for (Student student : students) {
			System.out.println(student.getFirstName() + " " + student.getLastName());
		}
	}

	public void viewAllGroups() {
		for (Group group : groups) {
			System.out.println(group.getName());
		}
	}

	public void viewAllSubjects() {
		for (Subject subject : subjects) {
			System.out.println(subject.getName());
		}
	}

	public void viewAllRooms() {
		for (Room room : rooms) {
			System.out.println(room.getNumber());
		}
	}
}
