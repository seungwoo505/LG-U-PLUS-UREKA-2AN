package test1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyWorkbench {
	static Connection con;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Frame f = new Frame();
		
		TextArea ta = new TextArea();
		Panel p = new Panel();
		TextField tf = new TextField(25);
		
		f.add(ta);
		f.add(p, BorderLayout.SOUTH);
		p.add(tf);
		
		dbSeting();
		
		tf.addActionListener((e) -> {
			
			String sql = tf.getText();
			tf.setText("");
			ta.setText("");
			
			try {
				
				if(sql.length() < 6) {
					ta.append("올바르지않은 SQL 문법입니다.");
					return ;
				}
 				
				// SELECT, UPDATE, INSERT 3개만 허용하는 것으로 하기
				String checkSQL = sql.trim().substring(0, 6).toUpperCase();	
				
				if(checkSQL.equals("SELECT")) {
					Statement stmt = con.createStatement();
					
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String id = rs.getString("id");
						String pw = rs.getString("pw");
						String name = rs.getString("name");
						int age = rs.getInt("age");	
						
						ta.append(id + " " + pw + " " + name + " " + age + "\n");
					}
					
				}else if(checkSQL.equals("UPDATE") || checkSQL.equals("INSERT")) {
					PreparedStatement stmt = con.prepareStatement(sql);
					
					int i = stmt.executeUpdate(sql);
					ta.append(i + "행이 " +  (checkSQL.equals("UPDATE") ? "변경" :  "생성")  + "되었습니다.");
					
				}else {
					ta.append("잘못되었거나 사용할수없는 SQL 문법입니다.");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setSize(500, 400);
		f.setVisible(true);
	}

	private static void dbSeting() throws Exception {
		// 1. Driver 등록
		Class.forName("com.mysql.cj.jdbc.Driver");
					
		// 2. Connection
		con = DriverManager.getConnection("jdbc:mysql://localhost/ureka", "ureka", "ureka");
	}

}
