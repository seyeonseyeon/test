package test;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;

public class InsertAni {

	public static void main(String[] args) {
		Dao<Integer, AnimalVo> dao = new AnimalDao();
		
		AnimalVo ani = new AnimalVo(05, "°³¹Ì", 70);
		try {
			dao.insert(ani);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}