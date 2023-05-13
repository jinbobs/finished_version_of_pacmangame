import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement stmt1 =null;
	PasswordFrame a =null;
	static String id;
	static String name1;
	static String name2;
	static String name3;
	Database() {	//데이터베이스에 연결한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC 클래스의 정보를 얻기위한 클래스
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/login", "root", "mite"); //데이터베이스와 연결하는 객체.
			System.out.println("데이터베이스에 접속했습니다.");

		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch (SQLException se) {
			System.out.println("SQL에러입니다. " + se.getMessage());
		}
	}



	// 로그인 정보를 확인 
	boolean logincheck( String _i, String _p) {
		boolean flag = false;

		id = _i;
		String pw = _p;

		try {
			stmt = con.createStatement(); //SQL문을 데이터베이스에 보내기위한 객체이다.
			String checkingStr = "SELECT password FROM register WHERE id ='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr); //SQL문장(SELECT)을 실행하고 그결과를 resultset으로 맅턴한다.


			int count = 0;
			while(result.next()) { //next를 이용하여 커서를 이동시킨다. 패스워드의 일치여부를 알기 위한 코딩.
				if(pw.equals(result.getString("password"))) {
					flag = true;
					System.out.println("로그인 성공");
				}

				else {
					flag = false;
					System.out.println("로그인 실패");
				}
				count++;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 실패 > " + e.toString());
		}

		return flag;
	}

	boolean joinCheck(String _i, String _p) { //회원가입 체크를 위한 코딩.
		boolean flag = false;

		id = _i;
		String pw = _p;

		try {
			String insertStr = "INSERT INTO register(id,password) values (?,?)";
			stmt1 =con.prepareStatement(insertStr);
			stmt1.setString(1, id);
			stmt1.setString(2, pw);
			stmt1.executeUpdate(); // INSERT,UPATE,DELETE SQL문을 쓰기위해 excuteUpdate를 사용

			flag = true;
			System.out.println("회원가입 성공");
		} catch(Exception e) {
			flag = false;
			System.out.println("회원가입 실패 > " + e.toString());
		}

		return flag;
	}

	boolean logindelete(String _i, String _p) {// 회원정보 삭제를 위한 코딩.
		boolean flag = false;

		id = _i;
		String pw = _p;

		try {
			stmt1 = con.prepareStatement("DELETE FROM register WHERE id=? AND password =?");	
			stmt1.setString(1, id);
			stmt1.setString(2, pw);
			stmt1.executeUpdate(); // INSERT,UPATE,DELETE SQL문을 쓰기위해 excuteUpdate를 사용

			flag = true;	
		} catch(Exception e) {
			flag = false;
			System.out.println("정보삭제  실패 > " + e.toString());
		}

		return flag;
	}

	boolean passwordChange(String _i,String _p) { //비밀번호 변경을 위한 코딩.
		boolean flag = false;

		id = _i;
		String pw = _p;


		try {

			stmt1 = con.prepareStatement("UPDATE register SET password = ? WHERE id =?");	
			stmt1.setString(1, pw);
			stmt1.setString(2, id);
			stmt1.executeUpdate(); // INSERT,UPATE,DELETE SQL문을 쓰기위해 excuteUpdate를 사용

			flag = true;
			System.out.println("변경 성공");
		} catch(Exception e) {
			flag = false;
			System.out.println("변경 실패 > " + e.toString());
		}

		return flag;
	}






	boolean Score( String _i) {
		boolean flag = false;
		int count=0;
		id = _i;
		count=pacman.count;
		

		try {
			 
				stmt1 = con.prepareStatement("UPDATE register SET score = ? WHERE id =?");//SQL문을 데이터베이스에 보내기위한 객체이다.	
				stmt1.setInt(1, count);
				stmt1.setString(2, id);
				stmt1.executeUpdate();
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 정보 오류" + e.toString());
		}

		return flag;
	}

boolean Score1st() {
	boolean flag = false;
    
	
	try {
		stmt = con.createStatement(); //SQL문을 데이터베이스에 보내기위한 객체이다.
		String checkingStr = "SELECT id FROM register ORDER BY score  LIMIT 1";
		ResultSet result = stmt.executeQuery(checkingStr); 
		while (result.next()) {
		    String name = result.getString("id");
		    System.out.println(name);
		    name1=name;
		    
		}
		
	
		
	} catch(Exception e) {
		flag = false;
		System.out.println("아이디 정보 오류" + e.toString());
	}

	return flag;
}
boolean Score2nd() {
	boolean flag = false;
    
	
	try {
		stmt = con.createStatement(); //SQL문을 데이터베이스에 보내기위한 객체이다.
		String checkingStr = "SELECT id FROM register ORDER BY score ASC LIMIT 1 OFFSET 1";
		ResultSet result = stmt.executeQuery(checkingStr); 
		while (result.next()) {
		    String name = result.getString("id");
		    System.out.println(name);
		    name2=name;
		    
		}

	
		
	} catch(Exception e) {
		flag = false;
		System.out.println("아이디 정보 오류" + e.toString());
	}

	return flag;
}
boolean Score3rd() {
	boolean flag = false;
    
	
	try {
		stmt = con.createStatement(); //SQL문을 데이터베이스에 보내기위한 객체이다.
		String checkingStr = "SELECT id FROM register  ORDER BY score ASC LIMIT 1 OFFSET 2";
		ResultSet result = stmt.executeQuery(checkingStr); 
		while (result.next()) {
		    String name = result.getString("id");
		    System.out.println(name);
		    name3=name;
		    
		}

	
		
	} catch(Exception e) {
		flag = false;
		System.out.println("아이디 정보 오류" + e.toString());
	}

	return flag;
}


}
