package ua.com.foxminded.university;

import ua.com.foxminded.university.dao.DbConnection;
import ua.com.foxminded.university.dao.DbCooperator;

public class test {

    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();
        DbCooperator dbCooperator = new DbCooperator(dbConnection.init());
        dbCooperator.getGroupDaoJdbcTemplateImpl().find(1);
    }

}
