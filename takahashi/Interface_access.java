package Access_interface;

import java.sql.Connection;
import java.sql.SQLException;

interface Interface_access {

	public  Connection  initilize() throws ClassNotFoundException, SQLException;
	public void write(Model2 model) throws SQLException, InterruptedException;
	public Model2 read() throws SQLException, ClassNotFoundException;
	public void closed();
}
