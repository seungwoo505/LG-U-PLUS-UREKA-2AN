package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		
		/**
		 * JDBC 6단계
		 */
		
		try {
			// 1. Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ureka", "ureka", "ureka");
			
			// 3. Statement 생성
			Statement stmt = con.createStatement();
			
			// 4. SQL 전송
			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER"); // 안의 구문은 select 이여야한다 만약 다른 것을 사용할 경우 다른 매서드 사용
			
			// 5. 결과 얻기
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");	
				
				System.out.println(id + " " + pw + " " + name + " " + age);
			}
			
			// 6. 자원 닫기
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
