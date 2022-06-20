package app;

import java.util.List;
import java.util.Scanner;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;

public class App {

	public static void main(String[] args) {
		Dao<Integer, AnimalVo> dao = new AnimalDao();
		
		System.out.println("Start ...");
		Scanner sc = new Scanner(System.in);
		
			while(true) {
			System.out.println("Input cmd(i,s,l,q) ...");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("Bye");
				break;
				
			}else if(cmd.equals("i")) {
				System.out.println("Input Animal Info ..");
				String id = sc.next();
				int i = Integer.parseInt(id);
				
				String species = sc.next();
				
				String age = sc.next();
				int ag = Integer.parseInt(age);
				AnimalVo a = new AnimalVo(i, species, ag);
				try {
					dao.insert(a);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
			}else if(cmd.equals("s")) {
				List<AnimalVo> list = null;
				try {
					list = dao.select();
					for (AnimalVo a : list) {
						System.out.println(a);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}else if(cmd.equals("l")) {
				System.out.println("Input id species..");			
				String id = sc.next();
				int i = Integer.parseInt(id);
				String species = sc.next();
				AnimalVo a= null;
				try {
					a = dao.select(i);
					if(a.getSpecies().equals(species)) {
						System.out.println("Login Ok...");
					}else {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("Login Fail...");
				}
			}
		}
		sc.close();
		System.out.println("End ...");
	}
} 