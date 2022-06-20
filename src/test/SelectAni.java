package test;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;

public class SelectAni {

	public static void main(String[] args) {
		Dao<Integer, AnimalVo> dao =new AnimalDao();
		AnimalVo ani = null;
		try {
			ani = dao.select(01);
			System.out.println(ani);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}