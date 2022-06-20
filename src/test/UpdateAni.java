package test;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;

public class UpdateAni {

	public static void main(String[] args) {
		Dao<Integer, AnimalVo> dao = new AnimalDao();
		AnimalVo a =new AnimalVo(01, "¡„", 20);
		try {
			dao.update(a);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}