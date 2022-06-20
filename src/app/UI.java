package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;


public class UI {
	
	Dao<Integer, AnimalVo> dao;
	java.util.List<AnimalVo> alist; //밑에 list랑 다름
	
	Frame f;
	Button b1, b2, b3, b4;
	Panel p1, p2;
	Panel main;
	TextField tf1, tf2, tf3;
	TextField maintf;
	List list;//배운 list아니고 *임
	
	public UI() {
		dao = new AnimalDao();
		
		init();
		make();
		addEvent();
	}
	public void init() {//생성
		f = new Frame("My Frame");
		b1 = new Button("ADD");
		b2 = new Button("SELECT");
		b3 = new Button("DELETE");
		b4 = new Button("UPDATE");
		p1 = new Panel();
		p2 = new Panel();
		main = new Panel();
		maintf = new TextField();
		tf1 = new TextField("ID를 입력하세요");
		tf2 = new TextField("SPECIES를 입력하세요");
		tf3 = new TextField("AGE를 입력하세요");
		list = new List();
		
	}
	public void make() {//frame에 붙이기
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.BLUE);
		list.setBackground(Color.CYAN);
		b1.setBackground(Color.GREEN);

		
		p2.setLayout(new BorderLayout());//p2의 속성 바꾸기
		p2.add(list, "Center");
		p2.add(b2, "South");
		
		p1.setLayout(new GridLayout(6, 1));//필요한 속성 바꾸기
		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(b1);
		p1.add(b3);
		p1.add(b4);
		
		main.setLayout(new GridLayout(1, 2));//배치 바꾸기, 1행 2열
		main.add(p1);
		main.add(p2);
		
		f.add(main, "Center");
		f.add(maintf, "South");
		
		f.setSize(500, 500);
		f.setVisible(true);
		
	}
	public void addEvent() {
		list.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int t = list.getSelectedIndex();
				AnimalVo ani = alist.get(t);
				String s = ani.getId()+ "  " + ani.getSpecies()+ "   "+ ani.getAge();
				maintf.setText(s);
				
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				int i = Integer.parseInt(id);
				
				String species = tf2.getText();
				
				String age = tf3.getText();
				int ii = Integer.parseInt(age);
				
				AnimalVo v = new AnimalVo(i, species, ii);
				try {
					dao.insert(v);
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					maintf.setText(id+"    Insert OK");
				} catch (Exception e1) {
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					maintf.setText("Insert Error ... !!!");
				}			
			}
		});
		
		b2.addActionListener(new ActionListener() {//select해서 뿌린다
			
			@Override
			public void actionPerformed(ActionEvent e) {//버튼을 누르면 이 안에서 처리
				try {
					list.removeAll();
					alist = dao.select();
					for (AnimalVo a : alist) {
						String str = a.getId()+ "  "+a.getAge();
						list.add(str);
						maintf.setText(alist.size()+":Completed");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
       b3.addActionListener(new ActionListener() {//select해서 뿌린다
			
			@Override
			public void actionPerformed(ActionEvent e) {//버튼을 누르면 이 안에서 처리
				
				String i = tf1.getText();
				int id = Integer.parseInt(i);
				try {
					dao.delete(id);
					tf1.setText("");
					maintf.setText(id+"Deleted Ok!");	
				} catch (Exception e1) {
					maintf.setText("Deleted Error...!!!");
					tf1.setText("");
					e1.printStackTrace();
				}
			}
		});	
       
       b4.addActionListener(new ActionListener() {//select해서 뿌린다
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String id = tf1.getText();
			int i = Integer.parseInt(id);
			
			String species = tf2.getText();
			
			String age = tf3.getText();
			int ii = Integer.parseInt(age);
			
			AnimalVo v = new AnimalVo(i, species, ii);
			try {
				dao.update(v);
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				maintf.setText(id+"    Update OK");
			} catch (Exception e1) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				maintf.setText("Update Error ... !!!");
			}
		}
	});
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
  }