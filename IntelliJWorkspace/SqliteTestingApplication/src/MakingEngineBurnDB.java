import java.sql.*;

public class MakingEngineBurnDB {

    private static int iTimeout = 30;

    final static public String TABLE_NAME = "GAME_SETTINGS";
    final static public String COLUMN_SETTING_NAME = "SETTING_NAME";
    final static public String COLUMN_SETTING_VALUE = "SETTING_VALUE";

    final static public String CREATE_QUESTIONS = "CREATE TABLE "+ TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_SETTING_NAME + " TEXT, " + COLUMN_SETTING_VALUE + " TEXT)";
    final static public String CREATE_NEW_VALUES = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_SETTING_NAME + ", " + COLUMN_SETTING_VALUE + " ) VALUES('%s', '%s')";
    final static public String SELECT_QUESTIONS = "SELECT " + COLUMN_SETTING_NAME +" FROM " + TABLE_NAME;

    final static public String CHARACTER_SETTING = "CHARACTER_SETTING";

    public static void main (String[] args) throws Exception
    {
        // register the driver
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);

        // now we set up a set of fairly basic string variables to use in the body of the code proper
        String sTempDb = "C:/sqlite/testDB/" + TABLE_NAME + ".db";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;

        // create a database connection
        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                stmt.executeUpdate( CREATE_QUESTIONS );
                stmt.executeUpdate( String.format(CREATE_NEW_VALUES, CHARACTER_SETTING, "DEFAULT_UFO") );
                ResultSet rs = stmt.executeQuery(SELECT_QUESTIONS);
                try {
                    while(rs.next())
                    {
                        String sResult = rs.getString(COLUMN_SETTING_NAME);
                        System.out.println(sResult);
                    }
                } finally {
                    try { rs.close(); } catch (Exception ignore) {}
                }
            } finally {
                try { stmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { conn.close(); } catch (Exception ignore) {}
        }
    }

}
