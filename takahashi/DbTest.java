package db2;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DbTest {
	// TODO : ここに書かない。Model model = new Model("test");各テスト関数に移す。
	Connection conn;
	Statement stmt;
	ResultSet rset;

	@Before
	public void setup() {
		Db instance = Db.getInstance();
		try {
			instance.initilize();
			// TODO: テストで利用するDBコネクションを作成する。
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/DB_1", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void messagetest() {
		Model model = new Model("test");
		assertNotNull(model);
		assertEquals("test", model.toString());
	}

	@Test
	public void testWrite() {
		Model model = new Model("test");
		Db instance = Db.getInstance();
		try {
			// TODO: データベースをクリアする。delete
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from db_1");
			instance.write(model);
			// TODO: テスト用コネクションから、データを取得する。
			rset = stmt.executeQuery("select * from db_1 where (select max(id) from db_1)");
			rset.next();
			assertEquals("残念", "id:" + rset.getInt("id") + "\t" + "message:" + "" + rset.getString("message") + "\t"
					+ "time:" + rset.getString("time"), instance.read().toString());

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@After
	public void close() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rset != null) {
				rset.close();
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
