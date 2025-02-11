package Member;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

public class Member {

	public static void main(String[] args) {
		ArrayList<Map<String, String>> member = new ArrayList<>();
		boolean sign = false;
		
		Frame f = new Frame();
		Button login = new Button("로그인");
		Button logout = new Button("로그아웃");
		Button sign1 = new Button("회원가입");
		Button sign2 = new Button("가입하기");
		Button allBtn = new Button("전체 보기");
		
		Panel p = new Panel();
		TextArea ta = new TextArea();
		JLabel idLabel = new JLabel("id : ");
		TextField id = new TextField(10);
		JLabel pwLabel = new JLabel("password : ");
		TextField pw = new TextField(20);
		JLabel nameLabel = new JLabel("이름 : ");
		TextField name = new TextField(15);
		
		f.setSize(1000, 1000);
		f.setBackground(Color.WHITE);
		
		
		p.add(idLabel);
		p.add(id);
		p.add(pwLabel);
		p.add(pw);
		p.add(login);
		p.add(sign1);
		
		f.add(p, BorderLayout.SOUTH);
		f.add(ta, BorderLayout.CENTER);
		
		login.addActionListener(e ->{
			if(id.getText().equals("")) {
				ta.setText("id는 필수값입니다.\n입력해주세요");
				return ;
			}
			if(pw.getText().equals("")) {
				ta.setText("pw는 필수값입니다.\n입력해주세요");
				return ;
			}
			
			for(Map<String, String> m : member) {
				if(m.get("id").equals(id.getText()) && m.get("password").equals(pw.getText())){
					ta.setText(m.get("id") + "님 환영합니다.");
					p.removeAll();
					p.revalidate();
					p.repaint();
					
					p.add(logout);
					p.add(allBtn);
					p.revalidate();
					p.repaint();
					
					id.setText("");
					pw.setText("");
					return ;
				}
			}
			ta.setText("아이디나 패스워드 중 잘못입력하였습니다.\n재입력 후 다시시도해주세요.");
		});
		
		logout.addActionListener(e -> {
			p.removeAll();
			p.revalidate();
			p.repaint();
			
			p.add(idLabel);
			p.add(id);
			p.add(pwLabel);
			p.add(pw);
			p.add(login);
			p.add(sign1);
			
			p.revalidate();
			p.repaint();
			
			ta.setText("");
		});
		
		sign1.addActionListener(e -> {
			id.setText("");
			pw.setText("");
			
			p.removeAll();
			p.revalidate();
			p.repaint();
			
			p.add(idLabel);
			p.add(id);
			p.add(pwLabel);
			p.add(pw);
			p.add(nameLabel);
			p.add(name);
			p.add(sign2);
			
			p.revalidate();
			p.repaint();
		});
		
		sign2.addActionListener(e -> {
			if(id.getText().equals("")) {
				ta.setText("id는 필수값입니다.\n입력해주세요");
				return ;
			}
			if(pw.getText().equals("")) {
				ta.setText("pw는 필수값입니다.\n입력해주세요");
				return ;
			}
			if(name.getText().equals("")) {
				ta.setText("이름은 필수값입니다.\n입력해주세요");
				return ;
			}
			for(Map<String, String> m : member) {
				if(m.get("id").equals(id.getText())) {
					ta.setText(id.getText() + "는 이미 사용된 id입니다. \n다른 아이디를 입력해주시길바랍니다.");
					return ;
				}
			}
			Map<String, String> mem = new HashMap<>();
			mem.put("id", id.getText());
			mem.put("password", pw.getText());
			mem.put("name", name.getText());
			
			member.add(mem);
			
			id.setText("");
			pw.setText("");
			name.setText("");
			
			ta.setText(mem.get("id") + "님 가입을 축하드립니다.\n");
			ta.append(member.size() + "번째 회원이 되신걸 환영합니다.");
			
			p.removeAll();
			p.revalidate();
			p.repaint();
			
			p.add(idLabel);
			p.add(id);
			p.add(pwLabel);
			p.add(pw);
			p.add(login);
			p.add(sign1);
			
			p.revalidate();
			p.repaint();
		});
		
		allBtn.addActionListener(e -> {
			ta.setText("");
			
			for(int i = 0; i < member.size(); i++) {
				ta.append( (i + 1) + " id : " + member.get(i).get("id") + " password : " + member.get(i).get("password") + " name : " + member.get(i).get("name") + "\n");
			}
		});
		
		f.addWindowListener(new WindowAdapter(){ //익명 클래스 선언
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
}