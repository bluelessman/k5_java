package edu;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class printSQL {
	private ResultSet rs;
	private ResultSetMetaData rsMeta;

	public printSQL(ResultSet rs) {
		this.rs = rs;

	}
	
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public void print() throws SQLException {
		rsMeta = rs.getMetaData();
		while (rs.next()) {
			for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
				System.out.print(rs.getString(i) + ", ");
			}
			System.out.println();
		}
	}
}
