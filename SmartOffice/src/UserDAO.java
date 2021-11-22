import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private DBConnector db;
	//private Connection conn;
	//private PreparedStatement pstmt;
	//private ResultSet rs;
	
	public UserDAO() {
		db = DBConnector.getInstance();
	}
	
	public int login(UserDTO userInfo) {
		String sql = "SELECT pw FROM USER WHERE id = ?;";
		
		Connection conn = db.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userInfo.getId());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userInfo.getPw())) {
					return 1; // �α��� ����
				}
				else {
					return 0; // ��й�ȣ ����ġ
				}
			}
			return -1; // ���̵� ����
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return -2; // ����
	} // login()
}
