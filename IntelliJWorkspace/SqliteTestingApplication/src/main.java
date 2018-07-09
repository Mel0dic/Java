import java.sql.*;

public class main {

	private static int iTimeout = 30;

	public static final String TABLE_NAME = "QUESTIONS_TABLE";
	public static final String COLUMN_QUESTION = "QUESTION";
	public static final String COLUMN_QUESTION_ANSWER = "ANSWER";

	private static String CREATE_QUESTIONS = "CREATE TABLE "+ TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_QUESTION + " TEXT, " + COLUMN_QUESTION_ANSWER + " TEXT)";
	private static String CREATE_NEW_VALUES = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_QUESTION + ", " + COLUMN_QUESTION_ANSWER + " ) VALUES('%s', '%s')";
	private static String SELECT_QUESTIONS = "SELECT " + COLUMN_QUESTION +" FROM " + TABLE_NAME;

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
				stmt.executeUpdate( String.format(CREATE_NEW_VALUES, "What is the time?", "The time is currently %s") );
				stmt.executeUpdate( String.format(CREATE_NEW_VALUES, "What is the date?", "Todays date is %s") );
				stmt.executeUpdate( String.format(CREATE_NEW_VALUES, "How is the weather today?", "The weather in London is %s") );
				stmt.executeUpdate( String.format(CREATE_NEW_VALUES, "What is the temperature where you are?", "The temperature in London is %s") );
				stmt.executeUpdate( String.format(CREATE_NEW_VALUES, "What will the weather be like tomorrow?", "The weather in London tomorrow will be %s") );
				ResultSet rs = stmt.executeQuery(SELECT_QUESTIONS);
				try {
					while(rs.next())
					{
						String sResult = rs.getString(COLUMN_QUESTION);
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