package junit.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db implements Interface_access {
	private Connection conn = null;
	private Statement stmt = null;
	private Statement stmt_read = null;
	private ResultSet rset = null;
	private ResultSet rset_read = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt_read = null;
	private String sqlStr_insert;
	private String sqlStr_select;
	private String sqlStr_maxtime;
	private String sqlStr;

	// singleton
	private static Db database = new Db();

	public static final Object LOCK = new Object();

	private Db() {

	}

	public static Db getInstance() {

		return database;
	}

	public Connection initilize() throws ClassNotFoundException, SQLException {

		// JDBCドライバーのロード
		Class.forName("com.mysql.jdbc.Driver");
		// MySQL接続
		conn = DriverManager.getConnection("jdbc:mysql://localhost/DB_1", "root", "");
		conn.setAutoCommit(false);
		// SQL実行stmt
		stmt = conn.createStatement();
		stmt_read = conn.createStatement();

		// プリコンパイル
		sqlStr_insert = "insert db_1  (id,message,time) values (?,?,CURRENT_TIMESTAMP)";
		// パラメーター
		pstmt = conn.prepareStatement(sqlStr_insert);

		// プリコンパイル
		sqlStr_select = "select * from db_1 where time =  ?";

		pstmt_read = conn.prepareStatement(sqlStr_select);
		return conn;
	}

	// class Global {
	// static Object lock = new Object();
	// }
	// 書き込み
	/**
	 * 引数キーボードから読み込んだmodel
	 *
	 * @throws InterruptedException
	 * @throws SQLException
	 */

		public void write(Model2 model) throws InterruptedException, SQLException {
			synchronized(this){
		// //自動コミットオフ
		conn.setAutoCommit(false);

		int id;
		sqlStr = "select max(id) from db_1";
		rset = stmt.executeQuery(sqlStr);
		rset.next();

		id = rset.getInt("max(id)") + 1;

		sqlStr = "select id from db_1 where id = " + id + " for update";

		Thread.sleep(3000);

		// 文字数チェック
		String input = model.toString();

		if (input.length() > 255) {
			throw new SQLException();
		}

		pstmt.setInt(1, id);

		pstmt.setString(2, input);

		pstmt.executeUpdate();

		conn.commit();
			}

	}

	// 読み込み
	/** セレクトの結果をreturn */
	public Model2 read() throws SQLException, ClassNotFoundException, NullPointerException {

		// //自動コミットオフ
		conn.setAutoCommit(false);

		// 更新日が最新のものをセレクト
		sqlStr_maxtime = "select max(time) from db_1";
		rset_read = stmt_read.executeQuery(sqlStr_maxtime);
		rset_read.next();
		String time = rset_read.getString("max(time)");
		// DBが空のとき
		if (time == null) {
			System.out.println("データはありません.書き込みしてください ");
			return null;
		}
		pstmt_read.setString(1, time);
		rset_read = pstmt_read.executeQuery();
		rset_read.next();
		String ptr = "id:" + rset_read.getInt("id") + "\t" + "message:" + "" + rset_read.getString("message") + "\t"
				+ "time:" + rset_read.getString("time");
		return new Model2(ptr);
	}

	// クローズする
	public void closed() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (pstmt_read != null) {
				pstmt_read.close();
			}

			if (stmt != null) {
				stmt.close();
			}
			if (stmt_read != null) {
				stmt_read.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rset != null) {
				rset.close();
			}
			if (rset_read != null) {
				rset_read.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
