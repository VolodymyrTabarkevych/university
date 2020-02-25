package ua.com.foxminded.university;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.foxminded.university.console.GroupsMenu;
import ua.com.foxminded.university.console.TimetableMenu;
import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;

public class test {

    public static void main(String[] args) throws IOException {
        DbConnection dbConnection = new DbConnection();
        DbCooperator dbCooperator = new DbCooperator(dbConnection.init());
        /*
         * Teacher teacher =
         * dbCooperator.getTeacherDaoJdbcTemplateImpl().findAllSubjects(1); for (Subject
         * subject : teacher.getSubjects()) { System.out.println(subject.toString()); }
         */
        /*
         * for (Teacher teacher :
         * dbCooperator.getTeacherDaoJdbcTemplateImpl().findAll()) {
         * System.out.println(teacher.toString()); }
         */
        /*
         * Teacher teacher = dbCooperator.getTeacherDaoJdbcTemplateImpl().save(new
         * Teacher(1,"OOO", "VVV")); System.out.println(teacher.toString()); for
         * (Subject subject : teacher.getSubjects()) {
         * System.out.println(subject.toString()); }
         */
        /*
         * Teacher teacher = new Teacher("Teacher", "ForMath"); teacher.addSubject(new
         * Subject("Math")); dbCooperator.getTeacherDaoJdbcTemplateImpl().save(teacher);
         */

        /*
         * for (Lecture lecture :
         * dbCooperator.getLectureDaoJdbcTemplateImpl().findAll()) {
         * System.out.println(lecture.toString()); }
         */
        // System.out.println(dbCooperator.getLectureDaoJdbcTemplateImpl().find(1).toString());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TimetableMenu timetableMenu = new TimetableMenu(dbCooperator);
        timetableMenu.start("a", reader);
    }

}
