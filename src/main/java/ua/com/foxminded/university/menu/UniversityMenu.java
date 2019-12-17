package ua.com.foxminded.university.menu;

import java.io.BufferedReader;
import java.io.IOException;

class UniversityMenu extends Menu {
	public void start(String selectedOption, BufferedReader reader) {
		if (!checkIfBackMenu(selectedOption)) {
			if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")
					|| selectedOption.equals("d") || selectedOption.equals("e")) {
				if (selectedOption.equals("a")) {
					teachersMenu(reader);
				} else if (selectedOption.equals("b")) {
					studentsMenu(reader);
				} else if (selectedOption.equals("c")) {
					groupsMenu(reader);
				} else if (selectedOption.equals("d")) {
					roomsMenu(reader);
				} else if (selectedOption.equals("e")) {
					subjectsMenu(reader);
				} else {
					System.out.println(WRONG_INPUT);
				}
			}
		}
	}

	private void subjectsMenu(BufferedReader reader) {
		textMenu.showSubjectsMenuOptions();
		try {
			String selectedOption = reader.readLine();
			if (!checkIfBackMenu(selectedOption)) {
				if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")) {
					if (selectedOption.equals("a")) {
						do {
							String subjectName = reader.readLine();
							university.addSubject(subjectName);
							System.out.println(CONTINUE_ADDING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("b")) {
						do {
							String subjectName = reader.readLine();
							university.removeSubject(subjectName);
							System.out.println(CONTINUE_REMOVING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else {
						university.viewAllSubjects();
					}
				}
			}
		} catch (IOException e) {
			System.out.println(WRONG_INPUT);
		}

	}

	private void roomsMenu(BufferedReader reader) {
		textMenu.showRoomsMenuOptions();
		try {
			String selectedOption = reader.readLine();
			if (!checkIfBackMenu(selectedOption)) {
				if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")) {
					if (selectedOption.equals("a")) {
						do {
							int roomNumber = Integer.parseInt(reader.readLine());
							university.addRoom(roomNumber);
							System.out.println(CONTINUE_ADDING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("b")) {
						do {
							int roomNumber = Integer.parseInt(reader.readLine());
							university.removeRoom(roomNumber);
							System.out.println(CONTINUE_REMOVING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else {
						university.viewAllRooms();
					}
				}
			}
		} catch (IOException e) {
			System.out.println(WRONG_INPUT);
		}
	}

	private void groupsMenu(BufferedReader reader) {
		textMenu.showGroupsMenuOptions();
		try {
			String selectedOption = reader.readLine();
			if (!checkIfBackMenu(selectedOption)) {
				if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")
						|| selectedOption.equals("d") || selectedOption.equals("e")) {
					if (selectedOption.equals("a")) {
						do {
							System.out.println("Enter group name: ");
							String groupName = reader.readLine();
							university.addGroup(groupName);
							System.out.println(CONTINUE_ADDING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("b")) {
						do {
							System.out.println("Enter group name: ");
							String groupName = reader.readLine();
							university.removeGroup(groupName);
							System.out.println(CONTINUE_REMOVING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("c")) {
						do {
							System.out.println("Enter student id: ");
							int studentId = Integer.parseInt(reader.readLine());
							System.out.println("Enter group name: ");
							String groupName = reader.readLine();
							university.changeStudentGroup(studentId, groupName);
							System.out.println(CONTINUE_CHANGING);
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("d")) {
						university.viewAllGroups();
					} else if (selectedOption.equals("e")) {
						do {
							System.out.println("Enter group name: ");
							String groupName = reader.readLine();
							finder.findGroupByName(groupName).showAllStudents();
							System.out.println(CONTINUE_CHANGING);
						} while (!selectedOption.equals(""));
					}
				}
			}
		} catch (IOException e) {
			System.out.println(WRONG_INPUT);
		}
	}

	private void studentsMenu(BufferedReader reader) {
		textMenu.showStudentsMenuOptions();
		try {
			String selectedOption = reader.readLine();
			if (!checkIfBackMenu(selectedOption)) {
				if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")) {
					if (selectedOption.equals("a")) {
						do {
							System.out.println("Enter first name: ");
							String firstName = reader.readLine();
							System.out.println("Enter last name: ");
							String lastName = reader.readLine();
							System.out.println("Enter student id: ");
							int studentId = Integer.parseInt(reader.readLine());
							university.addStudentToUniversity(studentId, firstName, lastName);
							System.out.println(CONTINUE_ADDING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("b")) {
						do {
							System.out.println("Enter student id: ");
							int studentId = Integer.parseInt(reader.readLine());
							university.removeStudentFromUniversity(studentId);
							System.out.println(CONTINUE_REMOVING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else {
						university.viewAllStudents();
					}
				} else {
					System.out.println(WRONG_INPUT);
				}
			}
		} catch (IOException e) {
			System.out.println(WRONG_INPUT);
		}

	}

	private void teachersMenu(BufferedReader reader) {
		textMenu.showTeachersMenuOptions();
		try {
			String selectedOption = reader.readLine();
			if (!checkIfBackMenu(selectedOption)) {
				if (selectedOption.equals("a") || selectedOption.equals("b") || selectedOption.equals("c")) {
					if (selectedOption.equals("a")) {
						do {
							System.out.println("Enter first name: ");
							String firstName = reader.readLine();
							System.out.println("Enter last name: ");
							String lastName = reader.readLine();
							System.out.println("Enter teacher id: ");
							int teacherId = Integer.parseInt(reader.readLine());
							university.addTeacher(teacherId, firstName, lastName);
							System.out.println(CONTINUE_ADDING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else if (selectedOption.equals("b")) {
						do {
							System.out.println("Enter teacher id: ");
							int teacherId = Integer.parseInt(reader.readLine());
							university.removeTeacher(teacherId);
							System.out.println(CONTINUE_REMOVING);
							selectedOption = reader.readLine();
						} while (!selectedOption.equals(""));
					} else {
						university.viewAllTeachers();
					}
				} else {
					System.out.println(WRONG_INPUT);
				}
			}
		} catch (IOException e) {
			System.out.println(WRONG_INPUT);
		}

	}

}
