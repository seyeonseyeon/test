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
	java.util.List<AnimalVo> alist; //�ؿ� list�� �ٸ�
	
	Frame f;
	Button b1, b2, b3, b4;
	Panel p1, p2;
	Panel main;
	TextField tf1, tf2, tf3;
	TextField maintf;
	List list;//��� list�ƴϰ� *��
	
	public UI() {
		dao = new AnimalDao();
		
		init();
		make();
		addEvent();
	}
	public void init() {//����
		f = new Frame("My Frame");
		b1 = new Button("ADD");
		b2 = new Button("SELECT");
		b3 = new Button("DELETE");
		b4 = new Button("UPDATE");
		p1 = new Panel();
		p2 = new Panel();
		main = new Panel();
		maintf = new TextField();
		tf1 = new TextField("ID�� �Է��ϼ���");
		tf2 = new TextField("SPECIES�� �Է��ϼ���");
		tf3 = new TextField("AGE�� �Է��ϼ���");
		list = new List();
		
	}
	public void make() {//frame�� ���̱�
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.BLUE);
		list.setBackground(Color.CYAN);
		b1.setBackground(Color.GREEN);

		
		p2.setLayout(new BorderLayout());//p2�� �Ӽ� �ٲٱ�
		p2.add(list, "Center");
		p2.add(b2, "South");
		
		p1.setLayout(new GridLayout(6, 1));//�ʿ��� �Ӽ� �ٲٱ�
		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(b1);
		p1.add(b3);
		p1.add(b4);
		
		main.setLayout(new GridLayout(1, 2));//��ġ �ٲٱ�, 1�� 2��
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
		
		b2.addActionListener(new ActionListener() {//select�ؼ� �Ѹ���
			
			@Override
			public void actionPerformed(ActionEvent e) {//��ư�� ������ �� �ȿ��� ó��
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
		
       b3.addActionListener(new ActionListener() {//select�ؼ� �Ѹ���
			
			@Override
			public void actionPerformed(ActionEvent e) {//��ư�� ������ �� �ȿ��� ó��
				
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
       
       b4.addActionListener(new ActionListener() {//select�ؼ� �Ѹ���
			
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