package hashtable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_hash {



	private Connection conn;

	private Statement stmt;

	private PreparedStatement pstmt;

	private ResultSet rset;

	private ResultSet rset_count;

	private boolean gender;

	private int count;

	private Statement stmt_dbhash;

	private Statement stmt_delete;

	private static Db_hash database = new Db_hash();

	public static final Object LOCK = new Object();

	private Db_hash() {

	}

	public static Db_hash getInstance() {

		return database;
	}
	/**
	 * 処理内容 JDBCドライバーのロード
	 * 		    MySQL接続
	 *          SQLオブジェクト作成
	 *          プリコンパイル
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 *
	 */
	public void initilize() throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/db_1", "root", "");

		stmt = conn.createStatement();
		stmt_delete=conn.createStatement();
		stmt_dbhash = conn.createStatement();
		pstmt = conn.prepareStatement("insert dbhash  (id,name,gender) values (?,?,?)");
	}

	/**
	 * 前提条件:initilize()関数を呼び出しておくこと。DBとの接続を図る。
	 * アウトプット: dbhashテーブルからデータをセレクトする。
	 *               セレクトするデータ仕様は以下のとおりである。
	 *               name=DBに保管されているすべての名前
	 *               Gender=DBに保管されているすべての性別
	 *               count(*)=レコード数の合計
	 * 処理内容: DBが空の時は登録に移る。
	 *           Personオブジェクトを生成する。
	 *           トランザクション処理を行う。
	 * @param db
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Person[] hashinitilize(Db_hash db,Hashcontroller hashcon) throws SQLException, IOException, InterruptedException{
		try{
			// //自動コミットオフ
			conn.setAutoCommit(false);

			rset = stmt.executeQuery("select name,gender from dbhash for update");

			rset_count = stmt_dbhash.executeQuery("select count(*) from dbhash for update");

			conn.commit();

			} catch (SQLException e) {
	 			try {
	 			e.printStackTrace();
	 				conn.rollback();
	 			} catch (SQLException e1) {
	 				e.printStackTrace();
	 			}
			}

			rset_count.next();
			count = rset_count.getInt("count(*)");
			if (count == 0) {
				System.out.println("DBが空なので登録へ移動");
				hashcon.insert(db);
			}

			int i = 0;
			Person[] person = new Person[count];
			while (rset.next() && i < count) {

				if (rset.getString("gender").equals("男")) {
					gender = false;
				} else {
					gender = true;
				}
				person[i] = new Person(rset.getString("name"), gender);
				i++;
			}
			return person;
	}
	/**
	 * 前提条件:  initilize()関数を呼び出しておくこと。DBとの接続を図る。
	 *            hashinitilize関数を呼び出しておくことでPersonオブジェクト生成
	 * 処理内容:  nameカラムは50文字以上、genderカラムは5文字以上でSQLExceptionをthrowする。
	 *            writeメソッド内でmax(id)をセレクトする。
	 *            nameカラム,genderカラムをインサートする。
	 * @param model_name
	 * @param model_gender
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	public void write(Model_hash model_name, Model_hash model_gender) throws InterruptedException, SQLException {
		synchronized (this) {

			// 文字数チェック
			if (model_name.toString().length() >50||model_gender.toString().length()>5) {
				throw new IllegalArgumentException("nameが50文字以上か性別が5文字以上です。");
			}
			pstmt.setInt(1, maxid());
			pstmt.setString(2, model_name.toString());
			pstmt.setString(3, model_gender.toString());

			pstmt.executeUpdate();
		}
	}

	private int maxid() throws SQLException {

		rset = stmt.executeQuery("select max(id) from dbhash");
		rset.next();
		return rset.getInt("max(id)") + 1;
	}
	/**
	 * 処理内容: 指定したnameカラムを削除する。
	 * @param model_name
	 * @param person
	 * @throws SQLException
	 */
	public void deleted(Model_hash model_name,Person[] person) throws SQLException{
		for(Person p2:person){
			if(model_name.toString().equals(p2.getName())){
				stmt_delete.executeUpdate("delete from dbhash where name = '"+model_name.toString()+"'");
			}
		}
	}

	public void closed() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (stmt_dbhash != null) {
				stmt_dbhash.close();
			}
			if (stmt_delete != null) {
				stmt_delete.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rset != null) {
				rset.close();
			}
			if (rset_count != null) {
				rset_count.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

