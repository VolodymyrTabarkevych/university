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
        Teacher teacher = dbCooperator.getTeacherDaoJdbcTemplateImpl().find(1);
        System.out.println(teacher.toString());
        for (Subject subject : teacher.getSubjects()) {
            System.out.println(subject.toString());
        }
    }

}
