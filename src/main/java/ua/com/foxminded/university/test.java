package ua.com.foxminded.university;

import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Subject;
import ua.com.foxminded.university.domain.Teacher;

public class test {

    public static void main(String[] args) {
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
        Subject subject = new Subject(4, "Alch");
        dbCooperator.getSubjectDaoJdbcTemplateImpl().update(subject);
    }

}
