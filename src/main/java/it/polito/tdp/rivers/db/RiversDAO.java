package it.polito.tdp.rivers.db;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public void getAllRivers(Map<Integer, River> idMap) {
		
		final String sql = "SELECT id, name FROM river";


		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				River r = new River(res.getInt("id"), res.getString("name"));
				idMap.put(r.getId(), r);
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		
	}
	
	public void getFlows( River r, Map<Integer, River> idMap){
		
		String sql = "SELECT  DISTINCT f.`day`, f.flow, f.river "
				+ "FROM flow f, river r "
				+ "WHERE f.river = ?  "
				+ "ORDER BY f.`day`";
		List<Flow> risultato = new LinkedList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();
			
			while( res.next()) {
				Flow f = new Flow( res.getDate("day").toLocalDate(), res.getDouble("flow"), r);
				risultato.add(f);
				
			}
			
			conn.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
		
		idMap.get(r.getId()).setFlows(risultato);
	}
	
	
	
	
	
}
