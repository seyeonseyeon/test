package test;

import java.util.List;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;

public class SelectAllAni {

	public static void main(String[] args) {
		Dao<Integer,AnimalVo> dao = new AnimalDao();
		List<AnimalVo> list = null;
		try {
			list = dao.select();
			for (AnimalVo animalVo : list) {
				System.out.println(animalVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}