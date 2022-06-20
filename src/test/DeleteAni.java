package test;

import dao.AnimalDao;
import frame.Dao;
import vo.AnimalVo;

public class DeleteAni {

	public static void main(String[] args) {
		Dao<Integer, AnimalVo> dao = new AnimalDao();
		try {
			dao.delete(01);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		  //e.printStackTrace();
		}
	}
}