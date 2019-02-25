package com.selamino.tvseries.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;



@Service
public class HelperClass {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public int getNextId(String idC, String users) {
		int nextNumber =0;
		String sql = "select max("+idC+") from "+users;
		
		Integer currentNumber = jdbcTemplate.queryForObject(sql, new Object[]{ }, Integer.class);
		if(currentNumber == null){
			nextNumber = 1;
		}else{
			nextNumber = currentNumber +1;
		}
		return nextNumber;
	}
	
	public ArrayList<HashMap<String, Object>> getData(String sql, Object[] queryParams){
		ArrayList<HashMap<String, Object>> griddata = new ArrayList<HashMap<String, Object>>();
		griddata = (ArrayList<HashMap<String, Object>>) jdbcTemplate.query(sql, queryParams, new GridDataMapper());
		System.out.println(griddata.toString()+" griddata");
		return griddata;
	}

	@SuppressWarnings("rawtypes")
	public class GridDataMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			HashMap<String, Object> link = new HashMap<>();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			
			
			int numberOfColumns = rsMetaData.getColumnCount();
			
			for(int i = 1; i <numberOfColumns; i++){
				//System.out.println(numberOfColumns+" "+rsMetaData.getColumnLabel(i) );
				if(rsMetaData.getColumnType(i) == 2){
					link.put(rsMetaData.getColumnName(i).toUpperCase(), rs.getInt(rsMetaData.getColumnName(i)));
					
				}else{
					link.put(rsMetaData.getColumnName(i).toUpperCase(), rs.getString(rsMetaData.getColumnName(i)));
				}
			}
			//System.out.println(link.toString()+"link");
			return link;
		}

	}

}
