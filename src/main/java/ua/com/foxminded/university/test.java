package ua.com.foxminded.university;

import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;
import ua.com.foxminded.university.domain.Lecture;

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

        /*
         * for (Lecture lecture :
         * dbCooperator.getLectureDaoJdbcTemplateImpl().findAll()) {
         * System.out.println(lecture.toString()); }
         */
        // System.out.println(dbCooperator.getLectureDaoJdbcTemplateImpl().find(1).toString());
        Lecture lecture = dbCooperator.getLectureDaoJdbcTemplateImpl().find(1);
        lecture.setGroup(dbCooperator.getGroupDaoJdbcTemplateImpl().find(2));
        dbCooperator.getLectureDaoJdbcTemplateImpl().update(lecture);
    }

}
