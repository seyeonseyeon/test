package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import frame.Dao;
import frame.Sql;
import vo.AnimalVo;

public class AnimalDao extends Dao<Integer, AnimalVo> {

	@Override
	public void insert(AnimalVo v) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(Sql.insertAni);
			ps.setInt(1, v.getId());
			ps.setString(2, v.getSpecies());
			ps.setInt(3, v.getAge());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("사용자 입력 오류");
		}finally {
			close(ps);
			close(con);
		}
	}
		

	@Override
	public void update(AnimalVo v) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
		con = getConnection();
		ps = con.prepareStatement(Sql.updateAni);
		ps.setString(1, v.getSpecies());
		ps.setInt(2, v.getAge());
		ps.setInt(3, v.getId());
		ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
		close(ps);
		close(con);
		}		
     }

	@Override
	public void delete(Integer k) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
		con = getConnection();
		ps = con.prepareStatement(Sql.deleteAni);
		ps.setInt(1, k);
		ps.executeUpdate();
		int result = ps.executeUpdate();
		//if(result!=1) {
			//throw  new Exception("삭제 항목이 없습니다.");
		//}
		} catch (Exception e) {
			throw e;
		}finally {
		close(ps);
		close(con);
		}		
		
	}

	@Override
	public AnimalVo select(Integer k) throws Exception {
        AnimalVo ani = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		con = getConnection();
		ps = con.prepareStatement(Sql.selectAni);
		ps.setInt(1, k);
		rs = ps.executeQuery();
		rs.next();
		int id = rs.getInt("id");
		String species = rs.getString("species");
		int age = rs.getInt("age");
		ani = new AnimalVo(id,species,age);
	
		} catch (Exception e) {
			throw e;
		}finally {
		         close(rs);
		         close(ps);
		         close(con);
		}	
		return ani;
	  }
	
	@Override
	public List<AnimalVo> select() throws Exception {
       List<AnimalVo> list = new ArrayList<AnimalVo>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		con = getConnection();
		ps = con.prepareStatement(Sql.selectAllAni);
		rs = ps.executeQuery();
		while(rs.next()) {
	
		int id = rs.getInt("id");
		String species = rs.getString("species");
		int age = rs.getInt("age");
		AnimalVo ani = new AnimalVo(id,species,age);
		list.add(ani);
		}
		} catch (Exception e) {
			throw e;
		}finally {
		close(rs);
		close(ps);
		close(con);
		}	
		return list;
	}
}