import java.sql.*;
import java.util.Scanner;

public class SmartOffice {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("id: ");
		String id = sc.next();
		System.out.print("pw: ");
		String pw = sc.next();
		
		UserDTO info = new UserDTO();
		info.setLoginInfo(id, pw);
		
		UserDAO dao = new UserDAO();
		switch(dao.login(info)) {
		case 0:
			System.out.println("로그인 실패. 비밀번호 불일치");
			break;
		case 1:
			System.out.println("로그인 성공");
			break;
		case -1:
			System.out.println("아이디가 없음");
			break;
		case -2:
			System.out.println("오류 발생");
			break;
		}
	}
}
