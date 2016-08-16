package hashtable;

import java.io.IOException;
import java.sql.SQLException;


public class Hashmain {
	static Db_hash db;
	public static void main(String[] args) {
		try {
			db=Db_hash.getInstance();
			db.initilize();

			Hashtable hs = new Hashtable(args[0]);
			hs.initilize();
			Hash_view hv = new Hash_view();



			Hashcontroller hcon = new Hashcontroller();
			hcon.proc(hs,db,hcon,hv);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}catch(Exception e){
			String message =e.getMessage();
			System.out.println(message);
		}finally{
			db.closed();
		}
	}
}