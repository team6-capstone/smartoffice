import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static Connection dbConn = null;
	
	private DBConnector() {}
	
	private static class LazyHolder {
		private static final DBConnector instance = new DBConnector();
	} // class LazyHolder
	
	public static DBConnector getInstance() {
		return LazyHolder.instance;
	} // getInstance()
	
	public static Connection getConnection() {
		if(dbConn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // driver
				dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_office",
													 "smartoffice", "team6"); // url, id, pw
				System.out.println("DB ���� �Ϸ�");
			}
			catch(ClassNotFoundException e) {
				System.out.println("JDBC ����̹� �ε� ����");
			}
			catch(SQLException e) {
				System.out.println("DB ���� ����");
			}
			catch(Exception e) {
				e.printStackTrace();
			} // try..catch
		} // if
		
		return dbConn;
	} // getConnection()
	
	public static void close() throws SQLException {
		if(dbConn != null) {
			if(!dbConn.isClosed()) {
				dbConn.close();
			}
		}
	} // close()
} // class DBConnection
