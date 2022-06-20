package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao <K,V> {
	
	String url = "jdbc:mysql://192.168.219.191:3306/zoodb?serverTimezone=Asia/Seoul"; //데이터베이스가 설치되어있는 주소로 접속(내컴퓨터주소:port번호/schemas)
	String mid = "admin1";
	String mpwd = "111111";
	
	public Dao() {
       try {
	       Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Loading...");
        } catch (ClassNotFoundException e) {
	        e.printStackTrace();
    }
  }
	
	public Connection getConnection() throws SQLException {//처리하지 않고 던지겠다
		Connection con = null;
		con = DriverManager.getConnection(url,mid,mpwd);
		return con;
	}
	
	public void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}
	
	public void close(ResultSet rset) {
		if(rset!=null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}
	
	public abstract void insert(V v) throws Exception;
	public abstract void update(V v) throws Exception;
	public abstract void delete(K k) throws Exception;
	public abstract V select(K k) throws Exception;
	public abstract List<V> select() throws Exception;
	}