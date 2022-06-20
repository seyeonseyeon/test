package frame;

public class Sql {
	public static String insertAni = "INSERT INTO ANIMAL VALUES(?,?,?)"; 
	public static String deleteAni = "DELETE FROM ANIMAL WHERE id=?";
	public static String updateAni = "UPDATE ANIMAL SET species=?, age=? WHERE id=?";
	public static String selectAni = "SELECT * FROM ANIMAL WHERE id = ?";
	public static String selectAllAni = "SELECT * FROM ANIMAL";
	
	
	
	

}
