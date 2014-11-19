import com.tavant.sql.SQLQueries;


public class MySqlQueries implements SQLQueries {

	public String getAddUserQuery() {
		return "INSERT INTO user " +
				"(uid, uname, rid,password) VALUES (?, ?, ?,?)";
	}

}
