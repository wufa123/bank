package com.zx.bank.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

	public T mappingRow(ResultSet rs, int rownum) throws SQLException;
	
}
