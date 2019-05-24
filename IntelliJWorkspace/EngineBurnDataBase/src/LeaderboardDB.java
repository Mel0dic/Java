import java.sql.*;

public class LeaderboardDB {

    private static int iTimeout = 30;

    final static public String TABLE_NAME = "GLOBAL_LEADERBOARD";
    final static public String COLUMN_NAME = "USER_NAME";
    final static public String COLUMN_SCORE = "USER_SCORE";
    final static public String COLUMN_POSITION = "USER_POSITION";

    final static public String CREATE_LEADERBOARD = "CREATE TABLE "+ TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_NAME + " TEXT, " + COLUMN_SCORE + " INTEGER, "+ COLUMN_POSITION + " INTEGER)";
    final static public String CREATE_NEW_VALUES = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_SCORE + ", " + COLUMN_POSITION + " ) VALUES('%s', '%d', '%d')";
    final static public String SELECT_ALL = "SELECT " + COLUMN_NAME + " FROM " + TABLE_NAME + " ORDER BY " + COLUMN_SCORE + " ASC;";

    public static void main (String[] args) throws Exception
    {
        // Register the driver being used for the sql
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);

        // Create the file locations
        String sTempDb = "C:/sqlite/testDB/" + TABLE_NAME + ".db";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;

        // Create the connection to the database
        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                // Create the leaderboard
                stmt.executeUpdate( CREATE_LEADERBOARD );
                // Add all the default test data
                for(int i = 0; i < 10; i++) {
                    stmt.executeUpdate(String.format(CREATE_NEW_VALUES, "Null", 0, i+1));
                }
                // Get all the names from the the table sorted by the score
                ResultSet rs = stmt.executeQuery(SELECT_ALL);
                try {
                    // Print out all the names
                    while(rs.next())
                    {
                        String sResult = rs.getString(COLUMN_NAME);
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
