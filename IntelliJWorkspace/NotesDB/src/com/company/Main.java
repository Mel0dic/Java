package com.company;

import java.sql.*;

public class Main {

    private static int iTimeout = 30;

    final static public String DB_NAME = "NOTES_DB";
    final static public String TABLE_NOTES = "NOTES_TO_COMPLETE";
    final static public String TABLE_NOTES_COMPLETED = "NOTES_COMPLETED";
    final static public String CREATE_NOTES = "CREATE TABLE " + TABLE_NOTES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, NOTE_TITLE TEXT, NOTE_BODY TEXT)";
    final static public String CREATE_NOTES_COMPLETED = "CREATE TABLE " + TABLE_NOTES_COMPLETED + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, NOTE_TITLE TEXT, NOTE_BODY TEXT, DATE_COMPLETED DATE)";

    public static void main(String[] args) throws Exception {

        // register the driver
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);

        // now we set up a set of fairly basic string variables to use in the body of the code proper
        String sTempDb = "C:/sqlite/testDB/" + DB_NAME + ".db";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;

        // create a database connection
        Connection conn = DriverManager.getConnection(sDbUrl);

        try {
            Statement stmnt = conn.createStatement();
            try {
                stmnt.setQueryTimeout(iTimeout);
                stmnt.executeUpdate( CREATE_NOTES );
                stmnt.executeUpdate( CREATE_NOTES_COMPLETED );
            }finally {
                try { stmnt.close(); }catch (Exception ignore){ }
            }
        }finally {
            try { conn.close(); }catch (Exception ignore){ }
        }
    }
}
