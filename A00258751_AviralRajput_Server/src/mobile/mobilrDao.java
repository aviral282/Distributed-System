package mobile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class mobilrDao {

	@SuppressWarnings("null")
	public List<mobileModel> getAllItems() throws SQLException, ClassNotFoundException {

		List<mobileModel> mobileList = null;
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		Statement stmt = con.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("Select * from MOBILE");
		mobileList = new ArrayList<mobileModel>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("MOBILENAME");
			int price = rs.getInt("PRICE");
			String description = rs.getString("DESCRIPTION");
			mobileModel mobile = new mobileModel(id, name, price, description);
			mobileList.add(mobile);
		}

		return mobileList;
	}

	public mobileModel getMobiles(int id) throws ClassNotFoundException, SQLException {
		List<mobileModel> mob1 = getAllItems();
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		ResultSet rs;
		mobileModel user = null;
		String sql = "SELECT ID,MOBILENAME,PRICE,DESCRIPTION FROM MOBILE where ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		rs = st.executeQuery();
		while (rs.next()) {

			int id1 = rs.getInt("ID");
			String name1 = rs.getString("MOBILENAME");
			int price1 = rs.getInt("PRICE");
			String description1 = rs.getString("DESCRIPTION");
			mobileModel mobile = new mobileModel(id1, name1, price1, description1);
		}

		return user;

	}

	public int addMobile(mobileModel mobvar) throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		String sql = "insert into MOBILE(ID,MOBILENAME,PRICE,DESCRIPTION) values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st = con.prepareStatement(sql);
		st.setInt(1, mobvar.getId());
		st.setString(2, mobvar.getName());
		st.setInt(3, mobvar.getPrice());
		st.setString(4, mobvar.getDescription());
		int num = st.executeUpdate();

		return num;
	}

	public int updateMobiles(mobileModel mobvar) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		String sql = "UPDATE MOBILE SET ID = ?,MOBILENAME = ?,PRICE = ?,DESCRIPTION = ? WHERE ID = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st = con.prepareStatement(sql);
		st.setInt(1, mobvar.getId());
		st.setString(2, mobvar.getName());
		st.setInt(3, mobvar.getPrice());
		st.setString(4, mobvar.getDescription());
		st.setInt(5, mobvar.getId());
		int num = st.executeUpdate();
		return num;
	}

	public int deleteMobile(int id) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		String sql = "Delete from MOBILE where ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		int num = st.executeUpdate();
		return num;
	}

}
