package Notepad;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	TextField tf;
	TextArea ta;
	
	public Main() {
		// 생성자
		Frame f = new Frame();
		Button b1 = new Button("전송1");
		Panel p = new Panel();
		tf = new TextField(25);
		ta = new TextArea();
		MenuBar mb = new MenuBar();
		Menu file_menu = new Menu("file");
		Menu edit_menu = new Menu("edit");
		MenuItem save_item = new MenuItem("save");
		MenuItem open_item = new MenuItem("open");
		
		// 프레임 사이즈 설정
		f.setSize(500, 600);
		f.setBackground(Color.BLACK);
		
		f.setMenuBar(mb);
		mb.add(file_menu);
		mb.add(edit_menu);
		file_menu.add(open_item);
		file_menu.add(save_item);
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);
		p.add(tf);
		p.add(b1);
		
		save_item.addActionListener(e -> { //save_item이 클릭되었을 때
			FileDialog save_dialog = new FileDialog(f, "save", FileDialog.SAVE);
			save_dialog.setVisible(true);
			
			try {
				FileWriter fw = new FileWriter(save_dialog.getDirectory() + save_dialog.getFile());
				fw.write(ta.getText());
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		open_item.addActionListener(e -> {
			FileDialog open_dialog = new FileDialog(f, "open", FileDialog.LOAD);
		});
		
		tf.addActionListener(e -> { //익명 클래스 람다식으로 선언 (성능은 오히려 떨어질 수 있음 JVM이 해석하는 시간이 필요)
				// TODO Auto-generated method stub
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
		);
		
		//익명클래스를 통해 가독성 상승
		f.addWindowListener(new WindowAdapter(){ //익명 클래스 선언
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
	
	//INNER CLASS
	
	//실제 작동하는 곳에서 어떤 기능을 하는지 보려면 여기까지 와야하는 문제가 발생
	//이로 인해 가독성이 떨어진다.
	// 그래서 하나로 사용될 경유 익명 클래스를 통해 가독성 상승시킨다.
	/*
	public class MyButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ta.append(tf.getText() + "\n");
			tf.setText("");
		}

	}
	*/

}

//OUTER CLASS
