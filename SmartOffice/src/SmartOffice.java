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
			System.out.println("�α��� ����. ��й�ȣ ����ġ");
			break;
		case 1:
			System.out.println("�α��� ����");
			break;
		case -1:
			System.out.println("���̵� ����");
			break;
		case -2:
			System.out.println("���� �߻�");
			break;
		}
	}
}
